package br.edu.faculdadedelta.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profissao extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_profissao")
	private Long id;
	
	@Column(name = "nm_profissao", nullable = false, length = 150)
	private String nome;
	
	
	@Override
	public Long getId() {
		return null;
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


	public Profissao() {
		super();
	}

	
}
