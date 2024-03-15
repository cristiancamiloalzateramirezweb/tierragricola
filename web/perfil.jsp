<%-- 
    Document   : Datos
    Created on : 27/05/2021, 08:21:44 PM
    Author     : Camilo Alzate Ramire
--%>
<%@page import="modelo.DTO.DTOEstadoVenta"%>
<%@page import="modelo.DTO.DTODepartamento"%>
<%@page import="modelo.DTO.DTOClienteProducto"%>
<%@page import="modelo.DTO.DTOVenta"%>
<%@page import="modelo.DTO.DTOProducto"%>
<%@page import="java.util.List"%>
<%@page import="modelo.DTO.DTOMunicipio"%>
<%@page import="modelo.DTO.DTOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session1 = request.getSession(false);
    DTOUsuario usuario = (DTOUsuario) session1.getAttribute("usuario");
    DTODepartamento departamento = (DTODepartamento) request.getAttribute("departamento");
    DTOMunicipio municipio = (DTOMunicipio) request.getAttribute("municipio");
    List<DTODepartamento> listaDepartamentos = (List<DTODepartamento>) request.getAttribute("departamentos");
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
        <link rel="stylesheet" href="./css/perfil.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/perfil.js"></script>
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
        <div class="contenedor-decoracion">
            <div class="portada-usuario">
                <div class="container-opciones-portada" id="container-opciones-portada">
                    <div id="respuesta-portada">
                        <div id="respuesta-campos-vacios"></div>
                    </div>
                    <button type="button" id="editarPortada">Guardar</button>
                    <input class="input-file" type="file" name="portada" id="portada" value="<%=usuario.getPortada()%>" accept=".jpg, .jpeg, .png" required>
                </div>
                <img src="./covers/<%=usuario.getPortada()%>">
                <img id="imagen-previsualizacion-portada">
                <label for="portada" class="boton-portada"><i class="fa-solid fa-camera"></i> Editar Foto de Portada</label>
            </div>
            <div class="adicional-usuario">
                <div class="foto-usuario">
                    <img src="./photos/<%=usuario.getFoto()%>">
                    <button type="button" id="abrirModalFoto"><i class="fa-solid fa-camera"></i></button>
                </div>
                <div class="info-usuario">
                    <h1><%=usuario.getNombre()%> <%=usuario.getApellido()%></h1>
                    <p>Miembro desde el <%=usuario.getFecha_miembro()%></p>
                    <a href="productos#mis-productos"><i class="fa-solid fa-badge-dollar"></i> Vea y Edita Perfil de Productos</a>
                </div>
            </div>
        </div>
        <div id="modal-foto" class="modal-foto">
            <div class="contenido-modal-foto">
                <div class="header-modal">
                    <h2>Editar Foto de Perfil</h2>
                    <button id="cerrarModalFoto" class="button-close-modal">
                        <i class="fa-solid fa-xmark"></i>
                    </button>
                </div>
                <div class="foto">
                    <label for="foto" class="lugar-imagen">
                        <img id="imagen-previsualizacion-foto">
                        <img src="./photos/<%=usuario.getFoto()%>">
                    </label>
                    <input class="input-file" type="file" name="foto" id="foto" value="<%=usuario.getFoto()%>" accept=".jpg, .jpeg, .png" required>
                </div>
                <div class="info">
                    <div class="name">
                        <%=usuario.getNombre()%> <%=usuario.getApellido()%>
                    </div>
                    <button type="button" id="editarFoto">Guardar</button>
                    <div id="respuesta-foto">
                        <div id="respuesta-campos-vacios"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="mis-datos" id="mis-datos">
            <h1>Mis Datos</h1>
            <form autocomplete="off">
                <div class="container-info">
                    <div class="container-title">
                        <h2>Datos Personales</h2>
                    </div>
                    <div class="info-data">
                        <div class="data-box">
                            <label for="documento">Número de Documento</label>
                            <input disabled type="text" name="documento" id="documento" value="<%=usuario.getDocumento_identidad()%>">
                        </div>
                        <div class="data-box">
                            <label for="tipo_documento">Tipo de Documento</label>
                            <select name="tipo_documento" id="tipo_documento">
                                <option value="Cédula de Ciudadanía">Cédula de Ciudadanía</option>
                                <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                                <option value="Cédula de Extranjeria">Cédula de Extranjeria</option>
                                <option value="Pasaporte">Pasaporte</option>
                                <option value="NIT">NIT</option>
                            </select>
                        </div>
                        <div class="data-box">
                            <label for="nombre">Nombre Completo</label>
                            <input type="text" name="nombre" id="nombre" value="<%=usuario.getNombre()%>">
                        </div>
                        <div class="data-box">
                            <label for="apellido">Apellido Completo</label>
                            <input type="text" name="apellido" id="apellido" value="<%=usuario.getApellido()%>">
                        </div>
                    </div>
                    <div class="div-content content1">
                        <h3 class="titulo">¿Por qué es importante actualizar la información en Tierragricola?</h3>
                        <p>
                            Tierragricola se basa en la confianza. Ayuda a que otras personas te conozcan.
                            Registra y publica lo que deseas vender a tus clientes, busca lo que deseas comprar y 
                            notaras los resultados...
                        </p>
                    </div>
                </div>
                <div class="container-info">
                    <div class="container-title">
                        <h2>Datos Contacto</h2>
                    </div>
                    <div class="info-data">
                        <div class="data-box">
                            <label for="correo">Correo Electrónico</label>
                            <input type="text" name="correo" id="correo" value="<%=usuario.getCorreo()%>">
                        </div>
                        <div class="data-box">
                            <label for="celular">Número de Celular</label>
                            <input type="text" name="celular" id="celular" value="<%=usuario.getCelular()%>">
                        </div>
                    </div>
                    <div class="div-content content2">
                        <h3 class="titulo">Actualiza tu Información de Contacto</h3>
                        <p>
                            Actualiza la Información de contacto en Tierragricola para 
                            que te puedan contactar facilmente.
                        </p>
                    </div>
                </div>
                <div class="container-info">
                    <div class="container-title">
                        <h2>Datos Ubicación</h2>
                    </div>
                    <div class="info-data">
                        <div class="data-box">
                            <label for="departamento">Departamento</label>
                            <select name="departamento" id="departamento">
                                <option value="<%=departamento.getId_departamento()%>"><%=departamento.getDepartamento()%></option>
                                <% for (int i = 0; i < listaDepartamentos.size(); i++) {%>
                                <option value="<%=listaDepartamentos.get(i).getId_departamento()%>"><%=listaDepartamentos.get(i).getDepartamento()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="data-box">
                            <label for="municipio">Municipio</label>
                            <select name="municipio" id="municipio">
                                <option value="<%=municipio.getId_municipio()%>"><%=municipio.getMunicipio()%></option>
                            </select>
                        </div>
                        <div class="data-box">
                            <label for="direccion">Dirección</label>
                            <input type="text" name="direccion" id="direccion" value="<%=usuario.getDireccion()%>">
                        </div>
                    </div>
                    <div class="div-content content3">
                        <h3 class="titulo">Actualiza tu Información de Ubicación</h3>
                        <p>
                            Actualiza Información de tu ubicación en Tierragricola 
                            para que te ubiquen y puedan acceder al producto.
                        </p>
                    </div>
                </div>
                <div class="container-cambios">
                    <button class="btn-edit" type="button" id="editarCuenta">Actualizar Cuenta</button>
                    <button class="btn-delete" type="button" id="eliminarCuenta">Eliminar Cuenta</button>
                    <div id="respuestas">
                        <div id="respuesta-campos-vacios"></div>
                    </div>
                </div>
            </form>
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

