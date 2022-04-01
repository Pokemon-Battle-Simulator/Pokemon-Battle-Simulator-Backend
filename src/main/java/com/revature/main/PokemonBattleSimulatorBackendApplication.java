package com.revature.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PokemonBattleSimulatorBackendApplication{

	public static void main(String[] args) {
		SpringApplication.run(PokemonBattleSimulatorBackendApplication.class, args);
	}
	
	// Set the default welcome view to the index.html page (inside the static folder)
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index"); // our index.html page will be rendered at http://localhost:5000/api 
		return modelAndView;			   // we'll see index.html
	}
	

}
