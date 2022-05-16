package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_itempedido")
@SequenceGenerator(name = "itemPedido", sequenceName = "SQ_TB_ITEMPEDIDO", allocationSize = 1)
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = -6918994054727161839L;
	
	
	public ItemPedido(String quantidade) {
		super();
		this.quantidade = quantidade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemPedido")
	private Long id;
	
	@Column(name="nr_quantidade")
	private String quantidade;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="produto_id")
	private Produto produto;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		
		return "\nQuantidade: " + this.getQuantidade() ; 
	}

}
