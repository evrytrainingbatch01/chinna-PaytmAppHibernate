<html>
<head>
<title>Account Form</title>
<style type="text/css">
h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
text-align: center; text-decoration: underline }
table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;width: 50%;
text-align:; background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
table.inner{border: 0px}
</style>
</head>
<body>
<h3>Account Details</h3>
<form action="UpdateServlet" method="POST">
<table align="center" cellpadding = "10">
<tr>
<td>Enter Account Id</td>
<td><input type="text" name="aid" maxlength="30"/>

</td>
</tr>

<tr>
<td>Enter Amount</td>
<td><input type="text" name="balance" maxlength="30"/>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="update">
<input type="reset" value="Reset">
</td>
</tr>
</table>
</form>
</body>
</html>