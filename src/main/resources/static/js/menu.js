function toggleMenu() {
    var menu = document.getElementById('menuLista-desplegable');
    var style = window.getComputedStyle(menu);
    var display = style.getPropertyValue('display');
    if (display === 'none') {
        menu.style.display = 'block';
    } else {
        menu.style.display = 'none';
    }
}