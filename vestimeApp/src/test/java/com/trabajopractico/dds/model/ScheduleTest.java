package com.trabajopractico.dds.model;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.trabajopractico.dds.criterio.strategy.impl.CriterioNulo;

public class ScheduleTest {
    private Evento eventoPrueba;

    @Before
    public void setUp(){
        Guardarropa unGuardaropa = new Guardarropa();

        Prenda prenda1 = new Prenda(TipoDePrenda.SHORT, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda2 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda3 = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, Color.NEGRO, Color.BLANCO);
        Prenda prenda4 = new Prenda(TipoDePrenda.REMERA_MANGAS_LARGAS, Material.ALGODON, Color.BLANCO, Color.AMARILLO);
        Prenda prenda5 = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, Color.MARRON, Color.NEGRO);
        unGuardaropa.setPrendas(new ArrayList<>());

        unGuardaropa.agregarPrenda(prenda1);
        unGuardaropa.agregarPrenda(prenda2);
        unGuardaropa.agregarPrenda(prenda3);
        unGuardaropa.agregarPrenda(prenda4);
        unGuardaropa.agregarPrenda(prenda5);

        Date fecha = new Date();
        CriterioNulo criterioNulo = new CriterioNulo();

        eventoPrueba = new Evento(fecha,criterioNulo,unGuardaropa);

    }
    @Test
    public void scheduleTask_withValidDate_runsOk() throws InterruptedException {
        EventScheduler scheduler = new EventScheduler();
        long days = 0L;
        long period = 10*1000;
        System.out.println("TimerTask started");
        scheduler.notifyIn(days,period);
        Thread.sleep(15000);
    }

    @Test
    public void scheduleEvento_withValidDate_runsOk() throws InterruptedException {
        EventScheduler scheduler = new EventScheduler();
        System.out.println("TimerTask started " + eventoPrueba.getDate());
        long fechaActual = new Date().getTime() + 3000;
        Date fechaNueva = new Date(fechaActual);
        eventoPrueba.setFecha(fechaNueva);
        scheduler.scheduleEvent(eventoPrueba);
        Thread.sleep(10000);
        Assert.assertTrue(eventoPrueba.getResuelto());
    }
}
