package com.trabajopractico.dds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.trabajopractico.dds.criterio.strategy.impl.CriterioNulo;

public class UsuarioTest {

    private Usuario Fede;

    @Before
    public void setUp(){
        Fede = new Usuario();
        List<Guardarropa> guardarropas = new ArrayList<>();
        Guardarropa unGuardaropa = new Guardarropa();
        guardarropas.add(unGuardaropa);
        Fede.setGuardarropas(guardarropas);

        Guardarropa guardarropa = Fede.getGuardarropas().get(0);
        guardarropa.setPrendas(new ArrayList<>());

        Prenda prenda1 = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda2 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda3 = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, Color.NEGRO, Color.BLANCO);
        Prenda prenda4 = new Prenda(TipoDePrenda.REMERA_MANGAS_LARGAS, Material.ALGODON, Color.BLANCO, Color.AMARILLO);
        Prenda prenda5 = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, Color.MARRON, Color.NEGRO);

        Fede.getGuardarropas().get(0).agregarPrenda(prenda1);
        Fede.getGuardarropas().get(0).agregarPrenda(prenda2);
        Fede.getGuardarropas().get(0).agregarPrenda(prenda3);
        Fede.getGuardarropas().get(0).agregarPrenda(prenda4);
        Fede.getGuardarropas().get(0).agregarPrenda(prenda5);

    }
    @Test
    public void CargaEventos(){
        List<Evento> eventos = new ArrayList<>();
        Fede.setEventos(eventos);

        Date fecha = new Date("06/11/2019");
        CriterioNulo criterioNulo = new CriterioNulo();

        Evento evento = new Evento(fecha,criterioNulo,Fede.getGuardarropas().get(0));
        Fede.addEvento(evento);
        Assert.assertTrue(Fede.getEventos().isEmpty() == false );

    }
    @Test
    public void EjecutarEvento(){

        List<Evento> eventos = new ArrayList<>();

        Fede.setEventos(eventos);
        Date fecha = new Date("06/11/2019");
        CriterioNulo criterioNulo = new CriterioNulo();

        Evento evento = new Evento(fecha,criterioNulo,Fede.getGuardarropas().get(0));
        Fede.addEvento(evento);

        Evento eventoTest = Fede.getEventos().get(0);

        List<Atuendo> AtuendosSugeridos = eventoTest.resolver();
        Assert.assertTrue(AtuendosSugeridos.isEmpty() == false );

    }
//    public void PersonasConDistintosPlacared (){
//        Usuario personaA = new Usuario();
//
//        String fileNameA = "PlacardA.txt";
//        String fileNameB = "PlacardB.txt";
//
//        Guardarropa placardA = new Guardarropa();
//        Guardarropa placardB = new Guardarropa();
//
//        ParserPrenda parseA = new ParserPrenda(fileNameA);
//        parseA.GuardarPrendas(";", placardA);
//
//        ParserPrenda parseB = new ParserPrenda(fileNameB);
//        parseA.GuardarPrendas(";", placardB);
//
//        List<Guardarropa> placares = new LinkedList<>();
//        placares.add(placardA);
//        placares.add(placardB);
//
//        personaA.setGuardarropas(placares);
//
//        Assert.assertEquals(true, (personaA.getGuardarropas().get(0)) != (personaA.getGuardarropas().get(1)));
//    }
}
