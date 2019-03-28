package com.evry.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evry.model.Account;
import com.evry.service.TransferService;



public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
	     PrintWriter out = response.getWriter();
	     
	     String aid1=request.getParameter("accid");
	     long id1=Integer.parseInt(aid1);
	     
	     String aid2=request.getParameter("taid");
	     long id2=Integer.parseInt(aid2);
	     
	     String bal=request.getParameter("tbal");
	     int balance=Integer.parseInt(bal);
	     
	     TransferService us=new TransferService();
	     
	     Account addmoney=us.transferMoney(id1,id2, balance);
	     
	     out.println("<html>");
        out.println("<head>");      
        out.println("<title>transfer Successful</title>");    
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
	     if(addmoney!=null) {
	    	 out.println("<h1>Amount transfer to your Account Successful.</h1>");
            out.println("you want check balance-<a href=checkbal.jsp>Click here</a>");
        }else{
            out.println("<h1>Transfer Failed</h1>");
            out.println("To try again<a href=transfer.jsp>Click here</a>");
        }
	     out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
	}

}
