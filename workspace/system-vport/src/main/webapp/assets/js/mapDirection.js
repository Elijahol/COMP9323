$(document).ready(function(){
    let currLat = -33.9162998;
    let currLng = 151.2313394;
    var type = "transit";
    var map;
    var destination = $("#addr").val();
//    function getCurrLocation() {
//        if (navigator.geolocation){
//            navigator.geolocation.getCurrentPosition(showPosition);
//        }
//    }
//    function showPosition(position){
//        currLat = position.coords.latitude;
//        currLng = position.coords.longitude;
//        getMap();
//    }
    function getMap(){
        map = new GMaps({
            el:'#location',
            lat: currLat,
            lng: currLng
        });
        
        map.renderRoute({
            origin:[currLat,currLng],
            destination:destination,
            travelMode: type,
            strokeColor: '#131540',
            strokeOpacity: 0.8,
            strokeWeight: 6
        },{
            panel:'#direction',
            draggable:true
        });
    }
    getMap();
    $(".nav-item").click(function () {
        $(".nav-item a").removeClass("show active");
        $(this).children("a").addClass("show active");
        $("#map-content").empty();
        type = $(this).children().text().trim().toLowerCase();
        $("#map-content").html("<div class='card-box'>" +
                                    "<h4 class='mb-3 header-title'>"+type+"</h4>" +
                                    "<div id='location' class='gmaps'></div>" +
                                    "</div>" +
                                    "<div class='card-box'>" +
                                    "<div id='direction'></div>" +
                                "</div>");
        getMap();
    });


});
