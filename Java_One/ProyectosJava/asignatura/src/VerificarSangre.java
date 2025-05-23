import java.util.Scanner;

public class VerificarSangre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la edad del donante
        System.out.print("Ingrese la edad del donante: ");
        int edad = scanner.nextInt();

        // Solicitar el peso del donante
        System.out.print("Ingrese el peso del donante (en kg): ");
        double peso = scanner.nextDouble();

        // Verificar compatibilidad
        boolean esCompatible = true;
        StringBuilder motivo = new StringBuilder();

        if (edad < 18 || edad > 65) {
            esCompatible = false;
            motivo.append("Debe tener entre 18 y 65 años. ");
        }

        if (peso <= 50) {
            esCompatible = false;
            motivo.append("Debe pesar más de 50 kg.");
        }

        // Mostrar resultados
        if (esCompatible) {
            System.out.println("El donante es compatible para donar sangre.");
        } else {
            System.out.println("El donante no es compatible.");
            System.out.println("Motivo: " + motivo.toString().trim());
        }
    }
}