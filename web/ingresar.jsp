<%-- 
    Document   : ingresar
    Created on : 1/09/2022, 05:52:52 PM
    Author     : camil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>¡Hola Tierragricola! Ingresa a Tierragricola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/inicia-session.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/login.js"></script>
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
                <h1>Ingresa a Tierragr!cola</h2>
                <div id="respuesta-ingresar">
                    <div id="respuesta-campos-vacios"></div>
                </div>
                <form action="login" method="post">
                    <div class="data-box">
                        <label for="documento">Documento de Identidad</label>
                        <input type="number" name="documento" id="documento" required>
                    </div>
                    <div class="data-box">
                        <label for="password">Contraseña</label>
                        <div class="box-clave">
                            <input type="password" name="password" id="password" required>
                            <a class="ver-clave" onclick="verClave()">
                                <i class="fa-solid fa-eye" id='eyePass'></i>
                            </a>
                        </div>
                    </div>
                    <button>Ingresar</button>
                    <a href="recuperarcontrasena" class="olvide-contraseña">¿Olvidaste tu contraseña?</a>
                    <p class="a">¿Aún no tienes una cuenta? <a href="creacuenta" target="blank">Crea una Cuenta</a></p>
                </form>
            </div>
        </div>
        <div class="container-footer">
            <p class="footer">Tierragricola &copy; 2021 - 2022. Todos los derechos son reservados. Desarrollada por <a href="https://cristiancamiloweb.github.io/portafolio-web/">Cristian Camilo Alzate Ramirez.</a></p>
        </div>
        <div class="container-fijo"><i class="fas fa-angle-up"></i></div>
    </body>
</html>
