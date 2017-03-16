package br.edu.faculdadedelta.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Cliente extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_cliente")
	private Long id;
	
	@Column(length=60, nullable=false)
	private String nomeCliente;
	
	@Column(length=20)
	private String cpfCliente;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dataNascimento;
	
	@ManyToOne(cascade= {CascadeType.PERSIST}, fetch=FetchType.LAZY)
	@JoinColumn(name="id_profissao", referencedColumnName="id_profissao",
	   insertable=true, updatable=false, nullable=false)
	private Profissao profissao;
	
	@OneToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", nullable = false, insertable = true, updatable = false)
	private Endereco endereco;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<Pedido> compras;
	
	public Cliente() {
	}
	
	public Cliente(Long id, Profissao profissao, String nomeCliente,
			String cpfCliente, Date dataNascimento) {
		this.id = id;
		this.profissao = profissao;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.dataNascimento = dataNascimento;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
