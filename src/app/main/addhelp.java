package app.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addhelp
 */
public class addhelp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addhelp() {
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
		String name=request.getParameter("hname");
		String contact=request.getParameter("hmobile");
		
		try {
			Connection con =DbConnection.connect();
		
				PreparedStatement pstmt= con.prepareStatement("insert into helpline values (?,?)");
				pstmt.setString(1, name);
				pstmt.setString(2, contact);
				
				int i=pstmt.executeUpdate();
				
				if(i>0)
				{
					response.sendRedirect("adminDashboard.html");
				}
				else{
					response.sendRedirect("500.html");
				}
		
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		
		}

	}
}
