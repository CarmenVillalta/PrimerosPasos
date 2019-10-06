package com.trabajopractico.dds.model;

import java.util.Timer;
import java.util.TimerTask;

public class EventScheduler {

    public void notifyIn(long days) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sendReminder();
            }
        };
        Timer timer = new Timer("Timer");
        timer.schedule(task,days);
    }

    public void notifyIn(long days, long period){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sendReminder();
            }
        };
        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(task,days,period);
    }

    public void sendReminder(){
        System.out.println("se ejecuto");
    }

    public void scheduleEvent(Evento evento){
        TimerTask task = new TimerTask() {
            @Override
            public void run () {
                activateEvento(evento);

            };};
        Timer timer = new Timer();
        timer.schedule(task,evento.getDate());

        System.out.println("Se planificó el evento para: " + evento.getDate());
    }

    public void activateEvento(Evento evento){
        evento.resolver();
        // Pasarle a alguien el resultado, algún controler
        evento.setResuelto();
        System.out.println("se ejecuto el evento");
    }
}
