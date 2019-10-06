package com.trabajopractico.dds.model;


import java.util.List;
import java.util.stream.Collectors;

import com.trabajopractico.dds.criterio.strategy.ICriterio;

public class Atuendo {
    private List<Prenda> torso;
    private List<Prenda> piernas;
    private List<Prenda> pies;
    private List<Prenda> accesorios;
	private List<Prenda> prendasSugeridas;


    public Atuendo(List<Prenda> prendas){ 
       this.prendasSugeridas = prendas;
       ordenarPorTipoDeCategoria();       
    }

	public void ordenarPorTipoDeCategoria() {

		this.torso = prendasSugeridas.stream().filter(x -> Categoria.TORSO.equals(x.getCategoria())).collect(Collectors.toList());
		this.piernas = prendasSugeridas.stream().filter(x -> Categoria.PIERNAS.equals(x.getCategoria())).collect(Collectors.toList());
		this.pies = prendasSugeridas.stream().filter(x -> Categoria.PIES.equals(x.getCategoria())).collect(Collectors.toList());
		this.accesorios = prendasSugeridas.stream().filter(x -> Categoria.ACCESORIO.equals(x.getCategoria())).collect(Collectors.toList());
	}
    //El constructor vacio no lo agrego ya que un atuendo deberia tener si o si todos los elementos para esta entrega
    public Boolean esValido(ICriterio criterio) {
    	return criterio.validar(this);
    }
    
    public Boolean esValidoPor(List<ICriterio> criterios) {
    	Boolean esValido = true;
    	for(ICriterio criterio:criterios) {
    	    if (esValido) {
                esValido = esValido && this.esValido(criterio);
            }
    	}
    	return esValido;
    }
    
   	public Integer nivelDeCalor() {
   		return prendasSugeridas.stream().mapToInt(prenda->prenda.getNivelDeAbrigo()).sum();
   	}
   	
   // public Boolean esValidaPorCriterios(List<ICriterio> criterios) {
   // 	return criterios.stream().anyMatch(criterio->this.esValido(criterio));
   //}

    public boolean esValido(){
        if (torso.isEmpty() || pies.isEmpty() || piernas.isEmpty())
            return false;
        if (pies.size()> 2)
            return false;
    return true;
    }
    
    public List<Prenda> getPiernas() {
        return piernas;
    }

    public List<Prenda> getPies() {
        return pies;
    }

    public List<Prenda> getTorso() {
        return torso;
    }

    public List<Prenda> getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(List<Prenda> accesorios) {
        this.accesorios = accesorios;
    }

    public void setPiernas(List<Prenda> piernas) {
        this.piernas = piernas;
    }

    public void setPies(List<Prenda> pies) {
        this.pies = pies;
    }

    public void setTorso(List<Prenda> torso) {
        this.torso = torso;
    }

    public void reservar () {
        for (Prenda p : prendasSugeridas){
            p.setEstaEnUso();
        }
    }

    public void desReservar(){
        for (Prenda p: prendasSugeridas){
            p.setEstaDisponible();
        }
    }
}
