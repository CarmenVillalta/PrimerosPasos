package com.trabajopractico.dds.criterio.strategy.impl;

import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.model.Atuendo;
//import dds.trabajopractico.models.Prenda;

public class CriterioNulo implements ICriterio{
    
	/*
	 * @Override public List<Prenda> obtenerListaPrendas(List<Prenda> lista) {
	 * return lista; }
	 * 
	 * @Override public Boolean esPrendaValida(Prenda prenda) { return true; }
	 * 
	 * @Override public Boolean nivelCalorValido(Integer nivelDeCalor) { return
	 * true; }
	 */
	@Override
	public Boolean validar(Atuendo atuendo) {
		
		return true;
	}   

}
