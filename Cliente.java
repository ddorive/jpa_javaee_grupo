package br.edu.faculdadedelta.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="Cliente")
public class Cliente extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_cliente")
	private Long id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST}, fetch=FetchType.LAZY)
	@JoinColumn(name="id_profissao", referencedColumnName="id_profissao",
	   insertable=true, updatable=false, nullable=false)
	private Profissao profisao;
	
	@Column(length=60, nullable=false)
	private String nomeCliente;
	@Column(length=20)
	private String cpfCliente;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nascimento")
	private Date dataNascimento;
	
	
	public Cliente() {
	}
	
	
	public Cliente(Long id, Profissao profisao, String nomeCliente,
			String cpfCliente, Date dataNascimento) {
		this.id = id;
		this.profisao = profisao;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.dataNascimento = dataNascimento;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Profissao getprofisao() {
		return profisao;
	}
	public void setprofisao(Profissao profisao) {
		this.profisao = profisao;
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
