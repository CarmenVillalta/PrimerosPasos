package com.trabajopractico.dds.eventos.command.impl;

import com.trabajopractico.dds.eventos.command.ICommandEventos;
import com.trabajopractico.dds.model.Evento;

public class EventoAceptar implements ICommandEventos {
    private Evento evento;


    public EventoAceptar(Evento evento){ this.evento = evento;}

    @Override
    public boolean excecute () {
        return evento.AceptarSugerencia(evento.getAtuendo());
    }
}
