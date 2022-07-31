package com.example.practica15;

public class NumeroAleatorio {

    static int numero;

    public void generar() {
        numero = (int)(Math.random()*1000+1);
    }

    public int get() {
        return numero;
    }

}
