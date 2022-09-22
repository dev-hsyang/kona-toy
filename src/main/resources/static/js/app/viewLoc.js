var container = document.getElementById('map');
var latitude = $('#latitude').val();
var longtitude = $('#longtitude').val();
var iwContent = '<div style="padding:5px;">까꿍</div>'
var options = {
    center: new kakao.maps.LatLng(latitude, longtitude),
    level: 3
};
var map = new kakao.maps.Map(container, options);

var marker = new kakao.maps.Marker({
    map: map,
    position: new kakao.maps.LatLng(latitude, longtitude)
});

var infowindow = new kakao.maps.InfoWindow({
    content: iwContent
});

kakao.maps.event.addListener(marker, 'mouseover', function() {
    infowindow.open(map, marker);
});

kakao.maps.event.addListener(marker, 'mouseout', function() {
    infowindow.close();
});



