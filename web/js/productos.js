$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "archivarCompra":
            $.post("archivarCompra", {
                id_venta: id
            }, function (responseText) {
                $("#respuesta-compra").html(responseText);
            });
            break;
        case "desarchivarCompra":
            $.post("desarchivarCompra", {
                id_venta: id
            }, function (responseText) {
                $("#respuesta-compra").html(responseText);
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
    }

});

$(document).keyup(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "busqueda_producto":
            $.post("buscarmisproductos", {
                busqueda: id
            }, function (responseText) {
                $("#products-list").html(responseText);
            });
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

    // AGREGANDO CLASE ACTIVE AL PRIMER ENLACE 
    $('.filtro-compras .estado_compra_item[estadocompra="all"]').addClass('active-filtro');
    // FILTRANDO COMPRAS        
    $('.estado_compra_item').click(function () {
        var estadoCompra = $(this).attr('estadocompra');
        console.log(estadoCompra);
        // AGREGANDO CLASE ACTIVE AL ENLACE SELECCIONADO
        $('.estado_compra_item').removeClass('active-filtro');
        $(this).addClass('active-filtro');
        // OCULTANDO COMPRAS
        $('.product-item').css('transform', 'scale(0)');
        function hideProductCompras() {
            $('.product-item').hide();
        }
        setTimeout(hideProductCompras, 400);
        // MOSTRANDO COMPRAS
        function showProductCompras() {
            $('.product-item[estadocompra="' + estadoCompra + '"]').show();
            $('.product-item[estadocompra="' + estadoCompra + '"]').css('transform', 'scale(1)');
        }
        setTimeout(showProductCompras, 400);
    });
    // MOSTRANDO TODAS LAS COMPRAS 
    $('.estado_compra_item[estadocompra="all"]').click(function () {
        function showAllCompras() {
            $('.product-item').show();
            $('.product-item').css('transform', 'scale(1)');
        }
        setTimeout(showAllCompras, 400);
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

