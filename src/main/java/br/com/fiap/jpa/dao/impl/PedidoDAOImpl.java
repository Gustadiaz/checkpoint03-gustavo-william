package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Pedido;



public class PedidoDAOImpl extends HibernateGenericDAO<Pedido, Long> {

	private static PedidoDAOImpl instance = null;
	
	public static PedidoDAOImpl getInstance() {
		if (instance == null) {
			instance = new PedidoDAOImpl();
		}
		
		return instance;
	}
	
	private PedidoDAOImpl() {
		super(Pedido.class);
	}
	
	public List<Pedido> listarPorCPF(String cpf, EntityManager entityManager) {
		String jpql = "SELECT p FROM Pedido p WHERE p.cpfCliente = :cpf";
		TypedQuery<Pedido> consulta = entityManager.createQuery(jpql, Pedido.class);
		consulta.setParameter("cpf", cpf);
		
		return consulta.getResultList();
	}
	
	public List<Pedido> listarPedidoBoleto(EntityManager entityManager) {
		String jpql = "SELECT p FROM Pedido p INNER JOIN FETCH p.boleto";
		TypedQuery<Pedido> consulta = entityManager.createQuery(jpql, Pedido.class);
		
		return consulta.getResultList();
	}

}