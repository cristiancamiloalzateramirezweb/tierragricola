<%-- 
    Document   : newjsp
    Created on : 29/08/2022, 08:37:31 AM
    Author     : camil
--%>

<%@page import="modelo.DTO.DTOEstadoVenta"%>
<%@page import="modelo.DTO.DTOClienteProducto"%>
<%@page import="modelo.DTO.DTOVenta"%>
<%@page import="modelo.DTO.DTOProducto"%>
<%@page import="java.util.List"%>
<%@page import="modelo.DTO.DTOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session1 = request.getSession(false);
    DTOUsuario usuario = (DTOUsuario) session1.getAttribute("usuario");
    List<DTOProducto> listarProductosCliente = (List<DTOProducto>) request.getAttribute("listar_productos");
    List<DTOClienteProducto> listarClienteProductoCliente = (List<DTOClienteProducto>) request.getAttribute("listar_cliente_producto");
    List<DTOProducto> listarProductosComprasCliente = (List<DTOProducto>) request.getAttribute("listar_productos_compras");
    List<DTOVenta> listarComprasProductoCliente = (List<DTOVenta>) request.getAttribute("listar_compras_producto");
    List<DTOEstadoVenta> listarEstadoComprasCliente = (List<DTOEstadoVenta>) request.getAttribute("listar_estado_compras");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><%=usuario.getNombre()%> <%=usuario.getApellido()%> | Tierragricola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel=  "stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/productos.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/productos.js"></script>
    </head>
    <body>
        <div id="modal" class="modal">
        </div>
        <header class="main-header" id="nav">
            <nav class="main-nav">
                <div class="nav-logo">
                    <a href="tierragricola">
                        Tierragr!cola&reg;
                    </a>
                    <button id="button-menu-close" class="button-menu2">
                        <i class="fa-solid fa-xmark"></i>
                    </button>
                </div>
                <ul class="nav-links">
                    <li class="title-item">
                        Categorías
                    </li>
                    <li class="link-item">
                        <a href="ganaderia" target="blank"><span class="decor-item"></span>Ganadería</a>
                    </li>
                    <li class="link-item">
                        <a href="mascotas" target="blank"><span class="decor-item"></span>Mascotas</a>
                    </li>
                    <li class="link-item">
                        <a href="alimentos" target="blank"><span class="decor-item"></span>Alimentos</a>
                    </li>
                    <li class="link-item">
                        <a href="insumos" target="blank"><span class="decor-item"></span>Insumos</a>
                    </li>
                </ul>
            </nav>
        </header>
        <header class="nav-header">
            <div class="nav-container">
                <button id="button-menu-open" class="button-menu">
                    <i class="fa-solid fa-bars"></i>
                </button>
                <div class="nav-logo2">
                    <a href="tierragricola">
                        Tierragr!cola&reg;
                    </a>
                </div>
                <div class="search-bar">
                    <form action="buscador" method="get">
                        <input class="search-box" type="search" name="busqueda" id="busqueda" placeholder="¿Qué producto estás buscando?, Buscalo aqui...">
                        <button class="btnbuscar"><i class="fas fa-search"></i></button>
                    </form>
                </div>
                <div class="nav-menu2">
                    <ul class="list-menu2">
                        <li class="item-menu2" id="button-perfil-open">
                            <% if (usuario == null) {%>
                            <span class="icono-menu"><i class="fa-solid fa-user"></i></span><p>Mi Cuenta<p>
                            <%} else if (usuario != null) {%>
                            <span class="icono-menu"><i class="fa-solid fa-user"></i></span><p><%=usuario.getNombre()%><p>
                            <%}%>
                        </li>
                        <li class="item-menu2">
                            <a href="vender" target="blank"><span class="icono-menu"><i class="fa-solid fa-warehouse"></i></span><p>Vender</p></a>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
        <div class="perfil-header" id="perfil">
            <div class="perfil-nav">
                <div class="container-header">
                    <% if (usuario == null) {%>
                    <h3><i class="fa-solid fa-user"></i> Mi Cuenta</h3>
                    <%} else if (usuario != null) {%>
                    <h3><i class="fa-solid fa-user"></i> <%=usuario.getNombre()%></h3>
                    <%}%>
                    <button id="button-perfil-close">
                        <i class="fa-solid fa-xmark"></i>
                    </button>
                </div>
                <% if (usuario == null) {%>
                <div class="container-cuenta">
                    <div class="ingresar">
                        <h2>Ingresa a tu cuenta en Tierragricola para ver tus productos, compras, negociaciones y mucho más.</h2>
                        <a href="ingresar">Ingresar</a>
                    </div>
                    <div class="crear-cuenta">
                        <h2>Crea una cuenta en Tierragricola para acceder a los servicios.</h2>
                        <a href="creacuenta">Crear una Cuenta</a>
                    </div> 
                </div>
                <%} else if (usuario != null) {%>
                <div class="container-perfil">
                    <div class="contenido-usuario">
                        <div class="foto-perfil">
                            <img src="./photos/<%=usuario.getFoto()%>">
                        </div>
                        <div class="name-perfil">
                            <p><%=usuario.getNombre()%> <%=usuario.getApellido()%></p>
                            <a href="perfil" target="blank"><i class="fa-solid fa-user"></i> Ver y Editar Cuenta</a>
                        </div>
                    </div>
                    <div class="menu-perfil">
                        <ul>
                            <li>
                                <a href="productos#mis-productos" target="blank">
                                    <span class="icon-menu-perfil"><i class="fa-solid fa-bag-shopping"></i></span> Mis Productos <span class="decor-item"></span>
                                </a>
                            </li>
                            <li>
                                <a href="productos#mis-compras" target="blank">
                                    <span class="icon-menu-perfil"><i class="fa-solid fa-cart-shopping"></i></span> Mis Compras <span class="decor-item"></span>
                                </a>
                            </li>
                            <li>
                                <a href="vender" target="blank">
                                    <span class="icon-menu-perfil"><i class="fa-solid fa-warehouse"></i></span> Vender <span class="decor-item"></span>
                                </a>
                            </li>
                            <li>
                                <a href="manuales-ayudas.html" target="blank">
                                    <span class="icon-menu-perfil"><i class="fa-solid fa-question"></i></span> Ayudas <span class="decor-item"></span>
                                </a>
                            </li>
                            <li>
                                <a href="cambiarcontrasena" target="blank">
                                    <span class="icon-menu-perfil"><i class="fas fa-unlock-alt"></i></span> Cambiar Contraseña <span class="decor-item"></span>
                                </a>
                            </li>
                            <li>
                                <a href="salir">
                                    <span class="icon-menu-perfil"><i class="fa-solid fa-right-from-bracket"></i></span> Salir <span class="decor-item"></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
        <div class="menu">
            <ul>
                <li>
                    <a href="#mis-productos">Mis Productos</a>
                </li>
                <li>
                    <a href="#mis-compras">Mis Compras</a>
                </li>
            </ul>
        </div>
        <div class="mis-productos" id="mis-productos">
            <% if (listarClienteProductoCliente.size() == 0) {%>
            <div class="no-productos">
                <i class="fa-brands fa-buysellads"></i>
                <h4>¡No has publicado nada aún!</h4>
                <p>Vende lo que no uses aqui.</p>
                <a href="vender">Vender</a>
            </div>
            <% } else {%>
            <h1>Mis Productos</h1>
            <div class="search-bar-mis-productos">
                <form autocomplete="off">
                    <i class="fa-solid fa-magnifying-glass"></i>
                    <input class="search-box" type="text" name="busqueda_producto" id="busqueda_producto" placeholder="Busca por titulo del producto">
                </form>
            </div>
            <section class="products-list" id="products-list">
                <% for (int i = 0; i < listarClienteProductoCliente.size(); i++) {%>
                <div class="product-item">
                    <div class="header-item">
                        <h2>Publicado el:<br><%=listarProductosCliente.get(i).getFecha_publicacion()%></h2>
                    </div>
                    <div class="data-item">
                        <div class="item-foto">
                            <img src="./gallery/<%=listarProductosCliente.get(i).getCatalogo()%>">
                        </div>
                        <div class="item-info">
                            <h3><%=listarProductosCliente.get(i).getTitulo_anuncio()%></h3>
                            <p>$ <%=listarProductosCliente.get(i).getPrecio()%></p>
                            <p>Cantidad: <%=listarProductosCliente.get(i).getCantidad()%></p>
                        </div>
                        <div class="item-descripcion">
                            <p><%=listarProductosCliente.get(i).getDescripcion_producto()%></p>
                        </div>
                    </div>
                    <div class="options-item">
                        <a href="editar?id=<%=listarProductosCliente.get(i).getId_producto()%>" class="edit">Editar</a>
                        <button class="delete" type="button" id="recuperarEliminar" value="<%=listarProductosCliente.get(i).getId_producto()%>">Eliminar</button>
                        <a href="solicitudes?id=<%=listarClienteProductoCliente.get(i).getNumero_folio()%>" class="edit">Solicitudes</a>
                    </div>
                </div>
                <% }%>
            </section>
            <% }%>
        </div>
        <div class="mis-compras" id="mis-compras">
            <% if (listarComprasProductoCliente.size() == 0) {%>
            <div class="no-compras">
                <i class="fa-solid fa-cart-shopping"></i>
                <h4>¡No has comprado nada aún!</h4>
                <p>Compra lo que necesites aqui.</p>
            </div>
            <% } else {%>
            <h1>Mis Compras</h1>
            <div class="filtro-compras">
                <a href="#mis-compras" class="estado_compra_item" estadocompra="all">Todas</a>
                <a href="#mis-compras" class="estado_compra_item" estadocompra="Archivada">Archivadas</a>
                <a href="#mis-compras" class="estado_compra_item" estadocompra="Desarchivada">Desarchivadas</a>
            </div>
            <div id="respuesta-compra"></div>
            <section class="products-list">
                <% for (int i = 0; i < listarComprasProductoCliente.size(); i++) {%>
                <div class="product-item" estadocompra="<%=listarEstadoComprasCliente.get(i).getEstado_venta()%>">
                    <div class="header-item">
                        <h2>Publicado el:<br><%=listarProductosComprasCliente.get(i).getFecha_publicacion()%></h2>
                    </div>
                    <div class="data-item">
                        <div class="item-foto">
                            <img src="./gallery/<%=listarProductosComprasCliente.get(i).getCatalogo()%>">
                        </div>
                        <div class="item-info">
                            <h3><%=listarProductosComprasCliente.get(i).getTitulo_anuncio()%></h3>
                            <p>$ <%=listarProductosComprasCliente.get(i).getPrecio()%> ~ $ <%=listarComprasProductoCliente.get(i).getPrecio_venta()%></p>
                            <p>Cantidad: <%=listarProductosComprasCliente.get(i).getCantidad()%> ~ Solicitada: <%=listarComprasProductoCliente.get(i).getCantidad_venta()%></p>
                            <% if (listarComprasProductoCliente.get(i).getId_estado_venta() == 1) {%>
                            <div class="estado pendiente">Pendiente</div>
                            <%} else if (listarComprasProductoCliente.get(i).getId_estado_venta() == 2) {%>
                            <div class="estado aceptada">Aceptada</div>
                            <%} else if (listarComprasProductoCliente.get(i).getId_estado_venta() == 3) {%>
                            <div class="estado rechazada">Rechazada</div>
                            <%}%>
                        </div>
                        <div class="item-descripcion">
                            <p><%=listarProductosComprasCliente.get(i).getDescripcion_producto()%></p>
                        </div>
                    </div>
                    <div class="options-item">
                        <% if (listarComprasProductoCliente.get(i).getId_estado_compra() == 4) {%>
                        <button type="button" class="delete" id="desarchivarCompra" value="<%=listarComprasProductoCliente.get(i).getId_venta()%>">Desarchivar</button>
                        <%} else if (listarComprasProductoCliente.get(i).getId_estado_compra() == 5) {%>
                        <button type="button" class="delete" id="archivarCompra" value="<%=listarComprasProductoCliente.get(i).getId_venta()%>">Archivar</button>
                        <%}%>
                    </div>
                </div>
                <% }%>
            </section>
            <% }%>
        </div>
        <div class="container-footer">
            <div class="content content-app">
                <img src="./images/logo.jpeg">
                <h3>Tierragr!cola&reg;</h3>
            </div>
            <div class="content content-acerca">
                <h3>Sobre Tierragricola</h3>
                <p>Somos Tierragricola nuestro proposito es minimizar intermediarios en la venta de productos del campo y transformar la vida de los campesinos colombianos.</p>
            </div>
            <div class="content content-enlaces">
                <h3>Enlaces</h3>
                <ul>
                    <li>
                        <a href="ganaderia">Ganadería</a>
                    </li>
                    <li>
                        <a href="mascotas">Mascotas</a>
                    </li>
                    <li>
                        <a href="alimentos">Alimentos</a>
                    </li>
                    <li>
                        <a href="insumos">Insumos</a>
                    </li>
                    <li>
                        <a href="vender">Vender</a>
                    </li>
                </ul>
            </div>
            <div class="content content-social">
                <h3>Siguenos</h3>
                <ul>
                    <li>
                        <a href=""><i class="fa-brands fa-facebook"></i></a>
                    </li>
                    <li>
                        <a href=""><i class="fa-brands fa-instagram"></i></a>
                    </li>
                    <li>
                        <a href=""><i class="fa-brands fa-youtube"></i></a>
                    </li>
                </ul>
            </div>
            <div class="content content-footer">
                <p class="footer">Tierragricola &copy; 2021 - 2022. Todos los derechos son reservados. Desarrollada por <a href="https://cristiancamiloweb.github.io/portafolio-web/">Cristian Camilo Alzate Ramirez.</a></p>
            </div>
        </div>
        <div class="container-fijo"><i class="fas fa-angle-up"></i></div>
    </body>
</html>
