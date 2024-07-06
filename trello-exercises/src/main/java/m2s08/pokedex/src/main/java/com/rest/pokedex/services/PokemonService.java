package com.rest.pokedex.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.rest.pokedex.exceptions.PokemonNotFoundException;
import com.rest.pokedex.models.Pokemon;
import com.rest.pokedex.repositories.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository pokemonRepository;
	
	public Pokemon salvar(Pokemon pokemon) throws DuplicateKeyException {
		
		if (pokemonRepository.existsById(pokemon.getNumero())) {
			throw new DuplicateKeyException("Já existe um pokemon com esse número");
		}
		
		return pokemonRepository.save(pokemon);
	}
	
	public Pokemon buscarPorNumero(Integer numero) throws PokemonNotFoundException {
		Optional<Pokemon> opt = pokemonRepository.findById(numero);
		
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new PokemonNotFoundException("Pokemon com número " + numero + " não encontrado");
		}
	}
	
	public Pokemon alterarVisto(Integer numero, Pokemon pokemon) throws PokemonNotFoundException {
		Pokemon pokemonSalvo = buscarPorNumero(numero);
		pokemonSalvo.setNome(pokemon.getNome());
		pokemonSalvo.setImagemUrl(pokemon.getImagemUrl());
		pokemonSalvo.setHabitat(pokemon.getHabitat());
		return pokemonRepository.save(pokemonSalvo);
	}
	
	public Pokemon alterarCapturado(Integer numero, Pokemon pokemon) throws PokemonNotFoundException {
		Pokemon pokemonSalvo = buscarPorNumero(numero);
		BeanUtils.copyProperties(pokemon, pokemonSalvo, "numero");
		return pokemonRepository.save(pokemonSalvo);
	}
	
	public void apagar(Integer numero) throws PokemonNotFoundException {
		Pokemon pokemon = buscarPorNumero(numero);
		pokemonRepository.delete(pokemon);
	}
	
	public List<Pokemon> buscarTodos() {
		return pokemonRepository.findAll();
	}

}
