package br.org.com.recode.controller;

import java.io.IOException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import br.org.com.recode.model.Departamento;
import br.org.com.recode.model.Destinos;
import br.org.com.recode.model.Pedido;
import br.org.com.recode.model.Usuario;
import br.org.com.recode.repository.DestinosRepository;
import br.org.com.recode.repository.PedidoRepository;
import br.org.com.recode.repository.UsuarioRepository;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private DestinosRepository destinosRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// === REALIZANDO PEDIDO

	// CHAMA A VIEW CADASTRAR E PASSA UM OBJETO VAZIO
	@GetMapping("/{id}/realizarPedido")
	public ModelAndView realizarPedido(@PathVariable Long id) {
		
		ModelAndView modelAndView = new ModelAndView("perfil/pedido");

		Destinos destinos = destinosRepository.getOne(id);

		// PARA EXIBIR AS INFORMAÇÕES DA PASSAGEM
		modelAndView.addObject("destinos", destinos);
		
		// PARA CRIAR UM PEDIDO
		modelAndView.addObject("pedido", new Pedido());
		
		return modelAndView;
	}
	
	
	// SALVA O PEDIDO NO BD

	@PostMapping("/pedidoRealizado")
	public ModelAndView cadastrarDestino(Pedido pedido) throws IOException {

		ModelAndView modelAndView = new ModelAndView("perfil/success-compra");
		
		
		// PARA EXIBIR AS INFORMAÇÕES DO PEDIDO
		modelAndView.addObject("pedidos", pedido);	
		
		pedidoRepository.save(pedido);

		return modelAndView;
	}
	

	// LISTA OS PEDIDOS - PERFIL USUÁRIO
	
	@PostMapping("/minhasPassagens")
	// RECEBE MODEL E OBJETO COM O EMAIL E SENHA
	public ModelAndView buscarPedidos(Model model, Usuario userParams) {

		ModelAndView mv = new ModelAndView("perfil/minhaspassagens");
		
		// INSTÂNCIA DE USUÁRIO - RETORNA O OBJETO
		List<Pedido> pedidos = pedidoRepository.findByUserId(userParams.getId());


		//model.addAttribute("msg", "No momento não há passagens em seu nome.");
		mv.addObject("pedidos", pedidos);

		return mv;

	}
	
	// == MOSTRA DETALHES DO PEDIDO - PERFIL USUÁRIO
	
	@GetMapping("/detalhesPassagem/{idPedido}")
	public ModelAndView detalhesPassagem(@PathVariable Long idPedido) {
		ModelAndView modelAndView = new ModelAndView("perfil/exibir-detalhes");

		Pedido pedidos = pedidoRepository.getOne(idPedido);
		modelAndView.addObject("pedidos", pedidos);

		return modelAndView;
	}
	
	
	
	// === LISTA TODOS OS PEDIDOS - ADM

	@GetMapping("/listarPedidos")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("admin/pedidos/listar");

		List<Pedido> pedidos = pedidoRepository.findAll();
		mv.addObject("pedidos", pedidos);
		//mv.addObject("destinos", destinosRepository.findAll());

		return mv;
	}
	
	
	
	// == MOSTRA DETALHES DO PEDIDO - ADM
	
	@GetMapping("/{idPedido}/detalhePedido")
	public ModelAndView detalhePedido(@PathVariable Long idPedido) {
		ModelAndView modelAndView = new ModelAndView("admin/pedidos/detalhes");

		Pedido pedidos = pedidoRepository.getOne(idPedido);
		modelAndView.addObject("pedidos", pedidos);

		return modelAndView;
	}
	
	
}
