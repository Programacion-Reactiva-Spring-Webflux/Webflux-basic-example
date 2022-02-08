package com.lagm.webflux.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public class ProductoRepository {
	private static List<Producto> lista = new ArrayList<>();
	
	static {
		lista.add(new Producto(1, "ordenador", 200));
		lista.add(new Producto(2, "tablet", 300));
		lista.add(new Producto(3, "auricular", 200));
	}
	
	public Flux<Producto> buscarTodos() {
		return Flux.fromIterable(lista).delayElements(Duration.ofSeconds(3));
	}
}
