//Variables
let numeroMaximoPosible = 100;
let numeroSecreto = Math.floor(Math.random()*numeroMaximoPosible)+1;
let numeroUsuario=0;
let intentos = 1;
// let palabraVeces = 'vez';
let maximoIntentos=6;


while (numeroSecreto != numeroUsuario) {
    numeroUsuario = parseInt(prompt(`Me indicas un numero entre 1 y ${numeroMaximoPosible} por favor:`));

    console.log(typeof(numeroSecreto));
    /*
    Este código realiza
    la comparación
    */
    if (numeroUsuario == numeroSecreto) {

        alert(`Acertaste, el número es: ${numeroUsuario}. Lo hiciste en ${intentos}
         ${intentos ==1 ?'vez': 'veces'}`);
    } else {
        if (numeroUsuario > numeroSecreto) {
            alert('El número secreto es menor')
        } else {
            alert('El número secreto es mayor')
        }
        intentos ++;
        // palabraVeces ='veces';
        if (intentos > 3){
            alert(`Llegastes al número máximo de ${maximoIntentos} intentos`);
            break;
        }

    }
}

//     alert('Lo siento no acertastes el numero!');
// }

