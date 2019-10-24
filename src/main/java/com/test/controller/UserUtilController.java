package com.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bean.SongType;
import com.test.bean.User;
import com.test.service.SongTypeService;
import com.test.service.UserService;

@Controller
public class UserUtilController {

	@Autowired
	private SongTypeService songTypeService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/selectSongType")
	private String selectSongType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SongType> songtypeList = songTypeService.listAll();

        request.setAttribute("songtypeList",songtypeList);
        
        return "/jsp/user/user_register.jsp";
//        request.getRequestDispatcher("/jsp/user/user_register.jsp").forward(request,response);
    }
	
	@RequestMapping("/userInfo")
	public String userInfo(HttpSession session, Model model) throws ServletException, IOException {
        Object userId = session.getAttribute("userLoginId");

        if (null!=userId){
            Integer userIds = (Integer) userId;
            List<User> userBeans = userService.selectById(userIds);
            model.addAttribute("userBeans", userBeans);
            return "forward:/jsp/user/user_index.jsp";
//            request.getRequestDispatcher("/page/user/user_index_jsp").forward(request,response);
        }else {
        	return "forward:/jsp/user/user_tips.jsp";
//            request.getRequestDispatcher("/page/user/user_tips_jsp").forward(request,response);
        }
    }
}
