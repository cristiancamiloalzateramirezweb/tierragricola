<%-- 
    Document   : editar
    Created on : 17/08/2022, 05:45:27 PM
    Author     : camil
--%>

<%@page import="modelo.DTO.DTOCategoria"%>
<%@page import="modelo.DTO.DTOSeccion"%>
<%@page import="modelo.DTO.DTOProducto"%>
<%@page import="modelo.DTO.DTOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession session1 = request.getSession(false);
    DTOUsuario usuario = (DTOUsuario) session1.getAttribute("usuario");
    DTOProducto producto = (DTOProducto) request.getAttribute("producto");
    DTOSeccion seccion = (DTOSeccion) request.getAttribute("seccion");
    DTOCategoria categoria = (DTOCategoria) request.getAttribute("categoria");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><%=usuario.getNombre()%> <%=usuario.getApellido()%> | Tierragricola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/editar-producto.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/editar.js"></script>
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
        <div class="contenedor-form-productos">
            <div class="container-formulario">
                <form autocomplete="off">
                    <h2>Editar Producto</h2>
                    <div class="info-data">
                        <h3>Categoría Seleccionada</h3>
                        <p><%=seccion.getNombre_seccion()%> / <%=categoria.getNombre_categoria()%></p>
                        <input type="hidden" name="id_producto" id="id_producto" value="<%=producto.getId_producto()%>">
                    </div>
                    <div class="info-data">
                        <p>Selecciona la Foto</p>
                        <div class="data-box data-box3">
                            <label for="catalogo" class="lugar-imagen">
                                <img src="./gallery/<%=producto.getCatalogo()%>"
                                     <i class="fa-solid fa-camera"></i>
                                <img id="imagenPrevisualizacion">
                            </label>
                            <input class="input-file" type="file" name="catalogo" id="catalogo" value="<%=producto.getCatalogo()%>" accept=".jpg, .jpeg, .png" required>
                        </div>
                    </div>
                    <div class="info-data">
                        <p>Sobre el producto</p>
                        <div class="data-box">
                            <label for="titulo">Como aparece el producto</label>
                            <input type="text" name="titulo" id="titulo" value="<%=producto.getTitulo_anuncio()%>">
                        </div>
                        <div class="data-box">
                            <label for="cantidad">Cantidad en venta</label>
                            <input type="number" name="cantidad" id="cantidad" value="<%=producto.getCantidad()%>">
                        </div>
                        <div class="data-box">
                            <label for="precio">Precio en venta</label>
                            <input type="number" name="precio" id="precio" value="<%=producto.getPrecio()%>">
                        </div>
                    </div>
                    <div class="info-data">
                        <p>La descripción</p>
                        <div class="data-box data-box2">
                            <label for="descripcion">Descripción</label>
                            <textarea name="descripcion" id="descripcion"><%=producto.getDescripcion_producto()%></textarea>
                        </div>
                    </div>
                    <div class="container-cambios">
                        <button type="button" id="editarProducto">Editar Producto</button>
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
