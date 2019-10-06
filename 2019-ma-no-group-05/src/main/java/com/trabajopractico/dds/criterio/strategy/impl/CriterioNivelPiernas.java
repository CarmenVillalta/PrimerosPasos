package com.trabajopractico.dds.criterio.strategy.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.model.Atuendo;
import com.trabajopractico.dds.model.Nivel;
import com.trabajopractico.dds.model.Prenda;

public class CriterioNivelPiernas implements ICriterio {

    @Override
    public Boolean validar(Atuendo atuendo) {
        List<Prenda> piernas = atuendo.getPiernas();
        List<Prenda> piernasNivel0 = piernas.stream().filter(prenda->prenda.getNivel().equals(Nivel.CERO)).collect(Collectors.toList());
        if (piernasNivel0.size()>1) return false;
        List<Prenda> piernasNivel1 = piernas.stream().filter(prenda->prenda.getNivel().equals(Nivel.UNO)).collect(Collectors.toList());
        if (piernasNivel1.size()>1) return false;
        List<Prenda> piernasNivel2 = piernas.stream().filter(prenda->prenda.getNivel().equals(Nivel.DOS)).collect(Collectors.toList());
        if (piernasNivel2.size()>1) return false;
        return true;
    }
}
