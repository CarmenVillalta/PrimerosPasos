package com.trabajopractico.dds.criterio.strategy.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.trabajopractico.dds.criterio.strategy.ICriterio;
import com.trabajopractico.dds.model.Atuendo;
import com.trabajopractico.dds.model.Nivel;
import com.trabajopractico.dds.model.Prenda;

public class CriterioNivelTorso implements ICriterio {

    @Override
    public Boolean validar(Atuendo atuendo) {
        List<Prenda> torsos = atuendo.getTorso();
        List<Prenda> torsoNivel0 = torsos.stream().filter(prenda->prenda.getNivel().equals(Nivel.CERO)).collect(Collectors.toList());
        if (torsoNivel0.size()>1) return false;
        List<Prenda> torsoNivel1 = torsos.stream().filter(prenda->prenda.getNivel().equals(Nivel.UNO)).collect(Collectors.toList());
        if (torsoNivel1.size()>3) return false;
        List<Prenda> torsoNivel2 = torsos.stream().filter(prenda->prenda.getNivel().equals(Nivel.DOS)).collect(Collectors.toList());
        if (torsoNivel2.size()>2) return false;
        List<Prenda> torsoNivel3 = torsos.stream().filter(prenda->prenda.getNivel().equals(Nivel.TRES)).collect(Collectors.toList());
        if (torsoNivel3.size()>1) return false;
        List<Prenda> torsoNivel4 = torsos.stream().filter(prenda->prenda.getNivel().equals(Nivel.CUATRO)).collect(Collectors.toList());
        if (torsoNivel4.size()>1) return false;
        List<Prenda> torsoNivel5 = torsos.stream().filter(prenda->prenda.getNivel().equals(Nivel.CINCO)).collect(Collectors.toList());
        if (torsoNivel5.size()>1) return false;
        return true;
    }
}
