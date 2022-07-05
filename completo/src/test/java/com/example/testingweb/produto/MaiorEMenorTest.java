package com.example.testingweb.produto;

import com.example.testingweb.builders.CarrinhoDeCompraBuilder;
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
    public void deve_verificar_em_ordem_decrescente() throws ValorInvalido, CarrinhoVazioException {
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompraBuilder()
        .comItemDoCarrinho(new ItemDoCarrinho(geladeira, UM))
        .comItemDoCarrinho(new ItemDoCarrinho(liquidificador, UM))
        .comItemDoCarrinho(new ItemDoCarrinho(pratos, UM))
        .construir();
        
        MaiorEMenor algoritmo = new MaiorEMenor();
        algoritmo.encontra(carrinhoDeCompra);
        
        Assertions.assertEquals(pratos, algoritmo.getMenor());
    }

    private CarrinhoDeCompra carrinhoDecrescente() {
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();
        carrinhoDeCompra.adicionar(new ItemDoCarrinho(pratos, UM));
		carrinhoDeCompra.adicionar(new ItemDoCarrinho(liquidificador, UM));
		carrinhoDeCompra.adicionar(new ItemDoCarrinho(geladeira, UM));
        return carrinhoDeCompra;
    }

    @Test
    public void deve_verificar_o_maior_em_ordem_decrescente() throws CarrinhoVazioException {
        CarrinhoDeCompra carrinhoDeCompra = carrinhoDecrescente();

        MaiorEMenor algoritmo = new MaiorEMenor();
        algoritmo.encontra(carrinhoDeCompra);

        Assertions.assertEquals(geladeira, algoritmo.getMaior());
    }

    @Test
    public void deve_verificar_o_maior_preco_unitario_em_ordem_crescente() throws ValorInvalido {
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompraBuilder().construir();
    }


    @Test 
    public void deve_lancar_excecao_para_carrinho_sem_produtos() throws Exception {
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompraBuilder().construir();
        MaiorEMenor maiorEMenor = new MaiorEMenor();

        Assertions.assertThrows(CarrinhoVazioException.class, ()-> {
            maiorEMenor.encontra(carrinhoDeCompra);
        });
    }
    // outras ordens
    // apenas um produto
    // carrinho sem produto
}