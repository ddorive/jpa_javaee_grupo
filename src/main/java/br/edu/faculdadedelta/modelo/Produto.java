package br.edu.faculdadedelta.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Produto extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto", nullable = false)
	private Long id;

	@Column(name = "nm_produto", nullable = false, length = 100)
	private String nome;

	@Column(name = "vl_prod", nullable = true)
	private double valorProduto;

	@Column(name = "qtd_prod", nullable = true)
	private int saldoProduto;

	@Override
	public Long getId() {
		return id;
	}

	public Produto() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public int getSaldoProduto() {
		return saldoProduto;
	}

	public void setSaldoProduto(int saldoProduto) {
		this.saldoProduto = saldoProduto;
	}

	

}
