package com.example.testingweb.carrinhodecompra;;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;
import com.example.testingweb.produto.Produto;

public class CarrinhoDeCompraTeste {
	private static final int UM = 1;
	private Produto celular;

	@Before
	public void inicializar() throws Exception {
		double valorUnitario = 1300d;
		celular = new Produto("Nexus 5", valorUnitario);
	}

	@Test
	public void deve_poder_adicionar_itens_ao_carrinho() {
		ItemDoCarrinho umCelular = new ItemDoCarrinho(celular, UM);
		
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adicionar(umCelular);
		
		assertThat(carrinho.getItensDoCarrinho(), contains(umCelular));
	}
	
	@Test
	public void deve_poder_remover_itens_do_carrinho() throws Exception {
		ItemDoCarrinho umCelular = new ItemDoCarrinho(celular, UM);
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		carrinho.adicionar(umCelular);
		
		carrinho.remover(umCelular);
		
		assertThat(carrinho.getItensDoCarrinho(), not(contains(umCelular)));
	}
}
