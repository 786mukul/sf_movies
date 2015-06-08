 var map ;
$(document).ready(function(){/* google maps -----------------------------------------------------*/
google.maps.event.addDomListener(window, 'load', initialize);

function initialize() {

  /* position sanfrancisco*/
  var SF_SOUTH_WEST_LAT_LANG = new google.maps.LatLng(37.709369, -122.353829);
  var SF_NORTH_EAST_LAT_LANG = new google.maps.LatLng(37.819561, -122.537850);
  var SF_BOUNDS = new google.maps.LatLngBounds(SF_SOUTH_WEST_LAT_LANG, SF_NORTH_EAST_LAT_LANG);
  debugger;
  var SF_CENTER = new google.maps.LatLng(37.765681, -122.451208);
 
  var mapOptions = {
    center: SF_CENTER,
    scrollWheel: false,
    zoom: 12,
    draggable: false
  };
  
  
  
  map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
  
};
/* end google maps -----------------------------------------------------*/
});