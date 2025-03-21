<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Status</title>
</head>
<body>
<%@ page import="app.main.DbConnection" %>
	<%@ page import="java.sql.*" %>
	<%@ page import="java.io.IOException" %>
	
	<%
	int title=Integer.parseInt(request.getParameter("title"));
	//System.out.println(title);
	Connection con=DbConnection.connect();
	PreparedStatement pstmt=con.prepareStatement("update complaints set Status=? where cid=?");
	pstmt.setString(1,"Complete" );
	pstmt.setInt(2,title );
	int i=pstmt.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("viewdepartmentcom.jsp");
	}
	else
	{
		response.sendRedirect("500.html");
	}
	
	
	
	%>



</body>
</html>