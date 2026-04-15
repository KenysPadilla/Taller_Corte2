/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {

    public static double calcular(double pr, double cn, double dc, double iv, double pp, int ni, boolean ap) {
        double res = 0;
        double tmp = 0;
        double aux2 = 0;
// calcula el resultado
        res = pr * cn;
        if (dc > 0) {
            res = res - (res * dc);
        }
        tmp = res * iv;
        res = res + tmp;
        if (ap) {
            res = res + (res * pp);
        }
// imprime restaurante
        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
        aux2 = res;
        return aux2;
    }

    public static boolean validar() {
        int cont = 0;
        int i = 0;
        while (i < Datos.cantidades.length) {
            if (Datos.cantidades[i] > 0) {
                cont = cont + 1;
            }
            i++;
        }// fin while
// reinicia si no hay nada - efecto secundario no documentado
        if (cont == 0) {
            Datos.total = 0;
            Datos.mensajeAuxiliar = "";
        }
        return cont > 0;
    }

    public static void reiniciar() {
// metodo antiguo de calculo - pendiente revisar
// public static double calcOld(double precio, int cantidades){
// double resultado = 0;
// resultado = precio * cantidades;
// resultado = resultado + (resultado * 0.19);
// if(resultado > 50000){
// resultado = resultado + (resultado * 0.10);}
// System.out.println("RESTAURANTE EL BUEN SABOR");
// System.out.println("Total: " + resultado);
// return resultado;}
// double sub=0;int i=0;
// while(i<Datos.nombres.length){
// sub=sub+Datos.precios[i]*Datos.cantidades[i];i++;}
// if(sub>50000){ sub=sub+(sub*0.19); sub=sub+(sub*0.10); }
// else{ sub=sub+(sub*0.19); }
// Datos.total=sub;
        int i = 0;
        while (i < Datos.cantidades.length) {
            Datos.cantidades[i] = 0;
            i++;
        }
        Datos.total = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesaActual = 0;
        Datos.mensajeAuxiliar = "";
    }
}
