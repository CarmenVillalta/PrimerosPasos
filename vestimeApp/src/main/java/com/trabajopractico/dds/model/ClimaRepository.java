package com.trabajopractico.dds.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClimaRepository {
    private List<ApiClima> listaApis;

    public ClimaRepository(){
        listaApis = new ArrayList<>();
    }

    public double getClimaFor(String ciudad, LocalDateTime hora) throws Exception {
        try{
            return obtenerClimaDeLaLista(ciudad, hora);
        }catch(Exception e){
            throw new Exception("Hubo un problema obteniendo temperatura desde las Apis");
        }
    }

    private double obtenerClimaDeLaLista(String ciudad, LocalDateTime hora) {
        double result = 0;
        int index = 0;
        while(result == 0){
            result = listaApis.get(index).getClima(ciudad, hora);
            index++;
        }
        return result;
    }

    void addApi(ApiClima apiClima){
        listaApis.add(apiClima);
    }
}
