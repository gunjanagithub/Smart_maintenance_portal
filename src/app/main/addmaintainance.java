package app.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addmaintainance
 */
public class addmaintainance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmaintainance() {
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
		
		String road=request.getParameter("mroad");
		String location=request.getParameter("mlocation");
		String department=request.getParameter("mdepartment");
		String date=request.getParameter("mdate");
		
		try {
			Connection con =DbConnection.connect();
		
				PreparedStatement pstmt= con.prepareStatement("insert into road values (?,?,?,?)");
				pstmt.setString(1, road);
				pstmt.setString(2, location);
				pstmt.setString(3, department);
				pstmt.setString(4, date);
				
				int i=pstmt.executeUpdate();
				
				if(i>0)
				{
					response.sendRedirect("adminDashboard.html");
				}
				else{
					response.sendRedirect("500.html");
				}
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	

}
}
