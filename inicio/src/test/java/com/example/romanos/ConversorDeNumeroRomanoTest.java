package com.example.romanos;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ConversorDeNumeroRomanoTest {
    
    @Test
    public void deve_entender_o_simbolo_I() {
        String simbolo = "I";
        int resultadoEsperado = 1;
        int resultadoObtido = new ConversorDeNumeroRomano().converte(simbolo);
        assertThat(resultadoObtido).isEqualTo(resultadoEsperado);
    }

    @Test
    public void deve_entender_o_simbolo_V() {
        String simbolo = "V";
        int resultadoEsperado = 5;
        int resultadoObtido = new ConversorDeNumeroRomano().converte(simbolo);
        assertThat(resultadoObtido).isEqualTo(resultadoEsperado);
    }

    @Test
    public void deve_entender_dois_simbolos_como_II() {
        String simbolo = "II";
        int resultadoEsperado = 2;
        int resultadoObtido = new ConversorDeNumeroRomano().converte(simbolo);
        assertThat(resultadoObtido).isEqualTo(resultadoEsperado);
    }

    @Test
    public void deve_entender_quatro_simbolos_como_XXII() {
        String simbolo = "XXII";
        int resultadoEsperado = 22;
        int resultadoObtido = new ConversorDeNumeroRomano().converte(simbolo);
        assertThat(resultadoObtido).isEqualTo(resultadoEsperado);
    }

    @Test
    public void deve_entender_simbolos_como_IX() {
        String simbolo = "IX";
        int resultadoEsperado = 9;
        int resultadoObtido = new ConversorDeNumeroRomano().converte(simbolo);
        assertThat(resultadoObtido).isEqualTo(resultadoEsperado);
    }

    @Test
    public void deve_entender_simbolos_complexos_como_XXIV() {
        String simbolo = "XXIV";
        int resultadoEsperado = 24;
        int resultadoObtido = new ConversorDeNumeroRomano().converte(simbolo);
        assertThat(resultadoObtido).isEqualTo(resultadoEsperado);
    }
}
