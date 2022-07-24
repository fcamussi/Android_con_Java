package com.example.practica11;

public class Producto {
    private String codigo;
    private String desc;
    private String precio;

    public Producto(String codigo, String desc, String precio) {
        this.codigo = codigo;
        this.desc = desc;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
