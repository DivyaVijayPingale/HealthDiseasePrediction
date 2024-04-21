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
 * Servlet implementation class PatientRegisterServlet
 */
public class PatientRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegisterServlet() {
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
		String gender=request.getParameter("gender");
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String address=request.getParameter("address");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		
		try {
			Connection con=DBConnection.connect();
			PreparedStatement pstmt=con.prepareStatement("insert into patient_details values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, ID);
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setString(4, age);
			pstmt.setString(5, email);
			pstmt.setString(6, pwd);
			pstmt.setString(7, address);
			pstmt.setLong(8, mobile);
			int i=pstmt.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("PatientLogin.html");
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
