package com.mycompany.restauranteelbuensabor;

public class Factura {

    private static final double TASA_IVA = 0.19;
    private static final double TASA_DESCUENTO = 0.05;
    private static final double TASA_PROPINA = 0.10;
    // El umbral de propina es una política del restaurante, no un impuesto legal
    private static final double UMBRAL_PROPINA = 50000;
    // El descuento aplica solo cuando el cliente pide más de 3 productos diferentes
    private static final int MINIMO_ITEMS_DESCUENTO = 3;
    private static int contadorFacturas = 1;
    private final int numero;
    private final Pedido pedido;
    private final Mesa mesa;

    public Factura(Pedido pedido, Mesa mesa) {
        this.pedido = pedido;
        this.numero = contadorFacturas++;
        this.mesa = mesa;
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento() {
        if (pedido.contarItemsDiferentes() > MINIMO_ITEMS_DESCUENTO) {
            return calcularSubtotal() * TASA_DESCUENTO;
        }
        return 0;
    }

    public double calcularIVA() {
        // El IVA se aplica sobre el subtotal ya descontado, según normativa DIAN
        return (calcularSubtotal() - calcularDescuento()) * TASA_IVA;
    }

    public double calcularPropina() {
        // La propina aplica sobre el total con IVA incluido, no sobre el subtotal
        double baseConIVA = calcularSubtotal() - calcularDescuento() + calcularIVA();
        if (baseConIVA > UMBRAL_PROPINA) {
            return baseConIVA * TASA_PROPINA;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento() + calcularIVA() + calcularPropina();
    }
}