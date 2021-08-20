

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBConn;


@WebServlet("/AddDoctor")
public class AddDoctor extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cn = DBConn.getConnect();
		PreparedStatement ps = null;
		String name = request.getParameter("name");
		
		try {
			 ps=cn.prepareStatement("INSERT INTO doctb(name) VALUES (?)");
			ps.setString(1, name);
			int i = ps.executeUpdate();
			if(i==1)
			{
				
				HttpSession session = request.getSession();
				session.setAttribute("name",name);
				response.sendRedirect("doctorUpdate.jsp");
			}
			else
			{
				response.sendRedirect("error1.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			response.sendRedirect("error1.jsp");
		}
	}

}
