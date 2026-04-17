package com.mycompany.restauranteelbuensabor;

public class FacturaImpresor {

    private static final String SEPARADOR_GRUESO = "========================================";
    private static final String SEPARADOR_FINO = "----------------------------------------";
    private static final String NOMBRE_RESTAURANTE = "EL BUEN SABOR";
    private static final String DIRECCION = "Calle 15 #8-32, Valledupar";
    private static final String NIT = "900.123.456-7";

    public static void imprimirEncabezado() {
        System.out.println(SEPARADOR_GRUESO);
        System.out.println("    RESTAURANTE " + NOMBRE_RESTAURANTE);
        System.out.println("    " + DIRECCION);
        System.out.println("    NIT: " + NIT);
        System.out.println(SEPARADOR_GRUESO);
    }

    private static void imprimirItemsPedido(Pedido pedido) {
        for (ItemPedido item : pedido.getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n", item.getProducto().getNombre(),
                    item.getCantidad(), item.calcularSubtotal());
        }
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("--- PEDIDO ACTUAL ---");
        imprimirItemsPedido(pedido);
        System.out.println(SEPARADOR_FINO);
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", pedido.calcularSubtotal());
    }

    public static void imprimirFacturaCompleta(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println(SEPARADOR_FINO);
        imprimirItemsPedido(factura.getPedido());
        System.out.println(SEPARADOR_FINO);
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", factura.calcularSubtotal());
        System.out.printf("%-27s $%,.0f%n", "Descuento:", factura.calcularDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", factura.calcularIVA());
        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }
        System.out.println(SEPARADOR_FINO);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
        System.out.println(SEPARADOR_GRUESO);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(SEPARADOR_GRUESO);
    }

    public static void imprimirFacturaResumen(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", factura.getNumero());
        System.out.println(SEPARADOR_FINO);
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", factura.calcularSubtotal());
        System.out.printf("%-27s $%,.0f%n", "Descuento:", factura.calcularDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", factura.calcularIVA());
        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }
        System.out.println(SEPARADOR_FINO);
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
        System.out.println(SEPARADOR_GRUESO);
    }
}