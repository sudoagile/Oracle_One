import java.util.Scanner;

public class VerificarPrestamo {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al cliente que ingrese el valor del préstamo
        System.out.print("Ingrese el valor del préstamo: ");
        int valorPrestamo = scanner.nextInt();

        // Verificar si el valor está dentro del intervalo permitido
        if (valorPrestamo >= 1000 && valorPrestamo <= 5000) {
            System.out.println("El valor " + valorPrestamo + " está dentro del intervalo permitido para el préstamo.");
        } else {
            System.out.println("El valor " + valorPrestamo + " no está dentro del intervalo permitido para el préstamo.");
        }

        // Cerrar el objeto Scanner
        scanner.close();
    }
}