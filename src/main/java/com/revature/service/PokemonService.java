package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Pokemon;
import com.revature.repository.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepo;
	
	public int addPokemon(Pokemon pokemon) {
		
		Pokemon savedPokemon = pokemonRepo.save(pokemon);
		return savedPokemon.getId();
	}
	
	public List<Pokemon> findAllPokemon() {
		
		return pokemonRepo.findAll();
	}
	
	public void deletePokemonById(int id) {
		
		pokemonRepo.deleteById(id);
	}
	

}
