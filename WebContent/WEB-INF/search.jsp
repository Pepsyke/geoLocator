<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css"/>
	<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
	<h1>Search Page</h1>
	<br />
	<form method="post" action="result">
		IPv4 address:	
		<input type="number" name="first" max="255" min="0" required="required" />.
		<input type="number" name="second" max="255" min="0" required="required" />.
		<input type="number" name="third" max="255" min="0" required="required" />.
		<input type="number" name="fourth" max="255" min="0" required="required" /> <br />
		<input type="submit" value="Search" />
	</form>
	
	<h4>${info}</h4>
</body>
</html>