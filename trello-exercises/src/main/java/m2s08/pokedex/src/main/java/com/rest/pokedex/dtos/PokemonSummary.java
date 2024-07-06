package com.rest.pokedex.dtos;

public class PokemonSummary {

	private int numero;
	private String nome;
	private boolean capturado;
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isCapturado() {
		return capturado;
	}
	
	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
}
