package HealthDiseasePredicationPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DoctorRegisterServlet
 */
public class DoctorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorRegisterServlet() {
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
		int ID=0;
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String city=request.getParameter("city");
		String specialization=request.getParameter("specialization");
		
		
		try {
			Connection con=DBConnection.connect();
			PreparedStatement pstmt=con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, ID);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, pwd);
			pstmt.setLong(5, mobile);
			pstmt.setString(6, city);
			pstmt.setString(7, specialization);
			
			int i=pstmt.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("DoctorLogin.html");
		}
		else
		{
			response.sendRedirect("index.html");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
