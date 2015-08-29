<%@page import="java.util.ArrayList"%>
<%@page import="models.reservation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Passengers List result</title>
</head>
<body style="background-color:lightgrey" >
	<%
	ArrayList <reservation> arrreserv = (ArrayList <reservation> )request.getAttribute("arrayList");
	
 if (arrreserv.size()!=0){
	
	
		%>
		<h2>Number of results found for the flight instance: <%= arrreserv.size() %></h2>
		<table>
		<tr>
		<th> Seat number </th>
	    <th> Customer Name </th>
	    <th> Customer phone number </th>
	    </tr>
	    
	    <% for(int i=0;i<arrreserv.size();i++)
		{
			reservation rs1 = arrreserv.get(i);
			
			%>
			 <tr>
				<td><%=rs1.getSeatno() %>  </td>
			    <td><%=rs1.getCustomerName() %> </td>
			    <td><%=rs1.getContactNumber() %></td>
			    </tr> 
			    
			    <tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr>
			    <%} %>
			    </table>
			    
	<% }
	
	else{ %>
	<h2>No results found for the given flight instance</h2>
	<% }%>
</body>
</html>