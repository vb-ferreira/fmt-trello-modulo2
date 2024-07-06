package com.rest.pokedex.dtos.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.pokedex.dtos.PokemonCapturadoRequest;
import com.rest.pokedex.dtos.PokemonCapturadoResponse;
import com.rest.pokedex.dtos.PokemonSummary;
import com.rest.pokedex.dtos.PokemonVistoRequest;
import com.rest.pokedex.dtos.PokemonVistoResponse;
import com.rest.pokedex.models.Pokemon;

@Component
public class PokemonMapper {

	@Autowired
	private ModelMapper mapper;
	
	// Single Resources
	public Pokemon capturadoToEntity(PokemonCapturadoRequest dto) {
		Pokemon entity = mapper.map(dto, Pokemon.class);
		return entity;
	}

	public Pokemon vistoToEntity(PokemonVistoRequest dto) {
		Pokemon entity = mapper.map(dto, Pokemon.class);
		return entity;
	}
	
	public PokemonCapturadoResponse capturadoToDTO(Pokemon entity) {
		PokemonCapturadoResponse dto = mapper.map(entity, PokemonCapturadoResponse.class);
		return dto;
	}
	
	public PokemonSummary resumoToDTO(Pokemon entity) {
		PokemonSummary dto = mapper.map(entity, PokemonSummary.class);
		return dto;
	}
	
	public PokemonVistoResponse vistoToDTO(Pokemon entity) {
		PokemonVistoResponse dto = mapper.map(entity, PokemonVistoResponse.class);
		return dto;
	}

	// Collection Resources
	public List<PokemonVistoResponse> vistosToDTO(List<Pokemon> pokemonList) {
		return pokemonList.stream()
				.map(pokemon -> vistoToDTO(pokemon))
				.collect(Collectors.toList());
	}

	public List<PokemonSummary> resumosToDTO(List<Pokemon> pokemonList) {
		return pokemonList.stream()
				.map(pokemon -> resumoToDTO(pokemon))
				.collect(Collectors.toList());
	}

}
