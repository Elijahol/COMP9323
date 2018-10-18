$(document).ready(function(){
    let currLat = 0;
    let currLng = 0;
    var type = "transit";
    var map;

    function getCurrLocation() {
        if (navigator.geolocation){
            navigator.geolocation.getCurrentPosition(showPosition);
        }
    }
    function showPosition(position){
        currLat = position.coords.latitude;
        currLng = position.coords.longitude;
        console.log("Lat: " + currLat);
        console.log("Lng: " + currLng);
        getMap();
    }
    function getMap(){
        map = new GMaps({
            el:'#location',
            lat: currLat,
            lng: currLng
        });
        console.log(type);
        map.renderRoute({
            origin:[currLat,currLng],
            destination:"Sydney Airport, Sydney, NSW",
            travelMode: type,
            strokeColor: '#131540',
            strokeOpacity: 0.8,
            strokeWeight: 6
        },{
            panel:'#direction',
            draggable:true
        });
    }
    getCurrLocation();
    $(".nav-item").click(function () {
        $(".nav-item a").removeClass("show active");
        $(this).children("a").addClass("show active");
        $("#map-content").empty();
        type = $(this).children().text().trim().toLowerCase();
        console.log(type);
        $("#map-content").append("<div class='card-box'>" +
                                    "<h4 class='mb-3 header-title'>"+type+"</h4>" +
                                    "<div id='location' class='gmaps'></div>" +
                                    "</div>" +
                                    "<div class='card-box'>" +
                                    "<div id='direction'></div>" +
                                "</div>");
        getCurrLocation();
    });


});
