<%@page import="java.util.ArrayList"%>
<%@page import="models.reservation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Passenger Flight Info results</title>
</head>
<body style="background-color:lightgrey" >

<% 
ArrayList <reservation> arrreserv = (ArrayList <reservation> )request.getAttribute("arrayList");

if (arrreserv.size()!=0){
	
		%>
		<h2>Number of flight instance found : <%= arrreserv.size() %></h2>
		<table>
		<tr>
		<th> Flight Number </th>
	    <th> Date </th>
	    </tr>
	     <% for(int i=0;i<arrreserv.size();i++)
		{
			reservation rs1 = arrreserv.get(i);
			
			%>
			 <tr>
				<td><%=rs1.getFlight_number() %>  </td>
			    <td><%=rs1.getDate() %> </td>
			    </tr> 
			    
			    <tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr>
			    <%} %>
			    </table>
			    
	<% }
else{ %>
<h2>No results found for the given customer name</h2>
<% }%>
</body>
</html>