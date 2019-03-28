<%@page import="java.util.List"%>
<%@page import="com.evry.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.evry.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" type="text/css" href="css/style.css"/>
     <title>Result Page</title>
</head>
<body>
<center>
     <div id="container">
         <h1> Payment Application </h1>
         <b>This is digital application</b>
         </br>
         <%=new Date()%></br>
                 <%
                 User user = (User) session.getAttribute("user");
             %>     
             <h3>Welcome <%= user.getFirstName() + " " + user.getLastName()%></h3>     
             <br/>
             
            <h3> <a href="logout.jsp">Logout</a>|<a href="account.jsp">AddAccount</a>|<a href="transaction.jsp">Transaction</a>|<a href="checkbal.jsp">CheckBalance</a>|<a href="addmoney.jsp">AddBalance</a></h3>
         </p>
 
         <table>
             <thead>
                 <tr>
                     <th>User ID</th>
                     <th>First Name</th>
                    
                     <th>Last Name</th>
                     <th>email</th>                
                 </tr>
             </thead>
             <tbody>
                 <%
                     LoginService loginService = new LoginService();
                     List<User> list = loginService.getListOfUsers();
                     for (User u : list) {
                 %>
                 <tr>
                     <td><%=u.getUserId()%></td>
                     <td><%=u.getFirstName()%></td>
                     <td><%=u.getLastName()%></td>
                     <td><%=u.getEmail()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
</body>
</html>