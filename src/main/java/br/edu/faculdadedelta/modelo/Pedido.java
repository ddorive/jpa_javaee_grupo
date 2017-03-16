package br.edu.faculdadedelta.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pedido", unique=true, nullable=false)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_Pedido")
	@Basic(fetch= FetchType.LAZY)
	private Date dataPedido;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_Entrega")
	@Basic(fetch= FetchType.LAZY)
	private Date dataEntrega;
	
	@ManyToOne(cascade={ CascadeType.PERSIST}, fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente", referencedColumnName="id_cliente",
	insertable=true, updatable=false, nullable=false)
	private Cliente cliente;
	
	@ManyToMany(fetch= FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name="venda_produto", 
	 joinColumns = @JoinColumn(name="id_pedido"),
	 inverseJoinColumns=@JoinColumn(name="id_produto"))
	private List<Produto> produtos;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public Pedido() {
		
	}

	public Pedido(Long id, Date dataPedido, Date dataEntrega, Cliente cliente,
			List<Produto> produtos) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.cliente = cliente;
		this.produtos = produtos;
	}


	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
