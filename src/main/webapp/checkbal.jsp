<%@page import="java.util.List"%>
<%@page import="com.evry.service.AccountService"%>

<%@page import="com.evry.model.Account"%>
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
     <h3>View Balance</h3>
     <div id="container">
        
         <table>
             <thead>
                 <tr>
                 <th> Account ID</th>
                     <th>Account Name</th>
                    
                     <th>Account Number</th>
                     <th>Balance</th>                
                 </tr>
             </thead>
             <tbody>
                 <%
                     AccountService loginService = new AccountService();
                     List<Account> list = loginService.getListOfAccounts();
                     for (Account a : list) {
                 %>
                 <tr>
                    
                     <td><%=a.getId() %>
                     <td><%=a.getAccountName() %>
                     <td><%=a.getAccountNumber()%></td>
                     <td><%=a.getBalance()%></td>

                 </tr>
                 <%}%>
             <tbody>
         </table>    
         <br/>
     </div>
    </center>
</body>
</html>