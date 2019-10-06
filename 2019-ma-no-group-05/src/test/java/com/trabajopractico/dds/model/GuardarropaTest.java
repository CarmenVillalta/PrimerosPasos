package com.trabajopractico.dds.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.criterio.strategy.impl.CriterioNulo;

public class GuardarropaTest {
	@Test
	public void validarSelectorXCriterio() {
		  Prenda prenda1 = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda2 = new Prenda(TipoDePrenda.MUSCULOSA, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda3 = new Prenda(TipoDePrenda.BOTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  List<Prenda> prendas = new ArrayList<Prenda>();
		  prendas.add(prenda1);
		  prendas.add(prenda2);
		  prendas.add(prenda3);
		  ICriterio unCriterio = new CriterioNulo();
		  List<ICriterio> criterios = new ArrayList<ICriterio>();
		  criterios.add(unCriterio);
		  SelectorPorCriterio selector = new SelectorPorCriterio();
		 // Assert.assertEquals(selector.seleccionar(prendas,criterios).size(),3);
		  Atuendo a = new Atuendo(prendas);
//		  Assert.assertTrue(a.esValidaPorCriterios(criterios));
		  
	}


	  @Test 
	  public void validarCombinacionesPorCriterioNulo(){ 
		  Prenda prenda1 = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda2 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda3 = new Prenda(TipoDePrenda.BOTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  List<Prenda> prendas = new ArrayList<Prenda>();
		  prendas.add(prenda1);
		  prendas.add(prenda2);
		  prendas.add(prenda3);
		  ICriterio unCriterio = new CriterioNulo();
		  List<ICriterio> criterios = new ArrayList<ICriterio>();
		  criterios.add(unCriterio);
		  Sugeridor sugeridor = Sugeridor.obtenerInstanciaSigleton();
		  Assert.assertEquals(sugeridor.obtenerTodosLosAtuendosValidos(prendas,new CriterioNulo()).size(),1);
		  //Assert.assertEquals(sugeridor.obtenerTodosLosAtuendosValidos().stream().filter(atuendo->atuendo.esValidaPorCriterios(criterios)).collect(Collectors.toList()).size(),7);

	  }

    @Test
    public void validarQueUnGuardarropaEsCompartida() {
        Usuario fede = new Usuario();
        Usuario jere = new Usuario();

        Prenda prenda1 = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda2 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda3 = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, Color.NEGRO, Color.BLANCO);
        Prenda prenda4 = new Prenda(TipoDePrenda.REMERA_MANGAS_LARGAS, Material.ALGODON, Color.BLANCO, Color.AMARILLO);
        Prenda prenda5 = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, Color.MARRON, Color.NEGRO);

        List<Guardarropa> guardarropas = new ArrayList<>();
        List<Guardarropa> guardarropas2 = new ArrayList<>();
		Guardarropa guardarropa = new Guardarropa();
		guardarropa.setPrendas(new ArrayList<>());
		guardarropa.agregarPrenda(prenda1);
        guardarropa.agregarPrenda(prenda2);
        guardarropa.agregarPrenda(prenda3);
        guardarropa.agregarPrenda(prenda4);
        guardarropa.agregarPrenda(prenda5);
        guardarropas.add(guardarropa);
        fede.setGuardarropas(guardarropas);
        jere.setGuardarropas(guardarropas2);
        Assert.assertEquals(fede.getGuardarropas().size(),1);
        fede.getGuardarropas().get(0).compartirCon(jere);
        Assert.assertEquals(jere.getGuardarropas().size(),1);
    }
}
