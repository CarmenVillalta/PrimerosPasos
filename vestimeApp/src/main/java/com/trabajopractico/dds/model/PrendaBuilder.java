package com.trabajopractico.dds.model;

public class PrendaBuilder {

	private TipoDePrenda tipoDePrenda;
	private Material material;
	private Color colorPrimario;
	private Color colorSecundario;

	protected Prenda prenda;

	public PrendaBuilder construirTipoDePrenda(TipoDePrenda tipoDePrenda) {
		this.tipoDePrenda = tipoDePrenda;
		return this;
	}

	public PrendaBuilder construirMaterial(Material material) {
		this.material = material;
		return this;
	}

	public PrendaBuilder construirColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
		return this;
	}

	public PrendaBuilder construirColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
		return this;
	}

	public Prenda build() {
		return new Prenda(tipoDePrenda, material, colorPrimario, colorSecundario);
	}

}
