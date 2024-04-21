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
 * Servlet implementation class DoctorLoginSuccessServlet
 */
public class DoctorLoginSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLoginSuccessServlet() {
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
		int DID;
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
        try {
        	Connection con=DBConnection.connect();
			PreparedStatement pstmt=con.prepareStatement("select * from doctor where Email=? and Password=?");
			pstmt.setString(1, email);
            pstmt.setString(2, pwd);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
            	DID=rs.getInt(1);
            	GetSet.setDID(DID);
            	response.sendRedirect("DoctorLoginSuccess.html");
            }
            else
            {
            	response.sendRedirect("Wrong.html");
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
