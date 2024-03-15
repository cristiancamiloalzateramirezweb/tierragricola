$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "departamento":
            $.post("municipios", {
                id_departamento: id
            }, function (responseText) {
                $("#municipio").html(responseText);
            });
            break;
        case "editarCuenta":
            var documento_identidad = $("#documento").val();
            var tipo_documento = $("#tipo_documento").val();
            var nombre = $("#nombre").val();
            var apellido = $("#apellido").val();
            var correo = $("#correo").val();
            var celular = $("#celular").val();
            var id_departamento = $("#departamento").val();
            var id_municipio = $("#municipio").val();
            var direccion = $("#direccion").val();
            if (documento_identidad.length !== 0 && tipo_documento.length !== 0 && nombre.length !== 0 && apellido.length !== 0 &&
                    correo.length !== 0 && celular.length !== 0 && id_departamento.length !== 0 && id_municipio.length !== 0 && direccion.length !== 0) {
                $.post("editarCuenta", {
                    documento_identidad: documento_identidad,
                    tipo_documento: tipo_documento,
                    nombre: nombre,
                    apellido: apellido,
                    correo: correo,
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
        case "editarFoto":
            var foto = $("#foto").val().replace('C:\\fakepath\\', '');
            if (foto.length !== 0) {
                $.post("editarFoto", {
                    foto: foto
                }, function (responseText) {
                    $("#respuesta-foto").html(responseText);
                });
            }
            break;
        case "editarPortada":
            var portada = $("#portada").val().replace('C:\\fakepath\\', '');
            if (portada.length !== 0) {
                $.post("editarPortada", {
                    portada: portada
                }, function (responseText) {
                    $("#respuesta-portada").html(responseText);
                });
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

const seleccionFoto = document.querySelector("#foto");
const imagenPrevisualizacionFoto = document.querySelector("#imagen-previsualizacion-foto");

seleccionFoto.addEventListener("change", () => {
    const foto = seleccionFoto.files;
    if (!foto || !foto.length) {
        imagenPrevisualizacionFoto.src = "";
        return;
    }
    const primerArchivoFoto = foto[0];
    const objectURL = URL.createObjectURL(primerArchivoFoto);
    imagenPrevisualizacionFoto.src = objectURL;
});

const seleccionPortada = document.querySelector("#portada");
const imagenPrevisualizacionPortada = document.querySelector("#imagen-previsualizacion-portada");
var contenedorOpcionesPortada = document.querySelector("#container-opciones-portada");

seleccionPortada.addEventListener("change", () => {
    const portada = seleccionPortada.files;
    if (!portada || !portada.length) {
        imagenPrevisualizacionPortada.src = "";
        return;
    }
    const primerArchivoPortada = portada[0];
    const objectURL = URL.createObjectURL(primerArchivoPortada);
    imagenPrevisualizacionPortada.src = objectURL;
    contenedorOpcionesPortada.style.display = "block";
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

const botonAbrirModalFoto = document.getElementById('abrirModalFoto');
const botonCerrarModalFoto = document.getElementById('cerrarModalFoto');
const modalFoto = document.getElementById('modal-foto');

botonAbrirModalFoto.addEventListener('click', () => {
    modalFoto.classList.toggle('show-modal-foto');
});
botonCerrarModalFoto.addEventListener('click', () => {
    modalFoto.classList.remove('show-modal-foto');
});

modalFoto.addEventListener('click', e => {
    if (e.target.id === 'modal-foto') {
        modalFoto.classList.remove('show-modal-foto');
    }
});
