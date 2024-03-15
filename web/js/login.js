function verClave() {
    var temp = document.getElementById("password");
    var icono = document.getElementById("eyePass");
    if (temp.type === "password") {
        temp.type = "text";
        icono.classList = "fa-solid fa-eye-slash";
    } else {
        temp.type = "password";
        icono.classList = "fa-solid fa-eye";
    }
}

$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "login":
            var documento = $("#documento").val();
            var clave = $("#password").val();
            if (documento.length !== 0 && clave.length !== 0) {
                $.post("ingresar", {
                    documento: documento,
                    clave: clave
                }, function (responseText) {
                    if (responseText === "tierragricola") {
                        location.href = "tierragricola";
                    } else {
                        $("#respuesta-ingresar").html(responseText);
                    }
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