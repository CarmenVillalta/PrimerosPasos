package com.trabajopractico.dds.eventos.command.impl;

import java.util.ArrayList;
import java.util.List;

import com.trabajopractico.dds.eventos.command.ICommandEventos;

public class EjecutadorEventos {

    private final List<ICommandEventos> comandosEvento = new ArrayList<>();

    public boolean ejecutarEvento(ICommandEventos comandoEvento){
       comandosEvento.add(comandoEvento);
       return comandoEvento.excecute();
    }
}
