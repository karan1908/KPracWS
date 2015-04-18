<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<script type="text/javascript">

</script>

<title>Show Result</title></head>
<body>
<table border="1">
	<tr> <th>Header</th><th>Value</th>
	</tr>
	<tr>
		<td>Bean Result</td>
		<td><%= request.getAttribute("bean.result")%></td>
	</tr>
</table>
</body>
</html>