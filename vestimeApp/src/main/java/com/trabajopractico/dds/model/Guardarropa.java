package com.trabajopractico.dds.model;
import java.util.ArrayList;
import java.util.List;

public class Guardarropa {
	
	private String idNombre;
	private List<Prenda> prendas;
	private Usuario duenio;
	private List<Usuario> compartidosCon = new ArrayList<Usuario>();

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	public void agregarPrenda(Prenda ropa) {
		this.prendas.add(ropa);
	}

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setDuenio(Usuario usuario) {
		duenio = usuario;
	}
	
	public Usuario getDuenio() {
		return duenio;
	}
	
	public void compartirCon(Usuario user) {
		
		user.agregarGuardarropa(this);
		compartidosCon.add(user);
	}
	
	public void dejarDeCompartir(Usuario user) {
		user.eliminarGuardarropa(this);
		compartidosCon.remove(user);

	}

	public String getIdNombre() {
		return idNombre;
	}

	public void setIdNombre(String idNombre) {
		this.idNombre = idNombre;
	}
	
	

}
