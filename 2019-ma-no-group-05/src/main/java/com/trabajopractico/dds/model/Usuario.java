package com.trabajopractico.dds.model;

import static com.trabajopractico.dds.notificador.strategy.impl.NotificadorMail.instanceofNotificadorMail;

import java.util.Arrays;
import java.util.List;

import com.trabajopractico.dds.eventos.command.impl.EjecutadorEventos;
import com.trabajopractico.dds.eventos.command.impl.EventoAceptar;
import com.trabajopractico.dds.eventos.command.impl.EventoDeshacer;
import com.trabajopractico.dds.notificador.strategy.INotificador;

public class Usuario {
	private List<Guardarropa> guardarropas;
	private List<Evento> eventos;
	private Membresia membresia;
	private String mail;
	private INotificador notificador;

	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
		if(membresia.tipo.toLowerCase().equals("gratuito")){
			guardarropas = Arrays.asList(new Guardarropa[membresia.limitePrendas]);
			//The resulting list is modifiable, but not resizable (i.e. add(e) and remove(e) don't work, but set(index, e) does).
		}
	}


	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}

	public void setGuardarropas(List<Guardarropa> guardarropas) {		
		guardarropas.forEach(guardarropa->guardarropa.setDuenio(this));
		this.guardarropas = guardarropas;
	}
	
	public void agregarGuardarropa(Guardarropa guardarropa) {
		this.guardarropas.add(guardarropa);
	}
	
	public void eliminarGuardarropa(Guardarropa guardarropa) {
		this.guardarropas.remove(guardarropa);
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public void addEvento(Evento evento) {this.eventos.add(evento);}
	public List<Evento> getEventos(){return this.eventos;}
	
	public void aceptar(Evento evento){
		EjecutadorEventos ejecutadorEventos = new EjecutadorEventos();
		ejecutadorEventos.ejecutarEvento(new EventoAceptar(evento));
	}
	
	public void deshacer(Evento evento){
		EjecutadorEventos ejecutadorEventos = new EjecutadorEventos();
		ejecutadorEventos.ejecutarEvento(new EventoDeshacer(evento));
	}

	public void setModoNotificacion(String mail){
		this.mail = mail;
		this.notificador = instanceofNotificadorMail();
	}

	public String getMail () {
		return mail;
	}

	public void setMail (String s) {
	    this.mail = s;
	}
}
