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
 * Servlet implementation class DLogin
 */
public class DLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DLogin() {
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
		
		
		String email=request.getParameter("demail");
		String password=request.getParameter("dpassword");


		
		Connection con=DbConnection.connect();
		try{
			
		PreparedStatement pstmt= con.prepareStatement("select * from department where (demail=? and dpassword =?)");
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();

		if(rs.next())
		{
			Values.setDname(rs.getString(3));
			response.sendRedirect("departmentDashboard.html");
		}
		else
			{response.sendRedirect("500.html");}


	}
		catch(Exception e){
			e.printStackTrace();
		
		}

	}
}
