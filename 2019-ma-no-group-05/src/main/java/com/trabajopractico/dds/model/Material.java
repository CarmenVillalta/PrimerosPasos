package com.trabajopractico.dds.model;

import java.util.Arrays;
import java.util.Optional;

public enum Material {

	SEDA("seda"), ALGODON("algodon"), LANA("lana"), JEAN("jean"), CUERO("cuero");

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	private Material(String descripcion) {
		this.descripcion = descripcion;
	}

	public static Material getMaterial(String name) {
		return Optional.ofNullable(
				Arrays.asList(Material.values()).stream().filter(x -> x.name().equals(name)).findAny().orElse(null))
				.orElseThrow(() -> new RuntimeException("Material invalido"));
	}

}
