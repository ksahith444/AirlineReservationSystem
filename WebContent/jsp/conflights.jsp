<%@page import="java.util.ArrayList"%>
<%@page import="models.reservation"%>
<%@page import="java.lang.Integer" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available flights</title>
</head>
<body style="background-color:lightgrey" >
<% Integer typeofFlight = (Integer)request.getAttribute("arrayListType");%>

  
	<h3>Number of connecting flights needed: <%=typeofFlight%></h3>
	<% if (request.getAttribute("arrayList")!=null) 
	   {
		ArrayList <reservation> arrreserv = (ArrayList <reservation> )request.getAttribute("arrayList");
		%> 
		
		<% if(typeofFlight==0) { %>
		<h2>Number of connecting flights found : <%=arrreserv.size() %></h2>
		<table>
				<tr>
				<th>Departure Airport code</th>
			    <th>Scheduled departure time </th>
			    <th>Arrival Airport code </th>
			    <th>Scheduled arrival time</th>
			     <th>Weekdays </th>
			    </tr>
		<% for(int i=0;i<arrreserv.size();i++)
		{
			reservation rs1 = arrreserv.get(i);
			%>
				
			    <tr>
				<td><%=rs1.getDepaircode() %>  </td>
			    <td><%=rs1.getScheduled_departure_time() %></td>
			    <td><%=rs1.getArraircode() %></td>
			    <td><%=rs1.getScheduled_arrival_time() %></td>
			    <td><%=rs1.getWeekdays() %></td>
			    </tr> 
			    
			    <tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr>
			    <% 	}%>
		
		</table>
		<%} 
		
		 else if(typeofFlight==1) {%>
		<h2>Number of connecting flights found : <%=arrreserv.size()/2 %></h2>
		<table>
				<tr>
				<th>Departure Airport code</th>
			    <th>Scheduled departure time </th>
			    <th>Arrival Airport code </th>
			    <th>Scheduled arrival time</th>
			    <th>Weekdays </th>
			    </tr>
			    
			  
		<% for(int i=0;i<arrreserv.size();i=i+2)
		{
			reservation rs1 = arrreserv.get(i);
			reservation rs2 = arrreserv.get(i+1);
			%>
				
			    <tr>
				<td><%=rs1.getDepaircode() %>  </td>
			    <td><%=rs1.getScheduled_departure_time() %> </td>
			    <td><%=rs1.getArraircode() %></td>
			    <td><%=rs1.getScheduled_arrival_time() %></td>
			    <td><%=rs1.getWeekdays() %></td>
			    </tr> 
			    <tr>
				<td><%=rs2.getDepaircode() %>  </td>
			    <td><%=rs2.getScheduled_departure_time() %></td>
			    <td><%=rs2.getArraircode() %></td>
			    <td><%=rs2.getScheduled_arrival_time() %></td>
			    <td><%=rs2.getWeekdays() %></td>
			    </tr> 
			    <tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr>
			    
	<% 	}
		%>
		</table>
 <%}
		 else if(typeofFlight==2) {%>
  <h2>Number of connecting flights found : <%=arrreserv.size()/3 %></h2>
		<table>
				<tr>
				<th>Departure Airport code</th>
			    <th>Scheduled departure time </th>
			    <th>Arrival Airport code </th>
			    <th>Scheduled arrival time</th>
			    <th>Weekdays </th>
			    </tr>
			    
			    <% for(int i=0;i<arrreserv.size();i=i+3){
			reservation rs1 = arrreserv.get(i);
			reservation rs2 = arrreserv.get(i+1);
			reservation rs3 = arrreserv.get(i+2);
			%>
				
			    <tr>
				<td><%=rs1.getDepaircode() %>  </td>
			    <td><%=rs1.getScheduled_departure_time() %></td>
			    <td><%=rs1.getArraircode() %></td>
			    <td><%=rs1.getScheduled_arrival_time() %></td>
			    <td><%=rs1.getWeekdays() %></td>
			    </tr> 
			    <tr>
				<td><%=rs2.getDepaircode() %>  </td>
			    <td><%=rs2.getScheduled_departure_time() %></td>
			    <td><%=rs2.getArraircode() %></td>
			    <td><%=rs2.getScheduled_arrival_time() %></td>
			    <td><%=rs2.getWeekdays() %></td>
			    </tr> 
			    <tr>
				<td><%=rs3.getDepaircode() %>  </td>
			    <td><%=rs3.getScheduled_departure_time() %></td>
			    <td><%=rs3.getArraircode() %></td>
			    <td><%=rs3.getScheduled_arrival_time() %></td>
			    <td><%=rs3.getWeekdays() %></td>
			    </tr>
			    <tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr>
			    <tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr><tr><%out.newLine(); %></tr>
			    
	<% 	} %>
		</table>
  <% } %>
 
<% }

else{ %>
	<h2>No results found for the given source and destination</h2>
	<% }
 %>

</body>
</html>