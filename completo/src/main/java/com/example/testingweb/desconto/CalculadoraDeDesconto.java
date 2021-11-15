package com.example.testingweb.desconto;

public class CalculadoraDeDesconto {
	public double calcularDescontoPara(double valorGasto) {
		if(valorGasto > 100) {
			return valorGasto - (valorGasto * 0.05);
		} 
		return valorGasto;
	}
}
