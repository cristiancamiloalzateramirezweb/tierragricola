$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "recuperarContrasena":
            var correo = $("#destinatario").val();
            if (correo.length !== 0) {
                $.post("validarCorreoContrasena", {
                    correo: correo
                }, function (responseText) {
                    $("#respuestas").html(responseText);
                });
            } else {
                $("#respuesta-campos-vacios").css("display", "block");
                $("#respuesta-campos-vacios").html("El correo eléctronico es requerido.");
            }
            break;
        case "restablecerContrasena":
            var documento = $("#documento").val();
            var correo = $("#correo").val();
            var clave1 = $("#clave1").val();
            var clave2 = $("#clave2").val();
            if (clave1 === clave2) {
                var clave = clave1;
            } else {
                $("#respuesta-campos-vacios").css("display", "block");
                $("#respuesta-campos-vacios").html("Las contraseñas no coinciden.");
            }
            if (documento.length !== 0 && clave.length !== 0) {
                $.post("editarClave", {
                    documento: documento,
                    clave: clave,
                    correo: correo
                }, function (responseText) {
                    $("#respuestas").html(responseText);
                });
            } else {
                $("#respuesta-campos-vacios").css("display", "block");
                $("#respuesta-campos-vacios").html("Todos los campos son requeridos.");
            }
            break;
        case "cambiarContrasena":
            var clave1 = $("#clave1").val();
            var clave2 = $("#clave2").val();
            if (clave1 === clave2) {
                var clave = clave1;
            } else {
                $("#respuesta-campos-vacios").css("display", "block");
                $("#respuesta-campos-vacios").html("Las contraseñas no coinciden.");
            }
            if (clave.length !== 0) {
                $.post("cambiarClave", {
                    clave: clave
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


function verClave() {
    var box1 = document.getElementById("clave1");
    var icono1 = document.getElementById("eyePass1");
    if (box1.type === "password") {
        box1.type = "text";
        icono1.classList = "fa-solid fa-eye-slash";
    } else {
        box1.type = "password";
        icono1.classList = "fa-solid fa-eye";
    }
}

function verConfirmeClave() {
    var box2 = document.getElementById("clave2");
    var icono2 = document.getElementById("eyePass2");
    if (box2.type === "password") {
        box2.type = "text";
        icono2.classList = "fa-solid fa-eye-slash";
    } else {
        box2.type = "password";
        icono2.classList = "fa-solid fa-eye";
    }
}