package br.edu.faculdadedelta.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.junit.ClassRule;

@Entity
@Table
public class ProdutosPedidos extends BaseEntity<Long> {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto_pedido", nullable = false)
	private Long id;
   
	@ManyToMany(fetch= FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name="produtos_pedidos", 
	 joinColumns = @JoinColumn(name="id_produto_pedido"),
	 inverseJoinColumns=@JoinColumn(name="id_pedido"))
	private Pedido id_pedido;
	
	@ManyToMany(fetch= FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name="produtos_pedidos", 
	 joinColumns = @JoinColumn(name="id_produto_pedido"),
	 inverseJoinColumns=@JoinColumn(name="id_produto"))
	private Produto id_produto;
	
	@Column(name="qtde_produto")
	private Integer qtdeProduto;
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ProdutosPedidos() {
		
	}
    
	

	public ProdutosPedidos(Long id, Pedido id_pedido, Produto id_produto,
			Integer qtdeProduto) {
		this.id = id;
		this.id_pedido = id_pedido;
		this.id_produto = id_produto;
		this.qtdeProduto = qtdeProduto;
	}


	public Pedido getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Pedido id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Produto getId_produto() {
		return id_produto;
	}
	public void setId_produto(Produto id_produto) {
		this.id_produto = id_produto;
	}
	public Integer getQtdeProduto() {
		return qtdeProduto;
	}
	public void setQtdeProduto(Integer qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
