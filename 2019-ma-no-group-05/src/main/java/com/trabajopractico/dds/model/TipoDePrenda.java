package com.trabajopractico.dds.model;

public class TipoDePrenda {

	private Categoria categoria;
	private Nivel nivel;
	private Integer abrigo;

	public TipoDePrenda(Categoria categoria,Nivel nivel, Integer abrigo) {
		this.categoria = categoria;
		this.nivel = nivel;
		this.abrigo = abrigo;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public Integer getAbrigo() {
	    return this.abrigo;
    }
	static final TipoDePrenda BOTAS = new TipoDePrenda(Categoria.PIES, Nivel.UNO,8);
	static final TipoDePrenda REMERA_MANGAS_LARGAS = new TipoDePrenda(Categoria.TORSO, Nivel.DOS,12);
	static final TipoDePrenda REMERA_MANGAS_CORTAS = new TipoDePrenda(Categoria.TORSO, Nivel.UNO,8);
	static final TipoDePrenda MUSCULOSA = new TipoDePrenda(Categoria.TORSO, Nivel.CERO,4);
	static final TipoDePrenda PANTALON = new TipoDePrenda(Categoria.PIERNAS, Nivel.DOS,8);
	static final TipoDePrenda POLLERA = new TipoDePrenda(Categoria.PIERNAS, Nivel.UNO,4);
	static final TipoDePrenda SHORT = new TipoDePrenda(Categoria.PIERNAS, Nivel.UNO,4);
	static final TipoDePrenda CAMPERA = new TipoDePrenda(Categoria.TORSO,Nivel.CINCO,30);

	public static TipoDePrenda getBotas() {
		return BOTAS;
	}

	public static TipoDePrenda getRemeraMangasLargas() {
		return REMERA_MANGAS_LARGAS;
	}

	public static TipoDePrenda getRemeraMangasCortas() {
		return REMERA_MANGAS_CORTAS;
	}

	public static TipoDePrenda getMusculosa() {
		return MUSCULOSA;
	}

	public static TipoDePrenda getPantalon() {
		return PANTALON;
	}

	public static TipoDePrenda getPollera() {
		return POLLERA;
	}

	public static TipoDePrenda getShort() {
		return SHORT;
	}

	public static TipoDePrenda getCampera() {
		return CAMPERA;
	}
	
}
