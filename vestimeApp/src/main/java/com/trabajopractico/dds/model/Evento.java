package com.trabajopractico.dds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.criterio.strategy.impl.CriterioNulo;


public class Evento {

    private Date fecha;
    private List<ICriterio> criterioList;
    private Guardarropa guardarropa;
    private boolean resuelto;
    private Atuendo atuendo;

    public Evento (Date fecha, ICriterio criterio, Guardarropa guardarropas){
        this.fecha = fecha;
        this.criterioList = new ArrayList<>();
        criterioList.add(criterio);
        this.guardarropa = guardarropas;
        this.resuelto = false;
    }

    public List<Atuendo> resolver(){
        Sugeridor sugeridor = Sugeridor.obtenerInstanciaSigleton();
        return sugeridor.obtenerTodosLosAtuendosValidos(guardarropa.getPrendas(),new CriterioNulo());
    }

    public Date getDate()
    {
        return this.fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public void setResuelto(){
        this.resuelto = true;
    }
    public boolean AceptarSugerencia(Atuendo atuendo){

        atuendo.reservar();
        this.atuendo = atuendo;

        return true;
    }

    public boolean RechazarSugerencia(){
        return true;
    }

    public boolean DeshacerOperacion(Atuendo atuendo){

        return true;
    }

    public boolean getResuelto () {
        return resuelto;
    }

    public Atuendo getAtuendo () {
        return atuendo;
    }
}