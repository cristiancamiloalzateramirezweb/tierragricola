<%-- 
    Document   : Vender
    Created on : 29/07/2021, 05:45:41 PM
    Author     : Camilo Alzate Ramire
--%>

<%@page import="modelo.DTO.DTOProducto"%>
<%@page import="java.util.List"%>
<%@page import="modelo.DTO.DTOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session1 = request.getSession(false);
    DTOUsuario usuario = (DTOUsuario) session1.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>¡Hola <%=usuario.getNombre()%>!, Vender | Tierragricola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/vender.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/vender.js"></script>
    </head>
    <body>
        <header class="nav-header">
            <div class="nav-container">
                <div class="nav-logo2">
                    <a href="javascript:history.back()">
                        <i class="fa-solid fa-arrow-left"></i>
                    </a>
                </div>
                <div class="nav-menu2">
                    <ul class="list-menu2">
                        <li class="item-menu2" id="button-perfil-open">
                            <% if (usuario == null) {%>
                            <span class="icono-menu"><i class="fa-solid fa-user"></i></span> <p>Mi Cuenta<p>
                            <%} else if (usuario != null) {%>
                            <span class="icono-menu"><i class="fa-solid fa-user"></i></span> <p><%=usuario.getNombre()%><p>
                            <%}%>
                        </li>
                        <li class="item-menu2">
                            <a href="" target="blank"><span class="icono-menu"><i class="fa-solid fa-question"></i></span> Ayudas</a>
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
        <div class="contenedor-form-productos">
            <div class="container-background">
                <img src="./images/background-vender.jpg">
                <h1>¡Hola! ¿Qué vas a vender?</h1>
            </div>
            <div class="container-formulario">
                <form autocomplete="off">
                    <h2>Publica tu Producto</h2>
                    <div class="info-data">
                        <p>Selecciona la Foto</p>
                        <div class="data-box data-box3">
                            <label for="catalogo" class="lugar-imagen"><i class="fa-solid fa-camera"></i><img id="imagenPrevisualizacion"></label>
                            <input class="input-file" type="file" name="catalogo" id="catalogo" accept=".jpg, .jpeg, .png" required>
                        </div>
                    </div>
                    <div class="info-data">
                        <p>¿Que quieres vender?</p>
                        <div class="data-box">
                            <label for="id_seccion">Elige una Categoría</label>
                            <select name="id_seccion" id="id_seccion">
                                <option>Categoría</option>
                                <option value="1">Ganadería</option>
                                <option value="2">Mascotas</option>
                                <option value="3">Alimentos</option>
                                <option value="4">Insumos</option>
                            </select>
                        </div>
                        <div class="data-box">
                            <label for="id_categoria">Elige una Sección</label>
                            <select name="id_categoria" id="id_categoria">
                                <option>Sección</option>
                            </select>
                        </div>
                    </div>
                    <div class="info-data">
                        <p>Valora tu producto</p>
                        <div class="data-box">
                            <label for="titulo">¿Como quieres que aparezca tu producto?</label>
                            <input type="text" name="titulo" id="titulo" placeholder="Titulo del Anuncio">
                        </div>
                        <div class="data-box">
                            <label for="cantidad">¿Que cantidad vas a vender?</label>
                            <input type="number" name="cantidad" id="cantidad" placeholder="0">
                        </div>
                        <div class="data-box">
                            <label for="precio">¿En cuanto lo vas a vender?</label>
                            <input type="number" name="precio" id="precio" placeholder="$">
                        </div>
                    </div>
                    <div class="info-data">
                        <p>Por último describalo</p>
                        <div class="data-box data-box2">
                            <label for="descripcion">¿Como lo describes?</label>
                            <textarea name="descripcion" id="descripcion" placeholder="Descripción..."></textarea>
                        </div>
                    </div>
                    <div class="container-cambios">
                        <button type="button" id="crearProducto">Publicar Producto</button>
                        <div id="respuesta-vender">
                            <div id="respuesta-campos-vacios"></div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="container-footer">
            <p class="footer">Tierragricola &copy; 2021 - 2022. Todos los derechos son reservados. Desarrollada por <a href="https://cristiancamiloweb.github.io/portafolio-web/">Cristian Camilo Alzate Ramirez.</a></p>
        </div>
        <div class="container-fijo"><i class="fas fa-angle-up"></i></div>
    </body>
</html>