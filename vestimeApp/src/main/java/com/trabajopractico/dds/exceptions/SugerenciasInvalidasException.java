package com.trabajopractico.dds.exceptions;

public class SugerenciasInvalidasException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SugerenciasInvalidasException(String mensaje){
		super(mensaje);
	}
}
