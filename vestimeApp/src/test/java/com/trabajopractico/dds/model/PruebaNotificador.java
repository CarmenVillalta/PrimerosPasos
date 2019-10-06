package com.trabajopractico.dds.model;

import org.junit.Test;

import com.trabajopractico.dds.notificador.strategy.impl.NotificadorMail;
import com.trabajopractico.dds.notificador.strategy.impl.NotificadorSMS;
import com.trabajopractico.dds.notificador.strategy.impl.NotificadorWA;

public class PruebaNotificador {

    @Test
    public void ValidoLaComunicacionPorMail(){
        NotificadorMail nm = NotificadorMail.instanceofNotificadorMail();
        NotificadorSMS ns= NotificadorSMS.instanceofNotificadorSMS();
        NotificadorWA nw = NotificadorWA.instanceofNotificdorWA();

        String mensaje = "Buenas!! a que no sabés quien hizo andar el mail de la aplicación de java?";
        String destino = "mlauramonesterolo@gmail.com";
        nm.notificar(destino, mensaje);
        ns.notificar("1561760611", "Buenas!!");
        nw.notificar("1561769611","Buen dìa!");
    }
}
