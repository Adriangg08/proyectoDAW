// const fotoZoom = document.getElementById('fotoZoom');

// const foto1 = document.getElementById('foto1');

// const botonCerrar = fotoZoom.querySelector("span.botonCerrar");
// const contenido = botonCerrar.nextElementSibling;


// function zoomIn() {
//     fotoZoom.style.display = "flex";
//     contenido.src = this.src;
// }

// function cerrar() {
//     fotoZoom.style.display = "none";
// }

// foto1.onclick = zoomIn;

// botonCerrar.onclick = cerrar;

const items = document.querySelectorAll('.item');
const carta = document.querySelector(".carta");


// function checkClick() {
//     for (let i = 0; i < items.length; i++) {
        
//         items[i].addEventListener("onclick", prueba);
//         console.log(items[i]);

//     }
// }

// function prueba() {
//     items[1].style = "background-color: red;";
// }

// function cerrar() {
//     this.style = "background-color: red;";
    
//     let padre = this.parentNode;

//     padre.style.display = "none;";
    
//     console.log(padre);
// }

function check() {
    let fotoZoom = this.children[4];

    console.log("primera");
    console.log(fotoZoom);
    
    if (fotoZoom.style.display == "" || fotoZoom.style.display == "none") {
        fotoZoom.style.display = "flex";
    } else {
        fotoZoom.style.display = "none";
    }

    console.log("segunda");
    console.log(fotoZoom.style.display);

    let fotoModal = fotoZoom.children[1];
    fotoModal.src = this.firstElementChild.src;

    let botonCerrar = fotoZoom.firstElementChild;
    botonCerrar.onclick = check;
    console.log("adios");
}

for (var i = 0; i < items.length; i++) {
    items[i].addEventListener("click", check);
	}