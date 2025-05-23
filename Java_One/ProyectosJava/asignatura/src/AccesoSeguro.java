import java.util.Scanner;

public class AccesoSeguro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la clave: "); // Mensaje para el usuario
        int clave = sc.nextInt();

        if (clave == 123456) {
            System.out.println("Acceso permitido.");
        } else {
            System.out.println("Acceso denegado.");
        }
        sc.close();
    }
}