package br.org.com.recode.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.org.com.recode.repository.UsuarioRepository;
import br.org.com.recode.model.Usuario;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/login")
	// PÁGINA LOGIN
	public String login(Model model) {
		return "site/login";
	}
	
	
	@PostMapping("/logar")
	// RECEBE MODEL E OBJETO COM O EMAIL E SENHA
	public String logar(Model model, Usuario userParams, String lembrar, HttpSession session) {
		
		// INSTÂNCIA DE USUÁRIO - RETORNA O OBJETO
		Usuario user = this.usuarioRepository.Login(userParams.getEmail(), userParams.getSenha());
		
		if(user != null) {
			session.setAttribute("usuarioLogado", user);
			return "redirect:/perfil";
			
		}
		
		model.addAttribute("erro", "Email e/ou senha inválidos!");
		return "site/login";
	}
	
	// LOGOUT
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";	
	}
	
}
