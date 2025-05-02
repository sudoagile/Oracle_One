import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {
        String nombre = "Tony Start";
        String tipoDeCuenta = "Corriente";
        double saldo = 1599.99;
        int opcion = 0;
        System.out.println("*******************************");
        System.out.println("\nNombre del cliente: " + nombre);
        System.out.println("Tipo de cuenta es: " + tipoDeCuenta);
        System.out.println("Saldo disponible es: S/. " + saldo);
        System.out.println("\n*******************************");

        String menu = """
                *** Escribo el númeo de la opdión deseada ***
                1. Consultar saldo
                2. Retirar
                3. Depositar
                9. Salir
                """;
        Scanner sc = new Scanner(System.in);
        while (opcion != 9) {
            System.out.println(menu);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("El saldo es: S/. " + saldo);
                    break;
                case 2:
                    System.out.println("Cual es el valor que desea retirar");
                    double valorRetirar = sc.nextDouble();
                    if (valorRetirar>saldo) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        saldo = saldo - valorRetirar;
                        System.out.println("Saldo es: S/. " + saldo);
                    }
                    break;
                    case 3:
                        System.out.println("Cual es el valor que desea depositar");
                        double valorDepositar = sc.nextDouble();
                        saldo = saldo + valorDepositar;
                        System.out.println("Saldo es: S/. " + saldo);
                        break;
                        case 9:
                            System.out.println("Saliendo del programa, gracias");
                            break;
                default:
                    System.out.println("Opcion no valida");
            }


        }
    }

}

