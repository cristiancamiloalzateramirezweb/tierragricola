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

let slider_index = 0;

function show_slide(index) {
  let slides = document.querySelectorAll('.album');
  let dots = document.querySelectorAll('.dot-nav');

  if (index >= slides.length) slider_index = 0;
  if (index < 0) {
    slider_index = slides.length - 1;
  };
  for (let i = 0; i < slides.length; i++) {
    slides[i].style.display = 'none';
    dots[i].classList.remove('active-dot');
  }

  slides[slider_index].style.display = 'block';
  dots[slider_index].classList.add('active-dot');
}
show_slide(slider_index);
document.querySelector('#arrow-prev').addEventListener('click', () => {
  show_slide(--slider_index);
});
document.querySelector('#arrow-next').addEventListener('click', () => {
  show_slide(++slider_index);
});
document.querySelectorAll('.dot-nav').forEach((element) => {
  element.addEventListener('click', function () {
    var dots = Array.prototype.slice.call(this.parentElement.children),
      dot_index = dots.indexOf(element);
    show_slide(slider_index = dot_index);
  });
});
setInterval(() => {
  show_slide(++slider_index);
}, 10000);



