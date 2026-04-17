package com.mycompany.restauranteelbuensabor;

public class Mesa {

    private int numero;
    private boolean activa;

    public Mesa() {
        this.numero = 0;
        this.activa = false;
    }

    public void activar(int numero) {
        this.numero = numero;
        this.activa = true;
    }

    public void reiniciar() {
        this.numero = 0;
        this.activa = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean estaActiva() {
        return activa;
    }
}