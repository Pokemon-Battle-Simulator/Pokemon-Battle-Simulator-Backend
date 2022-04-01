package com.revature.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Pokemon;
import com.revature.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*") 
	@PostMapping("/add")
	public ResponseEntity<Pokemon> addPokemon(Pokemon pokemon) {
		return ResponseEntity.ok(pokemonService.add(pokemon));
	}
	
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*") 
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> getPokemon(@PathVariable int id) {
		return ResponseEntity.ok(pokemonService.getById(id));
	}

}
