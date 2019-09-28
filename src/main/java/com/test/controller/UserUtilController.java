package com.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bean.SongType;
import com.test.service.SongTypeService;

@Controller
public class UserUtilController {

	@Autowired
	private SongTypeService songTypeService;
	
	@RequestMapping("/selectSongType")
	private String selectSongType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SongType> songtypeList = songTypeService.listAll();

        request.setAttribute("songtypeList",songtypeList);
        
        return "/jsp/user/user_register.jsp";
//        request.getRequestDispatcher("/jsp/user/user_register.jsp").forward(request,response);
    }
}
