package HealthDiseasePredicationPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PredictDiseaseServlet
 */
public class PredictDiseaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PredictDiseaseServlet() {
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
		int PID=GetSet.getPID();
		int DID;
		String PName=GetSet.getPName();
		String gender=GetSet.getGender();
		int age=GetSet.getAge();
		String Disease;
		String Specialization;
		//String symptom_1=request.getParameter("symptom_1");
		//System.out.println(symptom_1);
		//String symptom_2=request.getParameter("symptom_2");
		String symptom_1=GetSet.getSymptom_1();
		String symptom_2=GetSet.getSymptom_2();
		String symptom_3=request.getParameter("symptom_3");
		System.out.println(symptom_1);
		System.out.println(symptom_2);
		System.out.println(symptom_3);
		try {
			Connection con=DBConnection.connect();
			PreparedStatement pstmt=con.prepareStatement("select * from dataset where Symptom_1=? and Symptom_2=? and Symptom_3=?");
			pstmt.setString(1, symptom_1);
			pstmt.setString(2, symptom_2);
			pstmt.setString(3, symptom_3);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
            {
				Disease=rs.getString(2);
				Specialization=rs.getString(6);
				System.out.println(Disease);
				System.out.println(Specialization);
				PreparedStatement pstmt1=con.prepareStatement("select * from doctor where Specialization=?");
				pstmt1.setString(1, Specialization);
				ResultSet rs1=pstmt1.executeQuery();
				if(rs1.next())
				{
					DID=rs1.getInt(1);
					GetSet.setPredictDID(DID);
					System.out.println(DID);
					PreparedStatement pstmt2=con.prepareStatement("insert into patient_disease values(?,?,?,?,?,?,?,?,?,?)");
					pstmt2.setInt(1, ID);
					pstmt2.setInt(2, PID);
				    pstmt2.setString(3, PName);
				    pstmt2.setString(4, gender);
				    pstmt2.setInt(5, age);
				    pstmt2.setInt(6, DID);
				    pstmt2.setString(7, symptom_1);
				    pstmt2.setString(8, symptom_2);
				    pstmt2.setString(9, symptom_3);
				    pstmt2.setString(10, Disease);
				    int i=pstmt2.executeUpdate();
					if(i>0)
					{
						response.sendRedirect("PatientDiseasePredictedResult.jsp");
					}
					else
					{
						response.sendRedirect("index.html");
					}
				}
            }	    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
