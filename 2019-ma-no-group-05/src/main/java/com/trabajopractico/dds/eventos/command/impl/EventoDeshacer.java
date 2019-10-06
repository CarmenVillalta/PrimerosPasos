package com.trabajopractico.dds.eventos.command.impl;

import com.trabajopractico.dds.eventos.command.ICommandEventos;
import com.trabajopractico.dds.model.Evento;

public class EventoDeshacer implements ICommandEventos {

    private Evento evento;

    public EventoDeshacer(Evento evento){ this.evento = evento;}

    @Override
    public boolean excecute () {
        return evento.DeshacerOperacion(evento.getAtuendo());
    }
}
