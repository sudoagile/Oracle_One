package com.sudoagile.desafio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AplicacionCompras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el límite de tu tarjeta: ");
        double limiteTarjeta = scanner.nextDouble();

        ArrayList<com.sudoagile.desafio1.Producto> compras = new ArrayList<>();
        double saldoRestante = limiteTarjeta;

        while (true) {
            System.out.print("Introduce el nombre del producto (o escribe 'fin' para terminar): ");
            String nombreProducto = scanner.next();

            if (nombreProducto.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Introduce el precio del producto: ");
            double precioProducto = scanner.nextDouble();

            if (precioProducto > saldoRestante) {
                System.out.println("Saldo insuficiente.");
                break;
            }

            compras.add(new Producto(nombreProducto, precioProducto));
            saldoRestante -= precioProducto;

            System.out.print("¿Deseas continuar comprando? (1 para sí, 0 para no): ");
            int continuar = scanner.nextInt();

            if (continuar == 0) {
                break;
            }
        }

        Collections.sort(compras, Comparator.comparingDouble(Producto::getPrecio));

        System.out.println("\nResumen de compras:");
        for (Producto compra : compras) {
            System.out.println(compra.getNombre() + ": " + compra.getPrecio());
        }

        System.out.println("\nSaldo restante: " + saldoRestante);

        scanner.close();
    }
}