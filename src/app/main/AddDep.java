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
 * Servlet implementation class AddDep
 */
public class AddDep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDep() {
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
		
		String demail= request.getParameter("demail");
		String dpassword= request.getParameter("dpassword");
		String dname= request.getParameter("dname");
		String dtaluka= request.getParameter("dtaluka");
		String ddistrict= request.getParameter("ddistrict");
		String daddress= request.getParameter("daddress");
		String dmobile= request.getParameter("dmobile");
		try {
		Connection con =DbConnection.connect();
	
			PreparedStatement pstmt= con.prepareStatement("insert into department(demail,dpassword,dname,dtaluka,ddistrict,daddress,dmobile) values (?,?,?,?,?,?,?)");
			pstmt.setString(1, demail);
			pstmt.setString(2, dpassword);
			pstmt.setString(3, dname);
			pstmt.setString(4, dtaluka);
			pstmt.setString(5, ddistrict);
			pstmt.setString(6, daddress);
			pstmt.setString(7, dmobile);
			int i=pstmt.executeUpdate();
			
			if(i>0)
			{
				response.sendRedirect("adminDashboard.html");
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
