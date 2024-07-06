package com.rest.pokedex.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PokemonVistoRequest {

	  @NotNull private int numero;
	  @NotBlank private String nome;
	  @NotBlank private String imagemUrl;
	  @NotBlank private String habitat;

	  @NotNull
	  public int getNumero() {
	    return numero;
	  }

	  public void setNumero(@NotNull int numero) {
	    this.numero = numero;
	  }

	  public @NotBlank String getNome() {
	    return nome;
	  }

	  public void setNome(@NotBlank String nome) {
	    this.nome = nome;
	  }

	  public @NotBlank String getImagemUrl() {
	    return imagemUrl;
	  }

	  public void setImagemUrl(@NotBlank String imagemUrl) {
	    this.imagemUrl = imagemUrl;
	  }

	  public @NotBlank String getHabitat() {
	    return habitat;
	  }

	  public void setHabitat(@NotBlank String habitat) {
	    this.habitat = habitat;
	  }
	
}
