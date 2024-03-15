const abrirMenu = document.getElementById('button-menu-open');
const cerrarMenu = document.getElementById('button-menu-close');
const menu = document.getElementById('nav');

abrirMenu.addEventListener('click', () => {
    menu.classList.toggle('show');
});

cerrarMenu.addEventListener('click', () => {
    menu.classList.remove('show');
});

menu.addEventListener('click', e => {
    if (e.target.id === 'nav') {
        menu.classList.remove('show');
    }
});

const abrirPerfil = document.getElementById('button-perfil-open');
const cerrarPerfil = document.getElementById('button-perfil-close');
const perfil = document.getElementById('perfil');

abrirPerfil.addEventListener('click', () => {
    perfil.classList.toggle('show-perfil');
});

cerrarPerfil.addEventListener('click', () => {
    perfil.classList.remove('show-perfil');
});

perfil.addEventListener('click', e => {
    if (e.target.id === 'perfil') {
        perfil.classList.remove('show-perfil');
    }
});


$(document).ready(function () {
    $('.container-fijo').click(function () {
        $('body, html').animate({
            scrollTop: '0px'
        }, 200);
    });
    $(window).scroll(function () {
        if ($(this).scrollTop() > 0) {
            $('.container-fijo').slideDown(200);
        } else {
            $('.container-fijo').slideUp(200);
        }
    });
});
