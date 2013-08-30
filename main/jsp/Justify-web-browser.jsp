<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Justify Web Browser</title>
</head>
<body>
<script type="text/javascript">
document.write("Browser CodeName: " + navigator.appCodeName);
document.write("<br /><br />");
document.write("Browser Name: " + navigator.appName);
document.write("<br /><br />");
document.write("Browser Version: " + navigator.appVersion);
document.write("<br /><br />");
document.write("Cookies Enabled: " + navigator.cookieEnabled);
document.write("<br /><br />");
document.write("Platform: " + navigator.platform);
document.write("<br /><br />");
document.write("User-agent header: " + navigator.userAgent +"<br /><br /><br /><br />");
var isIE = window.navigator.userAgent.indexOf("MSIE")>0;
var isFirefox = window.navigator.userAgent.indexOf("Firefox")>0;
document.write("Browser is IE: " + isIE +"<br /><br />");
document.write("Browser is Firefox: " + isFirefox+ "<br /><br />");
</script>

<%
	
	out.print("<p/>******************************************************************************************<p/>");
	String ua = request.getHeader( "User-Agent" );
	boolean isIE = ( ua != null && ua.indexOf( "MSIE" ) >0 );
	boolean isFirefox = ( ua != null && ua.indexOf( "Firefox/" ) >0 );
	
	out.print(ua +"<br /><br />");
	out.print("Browser is IE: " + isIE +"<br /><br />");
	out.print("Browser is Firefox: " + isFirefox +"<br /><br />");

%>
</body>
</html>