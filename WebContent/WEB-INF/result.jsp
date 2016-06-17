<!DOCTYPE html>
<html>
<head>

<style>

#floating-panel {
		width: 200px;
        align: left;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
}
</style>
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
		var geocoder = new google.maps.Geocoder();
		document.getElementById('submit').addEventListener('click', function() {
	          geocodeAddress(geocoder, map);
		});
	}
	google.maps.event.addDomListener(window, 'load', initialize);
	
	function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === google.maps.GeocoderStatus.OK) {
            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
    }
	
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
	<br />
	<div id="floating-panel">
      <input id="address" type="textbox" value="${city}">
      <input id="submit" type="button" value="Geocode">
    </div>

	<a href="<%=request.getContextPath()%>/main/search">Back to
		search</a>
</body>
</html>