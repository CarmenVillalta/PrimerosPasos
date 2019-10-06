package com.trabajopractico.dds.model;

public class Membresia {
    String tipo;
    int limitePrendas;

    public Membresia(String tipo, int limitePrendas) {
        this.tipo = tipo;
        this.limitePrendas = limitePrendas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getLimitePrendas() {
        return limitePrendas;
    }

    public void setLimitePrendas(int limitePrendas) {
        this.limitePrendas = limitePrendas;
    }
}
