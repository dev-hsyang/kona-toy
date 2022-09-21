var container = document.getElementById('map'); // 지도를 담을 영역의 DOM 레퍼런스
var options = { // 지도 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(37.281951284830896, 127.0464130617505), // 지도의 중심 좌표
    level: 3 // 지도의 레벨 (확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options);
var latitude;
var longtitude;

kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    alert(mouseEvent.latLng);
    latitude = mouseEvent.latLng.getLat();
    longtitude = mouseEvent.latLng.getLng();
});

