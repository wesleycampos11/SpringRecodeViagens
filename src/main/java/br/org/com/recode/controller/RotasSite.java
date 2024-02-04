package br.org.com.recode.controller;


import org.springframework.stereotype.Controller;   
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RotasSite {

	// ROTAS PRINCIPAIS	

	@GetMapping("/")
	// INICIALIZA A APLICAÇÃO
	public String index() {
		return "index";
	}

	@GetMapping("/pagina")
	// PÁGINA PROMOÇÕES
	public ModelAndView pagina() {
		ModelAndView modelAndView = new ModelAndView("site/pagina");
		return modelAndView;
	}
	
	@GetMapping("/contatos")
	// PÁGINA DESTINOS
	public ModelAndView contatos() {
		ModelAndView modelAndView = new ModelAndView("site/contatos");
		return modelAndView;
	}
		
	
	// ROTAS RODAPÉ
	@GetMapping("/{id}/promocoes")
	// PÁGINA QUEM SOMOS
	public ModelAndView quemsomos() {
		ModelAndView modelAndView = new ModelAndView("site/pagina");
		return modelAndView;
	}
	
	
		
}
