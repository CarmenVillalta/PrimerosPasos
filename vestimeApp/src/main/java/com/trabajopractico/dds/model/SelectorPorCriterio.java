package com.trabajopractico.dds.model;
//import java.util.ArrayList;
import java.util.List;

import com.trabajopractico.dds.criterio.strategy.ICriterio;

public class SelectorPorCriterio {


    public List<Prenda> seleccionar(List<Prenda> lista, List<ICriterio> criterios){
      //  List<Prenda> listaFiltrada= new ArrayList<>();
//        double temp;
//
   //     listaFiltrada=lista.stream().filter(prenda->criterios.stream().allMatch(criterio->criterio.validar(atuendo)))).collect(Collectors.toList());
   //     return listaFiltrada;
        return lista;
    }
    
}
