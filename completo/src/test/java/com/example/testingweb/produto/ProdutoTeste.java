package com.example.testingweb.produto;

import org.junit.Test;

import com.example.testingweb.produto.Produto;
import com.example.testingweb.produto.ValorInvalido;

public class ProdutoTeste {

	private static final double VALOR_NEGATIVO = -1d;

	@Test(expected = ValorInvalido.class)
	public void nao_deve_permitir_informar_valor_menor_que_zero() throws Exception {
		new Produto("Fogão 4 bocas", VALOR_NEGATIVO);
	}
}
