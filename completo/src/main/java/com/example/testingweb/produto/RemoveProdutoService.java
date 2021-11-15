package com.example.testingweb.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveProdutoService {

	private ProdutoRepository produtoRepository;

	@Autowired
	public RemoveProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public void remover(Integer id) {
		produtoRepository.excluir(id);
	}
}
