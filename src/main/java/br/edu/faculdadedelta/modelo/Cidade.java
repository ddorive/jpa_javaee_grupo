package br.edu.faculdadedelta.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cidade extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cidade", nullable = false)
	private Long id;
	
	@Column(name = "nm_cidade", nullable = false, length = 150)
	private String nome;
	
	@Column(name = "uf_cidade", nullable = false, length = 3)
	private String ufCidade;
	
	@OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
	private List<Endereco> enderecos;
	
	public Cidade() {
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUfCidade() {
		return ufCidade;
	}

	public void setUfCidade(String ufCidade) {
		this.ufCidade = ufCidade;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	
	
}
