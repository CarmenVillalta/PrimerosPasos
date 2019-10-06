package com.trabajopractico.dds.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.criterio.strategy.impl.CriterioNivelPiernas;
import com.trabajopractico.dds.criterio.strategy.impl.CriterioNivelPies;
import com.trabajopractico.dds.criterio.strategy.impl.CriterioNivelTorso;
import com.trabajopractico.dds.exceptions.SugerenciasInvalidasException;;

public class Sugeridor {

	private static Sugeridor sugeridor;

	private Sugeridor(){}


	public List<Atuendo> sugerir(List<Prenda> prendas, List<ICriterio> criterios) {
		validar(prendas);
		 return this.obtenerTodosLosAtuendosValidos(prendas,criterios);
	}

	public List<Prenda> obtenerSugerencia(List<Prenda> prendas, List<ICriterio> criterios) {
		
		SelectorPorCriterio selector = new SelectorPorCriterio();
		List<Prenda> prendasSugeridas = selector.seleccionar(prendas, criterios);
		//		ordenarPorTipoDeCategoria();
		
		//return this.obtenerTodosLosAtuendosValidos(prendasSugeridas ,criterios);
		return prendasSugeridas;
	}

	public static Sugeridor obtenerInstanciaSigleton(){

		if (sugeridor == null)
			sugeridor = new Sugeridor();

		return sugeridor;
	}

//	VALIDAR QUE LA SUGERENCIA TENGA AL MENOS UNA PRENDA DE CADA TIPO (SALVO ACCESORIOS)
	private void validar(List<Prenda> prendasSugeridas){
		boolean torso, piernas, pies;
		torso = false;
		piernas = false;
		pies = false;
		for (Prenda unaPrenda : prendasSugeridas){
			switch (unaPrenda.getCategoria()){
				case TORSO:
					torso =true;
					break;
				case PIES:
					pies = true;
					break;
				case PIERNAS:
					piernas =true;
					break;
				case ACCESORIO:
					break;
			}
		}
		if ((torso ==false) || (piernas == false) || (pies == false)) {
			throw new SugerenciasInvalidasException("Hubo un error al armar la sugerencia");
		}
	}

	public void ordenarPorTipoDeCategoria() {

	//	this.torso = prendasSugeridas.stream().filter(x -> Categoria.TORSO.equals(x.getTipoDePrenda().getCategoria())).collect(Collectors.toList());
	//	this.piernas = prendasSugeridas.stream().filter(x -> Categoria.PIERNAS.equals(x.getTipoDePrenda().getCategoria())).collect(Collectors.toList());
	//	this.pies = prendasSugeridas.stream().filter(x -> Categoria.PIES.equals(x.getTipoDePrenda().getCategoria())).collect(Collectors.toList());
	//	this.accesorios = prendasSugeridas.stream().filter(x -> Categoria.ACCESORIO.equals(x.getTipoDePrenda().getCategoria())).collect(Collectors.toList());
	}
	


	private Set<Set<Prenda>> todasCombinacionesPosibles(List<Prenda> prendasSugeridas) {
		//Inicializo convirtiendo las lista en un set de prendas
		Set<Prenda> set = new HashSet<Prenda>();
		set.addAll(prendasSugeridas);
		Integer tam = set.size();
		//Genero las combinaciones posibles con las prendas
		Set<Set<Prenda>> todasCombinaciones = new HashSet<Set<Prenda>>();
		for(Integer i=3;i<=tam;i++) {
			todasCombinaciones.addAll(Sets.combinations(set, i));
		}
		return todasCombinaciones;		
	}
	
	public List<Atuendo> obtenerTodosLosAtuendosValidos(List<Prenda> prendasSugeridas,ICriterio unCriterio){
		List<ICriterio> criterios = new ArrayList<>();
        criterios.add(unCriterio);
        criterios.add(new CriterioNivelTorso());
        criterios.add(new CriterioNivelPiernas());
        criterios.add(new CriterioNivelPies());
		return this.obtenerTodosLosAtuendosValidos( prendasSugeridas, criterios);
	}


	public List<Atuendo> obtenerTodosLosAtuendosValidos(List<Prenda> prendasSugeridas, List<ICriterio> criterios) {
		Set<Set<Prenda>> todasCombinaciones = this.todasCombinacionesPosibles(prendasSugeridas);
		//Convierto las combinaciones de tipo set a tipo atuendo
		List<Atuendo> atuendos = new ArrayList<Atuendo>();
		for(Set<Prenda> combinacion: todasCombinaciones) {
			List<Prenda> prendas = new ArrayList<Prenda>();
			prendas.addAll(combinacion);
			Atuendo unAtuendo = new Atuendo(prendas);
			if (unAtuendo.esValidoPor(criterios) && unAtuendo.esValido())
				atuendos.add(new Atuendo(prendas));
		}

		return atuendos;
	}


}
