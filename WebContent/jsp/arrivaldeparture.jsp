<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
function myFunction() {
   var depaircode = document.arrdepform.depaircode.value;
   var arraircode = document.arrdepform.arraircode.value;
   
   var alpha = /^[a-zA-z ]+$/;
	var num = /^[0-9]+$/;
	
	if(depaircode==null || depaircode == "")
	{
		alert("Please enter departure airport code" );
		return false;
	}
	else if(!depaircode.match(alpha))
	{
		alert("Please enter only alphabets in departure airport code");
		return false;
	}
	if(arraircode==null || arraircode == "")
	{
		alert("Please enter arrival airport code");
		return false;
	}
	else if(!arraircode.match(alpha))
	{
		alert("Please enter only alphabets in arrival airport code");
		return false;
	}
	return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flights between cities</title>
</head>
<body style="background-color:lightgrey" >
<form name="arrdepform" method="post" action="<%=getServletContext().getContextPath()%>/servletpath">
<fieldset>
<legend>Arrival Departure information:</legend>
Departure Airport Code:<br>
<input type="text" name="depaircode" id="depaircode">
<br>
Arrival Airport code:<br>
<input type="text" name="arraircode" >
<br>
Number of connecting flights:
<select name="noofcon">
  <option value="0">0</option>
  <option value="1">1</option>
  <option value="2">2</option>
</select>
<br>
<input type="submit" value="Submit" onclick="return myFunction()">
<input type="hidden" name="action" value="arrivaldeparture" />
</fieldset>
</form>
</body>
</html>