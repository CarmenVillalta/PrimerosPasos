package com.trabajopractico.dds.exceptions;

public class NotificacionNoEntragadaException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotificacionNoEntragadaException(String mensaje) {
            super(mensaje);
    }
}
