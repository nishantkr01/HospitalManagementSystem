

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBConn;

@WebServlet("/Appoinment")
public class Appoinment extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		response.setHeader("Cache-Control", "no-catch, no-store, must-revalidate");
		response.setHeader("Pragma","no-catch"); //http 1.0
		response.setHeader("Expires","0"); //Proxies
		HttpSession session = request.getSession(false);
		if(session.getAttribute("username")!=null)
		{
		
		
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String doctor = request.getParameter("doctor");
		String payment = request.getParameter("payment");
		
		
		
		
		String place = request.getParameter("place");
	
		
		String Certificate = "Birth";
		PreparedStatement ps=null;
		try {
			Connection cn=DBConn.getConnect();
			 ps=cn.prepareStatement("insert into appointmenttb values(?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, contact);
			ps.setString(5, doctor);
			ps.setString(6, payment);
			
			int i = ps.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("appoinment.jsp");
			}
			
			
			
		}
			
		catch (SQLException e) {
			e.printStackTrace();
			out.println("<h5><center><font color='green'>Went Wrong !! </font></center></h5></h5>");
			RequestDispatcher rd = request.getRequestDispatcher("admin-pannel.jsp");
			rd.include(request, response);
			
		}
	}
	
	else
	{
		
	}
	
	}
}
		

		
