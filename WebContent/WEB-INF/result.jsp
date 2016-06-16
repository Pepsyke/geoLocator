<!DOCTYPE html>
<html>
<head>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>
	function initialize() {
		var mapProp = {
			center : new google.maps.LatLng(51.508742, -0.120850),
			zoom : 5,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapProp);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body onload="load()">
	<h1>Result Page</h1>
	<br />
	<h3>Country: ${country}</h3>
	<h3>City: ${city}</h3>
	<br />
	<div id="googleMap" style="width:500px;height:380px;"></div>

	<a href="<%=request.getContextPath()%>/main/search">Back to
		search</a>
</body>
</html>