package com.rest.pokedex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.pokedex.models.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {}