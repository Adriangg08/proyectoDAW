const body = document.querySelector('body');
const btn = document.getElementById('btn-oscuro');
let modo = "light";

btn.addEventListener('click', (e) => {

    if (modo === "dark") {
        btn.style = 'justify-content: flex-end;';
        document.documentElement.style.setProperty('--fondo', 'black');
        document.documentElement.style.setProperty('--texto', 'white');
        document.documentElement.style.setProperty('--fondo-cosas', 'rgb(100, 100, 100)');
        document.documentElement.style.setProperty('--platos','rgb(70, 70, 70)')
        modo = 'light';
    } else {
        btn.style = 'justify-content: flex-start;';
        document.documentElement.style.setProperty('--fondo', 'white');
        document.documentElement.style.setProperty('--texto', 'black');
        document.documentElement.style.setProperty('--fondo-cosas', 'rgba(255, 255, 255, 0.938) ');
        document.documentElement.style.setProperty('--platos','rgb(231, 229, 229)')
        modo = 'dark';
    }

})