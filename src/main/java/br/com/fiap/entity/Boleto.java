package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tb_boleto")
@SequenceGenerator(name = "boleto", sequenceName = "SQ_TB_BOLETO", allocationSize = 1)
public class Boleto implements Serializable {

	private static final long serialVersionUID = -2901947307617791502L;
	
	
	public Boleto() {
		this.dataVencimento = LocalDateTime.now();
	}

	
	public Boleto(String nossoNumero, String valor, String codigoBarras) {
		super();
		this.nossoNumero = nossoNumero;
		this.valor = valor;
		this.codigoBarras = codigoBarras;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boleto")
	private Long id;
	
	@Column(name="nr_nossoNumero")
	private String nossoNumero;
	
	@Column(name="dt_vencimento")
	private LocalDateTime dataVencimento;
	
	@Column(name="valor")
	private String valor;
	
	@Column(name="nr_codigoBarras")
	private String codigoBarras;
	
	@OneToOne(mappedBy = "boleto", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Pedido pedido;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNossoNumero() {
		return nossoNumero;
	}


	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}


	public LocalDateTime getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getCodigoBarras() {
		return codigoBarras;
	}


	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "\nNosso Número: " + this.getNossoNumero()
				+ "\nData Vencimento: " + this.getDataVencimento ()
				+ "\n Valor: " + this.getValor()
				+ "\n Codigo Barras: " + this.getCodigoBarras();
	}


}
