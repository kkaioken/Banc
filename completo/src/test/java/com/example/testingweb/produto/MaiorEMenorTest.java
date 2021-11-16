package com.example.testingweb.produto;

import com.example.testingweb.carrinho.CarrinhoDeCompra;
import com.example.testingweb.carrinho.ItemDoCarrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaiorEMenorTest {
    private static final int UM = 1;
    private Produto geladeira;
    private Produto liquidificador;
    private Produto pratos;

    @BeforeEach
	public void inicializar() throws Exception {
		geladeira = new Produto("Geladeira", 450.0);
        liquidificador = new Produto("Liquidificador", 250.0);
        pratos = new Produto("Jogo de pratos", 70.0);
	}
    
    @Test
    public void ordemDecrescente() {
        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
        carrinho.adicionar(new ItemDoCarrinho(geladeira, UM));
        carrinho.adicionar(new ItemDoCarrinho(liquidificador, UM));
        carrinho.adicionar(new ItemDoCarrinho(pratos, UM));
        
        MaiorEMenor algoritmo = new MaiorEMenor();
        algoritmo.encontra(carrinho);
        
        Assertions.assertEquals("Jogo de pratos", algoritmo.getMenor().getDescricao());
        Assertions.assertEquals("Geladeira", algoritmo.getMaior().getDescricao());
    }
}