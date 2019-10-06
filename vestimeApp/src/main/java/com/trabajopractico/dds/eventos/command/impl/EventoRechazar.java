package com.trabajopractico.dds.eventos.command.impl;

import com.trabajopractico.dds.eventos.command.ICommandEventos;
import com.trabajopractico.dds.model.Evento;

public class EventoRechazar implements ICommandEventos {

    private Evento evento;

    public EventoRechazar(Evento evento){ this.evento = evento;}

    @Override
    public boolean excecute () {
        return evento.RechazarSugerencia();
    }
}
