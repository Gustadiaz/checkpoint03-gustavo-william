package br.com.fiap.jpa.dao.impl;

import br.com.fiap.entity.ItemPedido;


public class ItemPedidoDAOImpl extends HibernateGenericDAO<ItemPedido, Long> {

	private static ItemPedidoDAOImpl instance = null;
	
	public static ItemPedidoDAOImpl getInstance() {
		if (instance == null) {
			instance = new ItemPedidoDAOImpl();
		}
		
		return instance;
	}
	
	private ItemPedidoDAOImpl() {
		super(ItemPedido.class);
	}



}
