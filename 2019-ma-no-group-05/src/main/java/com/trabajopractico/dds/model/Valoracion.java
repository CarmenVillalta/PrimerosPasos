package com.trabajopractico.dds.model;

import java.util.ArrayList;
import java.util.List;

public class Valoracion {
    private Integer valoracionGeneral;
    private List<Integer> valoracionParticular; //Ver si necesitamos alguna lista especial o con integer y despues mapearlo estamos

    public Valoracion() {
        this.valoracionGeneral = null;
        this.valoracionParticular = new ArrayList<>();
    }

    public Valoracion(Integer valoracionGeneral, List<Integer> valoracionParticular) {
        this.valoracionGeneral = valoracionGeneral;
        this.valoracionParticular = valoracionParticular;
    }

    public Integer getValoracionGeneral() {
        return valoracionGeneral;
    }

    public void setValoracionGeneral(Integer valoracionGeneral) {
        this.valoracionGeneral = valoracionGeneral;
    }

    public List<Integer> getValoracionParticular() {
        return valoracionParticular;
    }

    public void setValoracionParticular(List<Integer> valoracionParticular) {
        this.valoracionParticular = valoracionParticular;
    }
}
