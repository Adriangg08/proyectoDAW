const body = document.querySelector('body');
const btn = document.getElementById('btn-oscuro');
let modo = "light";

btn.addEventListener('click', (e) => {

    if (modo === "dark") {
        btn.style = 'justify-content: flex-end;';
        document.documentElement.style.setProperty('--fondo', 'black');
        document.documentElement.style.setProperty('--texto', 'white');
        modo = 'light';
    } else {
        btn.style = 'justify-content: flex-start;';
        document.documentElement.style.setProperty('--fondo', 'white');
        document.documentElement.style.setProperty('--texto', 'black');
        modo = 'dark';
    }

})