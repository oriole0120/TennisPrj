function initialize() {
    //var myLatlng = new google.maps.LatLng(37.555170, 126.936789);
    var myLatlng = new google.maps.LatLng(37.4787274, 126.9034202);
    var mapOptions = {
        zoom: 17,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    
    var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
}