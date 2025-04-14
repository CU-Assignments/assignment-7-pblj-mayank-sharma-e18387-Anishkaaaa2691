<%@ page import="yourpackage.StudentAttendance" %>
<%
  StudentAttendance s = (StudentAttendance) request.getAttribute("student");
%>
<html>
<body>
  <h2>Attendance Submitted Successfully!</h2>
  <p>Name: <%= s.getName() %></p>
  <p>Date: <%= s.getDate() %></p>
  <p>Status: <%= s.getStatus() %></p>
</body>
</html>
