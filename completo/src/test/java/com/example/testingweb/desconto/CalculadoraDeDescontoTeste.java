package com.example.testingweb.desconto;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.testingweb.desconto.CalculadoraDeDesconto;

public class CalculadoraDeDescontoTeste {
	@Test
	public void deve_calcular_desconto_para_compras_acima_de_100_reais() {
		// arrange
		double valorComprado = 120d;
		double valorAPagarEsperado = 114d;

		// act
		CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
		double valorAPagarRetornado = calculadora.calcularDescontoPara(valorComprado);

		// assert
		assertEquals(valorAPagarEsperado, valorAPagarRetornado, 0.01);
	}

	@Test
	public void nao_deve_calcular_desconto_para_valores_iguais_a_100_reais() throws Exception {
		double valorComprado = 100d;
		double valorAPagarEsperado = 100d;

		CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
		double valorAPagarRetornado = calculadora.calcularDescontoPara(valorComprado);

		assertEquals(valorAPagarEsperado, valorAPagarRetornado, 0.01);
	}
	
	@Test
	public void nao_deve_calcular_desconto_para_valores_menores_que_100_reais() throws Exception {
		double valorComprado = 90d;
		double valorAPagarEsperado = 90d;

		CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
		double valorAPagarRetornado = calculadora.calcularDescontoPara(valorComprado);

		assertEquals(valorAPagarEsperado, valorAPagarRetornado, 0.01);
	}

}