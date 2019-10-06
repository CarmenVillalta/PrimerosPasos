package com.trabajopractico.dds.notificador.strategy.impl;

import com.trabajopractico.dds.notificador.strategy.INotificador;

public class NotificadorSMS implements INotificador {
    private static NotificadorSMS ns;
    private NotificadorSMS(){}

    public static NotificadorSMS instanceofNotificadorSMS(){
        if (ns == null){
            ns= new NotificadorSMS();
        }

        return ns;
    }
    @Override
    public int notificar(String destino, String mensaje)
    {
        System.out.println("Enviò el messaje: \n" + mensaje + "\nAl destino:\n" + destino);
        //        if (error) {throw new SugerenciasInvalidasException("Hubo un error al armar la sugerencia");}
        return 0;
    }
}
