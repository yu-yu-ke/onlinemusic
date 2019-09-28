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
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.Manager;
import com.test.bean.User;
import com.test.service.ManagerService;
import com.test.service.UserService;
import com.test.utils.R;

@Controller
public class LoginController {

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/adminLogin")
	public R adminLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");

        List<Manager> list = managerService.listAll();
        Boolean flag = false;
        for (Manager managerBean : list){
            if (adminName.equals(managerBean.getManagerName()) &&
                    adminPassword.equals(managerBean.getManagerPassword())){
                flag = true;
                session.setAttribute("adminLoginId",managerBean.getManagerId());
                break;
            }
        }
        R r = null;
        if (flag){
            r = R.ok("登录成功！");
        }else {
            r = R.error("登录失败！");
        }
        return r;
    }
	
	@RequestMapping("/userLogin")
	private R userLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        
        List<User> list = userService.listAll();
        Boolean flag = false;
        for (User userBean : list){
            if (userName.equals(userBean.getUserName()) &&
                    userPassword.equals(userBean.getUserPassword())){
                flag = true;
                session.setAttribute("userLoginId",userBean.getUserId());
                break;
            }
        }

        R r = null;

        if (flag){
            r = R.ok();
        }else {
            r = R.error("登录失败！");
        }

        return r;
    }
	
}
