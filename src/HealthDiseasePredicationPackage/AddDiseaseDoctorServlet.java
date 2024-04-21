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
 * Servlet implementation class AddDiseaseDoctorServlet
 */
public class AddDiseaseDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDiseaseDoctorServlet() {
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
		String symptom_1=request.getParameter("symptom_1");
		String symptom_2=request.getParameter("symptom_2");
		String symptom_3=request.getParameter("symptom_3");
		String specialization=request.getParameter("specialization");
		
		
		try {
			Connection con=DBConnection.connect();
			PreparedStatement pstmt=con.prepareStatement("insert into dataset values(?,?,?,?,?,?)");
			pstmt.setInt(1, ID);
			pstmt.setString(2, name);
			pstmt.setString(3, symptom_1);
			pstmt.setString(4, symptom_2);
			pstmt.setString(5, symptom_3);
			pstmt.setString(6, specialization);
			
			int i=pstmt.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("AddDiseaseDoctorSuccess.html");
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
