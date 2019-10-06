package com.trabajopractico.dds.model;

import java.util.Arrays;
import java.util.Optional;

public enum Color {

	NEGRO("negro"), BLANCO("blanco"), ROJO("rojo"), AZUL("azul"), VERDE("verde"), AMARILLO("amarillo"), VIOLETA(
			"violeta"), GRIS("gris"), MARRON("marron"), NARANJA("naranja"), CELETE("celeste");

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	private Color(String descripcion) {
		this.descripcion = descripcion;
	}

	public static Color getCategoria(String name) {
		return Optional.ofNullable(
				Arrays.asList(Color.values()).stream().filter(x -> x.name().equals(name)).findAny().orElse(null))
				.orElseThrow(() -> new RuntimeException("Color invalida"));
	}
}
