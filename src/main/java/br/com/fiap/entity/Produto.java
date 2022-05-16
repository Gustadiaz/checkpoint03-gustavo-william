package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
@NamedQueries({
	@NamedQuery(name = "Produto.listarProdutosComValor", query = "SELECT p FROM Produto p WHERE p.valor >= :vl_produto")
})
@SequenceGenerator(name = "produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto implements Serializable {

	private static final long serialVersionUID = -1606933813055933311L;
	
	public Produto() {}
	
	public Produto(String nome, String valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private Long id;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Column(name="vl_produto")
	private String valor;
	
	@OneToMany(mappedBy="produto")
	private List<ItemPedido> itemPedidos;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		
		return "\nNome do Produto: " + this.getNome() 
			+ "\nValor Produto: " + this.getValor();
 
	}

}
