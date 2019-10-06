package com.trabajopractico.dds.model;

import java.util.Arrays;
import java.util.Optional;


public enum Categoria {
	TORSO("torso"), PIERNAS("piernas"), PIES("pies"), ACCESORIO("accesorio");

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	private Categoria(String descripcion) {
		this.descripcion = descripcion;
	}

	public static Categoria getCategoria(String name) {
		return Optional.ofNullable(
				Arrays.asList(Categoria.values()).stream().filter(x -> x.name().equals(name)).findAny().orElse(null))
				.orElseThrow(() -> new RuntimeException("Categoria invalida"));
	}

}
