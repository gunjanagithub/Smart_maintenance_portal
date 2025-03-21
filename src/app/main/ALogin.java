package app.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ALogin
 */
public class ALogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ALogin() {
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
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");


		
		Connection con=DbConnection.connect();
		try{
			
		PreparedStatement pstmt= con.prepareStatement("select * from admin where (email=? and password =?)");
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();

		if(rs.next())
		{
			response.sendRedirect("adminDashboard.html");
		}
		else
			{response.sendRedirect("500.html");}


	}
		catch(Exception e){
			e.printStackTrace();
		
		}

	}
}
