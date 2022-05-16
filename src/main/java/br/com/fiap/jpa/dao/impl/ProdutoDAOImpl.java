package br.com.fiap.jpa.dao.impl;




import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.fiap.entity.Produto;



public class ProdutoDAOImpl extends HibernateGenericDAO<Produto, Long>{
	
private static ProdutoDAOImpl instance = null;
	
	public static ProdutoDAOImpl getInstance() {
		if (instance == null) {
			instance = new ProdutoDAOImpl();
		}
		
		return instance;
	}
	
	private ProdutoDAOImpl() {
		super(Produto.class);
	}
	
	public List<Produto> listarProdutosComValor(EntityManager entityManager) {
		
		TypedQuery<Produto> consulta = entityManager.createNamedQuery("Produto.listarProdutosComValor", Produto.class);
		
		
		
		return consulta.getResultList();
	}
	
	public List<Produto> pesquisarProdutos(String nome, String vl_produto, EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = builder.createQuery(Produto.class);
		
		Root<Produto> produto = criteriaQuery.from(Produto.class);
		List<Predicate> predicates = new ArrayList<>();
		
		if (nome != null) {
			Predicate predicate = builder.like(produto.get("nome"), "%" + nome + "%");
			predicates.add(predicate);
		}
		
		if (vl_produto != null) {
			Predicate predicate = builder.greaterThanOrEqualTo(produto.get("vl_produto"), vl_produto);
			predicates.add(predicate);
		}
		
		criteriaQuery.select(produto);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		
		
		TypedQuery<Produto> consulta = entityManager.createQuery(criteriaQuery);
		
		return consulta.getResultList();
	}

}


