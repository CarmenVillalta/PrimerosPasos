package com.trabajopractico.dds.model;

import java.util.Arrays;
import java.util.Optional;

public enum Nivel {
    CERO(0), UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5);

    private Integer valor;

    public Integer getValor() {
        return valor;
    }

    private Nivel(Integer valor) {
        this.valor = valor;
    }

    public static Nivel getNivel(String name) {
        return Optional.ofNullable(
                Arrays.asList(Nivel.values()).stream().filter(x -> x.name().equals(name)).findAny().orElse(null))
                .orElseThrow(() -> new RuntimeException("Nivel Invalido"));
    }

}

