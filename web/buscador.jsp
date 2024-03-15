<%-- 
    Document   : Buscador
    Created on : 21/10/2021, 10:21:41 AM
    Author     : Camilo Alzate Ramire
--%>

<%@page import="modelo.DTO.DTOCategoria"%>
<%@page import="modelo.DTO.DTOMunicipio"%>
<%@page import="modelo.DTO.DTODepartamento"%>
<%@page import="modelo.DTO.DTOProducto"%>
<%@page import="modelo.DTO.DTOClienteProducto"%>
<%@page import="java.util.List"%>
<%@page import="modelo.DTO.DTOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session1 = request.getSession(false);
    DTOUsuario usuario = (DTOUsuario) session1.getAttribute("usuario");
    String busqueda = (String) request.getAttribute("busqueda");
    List<DTOClienteProducto> buscarClienteProducto = (List<DTOClienteProducto>) request.getAttribute("buscar_cliente_producto");
    List<DTOProducto> buscarProductos = (List<DTOProducto>) request.getAttribute("buscar_productos");
    List<DTODepartamento> buscarDepartamentos = (List<DTODepartamento>) request.getAttribute("buscar_departamentos");
    List<DTOMunicipio> buscarMunicipios = (List<DTOMunicipio>) request.getAttribute("buscar_municipios");
    List<DTOCategoria> buscarCategoria = (List<DTOCategoria>) request.getAttribute("buscar_categorias");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ha buscado <%=busqueda%> | Tierragricola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBcMvJb7zdnjOAkNGZa2fl6wPLkEL_Ufmg&libraries=places&callback=initMap"></script>
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/buscador.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/page.js"></script>
    </head>
    <body>
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
        <% if (buscarClienteProducto.size() == 0) {%>
        <div class="container-mensaje">
            <div class="icono">
                <i class="fa-brands fa-searchengin"></i>
            </div>
            <div class="mensaje">
                <h1><% if (usuario == null) {%><%} else if (usuario != null) {%><%=usuario.getNombre()%><%}%> No hay productos que coincidan con tu búsqueda.</h1>
                <ul>
                    <li>Revisa la ortografia de la palabra.</li>
                    <li>Utiliza palabras más generales.</li>
                    <li>Navega por las categorias para encontrar el producto.</li>
                </ul>
            </div>
        </div>
        <% } else {%>
        <div class="wrap">
            <h1>Resultados de la busqueda de "<%=busqueda%>".</h1>
            <div class="store-wrapper">
                <h2>Categorías:</h2>
                <div class="category_list">
                    <a href="ganaderia">Ganadería</a>
                    <a href="mascotas">Mascotas</a>
                    <a href="alimentos">Alimentos</a>
                    <a href="insumos">Insumos</a>
                </div>
                <section class="products-list">
                    <% for (int i = 0; i < buscarClienteProducto.size(); i++) {%>
                    <div class="product-item" title="<%=buscarProductos.get(i).getTitulo_anuncio()%>">
                        <% if (buscarProductos.get(i).getCantidad() <= 0) {%>
                        <h6 class="agotado">Vendido</h6>
                        <%}%>
                        <div class="cover-item">
                            <img src="./gallery/<%=buscarProductos.get(i).getCatalogo()%>">
                        </div>
                        <div class="info-item">
                            <p class="precio">$ <%=buscarProductos.get(i).getPrecio()%></p>
                            <p><%=buscarProductos.get(i).getTitulo_anuncio()%></p>
                            <p><%=buscarMunicipios.get(i).getMunicipio()%>, <%=buscarDepartamentos.get(i).getDepartamento()%></p>
                            <p>Publicado el <%=buscarProductos.get(i).getFecha_publicacion()%></p>
                            <a href="item?id=<%=buscarProductos.get(i).getId_producto()%>"><i class="fas fa-search"></i></a>
                        </div>
                    </div>
                    <% }%>
                    <% }%>
                </section>
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
    </body>
</html>
