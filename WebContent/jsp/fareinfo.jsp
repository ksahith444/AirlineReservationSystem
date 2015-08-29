<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function myFunction() {
   var flightno = document.fareform.flightno.value;
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
	return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fair Info</title>
</head>
<body style="background-color:lightgrey" >
	<form name=fareform method="post" action="<%=getServletContext().getContextPath()%>/servletpath">
		<fieldset>
			<legend>Fair Information:</legend>
			Flight number :<br> <input type="text" name="flightno" autocomplete>
			<br>
			<br> 
			<input type="submit" value="Submit" onclick="return myFunction()"> 
			<input type="hidden" name="action" value="fairinfo" />
		</fieldset>
	</form>
</body>
</html>