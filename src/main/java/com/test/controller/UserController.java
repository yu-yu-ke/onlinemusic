package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.UserService;
import com.test.utils.R;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 用户注册
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	
	@RequestMapping("/register")
	@ResponseBody
	public void register(HttpServletRequest request, HttpServletResponse response, Model model) throws ParseException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		
		String userName = request.getParameter("user_name");
        String userPassword = request.getParameter("user_password");
        Integer vipId = Integer.parseInt(request.getParameter("vip_id"));
        Date userBirthday = simpleDateFormat.parse(request.getParameter("user_birthday") + " 00:00:00");
        String userGender = request.getParameter("user_gender");
        Integer typeId = Integer.parseInt(request.getParameter("type_id"));
        
        Boolean flag = userService.register(userName, userPassword, vipId, userBirthday, userGender, typeId);
        R r = R.modify(flag);
        printWriter.print(r);
		
	}
	
	@RequestMapping("/beforeRegister")
	@ResponseBody
	public void beforeRegister(HttpServletRequest request, HttpServletResponse response, Model model) throws ParseException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		
		String userName = request.getParameter("user_name");
        String userPassword = request.getParameter("user_password");
        Integer vipId = Integer.parseInt(request.getParameter("vip_id"));
        Date userBirthday = simpleDateFormat.parse(request.getParameter("user_birthday") + " 00:00:00");
        String userGender = request.getParameter("user_gender");
        Integer typeId = Integer.parseInt(request.getParameter("type_id"));
        
        Boolean flag = userService.register(userName, userPassword, vipId, userBirthday, userGender, typeId);
        R r = R.modify(flag);
        printWriter.print(r);
		
	}
	
}
