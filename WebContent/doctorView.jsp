<%@ page language="java" import = "java.sql.*, database.DBConn" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <title>Search Patient</title>
  </head>
  
  <body style="background-color:#3498DB;color:white;text-align:center;padding-top:50px;">
  
  <center><h3>Search Results</h3></center><br>
    <div class="container" style="text-align:left;">
  <table class="table table-hover">
  <thead>
    <tr>
      <th>Doctor's  Name</th>
    </tr>
  </thead>
<%
	
	Connection cn = DBConn.getConnect();
	PreparedStatement ps = cn.prepareStatement("select * from doctb");
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
%>
 
  <tbody>

    <tr>
      <td><%=rs.getString(1) %></td>
    </tr>
    </tbody>
    <%
	}
    %>
    </table></div> 
    <a href="admin-panel.jsp" class="btn btn-primary">Go Back</a>
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
  </body>
</html>