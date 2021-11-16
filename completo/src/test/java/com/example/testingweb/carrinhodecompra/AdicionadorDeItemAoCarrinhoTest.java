package com.example.testingweb.carrinhodecompra;

import com.example.testingweb.carrinho.AdicionadorDeItemAoCarrinho;
import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.CarrinhoHibernateDAO;
import com.example.testingweb.carrinho.CarrinhoRepository;
import com.example.testingweb.carrinho.ItemDoCarrinho;
import com.example.testingweb.produto.Produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AdicionadorDeItemAoCarrinhoTest {
	private static final int UM = 1;
	private Produto celular;

	@BeforeEach
	public void inicializar() throws Exception {
		double valorUnitario = 1300d;
		celular = new Produto("Nexus 5", valorUnitario);
	}
	
	@Test
	public void deve_ser_possivel_adicionar_um_item() throws Exception {
		ItemDoCarrinho umCelular = new ItemDoCarrinho(celular, UM);
		CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
		
		CarrinhoRepository carrinhoRepository = Mockito.mock(CarrinhoHibernateDAO.class);
		
		AdicionadorDeItemAoCarrinho adicionador = 
					new AdicionadorDeItemAoCarrinho(carrinhoRepository);
		adicionador.adicionar(umCelular, carrinho);
		
		Mockito.verify(carrinhoRepository, Mockito.times(1)).salvar(carrinho);
	}
}
