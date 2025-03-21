<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Department Complaints Table</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons CSS -->

 <!-- side nav css file -->
 <link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
 <!-- side nav css file -->
 
 <!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>

<!--webfonts-->
<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
<!--//webfonts--> 

<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->

</head> 
<body >
	<%@ page import="app.main.DbConnection" %>
	<%@ page import="app.main.Values" %>
	<%@ page import="java.sql.*" %>
	<%@ page import="java.io.IOException" %>
		<%
		Connection con=DbConnection.connect();
		
		
		String dname=Values.getDname();
		PreparedStatement pstmt=con.prepareStatement("select * from complaints where cdepartment=?");
		pstmt.setString(1, dname);
		ResultSet rs=pstmt.executeQuery();
		
		%>
	
		
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="tables">
					<h2 class="title1">Complaint Details</h2>
					
					
					
					<div class="bs-example widget-shadow" data-example-id="contextual-table"> 
						
						<table class="table"> 
							<thead> 
								<tr> 
									<th>Compaint id</th>
									<th>User</th>
									<th>Title</th> 
									<th>Description</th> 
									<th>Department</th> 
									<th>Date</th> 
									<th>Image</th>
									<th>Comment</th>
									<th>Delete</th> 
									<th>Status</th>
								</tr> 
							</thead> 
							<tbody> 
								    <% while(rs.next()){%>
								<tr class="info"> 
									<td><%=rs.getString("cid") %></td>
									 <td><%=rs.getString("uname") %></td> 
									 <td><%=rs.getString("ctitle") %></td> 
									 <td><%=rs.getString("cdescription") %></td> 
									 <td><%=rs.getString("cdepartment") %></td> 
									 <td><%=rs.getString("date") %></td> 
									 <td></td>
									
									 <td><a href="viewcomment.jsp?title=<%=rs.getString(1) %>" >comment</a> </td> 
									 <td><a href="deletecomplaint.jsp?delete=<%=rs.getString(1) %>" >Delete</a> </td> 
									<td><a href="updatestatus.jsp?title=<%=rs.getString(1)%>"><%=rs.getString("Status")%></a></td> 
									  
								</tr>  
								<%} %>
							</tbody> 
							</table> 
					</div>
					
				</div>
			</div>
		</div>
		
	</div>
	
	<!-- side nav js -->
	<script src='js/SidebarNav.min.js' type='text/javascript'></script>
	<script>
      $('.sidebar-menu').SidebarNav()
    </script>
	<!-- //side nav js -->
	
	<!-- Classie --><!-- for toggle left push menu script -->
		<script src="js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!-- //Classie --><!-- //for toggle left push menu script -->
	
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.js"> </script>
	
</body>
</html>