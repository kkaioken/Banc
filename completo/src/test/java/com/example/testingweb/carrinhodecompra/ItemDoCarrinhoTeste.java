package com.example.testingweb.carrinhodecompra;

import static org.junit.jupiter.api.Assertions.*;

import com.example.testingweb.carrinho.ItemDoCarrinho;
import com.example.testingweb.produto.Produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemDoCarrinhoTeste {

	private Produto geladeira;

	@BeforeEach
	public void inicializar() throws Exception {
		geladeira = new Produto("Geladeira", 1200d);
	}
	
	@Test
	public void deve_calcular_valor_total() throws Exception {
		double totalEsperado = 2400d;
		ItemDoCarrinho itemDoCarrinho = new ItemDoCarrinho(geladeira, 2);
		
		assertEquals(totalEsperado, itemDoCarrinho.getValorTotal(), 0.001);
	}
}
