<%-- 
    Document   : recuperar-contrasena
    Created on : 23/08/2022, 12:52:21 PM
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
        <title>¡Hola Tierragricola! Recupera tu Contraseña</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/recuperar-contraseña.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/contraseña.js"></script>
    </head>
    <body>
        <header class="nav-header">
            <div class="nav-container">
                <div class="nav-logo2">
                    <a href="ingresar">
                        <i class="fa-solid fa-arrow-left"></i>
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
                <h1>Recupera tu Contraseña en Tierragr!cola</h2>
                <form autocomplete="off">
                    <label for="destinatario">Ingresa la dirección de correo electrónico registrada en Tierragricola para la recuperación de la contraseña</label><br>
                    <input type="email" name="destinatario" id="destinatario" placeholder="Correo Electrónico" required>
                    <button type="button" id="recuperarContrasena">Recuperar Contraseña</button>
                    <div id="respuestas">
                        <div id="respuesta-campos-vacios"></div>
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
