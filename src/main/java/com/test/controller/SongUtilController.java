package com.test.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bean.Song;
import com.test.bean.SongType;
import com.test.bean.User;
import com.test.service.ClicksService;
import com.test.service.DownloadService;
import com.test.service.SongService;
import com.test.service.SongTypeService;
import com.test.service.UserService;

@Controller
public class SongUtilController {

	@Autowired
	private SongTypeService songTypeService;
	
	@Autowired
	private SongService songService;
	
	@Autowired
	private ClicksService clicksService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DownloadService downloadService;
	
	@RequestMapping("/SongUtilController/querySongType")
	public String querySongType(Model model) {
        List<SongType> songtypeBeanList = songTypeService.listAll();

        model.addAttribute("songtypeBeanList",songtypeBeanList);
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return "forward:/index.jsp";
    }
	
	@RequestMapping("/SongUtilController/click")
    public String click(HttpSession session, HttpServletRequest request) {
        
        Object userId = session.getAttribute("userLoginId");
        if (null!=userId){
            Integer songId = Integer.parseInt(request.getParameter("song_id"));
            //在点击（click）表插入一条点击记录，
            //将歌曲（song）表中与song_id对应的记录的点击次数加一
            clicksService.click((Integer) userId, songId);
        }

//        request.getRequestDispatcher("/SongUtilServlet?state=querySongs").forward(request,response);
        return "redirect:querySongs";
    }
	
	@RequestMapping("/SongUtilController/listen")
    public void listen(HttpServletRequest request, HttpServletResponse response) {
        Integer songId = Integer.parseInt(request.getParameter("song_id"));
        List<Song> songs = songService.selectById(songId);
        String songUrl = songs.get(0).getSongUrl();
        int index = songUrl.indexOf("/resources");
        String substring = songUrl.substring(index);
        String listenSongUrl = "." + substring;

        request.setAttribute("listenSongUrl",listenSongUrl);
        this.querySongs(request);
    }
	
	
	@RequestMapping("/SongUtilController/querySongs")
	public String querySongs(HttpServletRequest request) {
        List<Song> songDisplayBeans = songService.selectAll();
        Integer size = songDisplayBeans.size();
        for (int i=1;i<=size;i++){
            songDisplayBeans.get(i-1).setSongUrl(i + "");
        }
        request.setAttribute("songDisplayBeans",songDisplayBeans);
        
//        request.getRequestDispatcher("/page/song/song_index_jsp").forward(request,response);
//        return "forward:/jsp/song/song_index.jsp";
        return "song/song_index";
    }
	
	@RequestMapping("/SongUtilController/hotSearch")
	public String hotSearch(HttpServletRequest request) {
        List<Song> songDisplayBeans = songService.hotSearch();
        Integer size = songDisplayBeans.size();
        for (int i=1;i<=size;i++){
            songDisplayBeans.get(i-1).setSongUrl(i + "");
        }
        request.setAttribute("songDisplayBeans1",songDisplayBeans);
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return "forward:/index.jsp";
    }
	
	@RequestMapping("/SongUtilController/hotDownload")
	public String hotDownload(HttpServletRequest request ) {
       
		List<Song> songDisplayBeans = songService.hotDownload();
        Integer size = songDisplayBeans.size();
        for (int i=1;i<=size;i++){
            songDisplayBeans.get(i-1).setSongUrl(i + "");
        }
        request.setAttribute("songDisplayBeans2",songDisplayBeans);
//        request.getRequestDispatcher("/index.jsp").forward(request,response);
        return "forward:/index.jsp";
    }
	
	@RequestMapping("/SongUtilController/download")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Integer songId = Integer.parseInt(request.getParameter("song_id"));
        List<Song> songBeans = songService.selectById(songId);
        Integer songVipId = songBeans.get(0).getVipId();

        HttpSession session = request.getSession();
        Object loginId = session.getAttribute("userLoginId");
        if (null==loginId){
            request.getRequestDispatcher("/jsp/user/user_tips.jsp").forward(request,response);
        }else {
            List<User> userBeans = userService.selectById((Integer) loginId);
            Integer userVipId = userBeans.get(0).getVipId();
            if (userVipId >= songVipId){
                //在下载（download）表插入一条下载记录，
                //将歌曲（song）表中与song_id对应的记录的下载次数加一
                downloadService.download((Integer)loginId,songId);
                this.downLoad(songBeans,response);
            }else {
                String purchaseInfo = "您需支付￥" + (songVipId - 1)*2 + "元以购买该歌曲！";
                request.setAttribute("user_id",(Integer)loginId);
                request.setAttribute("song_id",songId);
                request.setAttribute("purchaseInfo",purchaseInfo);
                request.getRequestDispatcher("/jsp/user/purchase.jsp").forward(request,response);
            }
        }
    }
	
	public void downLoad(List<Song> songBeans,HttpServletResponse response) throws UnsupportedEncodingException {
        //获取所要下载的文件名称
        String songName = songBeans.get(0).getSongName();
        String songFormat = songBeans.get(0).getSongFormat();
        //下载文件所在目录
        String songUrl = songBeans.get(0).getSongUrl();

        String fileName = new String((songName + "." + songFormat).getBytes("utf-8"),"ISO8859-1");

//        System.out.println(fileName);

        try {
            // path是指欲下载的文件的路径。
            File file = new File(songUrl);
            // 以流的形式下载文件。
            InputStream inputStream = new BufferedInputStream(new FileInputStream(songUrl));
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
	@RequestMapping("/SongUtilController/querySongByTypeId")
	public String querySongByTypeId(Integer typeId, HttpServletRequest request) {
        List<Song> songDisplayBeans = songService.selectSongByTypeId(typeId);
        Integer size = songDisplayBeans.size();
        for (int i=1;i<=size;i++){
            songDisplayBeans.get(i-1).setSongUrl(i + "");
        }

        request.setAttribute("songDisplayBeans",songDisplayBeans);
        // request.getRequestDispatcher("/page/song/song_byTypeId_jsp").forward(request,response);
        return "song/song_byTypeId";
    }
	
	@PostMapping("/SongUtilController/query")
	public String querySongByTypeId(String queryInfo, HttpServletRequest request) {
		List<Song> songDisplayBeans = songService.fuzzyQuery(queryInfo);
		Integer size = songDisplayBeans.size();
		for (int i = 1; i <= size; i++) {
			songDisplayBeans.get(i - 1).setSongUrl(i + "");
		}

		// System.out.println(queryInfo);
		// System.out.println(size);

		request.setAttribute("songDisplayBeans", songDisplayBeans);
//		request.getRequestDispatcher("/page/song/query_jsp").forward(request, response);
		return "song/query";
	}
}
