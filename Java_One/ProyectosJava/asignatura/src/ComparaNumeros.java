import java.util.InputMismatchException;
import java.util.Scanner;

public class ComparaNumeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduce el primer número: ");
            double num1 = sc.nextDouble();

            System.out.println("Introduce el segundo número: ");
            double num2 = sc.nextDouble();

            if (num1 > num2) {
                System.out.printf("El primer número que es %.2f es mayor que el segundo número que es %.2f.%n", num1, num2);
            } else if (num1 < num2) {
                System.out.printf("El primer número que es %.2f es menor que el segundo número que es %.2f.%n", num1, num2);
            } else {
                System.out.printf("El primer número que es %.2f es igual que el segundo número que es %.2f.%n", num1, num2);
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, introduce valores numéricos válidos.");
        } finally {
            sc.close();
        }
    }
}
