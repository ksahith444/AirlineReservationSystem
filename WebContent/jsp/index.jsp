<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Airline Reservation</title>
</head>

<body style="background-color:lightgrey" >
<h1 align="center" > Airline Reservation System</h1>
 
    <table colour:"black"  style="font-family:courier ">
      <tr>
      <th><a href="<%=getServletContext().getContextPath()%>/jsp/arrivaldeparture.jsp">Arrivals Departures list</a></th>
      <th><a href="<%=getServletContext().getContextPath()%>/jsp/seatsavailable.jsp">Seats Available </a></th>
      <th><a href="<%=getServletContext().getContextPath()%>/jsp/fareinfo.jsp">Fare Information </a></th>
      <th><a href="<%=getServletContext().getContextPath()%>/jsp/passengerslist.jsp">Passengers List on Flight </a></th>
      <th><a href="<%=getServletContext().getContextPath()%>/jsp/passengerflightlist.jsp">Passenger Flight Info </a></th>
      </tr>
      </table>
 


</body>
</html>