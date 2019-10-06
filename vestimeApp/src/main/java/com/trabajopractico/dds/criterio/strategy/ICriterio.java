package com.trabajopractico.dds.criterio.strategy;

import com.trabajopractico.dds.model.Atuendo;
//import dds.trabajopractico.models.Prenda;

//import java.util.List;

public interface ICriterio {

	/*
	 * List<Prenda> obtenerListaPrendas(List<Prenda> lista); Boolean
	 * esPrendaValida(Prenda prenda); Boolean nivelCalorValido(Integer
	 * nivelDeCalor);
	 */
	Boolean validar(Atuendo atuendo);
}
