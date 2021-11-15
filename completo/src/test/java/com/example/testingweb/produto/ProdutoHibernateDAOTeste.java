package com.example.testingweb.produto;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.testingweb.produto.Produto;
import com.example.testingweb.produto.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class ProdutoHibernateDAOTeste {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	private Produto geladeira;
	private Produto fogao;
	private Produto microondas;
	
	@Before
	public void init() throws Exception {
		geladeira = new Produto("Geladeira", 1200d);
		produtoRepository.salvar(geladeira);
		fogao = new Produto("Fog�o", 1000d);
		produtoRepository.salvar(fogao);
		microondas = new Produto("Microondas", 200d);
		produtoRepository.salvar(microondas);
	}
	
	@Test
	public void deve_salvar_um_produto() throws Exception {
		Produto produto = new Produto("Geladeira", 1200d);
		
		produtoRepository.salvar(produto);
		
		assertNotNull(produtoRepository.buscarPelo(produto.getId()));
	}
	
	@Test
	public void deve_buscar_produtos_por_faixa_de_preco() throws Exception {
		double precoMinimo = 1000d;
		double precoMaximo = 1500d;
		
		List<Produto> produtosRetornados = produtoRepository.buscarPorFaixaDePreco(precoMinimo, precoMaximo);
		
		assertThat(produtosRetornados, contains(geladeira, fogao));
	}
}
