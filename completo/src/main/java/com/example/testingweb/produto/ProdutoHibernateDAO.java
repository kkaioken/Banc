package com.example.testingweb.produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProdutoHibernateDAO implements ProdutoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Produto buscarPelo(int id) {
		return entityManager.find(Produto.class, id);
	}

	@Override
	public void salvar(Produto produto) {
		entityManager.persist(produto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscarPorFaixaDePreco(double precoMinimo, double precoMaximo) {
		return entityManager
				.createQuery("FROM Produto WHERE valorUnitario BETWEEN :precoMinimo AND :precoMaximo")
				.setParameter("precoMinimo", precoMinimo)
				.setParameter("precoMaximo", precoMaximo)
				.getResultList();
	}

	@Override
	public void excluir(int id) {
		entityManager.remove(entityManager.getReference(Produto.class, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscarTodos() {
		return entityManager
				.createQuery("FROM Produto p")
				.getResultList();
	}

}
