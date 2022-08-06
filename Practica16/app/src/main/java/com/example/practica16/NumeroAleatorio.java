package com.example.practica16;

public class NumeroAleatorio {

    static int numero;

    public static void generar() {
        numero = (int)(Math.random()*1000+1);
    }

    public static int get() {
        return numero;
    }

}
