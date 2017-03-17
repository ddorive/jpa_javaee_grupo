package br.edu.faculdadedelta.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos_pedidos")
public class ProdutosPedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pedido", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "pedido_id")
	private Pedido pedido;
	

    @ManyToOne
    @JoinColumn(name = "produto_id")
	private Produto produto;
	
	@Column(name="qtde_produto")
	private Integer qtdeProduto;
	
	
	public ProdutosPedidos() {	
	}

	public ProdutosPedidos(Pedido pedido, Produto produto,
			Integer qtdeProduto) {
		this.pedido = pedido;
		this.produto = produto;
		this.qtdeProduto = qtdeProduto;
	}


	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQtdeProduto() {
		return qtdeProduto;
	}
	public void setQtdeProduto(Integer qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}
}
