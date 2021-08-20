<%@ page language="java" import="javax.servlet.http.Cookie, java.sql.*, database.DBConn" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String uname = request.getParameter("contact");
Connection cn = DBConn.getConnect();
PreparedStatement ps = cn.prepareStatement("delete FROM appointmenttb WHERE contact = (?)");
ps.setString(1, uname);
int i = ps.executeUpdate();
if(i==1)
{
	%>
	
    <jsp:forward page="deletedSuccessfully.jsp"></jsp:forward>
	<%
}
%>

</body>
</html>