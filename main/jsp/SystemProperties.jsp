<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Print System Properties</title>
<style type="text/css" title="currentStyle">
			@import "http://www.datatables.net/release-datatables/media/css/demo_page.css";
			@import "http://www.datatables.net/release-datatables/media/css/demo_table.css";
</style>
<script type="text/javascript" src="http://www.datatables.net/release-datatables/media/js/jquery.js"></script>
<script type="text/javascript" src="http://www.datatables.net/release-datatables/media/js/jquery.dataTables.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#idTable').dataTable();
} );
</script>
</head>
<body>

<DIV>
<%
String userName = System.getProperty("user.name");
String osName = System.getProperty("os.name");
String osVersion = System.getProperty("os.version");
if("Windows Vista".equals(osName) && "6.1".equals(osVersion)){
	osName = "Windows 7";
}
out.print("Your username is <B>"+userName+"</B>, and System is <B>"+ osName +"\r\n");
%>
</DIV>

<DIV style="width: 80%; margin-top: 30px; margin-left: 5%;">
<%
Properties ps = System.getProperties();
List<String> keys = new ArrayList(ps.keySet());
Collections.sort(keys);
out.print("<table id=\"idTable\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"display\">\r\n");
out.print("<thead><tr><th>Key</th><th>Property</th></tr></thead>\r\n");
out.print("<tbody>\r\n");

String prop;
for(String key : keys){
    prop = ps.getProperty(key);
    prop = prop.replace("\n", "\\n").replace("\r", "\\r");
    out.print("<tr><td>"+ key +"</td><td>"+ prop +"</td></tr>\r\n");
}
out.print("</tbody></table>");
%>
</DIV>
</body>
</html>