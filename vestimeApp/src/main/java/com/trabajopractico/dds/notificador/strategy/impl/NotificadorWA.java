package com.trabajopractico.dds.notificador.strategy.impl;

import com.trabajopractico.dds.notificador.strategy.INotificador;

public class NotificadorWA implements INotificador {
    private static NotificadorWA nw;

    private NotificadorWA(){};

    public static NotificadorWA instanceofNotificdorWA(){
        if (nw == null){
            nw = new NotificadorWA();
        }
        return nw;
    }

    @Override
    public int notificar (String destino, String mensaje) {
        System.out.println("Enviò el messaje: \n" + mensaje + "\nAl destino: \n" + destino);
        //        if (error) {throw new SugerenciasInvalidasException("Hubo un error al armar la sugerencia");}
        return 0;
    }
}
