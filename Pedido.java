package br.edu.faculdadedelta.modelo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	private Cliente id_cliente;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
