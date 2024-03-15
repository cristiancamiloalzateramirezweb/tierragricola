<%-- 
    Document   : solicitudes
    Created on : 29/08/2022, 11:16:50 AM
    Author     : camil
--%>

<%@page import="modelo.DTO.DTOEstadoVenta"%>
<%@page import="modelo.DTO.DTOVenta"%>
<%@page import="modelo.DTO.DTOClienteProducto"%>
<%@page import="modelo.DTO.DTOProducto"%>
<%@page import="java.util.List"%>
<%@page import="modelo.DTO.DTOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session1 = request.getSession(false);
    DTOUsuario usuario = (DTOUsuario) session1.getAttribute("usuario");
    DTOProducto productoFolio = (DTOProducto) request.getAttribute("producto");
    List<DTOClienteProducto> listarClienteProductoVentas = (List<DTOClienteProducto>) request.getAttribute("cliente_producto_ventas");
    List<DTOProducto> listarProductoVentasCliente = (List<DTOProducto>) request.getAttribute("producto_ventas_cliente");
    List<DTOVenta> listarVentasProductoCliente = (List<DTOVenta>) request.getAttribute("ventas_producto_cliente");
    List<DTOEstadoVenta> listarEstadoNegociosCliente = (List<DTOEstadoVenta>) request.getAttribute("estado_negocio_cliente");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><%=usuario.getNombre()%> <%=usuario.getApellido()%>, Solicitudes de <%=productoFolio.getTitulo_anuncio()%> | Tierragricola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/solicitudes.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/solicitudes.js"></script>
    </head>
    <body>
        <header class="nav-header">
            <div class="nav-container">
                <div class="nav-logo2">
                    <a href="javascript:history.back()">
                        <i class="fa-solid fa-arrow-left"></i>
                    </a>
                </div>
            </div>
        </header>
        <div class="mis-productos">
            <h1>Solicitudes de "<%=productoFolio.getTitulo_anuncio()%>"</h1>
            <% if (listarClienteProductoVentas.size() == 0) {%>
            <div class="no-productos">
                <i class="fa-solid fa-handshake"></i>
                <h4>¡No hay solicitudes aún!</h4>
                <p>Espera que llegue una solicitud por el producto.</p>
            </div>
            <% } else {%>
            <div class="filtro-compras">
                <a href="#" class="estado_compra_item" estadocompra="all">Todas</a>
                <a href="#" class="estado_compra_item" estadocompra="Archivada">Archivadas</a>
                <a href="#" class="estado_compra_item" estadocompra="Desarchivada">Desarchivadas</a>
            </div>
            <div id="respuestas"></div>
            <section class="products-list">
                <% for (int i = 0; i < listarClienteProductoVentas.size(); i++) {%>
                <div class="product-item" estadocompra="<%=listarEstadoNegociosCliente.get(i).getEstado_venta()%>">
                    <div class="header-item">
                        <h2>Publicado el:<br><%=listarProductoVentasCliente.get(i).getFecha_publicacion()%></h2>
                    </div>
                    <div class="data-item">
                        <div class="item-foto">
                            <img src="./gallery/<%=listarProductoVentasCliente.get(i).getCatalogo()%>">
                        </div>
                        <div class="item-info">
                            <h3><%=listarProductoVentasCliente.get(i).getTitulo_anuncio()%></h3>
                            <p>$ <%=listarVentasProductoCliente.get(i).getPrecio_venta()%></p>
                            <p>Cantidad: <%=listarVentasProductoCliente.get(i).getCantidad_venta()%></p>
                            <% if (listarVentasProductoCliente.get(i).getId_estado_venta() == 1) {%>
                            <div class="estado pendiente">Pendiente</div>
                            <%} else if (listarVentasProductoCliente.get(i).getId_estado_venta() == 2) {%>
                            <div class="estado aceptada">Aceptada</div>
                            <%} else if (listarVentasProductoCliente.get(i).getId_estado_venta() == 3) {%>
                            <div class="estado rechazada">Rechazada</div>
                            <%}%>
                        </div>
                        <div class="item-descripcion">
                            <p><%=listarVentasProductoCliente.get(i).getMensaje()%></p>
                        </div>
                    </div>
                    <div class="options-item">
                        <% if (listarVentasProductoCliente.get(i).getId_estado_venta() == 2 || listarVentasProductoCliente.get(i).getId_estado_venta() == 3) {%>
                        
                        <%} else if (listarVentasProductoCliente.get(i).getId_estado_venta() == 1){%>
                        <button type="button" class="edit" id="responderVenta" value="<%=listarVentasProductoCliente.get(i).getId_venta()%>">Responder</button>
                        <%}%>
                        <% if (listarVentasProductoCliente.get(i).getId_estado_negociacion() == 4) {%>
                        <button type="button" class="delete" id="desarchivarNegocio" value="<%=listarVentasProductoCliente.get(i).getId_venta()%>">Desarchivar</button>
                        <%} else if (listarVentasProductoCliente.get(i).getId_estado_negociacion() == 5) {%>
                        <button type="button" class="delete" id="archivarNegocio" value="<%=listarVentasProductoCliente.get(i).getId_venta()%>">Archivar</button>
                        <%}%>
                    </div>
                </div>
                <%}%>
            </section>
            <%}%>
        </div>
        <div id="modal-responder-negocio" class="modal">

        </div>
        <div class="container-footer">
            <p class="footer">Tierragricola &copy; 2021 - 2022. Todos los derechos son reservados. Desarrollada por <a href="https://cristiancamiloweb.github.io/portafolio-web/">Cristian Camilo Alzate Ramirez.</a></p>
        </div>
        <div class="container-fijo"><i class="fas fa-angle-up"></i></div>
    </body>
</html>
