package com.rest.pokedex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pokedex.dtos.PokemonCapturadoRequest;
import com.rest.pokedex.dtos.PokemonCapturadoResponse;
import com.rest.pokedex.dtos.PokemonSummary;
import com.rest.pokedex.dtos.PokemonVistoRequest;
import com.rest.pokedex.dtos.PokemonVistoResponse;
import com.rest.pokedex.dtos.mappers.PokemonMapper;
import com.rest.pokedex.exceptions.PokemonNotFoundException;
import com.rest.pokedex.models.Pokemon;
import com.rest.pokedex.services.PokemonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private PokemonMapper pokemonMapper;
	
	@PostMapping("/vistos")
	public ResponseEntity<PokemonVistoResponse> salvar(@RequestBody @Valid PokemonVistoRequest pokemonVistoRequest) {
		Pokemon pokemon = pokemonMapper.vistoToEntity(pokemonVistoRequest);
		Pokemon pokemonSalvo = pokemonService.salvar(pokemon);
		PokemonVistoResponse pokemonVistoResponse = pokemonMapper.vistoToDTO(pokemonSalvo);
		return ResponseEntity.status(HttpStatus.CREATED).body(pokemonVistoResponse);
	}
	
	@PostMapping("/capturados")
	public ResponseEntity<PokemonCapturadoResponse> salvar(@RequestBody @Valid PokemonCapturadoRequest pokemonCapturadoRequest) {
		Pokemon pokemon = pokemonMapper.capturadoToEntity(pokemonCapturadoRequest);
		Pokemon pokemonSalvo = pokemonService.salvar(pokemon);
		PokemonCapturadoResponse pokemonCapturadoResponse = pokemonMapper.capturadoToDTO(pokemonSalvo);
		return ResponseEntity.status(HttpStatus.CREATED).body(pokemonCapturadoResponse);
	}
	
	@PutMapping("vistos/{id}")
	public ResponseEntity<Object> alterarVisto(@PathVariable(value = "id") Integer numero, 
		@RequestBody @Valid PokemonVistoRequest pokemonVistoRequest) throws PokemonNotFoundException {
		Pokemon pokemon = pokemonMapper.vistoToEntity(pokemonVistoRequest);
		Pokemon pokemonGravado = pokemonService.alterarVisto(numero, pokemon);
		PokemonVistoResponse pokemonVistoResponse = pokemonMapper.vistoToDTO(pokemonGravado);
		return ResponseEntity.status(HttpStatus.OK).body(pokemonVistoResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUm(@PathVariable(value = "id") Integer numero) throws PokemonNotFoundException {
		Pokemon pokemonSalvo = pokemonService.buscarPorNumero(numero);
		PokemonCapturadoResponse pokemonResponse = pokemonMapper.capturadoToDTO(pokemonSalvo);
		return ResponseEntity.status(HttpStatus.OK).body(pokemonResponse);
	}
	
	@PutMapping("capturados/{id}")
	public ResponseEntity<Object> alterarCapturado(@PathVariable(value = "id") Integer numero, 
		@RequestBody @Valid PokemonCapturadoRequest pokemonCapturadoRequest) throws PokemonNotFoundException {
		Pokemon pokemon = pokemonMapper.capturadoToEntity(pokemonCapturadoRequest);
		Pokemon pokemonGravado = pokemonService.alterarCapturado(numero, pokemon);
		PokemonCapturadoResponse pokemonCapturadoResponse = pokemonMapper.capturadoToDTO(pokemonGravado);
		return ResponseEntity.status(HttpStatus.OK).body(pokemonCapturadoResponse);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable(value = "id") Integer numero) throws PokemonNotFoundException {
		pokemonService.apagar(numero);
		return ResponseEntity.status(HttpStatus.OK).body("Pokemon removido com sucesso");
	}
	
	@GetMapping
	public ResponseEntity<List<PokemonSummary>> buscarTodos() {
		List<Pokemon> pokemon = pokemonService.buscarTodos(); 
		List<PokemonSummary> pokemonSummary = pokemonMapper.resumosToDTO(pokemon);
		return ResponseEntity.status(HttpStatus.OK).body(pokemonSummary);
	}
	
}
