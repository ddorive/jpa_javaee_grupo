package br.edu.faculdadedelta.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.edu.faculdadedelta.util.JPAUtil.EstoqueStatusEnum;

@Entity
@Table
public class Produto extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	private Set<ProdutosPedidos> produtosPedidos;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto", nullable = false)
	private Long id;

	@Column(name = "nm_produto", nullable = false, length = 100)
	private String nome;

	@Column(name = "vl_produto", nullable = true)
	private double valorProduto;

	@Column(name = "qtd_produto", nullable = true)
	private int saldoProduto;
	
	@Column(length=1, nullable=false)
	private String Status_estoque;
	@Transient
	public EstoqueStatusEnum getEstoqueStatusEnum(){
		return EstoqueStatusEnum.fromValue(Status_estoque);
		
	}
	public void setEstoqueStatusEnum(EstoqueStatusEnum statusEnum ){
		this.Status_estoque = statusEnum.toValue();
	}
	

	public Produto() {
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	
	public String getStatus_estoque() {
		return Status_estoque;
	}
	public void setStatus_estoque(String status_estoque) {
		Status_estoque = status_estoque;
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

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<ProdutosPedidos> getProdutosPedidos() {
		return produtosPedidos;
	}

	public void setProdutosPedidos(Set<ProdutosPedidos> produtosPedidos) {
		this.produtosPedidos = produtosPedidos;
	}
	
	

}
