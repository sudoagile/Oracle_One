// Desafío 1
let diaSemana = prompt("¿Qué día de la semana es hoy?");
diaSemana = diaSemana.toLowerCase();
if (diaSemana === "sábado" || diaSemana === "domingo") {
    alert("¡Buen fin de semana!");
} else {
    alert("¡Buena semana!");
}

// Desafío 2
let numero = prompt("Ingresa un número:");
numero = parseFloat(numero);
if (numero > 0) {
    alert("El número que ingresaste es positivo.");
} else if (numero < 0) {
    alert("El número que ingresaste es negativo.");
} else {
    alert("El número que ingresaste es cero.");
}

// Desafío 3
let puntuacion = prompt("Ingresa tu puntuación:");
puntuacion = parseInt(puntuacion);
if (puntuacion >= 100) {
    alert("¡Felicidades, has ganado!");
} else {
    alert("Intentalo nuevamente para ganar.");
}

// Desafío 4
let saldo = 1500.75;
let mensajeSaldo = `El saldo de tu cuenta es: $${saldo}.`;
alert(mensajeSaldo);

// Desafío 5
let nombreUsuario = prompt("Ingresa tu nombre:");
alert(`¡Hola, ${nombreUsuario}! Bienvenido/a`);