<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
function initialize() {
  var myLatlng = new google.maps.LatLng(-34.397, 150.644);
  var myOptions = {
  zoom: 8,
  center: myLatlng,
  mapTypeId: google.maps.MapTypeId.ROADMAP
}
var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
}
</script>
</head>
<body onload="initialize()">
  <div id="map_canvas" style="width:500px; height:300px;"></div>
</body>
</html>