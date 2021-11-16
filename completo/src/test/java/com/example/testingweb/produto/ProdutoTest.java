package com.example.testingweb.produto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProdutoTest {

	private static final double VALOR_NEGATIVO = -1d;

	@Test
	public void nao_deve_permitir_informar_valor_menor_que_zero() throws Exception {
		assertThrows(ValorInvalido.class, ()-> {
			new Produto("Fogão 4 bocas", VALOR_NEGATIVO);
		});
	}
}
