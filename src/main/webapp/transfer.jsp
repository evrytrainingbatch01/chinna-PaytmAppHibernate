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
<h3>Transaction Amount Here</h3>
<form action="TransferServlet" method="POST">
<table align="center" cellpadding = "10">
<tr>
<td>Enter your Account ID:</td>
<td><input type="text" name="accid" maxlength="30"/>

</td>
</tr>

<tr>
<td>Enter Transfer Account ID:</td>
<td><input type="text" name="taid" maxlength="30"/>

</td>
</tr>
<tr>
<td>How much amount your transfer</td>
<td><input type="text" name="tbal" maxlength="100" /></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Transfer">
<input type="reset" value="Cancle">
</td>
</tr>
</table>
</form>
</body>
</html>