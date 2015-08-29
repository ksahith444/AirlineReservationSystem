<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
function myFunction() {
   var flightno = document.passlistform.flightno.value;
   var date = document.passlistform.date.value;
	var num = /^[0-9]+$/;
	
	if(flightno==null || flightno == "")
	{
		alert("Please enter flight number" );
		return false;
	}
	else if(!flightno.match(num))
	{
		alert("Please enter only numbers in flight number field");
		return false;
	}
	if(date==null || date == "")
	{
		alert("Please select date .");
		return false;
	}
	return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
   <link href="<%=getServletContext().getContextPath() %>/css/calendar.css" rel="stylesheet" type="text/css" />
  
 <script type="text/javascript" language="javascript" src="<%=getServletContext().getContextPath() %>/jscript/calendar.js"></script>

 
<title>Passengers List</title>
</head>
<body style="background-color:lightgrey" >
<form name="passlistform" method="post" action ="<%=getServletContext().getContextPath()%>/servletpath">
<fieldset>
<legend>Passengers List:</legend>
Flight no.:<br>
<input type="text" name="flightno" autocomplete>
<br>
Date:<br>
<input type="text" name="date" size="20" readonly="readonly">
<jsp:include page="calender.jsp" flush="true"/>
<br><br>
<input type="submit" value="Submit" onclick="return myFunction()">
<input type="hidden" name="action" value="passengerslist" />
</fieldset>
</form>
</body>
</html>