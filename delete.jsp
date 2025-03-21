<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
</head>
<body>
<%@ page import="app.main.DbConnection" %>
	<%@ page import="java.sql.*" %>
	<%@ page import="java.io.IOException" %>
<%
String email=request.getParameter("email");
Connection con=DbConnection.connect();
PreparedStatement pstmt=con.prepareStatement("delete from department where demail=?");
pstmt.setString(1,email );
int i=pstmt.executeUpdate();
if(i>0)
{
	response.sendRedirect("viewdep.jsp");
}
else
{
	response.sendRedirect("500.html");
}
%>
</body>
</html>