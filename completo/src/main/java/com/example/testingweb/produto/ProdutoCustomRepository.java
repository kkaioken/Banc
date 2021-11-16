package com.example.testingweb.produto;

import java.util.List;

public interface ProdutoCustomRepository {
    List<Produto> buscarPorFaixaDePreco(double precoMinimo, double precoMaximo);
}
