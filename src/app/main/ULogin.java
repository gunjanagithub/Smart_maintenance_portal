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
 * Servlet implementation class ULogin
 */
public class ULogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ULogin() {
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
		
		
		
		
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");


		
		Connection con=DbConnection.connect();
		try{
			
		PreparedStatement pstmt= con.prepareStatement("select * from users where (uemail=? and upassword =?)");
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();

		if(rs.next())
		{
			Values.setUname(rs.getString(1));
			response.sendRedirect("userDashboard.html");
		}
		else
			{response.sendRedirect("500.html");}


	}
		catch(Exception e){
			e.printStackTrace();
		
		}

	}
}

		
		
		
		
		
		
		
		
		
		

