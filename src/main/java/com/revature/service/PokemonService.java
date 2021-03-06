
  
package com.revature.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Pokemon;
import com.revature.repository.PokemonRepository;

@Service
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepo;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Pokemon addPokemon(Pokemon pokemon) {
		
		Pokemon savedPokemon = pokemonRepo.save(pokemon);
		return savedPokemon;
	}
	
	public List<Pokemon> findAllPokemon() {
		
		return pokemonRepo.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void remove(int id) {
		pokemonRepo.deleteById(id);
	}

	@Transactional(readOnly=true)
	public Pokemon getById(int id) {
		return pokemonRepo.getById(id);
	}
}