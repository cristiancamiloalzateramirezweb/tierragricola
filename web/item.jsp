<%-- 
    Document   : item
    Created on : 4/08/2022, 10:25:28 PM
    Author     : camil
--%>

<%@page import="modelo.DTO.DTOCategoria"%>
<%@page import="modelo.DTO.DTOSeccion"%>
<%@page import="modelo.DTO.DTOProducto"%>
<%@page import="modelo.DTO.DTOClienteProducto"%>
<%@page import="modelo.DTO.DTOMunicipio"%>
<%@page import="modelo.DTO.DTODepartamento"%>
<%@page import="modelo.DTO.DTOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session1 = request.getSession(false);
    DTOUsuario usuario = (DTOUsuario) session1.getAttribute("usuario");
    DTOUsuario cliente = (DTOUsuario) request.getAttribute("cliente");
    DTODepartamento departamento = (DTODepartamento) request.getAttribute("departamento");
    DTOMunicipio municipio = (DTOMunicipio) request.getAttribute("municipio");
    DTOProducto producto = (DTOProducto) request.getAttribute("producto");
    DTOSeccion seccion = (DTOSeccion) request.getAttribute("seccion");
    DTOCategoria categoria = (DTOCategoria) request.getAttribute("categoria");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><%=producto.getTitulo_anuncio()%> - <%=seccion.getNombre_seccion()%>, <%=categoria.getNombre_categoria()%> | Tierragricola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBcMvJb7zdnjOAkNGZa2fl6wPLkEL_Ufmg&libraries=places&callback=initMap"></script>
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/item.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/item.js"></script>
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
        <div class="container-item">
            <div class="content-item">
                <div class="container-info1">
                    <div class="container-album">
                        <img src="./gallery/<%=producto.getCatalogo()%>">
                    </div>
                    <div class="container-acerca">
                        <h2>Descripción</h2>
                        <p><%=producto.getDescripcion_producto()%></p>
                    </div>
                </div>
                <div class="container-info2">
                    <div class="container-data-producto">
                        <h1><%=producto.getTitulo_anuncio()%></h1>
                        <h2>$ <%=producto.getPrecio()%></h2>
                        <p>Cantidad <%=producto.getCantidad()%></p>
                        <p><%=cliente.getDireccion()%>, <%=municipio.getMunicipio()%>, <%=departamento.getDepartamento()%></p>
                        <p>Publicado el <%=producto.getFecha_publicacion()%></p>
                    </div>
                    <div class="container-data-vendedor">
                        <h2>Descripción del Vendedor</h2>
                        <div class="item-vendedor">
                            <div class="foto">
                                <img src="./photos/<%=cliente.getFoto()%>">
                            </div>
                            <div class="data">
                                <h3><%=cliente.getNombre()%> <%=cliente.getApellido()%></h3>
                                <p>Miembro desde el <%=cliente.getFecha_miembro()%></p>
                                <div class="botones">
                                    <% if (usuario == null) {%>
                                    <button type="button" id="chatear1">Chatea con el vendedor</button>
                                    <%} else if (usuario != null) {%>
                                    <% if (usuario.getDocumento_identidad().equals(cliente.getDocumento_identidad())) {%>
                                    <a href="editar?id=<%=producto.getId_producto()%>">Editar</a>
                                    <button class="btn-enlace" type="button" id="recuperarEliminar" value="<%=producto.getId_producto()%>">Eliminar</button>
                                    <%} else {%>
                                    <% if (producto.getCantidad() > 0) {%>
                                    <button type="button" id="chatear2" value="<%=producto.getId_producto()%>">Chatea con el vendedor</button>
                                    <%} else {%>
                                    <button disabled="true">Chatea con el vendedor</button>
                                    <%}%>
                                    <%}%>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container-data-ubicacion">
                        <h2>Publicado en</h2>
                        <p><%=cliente.getDireccion()%>, <%=municipio.getMunicipio()%>, <%=departamento.getDepartamento()%></p>
                        <input type="hidden" id="checkout_shipping_address_address1" placeholder="Ubicación" oninput="initMap()" value="<%=cliente.getDireccion()%>">
                        <input type="hidden" id="checkout_shipping_address_country" placeholder="País" oninput="initMap()" value="Colombia">
                        <input type="hidden" id="checkout_shipping_address_province" placeholder="Departamento" oninput="initMap()" value="<%=departamento.getDepartamento()%>">
                        <input type="hidden" id="checkout_shipping_address_city" placeholder="Ciudad" oninput="initMap()" value="<%=municipio.getMunicipio()%>">
                        <div id="map"></div>
                    </div>
                </div>
            </div>
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
        <script defer src="./js/mapa.js"></script>
    </body>
</html>
