package com.mycompany.restauranteelbuensabor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carta {

    private static final List<Producto> productos = new ArrayList<>();
    private static final String SEPARADOR = "========================================";

    static {
        productos.add(new Producto("Bandeja Paisa", 32000));
        productos.add(new Producto("Sancocho de Gallina", 28000));
        productos.add(new Producto("Arepa con Huevo", 8000));
        productos.add(new Producto("Jugo Natural", 7000));
        productos.add(new Producto("Gaseosa", 4500));
        productos.add(new Producto("Cerveza Poker", 6000));
        productos.add(new Producto("Agua Panela", 3500));
        productos.add(new Producto("Arroz con Pollo", 25000));
    }

    public static List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public static Producto getProducto(int indice) {
        return productos.get(indice);
    }

    public static int cantidadProductos() {
        return productos.size();
    }

    public static void mostrarCarta() {
        System.out.println(SEPARADOR);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR);
        for (int i = 0; i < productos.size(); i++) {
            System.out.printf("%d. %-22s $%,.0f%n", (i + 1),
                    productos.get(i).getNombre(), productos.get(i).getPrecio());
        }
        System.out.println(SEPARADOR);
    }
}