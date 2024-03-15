<%-- 
    Document   : calificaciones
    Created on : 25/08/2022, 10:12:57 AM
    Author     : camil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hasta Luego!, Tierragricola Califica | Tierragicola</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
        <link rel="shortcut icon" href="./images/logo.jpeg" type="jpeg">
        <link rel="stylesheet" href="./css/calificaciones.css">
        <script defer src="./js/jquery-3.2.1.js"></script>
        <script defer src="./js/calificar.js"></script>
    </head>
    <body>
        <header class="nav-header">
            <div class="nav-container">
                <div class="nav-logo2">
                    <a href="tierragricola">
                        Tierragr!cola&reg;
                    </a>
                </div>
            </div>
        </header>
        <div class="container-formulario">
            <div class="container-form">
                <img src="./images/logo.jpeg">
                <h1>Hasta Luego!, Califica tu experiencia en Tierragr!cola</h1>
                <form autocomplete="off">
                    <div class="container-calificar">
                        <input type="radio" id="calificacion" name="calificacion" value="5">
                        <label for="five"></label>
                        <input type="radio" id="calificacion" name="calificacion" value="4">
                        <label for="four"></label>
                        <input type="radio" id="calificacion" name="calificacion" value="3">
                        <label for="three"></label>
                        <input type="radio" id="calificacion" name="calificacion" value="2">
                        <label for="two"></label>
                        <input type="radio" id="calificacion" name="calificacion" value="1">
                        <label for="one"></label>
                    </div>
                    <label for="observaciones">Deja tus observaciones</label>
                    <textarea name="observaciones" id="observaciones" placeholder="Observaciones..." required></textarea>
                    <button type="button" id="calificar">Calificar</button>
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
