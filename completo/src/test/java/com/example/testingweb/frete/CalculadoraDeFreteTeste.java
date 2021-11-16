package com.example.testingweb.frete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraDeFreteTeste {
	
	private static final String CEP_ORIGEM = "79750000";
	private static final String CEP_DESTINO = "79800000";;
	private ServicoDeFrete servicoDeFrete;
	private CalculadoraDeFrete calculadora;
	
	@BeforeEach
	public void init() {
		servicoDeFrete = mock(ServicoDeFreteImpl.class);
		calculadora = new CalculadoraDeFrete(servicoDeFrete, CEP_ORIGEM);
	}

	@Test
	public void deve_retornar_o_valor_doc_frete() throws Exception {
		double valorDoFreteEsperado = 12.45d;
		
		when(servicoDeFrete.calcularFretePara(CEP_ORIGEM, CEP_DESTINO))
				.thenReturn(valorDoFreteEsperado);
		
		double valorDoFreteRetornado = calculadora.calcularFretePara(CEP_DESTINO);
		
		assertEquals(valorDoFreteEsperado, valorDoFreteRetornado, 0.001);
	}
	
	@Test
	public void deve_alertar_caso_servico_esteja_indisponivel() throws Exception {
		doThrow(new ServicoDeFreteIndisponivel()).when(servicoDeFrete)
			.calcularFretePara(CEP_ORIGEM, CEP_DESTINO);
		
		assertThrows(ServicoDeFreteIndisponivel.class, ()->{
			calculadora.calcularFretePara(CEP_DESTINO);
		});
	}
}
