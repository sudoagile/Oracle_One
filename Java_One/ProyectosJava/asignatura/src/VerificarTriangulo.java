import java.util.Scanner;

public class VerificarTriangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los tres lados al usuario
        System.out.print("Ingrese el primer lado: ");
        double lado1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo lado: ");
        double lado2 = scanner.nextDouble();

        System.out.print("Ingrese el tercer lado: ");
        double lado3 = scanner.nextDouble();

        // Comprobar si los lados pueden formar un triángulo
        if (esTriangulo(lado1, lado2, lado3)) {
            System.out.println("Los lados pueden formar un triángulo.");
        } else {
            System.out.println("Los lados no pueden formar un triángulo.");
        }
    }

    // Método para verificar la regla del triángulo
    public static boolean esTriangulo(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}