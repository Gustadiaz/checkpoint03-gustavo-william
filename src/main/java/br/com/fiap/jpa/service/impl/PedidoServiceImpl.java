package br.com.fiap.jpa.service.impl;

import java.util.List;


import br.com.fiap.entity.Pedido;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.service.GenericService;

public class PedidoServiceImpl extends GenericService<Pedido, Long> {

	private static PedidoServiceImpl instance = null;
	
	private PedidoDAOImpl pedidoDAO;

	
	private PedidoServiceImpl() {
		pedidoDAO = PedidoDAOImpl.getInstance();
	}
	
	public static PedidoServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new PedidoServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Pedido pedido) {
		try {
			pedidoDAO.salvar(pedido, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	
	
	@Override
	public void atualizar(Pedido pedido) {
		try {
			pedidoDAO.atualizar(pedido, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void remover(Long id) {
		try {
			pedidoDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Pedido obter(Long id) {
		Pedido pedido = null;
		
		try {
			pedido = pedidoDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return pedido;
	}

	@Override
	public List<Pedido> listar() {
		List<Pedido> pedidos = null;
		
		try {
			pedidos = pedidoDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return pedidos;
	}
	
	
	public List<Pedido> listarPorCPF(String cpf) {
		List<Pedido> pedidos = null;
		
		try {
			pedidos = pedidoDAO.listarPorCPF(cpf, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		
		return pedidos;
	}
	
	
	public List<Pedido> listarPedidoBoleto() {
		List<Pedido> pedidos = null;
		
		try {
			pedidos = pedidoDAO.listarPedidoBoleto(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return pedidos;
	}

	


	
}
