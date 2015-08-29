<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function myFunction() {
   var passname = document.passflightform.form.passname.value;
   var alpha = /^[a-zA-z ]+$/;
	
	if(passname==null || passname == "")
	{
		alert("Please enter passenger name" );
		return false;
	}
	else if(!passname.match(alpha))
	{
		alert("Please enter only alphabets in passenger name field");
		return false;
	}
	return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Passenger Flight Info</title>
</head>
<body style="background-color:lightgrey" >
<form name="passflightform" method="post" action ="<%=getServletContext().getContextPath()%>/servletpath">
<fieldset>
<legend>Passenger Flight Info:</legend>
Passenger Name.:<br>
<input type="text" name="passname" autocomplete>
<br><br>
<input type="submit" value="Submit" onclick="return myFunction()">
<input type="hidden" name="action" value="passengerflightlist" />
</fieldset>
</form>
</body>
</html>