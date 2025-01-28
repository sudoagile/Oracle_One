//Variables
let numeroSecreto = 5;
let numeroUsuario=0;

while (numeroSecreto != numeroUsuario) {
    numeroUsuario = prompt("Me indicas un numero entre 1 y 10 por favor:");

    console.log(numeroUsuario);
    /*
    Este código realiza
    la comparación
    */
    if (numeroUsuario == numeroSecreto) {

        alert(`Acertaste, el número es: ${numeroUsuario}`);
    } else {
        if (numeroUsuario > numeroSecreto) {
            alert('El número secreto es menor')
        } else {
            alert('El número secreto es mayor')
        }

    }
}

//     alert('Lo siento no acertastes el numero!');
// }

