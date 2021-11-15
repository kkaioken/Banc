package com.example.testingweb.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdicionaProdutoService {
	private ProdutoRepository produtoRepository;

	@Autowired
	public AdicionaProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Transactional
	public int inserir(ProdutoRequest produtoRequest) throws ValorInvalido {
		Produto produto = new Produto(produtoRequest.getDescricao(), produtoRequest.getValorUnitario());
		produtoRepository.salvar(produto);
		return produto.getId();
	}
}
