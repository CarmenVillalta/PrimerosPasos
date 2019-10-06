package com.trabajopractico.dds.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.criterio.strategy.impl.CriterioNulo;
import com.trabajopractico.dds.criterio.strategy.impl.CriterioTemperatura;

public class SugeridorTest {
    private Guardarropa guardarropa;
    private ClimaService climaService;

    @Before
    public void setUp(){
        ApiClima apiClima= new ApiClima();
        apiClima.setAPI_KEY("06c148b53ea6ac6798311ab18241b581");
        apiClima.setLOCATION_ID("Buenos Aires");
        String urlString =
                "http://api.openweathermap.org/data/2.5/weather?q=";

        apiClima.setUrlString(urlString);
        ClimaRepository climaRepository = new ClimaRepository();
        climaRepository.addApi(apiClima);
        this.climaService = new ClimaService(climaRepository);

    }
    
    @Test
	public void validarSelectorXCriterioNulo() {
		 //Genero la lista de prendas
		  Prenda prenda1 = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda2 = new Prenda(TipoDePrenda.MUSCULOSA, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda3 = new Prenda(TipoDePrenda.BOTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda4 = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  List<Prenda> prendas = new ArrayList<Prenda>();
		  prendas.add(prenda4);
		  prendas.add(prenda1);
		  prendas.add(prenda2);
		  prendas.add(prenda3);
		  //Genero la lista de Criterios con solo el Criterio Nulo
		  ICriterio unCriterio = new CriterioNulo();
		  List<ICriterio> criterios = new ArrayList<ICriterio>();
		  criterios.add(unCriterio);	  
		  SelectorPorCriterio selector = new SelectorPorCriterio();
		  Assert.assertEquals(selector.seleccionar(prendas,criterios).size(),4);
		  
	}


	  @Test 
	  public void validarCombinacionesPorCriterioNulo(){ 
		  Prenda prenda1 = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda2 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda3 = new Prenda(TipoDePrenda.BOTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  Prenda prenda4 = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		  List<Prenda> prendas = new ArrayList<Prenda>();
		  prendas.add(prenda1);
		  prendas.add(prenda2);
		  prendas.add(prenda3);
		  prendas.add(prenda4);
		  ICriterio unCriterio = new CriterioNulo();
		  List<ICriterio> criterios = new ArrayList<ICriterio>();
		  criterios.add(unCriterio);
		  Sugeridor sugeridor = Sugeridor.obtenerInstanciaSigleton();
		  Assert.assertEquals(sugeridor.sugerir(prendas,criterios).size(),3);
		  //Assert.assertEquals(sugeridor.obtenerTodosLosAtuendosValidos().stream().filter(atuendo->atuendo.esValidaPorCriterios(criterios)).collect(Collectors.toList()).size(),7);
	  }
	  

    @Test
    public void ObtenerUnaListaSugerida(){
        Usuario fede = new Usuario();
        List<Guardarropa> guardarropas = new ArrayList<>();
        guardarropa = new Guardarropa();
        guardarropas.add(guardarropa);
        fede.setGuardarropas(guardarropas);

        Guardarropa guardarropa = fede.getGuardarropas().get(0);
        guardarropa.setPrendas(new ArrayList<>());

        Prenda prenda1 = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda2 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda3 = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, Color.NEGRO, Color.BLANCO);
        Prenda prenda4 = new Prenda(TipoDePrenda.REMERA_MANGAS_LARGAS, Material.ALGODON, Color.BLANCO, Color.AMARILLO);
        Prenda prenda5 = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, Color.MARRON, Color.NEGRO);

        fede.getGuardarropas().get(0).agregarPrenda(prenda1);
        fede.getGuardarropas().get(0).agregarPrenda(prenda2);
        fede.getGuardarropas().get(0).agregarPrenda(prenda3);
        fede.getGuardarropas().get(0).agregarPrenda(prenda4);
        fede.getGuardarropas().get(0).agregarPrenda(prenda5);

        ICriterio cTemp = new CriterioTemperatura(climaService,"Buenos Aires");
        Sugeridor UnSugeridor= Sugeridor.obtenerInstanciaSigleton();

        List<Atuendo> atuendosSugeridas = UnSugeridor.obtenerTodosLosAtuendosValidos(guardarropa.getPrendas(), cTemp);

        System.out.println(atuendosSugeridas.size());
        int i = 0;
        for (Atuendo a: atuendosSugeridas
             ) {
            i++;
            System.out.println("Ocurrencia " + i);
            System.out.println(a.getPies().size());
            System.out.println(a.getTorso().size());
            System.out.println(a.getPiernas().size());
        }
    }
}
