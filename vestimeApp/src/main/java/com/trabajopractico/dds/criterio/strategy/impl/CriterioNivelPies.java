package com.trabajopractico.dds.criterio.strategy.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.model.Atuendo;
import com.trabajopractico.dds.model.Nivel;
import com.trabajopractico.dds.model.Prenda;

public class CriterioNivelPies implements ICriterio {
    @Override
    public Boolean validar(Atuendo atuendo) {
        List<Prenda> pies = atuendo.getPies();
        List<Prenda> piesNivel0 = pies.stream().filter(prenda->prenda.getNivel().equals(Nivel.CERO)).collect(Collectors.toList());
        if (piesNivel0.size()>1) return false;
        List<Prenda> piesNivel1 = pies.stream().filter(prenda->prenda.getNivel().equals(Nivel.UNO)).collect(Collectors.toList());
        if (piesNivel1.size()>1) return false;
        List<Prenda> piesNivel2 = pies.stream().filter(prenda->prenda.getNivel().equals(Nivel.DOS)).collect(Collectors.toList());
        if (piesNivel2.size()>1) return false;
        return true;
    }
}
