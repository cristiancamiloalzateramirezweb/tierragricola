$(document).click(function (e) {
    var boton = e.target.id;
    var id = e.target.value;
    switch (boton) {
        case "archivarNegocio":
            $.post("archivarNegocio", {
                id_venta: id
            }, function (responseText) {
                $("#respuestas").html(responseText);
            });
            break;
        case "desarchivarNegocio":
            $.post("desarchivarNegocio", {
                id_venta: id
            }, function (responseText) {
                $("#respuestas").html(responseText);
            });
            break;
        case "responderVenta":
            $.post("responderVenta", {
                id_venta: id
            }, function (responseText) {
                $("#modal-responder-negocio").css("display", "block");
                $("#modal-responder-negocio").html(responseText);
            });
            break;
        case "close-modal":
            $("#modal-responder-negocio").css("display", "none");
            break;
        case "modal-responder-negocio":
            if (e.target.id === 'modal-responder-negocio') {
                $("#modal-responder-negocio").css("display", "none");
            }
            break;
        case "aceptarVenta":
            var id_venta = $("#id_venta").val();
            var numero_folio = $("#numero_folio").val();
            var destinatario_comprador = $("#correo_comprador").val();
            var destinatario_vendedor = $("#correo_vendedor").val();
            var producto = $("#titulo").val();
            var vendedor = $("#vendedor").val();
            var comprador = $("#comprador").val();
            $.post("aceptarNegocio", {
                id_venta: id_venta,
                numero_folio: numero_folio,
                destinatario_comprador: destinatario_comprador,
                destinatario_vendedor: destinatario_vendedor,
                producto: producto,
                vendedor: vendedor,
                comprador: comprador
            }, function (responseText) {
                $("#respuestas-negocio").html(responseText);
            });
            break;
        case "rechazarVenta":
            var id_venta_rechazar = $("#id_venta").val();
            var destinatario_comprador_rechazar = $("#correo_comprador").val();
            var destinatario_vendedor_rechazar = $("#correo_vendedor").val();
            var producto_rechazar = $("#titulo").val();
            var vendedor_rechazar = $("#vendedor").val();
            var comprador_rechazar = $("#comprador").val();
            $.post("rechazarNegocio", {
                id_venta: id_venta_rechazar,
                destinatario_comprador: destinatario_comprador_rechazar,
                destinatario_vendedor: destinatario_vendedor_rechazar,
                producto: producto_rechazar,
                vendedor: vendedor_rechazar,
                comprador: comprador_rechazar
            }, function (responseText) {
                $("#respuestas-negocio").html(responseText);
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

const modalButtonCerrar = document.getElementById('close-modal');
const modalWrapper = document.getElementById('modal-responder-negocio');

modalButtonCerrar.addEventListener('click', () => {
    modalWrapper.style.display = "none";
});

modalWrapper.addEventListener('click', e => {
    if (e.target.id === 'modal-responder-negocio') {
        modalWrapper.style.display = "none";
    }
});
