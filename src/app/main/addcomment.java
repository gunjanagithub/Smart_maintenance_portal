package app.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addcomment
 */
public class addcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcomment() {
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
		String comment=request.getParameter("comment");
		String uname=Values.getUname();
		int cid=Values.getCid();
		try {
			Connection con =DbConnection.connect();
				
				PreparedStatement pstmt= con.prepareStatement("update complaints set comment=? where uname=? and cid=?");
				pstmt.setString(1, comment);
				pstmt.setString(2, uname);
				pstmt.setInt(3, cid);
				
				int i=pstmt.executeUpdate();
				
				if(i>0)
				{
					response.sendRedirect("userDashboard.html");
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
