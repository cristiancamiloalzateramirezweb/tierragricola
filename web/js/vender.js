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

const seleccionArchivos = document.querySelector("#catalogo");
const imagenPrevisualizacion = document.querySelector("#imagenPrevisualizacion");

seleccionArchivos.addEventListener("change", () => {
    const archivos = seleccionArchivos.files;
    if (!archivos || !archivos.length) {
        imagenPrevisualizacion.src = "";
        return;
    }
    const primerArchivo = archivos[0];
    const objectURL = URL.createObjectURL(primerArchivo);
    imagenPrevisualizacion.src = objectURL;
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


$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "id_seccion":
            $.post("categorias", {
                id_seccion: id
            }, function (responseText) {
                $("#id_categoria").html(responseText);
            });
            break;
        case "crearProducto":
            var id_seccion = $("#id_seccion").val();
            var id_categoria = $("#id_categoria").val();
            var titulo = $("#titulo").val();
            var catalogo = $("#catalogo").val().replace('C:\\fakepath\\','');
            var precio = $("#precio").val();
            var cantidad = $("#cantidad").val();
            var descripcion = $("#descripcion").val();
            if (id_seccion.length !== 0 && id_categoria.length !== 0 && titulo.length !== 0 && catalogo.length !== 0 && 
                    precio.length !== 0 && cantidad.length !== 0 && descripcion.length !== 0) {
                $.post("crearProducto", {
                    id_seccion: id_seccion,
                    id_categoria: id_categoria,
                    titulo: titulo,
                    catalogo: catalogo,
                    precio: precio,
                    cantidad: cantidad,
                    descripcion: descripcion
                }, function (responseText) {
                    $("#respuesta-vender").html(responseText);
                });
            } else {
                $("#respuesta-campos-vacios").css("display", "block");
                $("#respuesta-campos-vacios").html("Todos los campos son requeridos.");
            }
            break;
    }
});



