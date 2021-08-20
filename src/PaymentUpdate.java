

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/PaymentUpdate")
public class PaymentUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter pw = response.getWriter();
		String contact = request.getParameter("contact");
		String payment = request.getParameter("status");
		
		Connection cn = DBConn.getConnect();
		PreparedStatement ps=null;
		try {
			ps=cn.prepareStatement("update appointmenttb set payment=? where contact=?");
			ps.setString(1, payment);
			ps.setString(2, contact);
			int i = ps.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("update.jsp");
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
