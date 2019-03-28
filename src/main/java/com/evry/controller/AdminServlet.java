package com.evry.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evry.model.Admin;
import com.evry.model.User;
import com.evry.service.AdminService;
import com.evry.service.LoginService;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");   
	     String password = request.getParameter("password");
	     AdminService adminService = new AdminService();
	     boolean result = adminService.authenticateUser(userId, password);
	     Admin admin = adminService.getUserByUserId(userId);
	     if(result == true){
	         request.getSession().setAttribute("admin", admin);      
	         response.sendRedirect("transfer.jsp");
	     }
	     else{
	         response.sendRedirect("error.jsp");
	     }
	}
}
