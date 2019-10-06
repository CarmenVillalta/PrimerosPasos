package com.trabajopractico.dds.model;

import java.util.List;

public class Sugerencia {
    private List<Prenda> prendasSugeridas;
    private Valoracion valoracionSugerencia;
    private boolean aceptada;

    public Sugerencia(List<Prenda> prendasSugeridas) {
        this.prendasSugeridas = prendasSugeridas;
        this.valoracionSugerencia = new Valoracion();
        this.aceptada = false;
    }

    public List<Prenda> getPrendasSugeridas() {
        return prendasSugeridas;
    }

    public void setPrendasSugeridas(List<Prenda> prendasSugeridas) {
        this.prendasSugeridas = prendasSugeridas;
    }

    public Valoracion getValoracionSugerencia() {
        return valoracionSugerencia;
    }

    public void setValoracionSugerencia(Valoracion valoracionSugerencia) {
        this.valoracionSugerencia = valoracionSugerencia;
    }

    public boolean isAceptada() {
        return aceptada;
    }

    public void aceptarSugerencia() {
        this.aceptada = true;
    }

    public void rechazarSugerencia(){
        this.aceptada = false;
    }
}
