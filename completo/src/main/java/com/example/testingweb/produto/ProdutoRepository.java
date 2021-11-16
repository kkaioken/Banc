package com.example.testingweb.produto;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoCustomRepository {
	List<Produto> buscarPorFaixaDePreco(double precoMinimo, double precoMaximo);
	List<Produto> findAll();
}
