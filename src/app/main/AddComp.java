package app.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddComp
 */
public class AddComp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComp() {
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
		String ctitle= request.getParameter("ctitle");
		String cdescription= request.getParameter("cdescription");
		String cdepartment= request.getParameter("cdepartment");
		String date= request.getParameter("cdate");
		
		String uname=Values.getUname();
	
		
		try {
		Connection con =DbConnection.connect();
		FileInputStream fis=new FileInputStream(request.getParameter("image"));
			PreparedStatement pstmt= con.prepareStatement("insert into complaints (uname,ctitle,cdescription,cdepartment,date,image,comment,Status) values (?,?,?,?,?,?,?,?)");
			pstmt.setString(1, uname);
			pstmt.setString(2, ctitle);
			pstmt.setString(3, cdescription);
			pstmt.setString(4, cdepartment);
			pstmt.setString(5, date);
			pstmt.setBinaryStream(6,fis,fis.available() );
			pstmt.setString(8, "pending");
			pstmt.setString(7, "null");
			int i=pstmt.executeUpdate();
			
			
			if(i>0)
			{
				response.sendRedirect("userDashboard.html");
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
