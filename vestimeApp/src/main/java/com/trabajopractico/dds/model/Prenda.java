package com.trabajopractico.dds.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Prenda {

	private TipoDePrenda tipoDePrenda;
	private Material material;
	private Color colorPrimario;
	private Color colorSecundario;
	private BufferedImage imagen;
	private Boolean estaEnUso = false;


	public Boolean getEstaEnUso() {
		return estaEnUso;
	}

	public void setEstaEnUso() {
		this.estaEnUso = true;
	}
	
	public void estaDisponible() {
		this.estaEnUso =false;
	}

	public Prenda(TipoDePrenda tipoDePrenda, Material material, Color colorPrimario, Color colorSecundario) {

		this.tipoDePrenda = tipoDePrenda;
		this.material = material;
		this.colorPrimario = colorPrimario;
		this.colorSecundario = colorSecundario;
	}

	public TipoDePrenda getTipoDePrenda() {
		return tipoDePrenda;
	}

	public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
		this.tipoDePrenda = tipoDePrenda;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Color getColorPrimario() {
		return colorPrimario;
	}

	public void setColorPrimario(Color colorPrimario) {
		this.colorPrimario = colorPrimario;
	}

	public Color getColorSecundario() {
		return colorSecundario;
	}

	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}
	
	public Categoria getCategoria(){
		return  this.tipoDePrenda.getCategoria();
	}

	public Nivel getNivel() {return this.tipoDePrenda.getNivel(); }

	public void agregarImagen(String path){
		BufferedImage data = null;
		try {
			data=ImageIO.read(new File(path));
			imagen = data;
		}
		catch (IOException ex){
			System.out.println("No se pudo guardar la imagen");
		}
	}

	public BufferedImage getImagen(){
		return this.imagen;
	}

	public Integer getNivelDeAbrigo() {
		return tipoDePrenda.getAbrigo();
	}

	public void setEstaDisponible () {
		estaEnUso = false;
	}
}