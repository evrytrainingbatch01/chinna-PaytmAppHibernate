package com.evry.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evry.model.Account;
import com.evry.service.UpdateService;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
	     PrintWriter out = response.getWriter();
	     
	     String aid=request.getParameter("aid");
	     long id=Integer.parseInt(aid);
	     
	     String bal=request.getParameter("balance");
	     int balance=Integer.parseInt(bal);
	     
	     UpdateService us=new UpdateService();
	     
	     Account addBalance=us.addBalance(id, balance);
	     
	     out.println("<html>");
         out.println("<head>");      
         out.println("<title>transfer Successful</title>");    
         out.println("</head>");
         out.println("<body>");
         out.println("<center>");
	     if(addBalance!=null) {
	    	 out.println("<h1>Amount Added to Account Successfully</h1>");
             out.println("you want check balance-<a href=checkbal.jsp>Click here</a>");
         }else{
             out.println("<h1>Transfer Failed</h1>");
             out.println("To try again<a href=addmoney.jsp>Click here</a>");
         }
	     out.println("</center>");
         out.println("</body>");
         out.println("</html>");
         
         out.close();
	}

}
