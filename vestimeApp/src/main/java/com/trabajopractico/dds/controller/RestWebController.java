package com.trabajopractico.dds.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trabajopractico.dds.model.Color;
import com.trabajopractico.dds.model.Guardarropa;
import com.trabajopractico.dds.model.Material;
import com.trabajopractico.dds.model.Prenda;
import com.trabajopractico.dds.model.TipoDePrenda;
import com.trabajopractico.dds.model.Usuario;

@RestController
public class RestWebController {
	
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
//	@RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
//	public List<Customer> getResource(){
//			return cust;
//	}
	
//	@RequestMapping(value="/postcustomer", method=RequestMethod.POST)
//	public String postCustomer(@RequestBody Customer customer){
//		cust.add(customer);
//		
//		return "Sucessful!";
//	}
	
	@RequestMapping(value = "/getPrendasByPlacard/{id}", method = RequestMethod.GET)
	public List<Prenda> getPrendasByPlacard(@PathVariable("id") String id){
		
		
		Usuario usuarioExistente = usuarios.stream().filter(x -> "carmen@gmail.com".equals(x.getMail())).findAny()
				.orElse(null);
		
		Guardarropa guardarropaSelected = usuarioExistente.getGuardarropas().stream().filter(x -> x.getIdNombre().equals(id)).findAny()
				.orElse(null);
		
		
			return guardarropaSelected.getPrendas();
	}
	
	@RequestMapping(value = "/postUsuario", method = RequestMethod.POST)
	public String postUsuario(@RequestBody Usuario usuario) {

		usuarios = this.crearUsuarios();

		Usuario usuarioExistente = usuarios.stream().filter(x -> x.getMail().equals(usuario.getMail())).findAny()
				.orElse(null);
		
		if(usuarioExistente == null)
			return "Error al loguear";

		return "Usuario logueado exitosamente";
	}

	private List<Usuario> crearUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		Usuario carmen = new Usuario();
		List<Guardarropa> guardarropas = new ArrayList<>();
		
		this.agregarPrendas(guardarropas);
		carmen.setGuardarropas(guardarropas);
		
		carmen.setMail("carmen@gmail.com");
		usuarios.add(carmen);
		return usuarios;
	}


	private void agregarPrendas(List<Guardarropa> guardarropas) {
		
		Guardarropa primerGuardarropa = new Guardarropa();
		primerGuardarropa.setIdNombre("G1");
		Guardarropa segundoGuardarropa = new Guardarropa();
		segundoGuardarropa.setIdNombre("G2");
		List<Prenda> prendasG1 = new ArrayList<>(); 
		
		Prenda remera = new Prenda(TipoDePrenda.getRemeraMangasCortas(), Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		Prenda shortCorto = new Prenda(TipoDePrenda.getShort(), Material.ALGODON, Color.NEGRO, Color.AMARILLO);
		Prenda botas = new Prenda(TipoDePrenda.getBotas(), Material.CUERO, Color.MARRON, Color.GRIS);
		Prenda pantalon = new Prenda(TipoDePrenda.getPantalon(), Material.ALGODON, Color.NEGRO, Color.NARANJA);
		
		prendasG1.add(remera);
		prendasG1.add(shortCorto);
		prendasG1.add(botas);
		prendasG1.add(pantalon);
		
		primerGuardarropa.setPrendas(prendasG1);
		
		List<Prenda> prendasG2 = new ArrayList<>();
		
		guardarropas.add(primerGuardarropa);
		
		Prenda musculosa = new Prenda(TipoDePrenda.getMusculosa(), Material.ALGODON, Color.NEGRO, Color.GRIS);
		Prenda campera = new Prenda(TipoDePrenda.getCampera(), Material.ALGODON, Color.NEGRO, Color.GRIS);
		Prenda pantalonnegro = new Prenda(TipoDePrenda.getPantalon(), Material.ALGODON, Color.NEGRO, Color.NEGRO);
		Prenda botasCuero = new Prenda(TipoDePrenda.getBotas(), Material.CUERO, Color.MARRON, Color.GRIS);
		Prenda pantalonAlgodon = new Prenda(TipoDePrenda.getPantalon(), Material.ALGODON, Color.NEGRO, Color.NARANJA);
		
		prendasG2.add(musculosa);
		prendasG2.add(campera);
		prendasG2.add(pantalonnegro);
		prendasG2.add(botasCuero);
		prendasG2.add(pantalonAlgodon);
		
		segundoGuardarropa.setPrendas(prendasG2);
		guardarropas.add(segundoGuardarropa);
		
		
	}

}