package com.lagm.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.lagm.webflux.model.ProductoRepository;

@Controller
public class ControladorReactivo {
	@Autowired
	private ProductoRepository productoRepository;
	
	@RequestMapping("/lista")
	public String lista(Model modelo) {
		// Variable reactiva
		IReactiveDataDriverContextVariable listaReactiva = new ReactiveDataDriverContextVariable(productoRepository.buscarTodos(), 1);
		modelo.addAttribute("listaProductos", listaReactiva);
		return "lista";
	}
}
