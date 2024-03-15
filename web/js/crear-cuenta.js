$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "id_departamento":
            $.post("municipios", {
                id_departamento: id
            }, function (responseText) {
                $("#id_municipio").html(responseText);
            });
            break;
        case "crearCuenta":
            var documento_identidad = $("#documento").val();
            var tipo_documento = $("#tipo_documento").val();
            var nombre = $("#nombre").val();
            var apellido = $("#apellido").val();
            var correo = $("#correo").val();
            var clave1 = $("#clave1").val();
            var clave2 = $("#clave2").val();
            var celular = $("#celular").val();
            var id_departamento = $("#id_departamento").val();
            var id_municipio = $("#id_municipio").val();
            var direccion = $("#direccion").val();
            if (clave1 === clave2) {
                var clave = clave1;
            } else {
                $("#respuesta-campos-vacios").css("display", "block");
                $("#respuesta-campos-vacios").html("Las contraseñas no coinciden.");
            }
            if (documento_identidad.length !== 0 && tipo_documento.length !== 0 && nombre.length !== 0 && apellido.length !== 0 &&
                    correo.length !== 0 && clave.length !== 0 && celular.length !== 0 && id_departamento.length !== 0 && 
                    id_municipio.length !== 0 && direccion.length !== 0) {
                $.post("crearCuenta", {
                    documento_identidad: documento_identidad,
                    tipo_documento: tipo_documento,
                    nombre: nombre,
                    apellido: apellido,
                    correo: correo,
                    clave: clave,
                    celular: celular,
                    id_departamento: id_departamento,
                    id_municipio: id_municipio,
                    direccion: direccion
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