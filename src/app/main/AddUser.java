package app.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String uemail= request.getParameter("uemail");
		String upassword= request.getParameter("upassword");
		String uname= request.getParameter("uname");
		String umobile= request.getParameter("umobile");
		
		String uaddress= request.getParameter("uaddress");
		
		try {
		Connection con =DbConnection.connect();
	
			PreparedStatement pstmt= con.prepareStatement("insert into users values (?,?,?,?,?)");
			pstmt.setString(3, uemail);
			pstmt.setString(4, upassword);
			pstmt.setString(1, uname);
			pstmt.setString(2, umobile);
			
			pstmt.setString(5, uaddress);
			
			int i=pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("userlogin.html");
			}
			else{
				response.sendRedirect("500.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
