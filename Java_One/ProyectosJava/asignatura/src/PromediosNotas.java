import java.util.Scanner;

public class PromediosNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir 5 notas al usuario
        double sumaNotas = 0.0; // Variable para almacenar la suma de las notas
        int cantidadNotas = 5;  // Número de notas a introducir

        System.out.println("Introduce las 5 notas del estudiante: ");
        for (int i = 1; i <= cantidadNotas; i++) {
            System.out.print("Nota " + i + ": ");
            double nota = sc.nextDouble(); // Leer la nota introducida
            sumaNotas += nota; // Sumar la nota al total
        }

        // Calcular promedio
        double promedio = sumaNotas / cantidadNotas;

        // Determinar y mostrar la situación del estudiante
        System.out.println("Promedio final: " + promedio);
        if (promedio >= 7.0) {
            System.out.println("El estudiante está aprobado.");
        } else if (promedio >= 5.0 && promedio < 7.0) {
            System.out.println("El estudiante está en recuperación.");
        } else {
            System.out.println("El estudiante está reprobado.");
        }

        sc.close(); // Cerrar Scanner
    }
}