import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creación del Scanner
        System.out.print("Introduce un número: "); // Mensaje de entrada

        int numero = sc.nextInt(); // Lectura del número ingresado por el usuario

        // Comprobar si el número es par o impar
        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par.");
        } else {
            System.out.println("El número " + numero + " es impar.");
        }

        sc.close(); // Cerrar el Scanner
    }
}
