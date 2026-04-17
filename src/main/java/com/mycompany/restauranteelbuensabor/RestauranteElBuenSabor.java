package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

public class RestauranteElBuenSabor {

    private static final int MAXIMO_INTENTOS_INVALIDOS = 3;
    private static final String SEPARADOR = "========================================";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Mesa mesa = new Mesa();
        Pedido pedido = new Pedido();
        int opcionMenu = 0;
        boolean sistemaActivo = true;
        int intentosInvalidos = 0;

        FacturaImpresor.imprimirEncabezado();

        while (sistemaActivo) {
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver pedido actual");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.println(SEPARADOR);
            System.out.print("Seleccione una opcion: ");
            opcionMenu = sc.nextInt();

            if (opcionMenu == 1) {
                Carta.mostrarCarta();
                System.out.println();

            } else if (opcionMenu == 2) {
                System.out.println("--- AGREGAR PRODUCTO ---");
                System.out.print("Numero de producto (1-" + Carta.cantidadProductos() + "): ");
                int numeroProducto = sc.nextInt();
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();

                if (numeroProducto < 1 || numeroProducto > Carta.cantidadProductos()) {
                    if (numeroProducto <= 0) {
                        System.out.println("El numero debe ser mayor a cero.");
                    } else {
                        System.out.println("Producto no existe. La carta tiene "
                                + Carta.cantidadProductos() + " productos.");
                    }
                } else if (cantidad <= 0) {
                    if (cantidad == 0) {
                        System.out.println("La cantidad no puede ser cero.");
                    } else {
                        System.out.println("Cantidad invalida. Ingrese un valor positivo.");
                    }
                } else {
                    if (!mesa.estaActiva()) {
                        System.out.print("Ingrese numero de mesa: ");
                        int numeroMesa = sc.nextInt();
                        if (numeroMesa > 0) {
                            mesa.activar(numeroMesa);
                        } else {
                            // Se asigna mesa 1 por defecto para evitar errores de flujo
                            mesa.activar(1);
                        }
                    }
                    Producto producto = Carta.getProducto(numeroProducto - 1);
                    pedido.agregarItem(producto, cantidad);
                    System.out.println("Producto agregado al pedido.");
                    System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
                }
                System.out.println();

            } else if (opcionMenu == 3) {
                System.out.println();
                if (pedido.tieneProductos()) {
                    FacturaImpresor.mostrarPedido(pedido);
                } else {
                    System.out.println("No hay productos en el pedido actual.");
                    System.out.println("Use la opcion 2 para agregar productos.");
                }
                System.out.println();

            } else if (opcionMenu == 4) {
                System.out.println();
                if (pedido.tieneProductos()) {
                    Factura factura = new Factura(pedido, mesa);
                    FacturaImpresor.imprimirFacturaCompleta(factura);
                    pedido.limpiar();
                    mesa.reiniciar();
                } else {
                    System.out.println("No se puede generar factura.");
                    System.out.println("No hay productos en el pedido.");
                    System.out.println("Use la opcion 2 para agregar productos primero.");
                }
                System.out.println();

            } else if (opcionMenu == 5) {
                System.out.println();
                pedido.limpiar();
                mesa.reiniciar();
                System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                System.out.println();

            } else if (opcionMenu == 0) {
                sistemaActivo = false;
                System.out.println("Hasta luego!");

            } else {
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
                intentosInvalidos++;
                // Se reinicia el contador para no bloquear permanentemente al usuario
                if (intentosInvalidos > MAXIMO_INTENTOS_INVALIDOS) {
                    System.out.println("Demasiados intentos invalidos.");
                    intentosInvalidos = 0;
                }
            }
        }
        sc.close();
    }
}