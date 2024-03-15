<%@page import="modelo.DTO.DTODepartamento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<DTODepartamento> listaDepartamentos = (List<DTODepartamento>) request.getAttribute("departamentos");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>¡Hola! Crea tu Cuenta en Tierragricola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/registrate.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/crear-cuenta.js"></script>
    </head>
    <body>
        <header class="nav-header">
            <div class="nav-container">
                <div class="nav-logo2">
                    <a href="tierragricola">
                        Tierragr!cola&reg;
                    </a>
                </div>
                <div class="nav-menu2">
                    <ul class="list-menu2">
                        <li class="item-menu2">
                            <a href="" target="blank"><span class="icono-menu"><i class="fa-solid fa-question"></i></span> Ayudas</a>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
        <div class="container">
            <div class="container-formulario">
                <img src="./images/logo.jpeg">
                <h1> Crea tu Cuenta en Tierragr!cola</h1>
                <form autocomplete="off">
                    <div class="data-box">
                        <label for="documento">Número de Documento</label>
                        <input type="number" name="documento" id="documento" required>
                    </div>
                    <div class="data-box">
                        <label for="tipo_documento">Tipo de Documento</label>
                        <select name="tipo_documento" id="tipo_documento" required>
                            <option hidden></option>
                            <option value="Cédula de Ciudadanía">Cédula de Ciudadanía</option>
                            <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                            <option value="Cédula de Extranjeria">Cédula de Extranjeria</option>
                            <option value="Pasaporte">Pasaporte</option>
                            <option value="NIT">NIT</option>
                        </select>
                    </div>
                    <div class="data-box">
                        <label for="nombre">Nombre Completo</label>
                        <input type="text" name="nombre" id="nombre" required>
                    </div>
                    <div class="data-box">
                        <label for="apellido">Apellido Completo</label>
                        <input type="text" name="apellido" id="apellido" required>
                    </div>
                    <div class="data-box">
                        <label for="correo">Correo Electrónico</label>
                        <input type="email" name="correo" id="correo" required>
                    </div>
                    <div class="data-box">
                        <label for="clave1">Contraseña</label>
                        <div class="box-clave">
                            <input type="password" name="clave1" id="clave1" required>
                            <a class="ver-clave" onclick="verClave()">
                                <i class="fa-solid fa-eye" id='eyePass1'></i>
                            </a>
                        </div>
                    </div>
                    <div class="data-box">
                        <label for="clave2">Confirmé la Contraseña</label>
                        <div class="box-clave">
                            <input type="password" name="clave2" id="clave2" required>
                            <a class="ver-clave" onclick="verConfirmeClave()">
                                <i class="fa-solid fa-eye" id='eyePass2'></i>
                            </a>
                        </div>
                    </div>
                    <div class="data-box">
                        <label for="celular">Número de Celular</label>
                        <input type="number" name="celular" id="celular" required> 
                    </div>
                    <div class="data-box">
                        <label for="id_departamento">Departamento</label>
                        <select name="id_departamento" id="id_departamento" autocomplete="off" required>
                            <option hidden></option>
                            <% for (int i = 0; i < listaDepartamentos.size(); i++) {%>
                            <option value="<%=listaDepartamentos.get(i).getId_departamento()%>"><%=listaDepartamentos.get(i).getDepartamento()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="data-box">
                        <label for="id_municipio">Municipio</label>
                        <select name="id_municipio" id="id_municipio" required>
                        </select>
                    </div>
                    <div class="data-box">
                        <label for="direccion">Dirección</label>
                        <input type="text" name="direccion" id="direccion" required>
                    </div>
                    <button type="button" id="crearCuenta">Crear Cuenta</button>
                    <div id="respuestas">
                        <div id="respuesta-campos-vacios"></div>
                    </div>
                    <p>¿Tienes una Cuenta? <a href="ingresar" target="blank">Ingresa</a></p>
                </form>
            </div>
        </div>
        <div class="container-footer">
            <p class="footer">Tierragricola &copy; 2021 - 2022. Todos los derechos son reservados. Desarrollada por <a href="https://cristiancamiloweb.github.io/portafolio-web/">Cristian Camilo Alzate Ramirez.</a></p>
        </div>
        <div class="container-fijo"><i class="fas fa-angle-up"></i></div>
    </body>
</html>
