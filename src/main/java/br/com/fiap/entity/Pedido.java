package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tb_pedido")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1673251381822237444L;
	
	public Pedido () {}
	
	public Pedido(String numeroPedido, String valorTotal, String cpfCliente) {
		super();
		this.numeroPedido = numeroPedido;
		this.valorTotal = valorTotal;
		this.cpfCliente = cpfCliente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private Long id;
	
	@Column(name="nr_pedido", unique = true)
	private String numeroPedido;
	
	@Column(name="vl_total")
	private String valorTotal;
	
	@Column(name = "nr_cpf")
	private String cpfCliente;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "boleto_id")
	private Boleto boleto;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itemPedidos;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		
		return "\nNúmero Pedido: " + this.getNumeroPedido() 
			+ "\nValor Total: " + this.getValorTotal()
			+ "\nCPF: " + this.getCpfCliente(); 
	}

}
