$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "chatear1":
            window.location.href = "ingresar";
            break;
        case "chatear2":
            $.post("recuperarChat", {
                id_producto: id
            }, function (responseText) {
                $("#modal").css("display", "flex");
                $("#modal").html(responseText);
            });
            break;
        case "recuperarEliminar":
            $.post("recuperarEliminar", {
                id_producto: id
            }, function (responseText) {
                $("#modal").css("display", "flex");
                $("#modal").html(responseText);
            });
            break;
        case "close-modal":
            $("#modal").css("display", "none");
            break;
        case "modal":
            if (e.target.id === 'modal') {
                $("#modal").css("display", "none");
            }
            break;
        case "negociar":
            var documento_identidad = $("#documento_identidad").val();
            var numero_folio = $("#numero_folio").val();
            var cantidad_venta = $("#cantidad").val();
            var precio_venta = $("#precio").val();
            var mensaje = $("#mensaje").val();
            var correo = $("#correo").val();
            var titulo = $("#titulo").val();
            var vendedor = $("#vendedor").val();
            if (documento_identidad.length !== 0 && numero_folio.length !== 0 && cantidad_venta.length !== 0 && precio_venta.length !== 0 &&
                    mensaje.length !== 0 && correo.length !== 0 && titulo.length !== 0 && vendedor.length !== 0) {
                $.post("crearVenta", {
                    documento_identidad: documento_identidad,
                    numero_folio: numero_folio,
                    cantidad_venta: cantidad_venta,
                    precio_venta: precio_venta,
                    mensaje: mensaje,
                    correo: correo,
                    titulo: titulo,
                    vendedor: vendedor
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

const abrirMenu = document.getElementById('button-menu-open');
const cerrarMenu = document.getElementById('button-menu-close');
const menu = document.getElementById('nav');

abrirMenu.addEventListener('click', () => {
    menu.classList.toggle('show');
});

cerrarMenu.addEventListener('click', () => {
    menu.classList.remove('show');
});

menu.addEventListener('click', e => {
    if (e.target.id === 'nav') {
        menu.classList.remove('show');
    }
});

const abrirPerfil = document.getElementById('button-perfil-open');
const cerrarPerfil = document.getElementById('button-perfil-close');
const perfil = document.getElementById('perfil');

abrirPerfil.addEventListener('click', () => {
    perfil.classList.toggle('show-perfil');
});

cerrarPerfil.addEventListener('click', () => {
    perfil.classList.remove('show-perfil');
});

perfil.addEventListener('click', e => {
    if (e.target.id === 'perfil') {
        perfil.classList.remove('show-perfil');
    }
});
