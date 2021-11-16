package com.example.testingweb.produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProdutoCustomRepositoryImpl implements ProdutoCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscarPorFaixaDePreco(double precoMinimo, double precoMaximo) {
		return entityManager
				.createQuery("FROM Produto WHERE valorUnitario BETWEEN :precoMinimo AND :precoMaximo")
				.setParameter("precoMinimo", precoMinimo)
				.setParameter("precoMaximo", precoMaximo)
				.getResultList();
	}

}
