let map;
let service;
let infowindow;



function initMap() {
    const bogota = new google.maps.LatLng(4.714666155967801, -74.17854579826428);

    infowindow = new google.maps.InfoWindow();
    map = new google.maps.Map(document.getElementById("map"), {
        center: bogota,
        zoom: 15,
    });

    const ubicacion = document.querySelector('#checkout_shipping_address_address1').value;
    const pais = document.querySelector('#checkout_shipping_address_country').value;
    const departamento = document.querySelector('#checkout_shipping_address_province').value;
    const ciudad = document.querySelector('#checkout_shipping_address_city').value;

    const request = {
        query: ubicacion + " " + pais + " " + departamento + " " + ciudad,
        fields: ["name", "geometry"],
    };

    service = new google.maps.places.PlacesService(map);
    service.findPlaceFromQuery(request, (results, status) => {
        if (status === google.maps.places.PlacesServiceStatus.OK && results) {
            for (let i = 0; i < results.length; i++) {
                createMarker(results[i]);
            }
            map.setCenter(results[0].geometry.location);
        }
    });

    autocomplete = new google.maps.places.Autocomplete(document.getElementById("checkout_shipping_address_address1"), {
        componentRestrictions: {'country': ['col']},
        fields: ['', ''],
        types: ['address']
    });
}

function createMarker(place) {
    if (!place.geometry || !place.geometry.location)
        return;

    const marker = new google.maps.Marker({
        map,
        position: place.geometry.location,
    });

    google.maps.event.addListener(marker, "click", () => {
        infowindow.setContent(place.name || "");
        infowindow.open(map);
    });

}

window.initMap = initMap;

 