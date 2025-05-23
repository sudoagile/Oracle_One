import java.util.Random;
import java.util.Scanner;

public class Adivinanza {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(101); // Número entre 0 y 100
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;
        int maximoIntentos = 5;
        int numeroUsuario;

        while (intentos < maximoIntentos) {
            System.out.print("Intenta adivinar el número (entre 0 y 100): ");
            numeroUsuario = scanner.nextInt();
            intentos++;

            if (numeroUsuario == numeroSecreto) {
                System.out.println("¡Acertaste! El número era " + numeroSecreto +
                        ". Lo lograste en " + intentos + (intentos == 1 ? " intento." : " intentos."));
                break;
            } else if (numeroUsuario > numeroSecreto) {
                System.out.println("El número ingresado es mayor que el número secreto.");
            } else {
                System.out.println("El número ingresado es menor que el número secreto.");
            }

            if (intentos == maximoIntentos) {
                System.out.println("Has alcanzado el máximo de intentos. El número era " + numeroSecreto + ".");
            }
        }

        scanner.close();
    }
}
