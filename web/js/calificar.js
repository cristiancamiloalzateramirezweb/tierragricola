$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "calificar":
            var calificacion = $("#calificacion").val();
            var observaciones = $("#observaciones").val();
            if (calificacion.length !== 0 && observaciones.length !== 0) {
                $.post("crearCalificacion", {
                    calificacion: calificacion,
                    observaciones: observaciones
                }, function (responseText) {
                    $("#respuestas").html(responseText);
                });
            } else {
                $("#respuesta-campos-vacios").css("display", "block");
                $("#respuesta-campos-vacios").html("Todos los campos son requeridos.");
            }
            break;
    }
});

$(document).ready(function () {

    $('.container-fijo').click(function () {
        $('body, html').animate({
            scrollTop: '0px'
        }, 200);
    });

    $(window).scroll(function () {
        if ($(this).scrollTop() > 0) {
            $('.container-fijo').slideDown(200);
        } else {
            $('.container-fijo').slideUp(200);
        }
    });

});