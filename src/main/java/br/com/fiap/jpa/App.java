package br.com.fiap.jpa;

import br.com.fiap.jpa.service.impl.BoletoServiceImpl;
import br.com.fiap.jpa.service.impl.ItemPedidoServiceImpl;
import br.com.fiap.jpa.service.impl.PedidoServiceImpl;
import br.com.fiap.jpa.service.impl.ProdutoServiceImpl;

public class App {
	
	public static void main(String[] args) {
		BoletoServiceImpl boletoService = BoletoServiceImpl.getInstance();
		PedidoServiceImpl pedidoService = PedidoServiceImpl.getInstance();
		ItemPedidoServiceImpl itemPedidoService = ItemPedidoServiceImpl.getInstance();
		ProdutoServiceImpl produtoService = ProdutoServiceImpl.getInstance();
		
		System.out.println("============ Listar os pedidos com CPF ==============");
		pedidoService.listarPorCPF("333.333.333-33").forEach(System.out::println);
		
		System.out.println("============ Listar todos os pedidos com boleto ==============");
		
		pedidoService.listarPedidoBoleto().forEach(System.out::println);
		
		System.out.println("============ Listar produto com valor ==============");
		
		produtoService.listarProdutosComValor().forEach(System.out::println);
		
		System.out.println("============ Pesquisar produtos ==============");
		
		produtoService.pesquisarProdutos("Caderno", "15").forEach(System.out::println);
		
		
	}

}
