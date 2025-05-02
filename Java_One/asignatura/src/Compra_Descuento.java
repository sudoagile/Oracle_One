import java.util.Scanner;

public class Compra_Descuento {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese el valor de la compra
        System.out.print("Ingrese el valor de la compra: ");
        double valorCompra = scanner.nextDouble();

        // Verificar si se aplica el descuento
        if (valorCompra >= 100.0) {
            // Calcular el nuevo valor con el descuento
            double descuento = valorCompra * 0.10;
            double nuevoValor = valorCompra - descuento;

            // Mostrar resultados al usuario
            System.out.println("Descuento del 10% aplicado.");
            System.out.println("Nuevo valor: $" + nuevoValor);
        } else {
            // Mostrar que no se aplica descuento
            System.out.println("Descuento no aplicado.");
            System.out.println("Valor total: $" + valorCompra);
        }

        // Cerrar el scanner
        scanner.close();
    }
}