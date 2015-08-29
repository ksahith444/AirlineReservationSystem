<%@page import="java.util.ArrayList"%>
<%@page import="models.reservation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seats Availability Results</title>
</head>
<body style="background-color:lightgrey" >
<%
ArrayList <reservation> arrreserv = (ArrayList <reservation> )request.getAttribute("arrayList");
 if (arrreserv.size()!=0){
		
			reservation rs1 = arrreserv.get(0);
			%>
			<h2>Number of seats available are : <%=rs1.getNumberofavailablesets() %></h2>  
			
		<%} 
		
		else{ %>
	<h2>No results found for the given flight instance</h2>
	<% }%>
	    
</body>
</html>