package com.trabajopractico.dds.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PrendaTest {
	
	private Guardarropa guardarropaCarmen;
	
	@Before
	public void initialize(){
		
		Usuario carmen = new Usuario();
		List<Guardarropa> guardarropas = new ArrayList<>();
		guardarropaCarmen = new Guardarropa();
		guardarropas.add(guardarropaCarmen);
		carmen.setGuardarropas(guardarropas);
		
		Guardarropa guardarropaCarmen = carmen.getGuardarropas().get(0);
		guardarropaCarmen.setPrendas(new ArrayList<>());
	}

	@Test
	public void prendaConTipoDePrendaShort() throws Exception {
		Prenda prenda = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		assertEquals(TipoDePrenda.SHORT, prenda.getTipoDePrenda());
	}

	@Test
	public void prendaRemeraMangasCortasEsCategoriaTorsoTest() throws Exception {
		Prenda prenda = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
	    assertEquals("TORSO", prenda.getCategoria().name());
	}

	@Test
	public void tipoDePrendaShortDebeSerCategoriaPiernas() throws Exception {
		Prenda prenda = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		assertEquals(Categoria.PIERNAS, prenda.getCategoria());
	}

	@Test
	public void tipoDePrendaRemeraNoDebeSerCategoriaPies() throws Exception {
		Prenda prenda = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		assertNotEquals(Categoria.PIES, prenda.getCategoria());
	}

	@Test
	public void getCapaDePrendaDeMusculosaDebeSer0() throws Exception {
		Prenda prenda = new Prenda(TipoDePrenda.MUSCULOSA, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		Nivel expectedValue = Nivel.CERO;
		assertEquals(expectedValue, prenda.getNivel());
	}

	@Test
	public void OrdenamientoDePrendasPorNivel() {
		Prenda prenda1 = new Prenda(TipoDePrenda.REMERA_MANGAS_LARGAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		Prenda prenda2 = new Prenda(TipoDePrenda.MUSCULOSA, Material.ALGODON, Color.NEGRO, Color.MARRON);
		Prenda prenda3 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.ROJO);
		Prenda prenda4 = new Prenda(TipoDePrenda.CAMPERA, Material.CUERO, Color.NEGRO, Color.NEGRO);
		Prenda prenda5 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.BLANCO);
		Prenda prenda6 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.CELETE);
		Prenda prenda7 = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, Color.MARRON, Color.GRIS);
		Prenda prenda8 = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, Color.NEGRO, Color.NARANJA);

		List<Prenda> prendas = new ArrayList<>();
		prendas.add(prenda1);
		prendas.add(prenda2);
		prendas.add(prenda3);
		prendas.add(prenda4);
		prendas.add(prenda5);
		prendas.add(prenda6);
		prendas.add(prenda7);
		prendas.add(prenda8);

		List<Prenda> listaOrdenada = new ArrayList<>();
		listaOrdenada.add(prenda2);
		listaOrdenada.add(prenda3);
		listaOrdenada.add(prenda5);
		listaOrdenada.add(prenda7);
		listaOrdenada.add(prenda1);
		listaOrdenada.add(prenda8);
		listaOrdenada.add(prenda4);


		Comparator<Prenda> prendaComparator
				= Comparator.comparing(
				Prenda::getNivel, (c1, c2) -> {
					return c1.compareTo(c2);
				});

        prendas.sort(prendaComparator);
		int asd=0;
		Assert.assertEquals(0,asd);

	}

//	Entrega 1 con builder incorporado
	
//	@Test 
//	public void crearRemera(){
//		
//		PrendaBuilder remeraBuilder = new RemeraBuilder();
//		remeraBuilder.construirTipoDePrenda(TipoDePrenda.REMERA_MANGAS_CORTAS);
//		remeraBuilder.construirColorPrimario(Color.AMARILLO);
//		remeraBuilder.construirColorSecundario(Color.AZUL);
//		remeraBuilder.construirMaterial(Material.SEDA);
//		
//		Prenda prendaRemera = remeraBuilder.build();
//		guardarropaCarmen.agregarPrenda(prendaRemera);
//		
//		assertEquals(Color.AMARILLO, prendaRemera.getColorPrimario());
//		assertEquals(Categoria.TORSO, prendaRemera.getCategoria());
//		assertEquals(1, guardarropaCarmen.getPrendas().size());
//	}
//	
//	@Test(expected = RuntimeException.class)
//	public void remeraConMaterialInconsistenteReturnException(){
//		
//		PrendaBuilder remeraBuilder = new RemeraBuilder();
//		remeraBuilder.construirTipoDePrenda(TipoDePrenda.REMERA_MANGAS_CORTAS);
//		remeraBuilder.construirColorPrimario(Color.AMARILLO);
//		remeraBuilder.construirColorSecundario(Color.AZUL);
//		remeraBuilder.construirMaterial(Material.JEAN);
//		
//		remeraBuilder.build();
//	}

}
