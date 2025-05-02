import java.util.Scanner;

public class VerificaCodigo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definimos el código de acceso correcto
        final int CODIGO_CORRECTO = 2023;

        // Pedimos al usuario que ingrese el código de acceso
        System.out.print("Ingrese el código de acceso: ");
        int codigoAcceso = scanner.nextInt();

        // Pedimos al usuario que ingrese el nivel de permiso
        System.out.print("Ingrese el nivel de permiso: ");
        int nivelPermiso = scanner.nextInt();

        // Verificar si el código de acceso y el nivel de permiso son válidos
        boolean codigoEsCorrecto = codigoAcceso == CODIGO_CORRECTO;
        boolean nivelEsValido = nivelPermiso == 1 || nivelPermiso == 2 || nivelPermiso == 3;

        // Comprobamos si el acceso está permitido
        if (codigoEsCorrecto && nivelEsValido) {
            System.out.println("Acceso permitido.");
        } else {
            System.out.println("Acceso denegado.");
            // Determinar el motivo de acceso denegado
            if (!codigoEsCorrecto && !nivelEsValido) {
                System.out.println("Motivo: Código de acceso incorrecto y nivel de permiso inválido.");
            } else if (!codigoEsCorrecto) {
                System.out.println("Motivo: Código de acceso incorrecto.");
            } else if (!nivelEsValido) {
                System.out.println("Motivo: Nivel de permiso inválido.");
            }
        }
    }
}