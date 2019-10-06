package com.trabajopractico.dds.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.trabajopractico.dds.criterio.strategy.impl.CriterioNulo;

import junit.framework.Assert;;

public class AtuendoTest {
    @Test
    public void validarCriteriosDeNivelUnoConMaxinoEnTorso() {
        Prenda prenda1 = new Prenda(TipoDePrenda.REMERA_MANGAS_LARGAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda2 = new Prenda(TipoDePrenda.MUSCULOSA, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda3 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.AMARILLO);
        Prenda prenda4 = new Prenda(TipoDePrenda.CAMPERA, Material.CUERO, Color.NEGRO, Color.MARRON);
        Prenda prenda5 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.ROJO);
        Prenda prenda6 = new Prenda(TipoDePrenda.REMERA_MANGAS_CORTAS, Material.ALGODON, Color.NEGRO, Color.MARRON);
        Prenda prenda7 = new Prenda(TipoDePrenda.BOTAS, Material.CUERO, Color.MARRON, Color.NEGRO);
        Prenda prenda8 = new Prenda(TipoDePrenda.PANTALON, Material.ALGODON, Color.NEGRO, Color.BLANCO);

        List<Prenda> prendas= new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);
        prendas.add(prenda3);
        prendas.add(prenda4);
        prendas.add(prenda5);
        prendas.add(prenda6);
        prendas.add(prenda7);
        prendas.add(prenda8);

        Sugeridor UnSugeridor= Sugeridor.obtenerInstanciaSigleton();
        List<Atuendo> atuendosSugeridas = UnSugeridor.obtenerTodosLosAtuendosValidos(prendas,new CriterioNulo());
        List<Atuendo> atuendosConCuatroRemeras = new ArrayList<>();
        for(Atuendo a : atuendosSugeridas){
            List<Prenda> p = a.getTorso().stream().filter(prenda -> (prenda.getNivel().equals(Nivel.UNO))).collect(Collectors.toList());
            if (p.size() > 3)
                atuendosConCuatroRemeras.add(a);
        }
        Assert.assertEquals(atuendosConCuatroRemeras.size(),0);

    }
}
