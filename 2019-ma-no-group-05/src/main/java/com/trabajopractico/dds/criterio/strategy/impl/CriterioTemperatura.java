package com.trabajopractico.dds.criterio.strategy.impl;


import java.time.LocalDateTime;
//import java.util.List;

import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.model.Atuendo;
import com.trabajopractico.dds.model.ClimaService;

public class CriterioTemperatura implements ICriterio{

	private ClimaService climaService;
	private String ciudad;
	private static Integer nivelDeCalorA15Grados = 70;
	private static Integer nivelDeCalorA32Grados = 30;
	
	/*
	 * @Override public List<Prenda> obtenerListaPrendas(List<Prenda> lista){ try {
	 * String ciudad = "Buenos Aires"; climaService.getTemperaturaFor(ciudad,
	 * LocalDateTime.now()); } catch (Exception e) {
	 * System.out.println("Es Posible Obtener La Temperatura"); } // agregar una
	 * logica que filtre por la teperatura de cada prenda return lista; }
	 * 
	 * @Override public Boolean esPrendaValida(Prenda prenda) { try { String ciudad
	 * = "Buenos Aires"; climaService.getTemperaturaFor(ciudad,
	 * LocalDateTime.now()); } catch (Exception e) {
	 * System.out.println("Es Posible Obtener La Temperatura"); } // Logica de
	 * evaluacion de prendas validas por Criterio del el ClimaService return true; }
	 * 
	 * @Override public Boolean nivelCalorValido(Integer nivelDeCalor) { Integer
	 * temp = 25; return (Math.min(temp,36) <= nivelDeCalor || Math.max(temp,36) >
	 * nivelDeCalor); }
	 */

	public CriterioTemperatura(ClimaService climaService, String ciudad){
		this.climaService = climaService;
		this.ciudad = ciudad;
	}

	@Override
	public Boolean validar(Atuendo atuendo) {
		try {
			 Double tempActual = climaService.getTemperaturaFor(ciudad, LocalDateTime.now());
			 if(tempActual<15)
				return atuendo.nivelDeCalor() > this.nivelDeCalorA15Grados;
			 if(tempActual>15 && tempActual<32)
				 return atuendo.nivelDeCalor() < this.nivelDeCalorA15Grados && atuendo.nivelDeCalor() > this.nivelDeCalorA32Grados;
			 if(tempActual>32)
				 return atuendo.nivelDeCalor() > this.nivelDeCalorA32Grados;	
			 }
		catch (Exception e) {
			 System.out.println("Es Posible Obtener La Temperatura");
		}
		return true;
	}


	

}
