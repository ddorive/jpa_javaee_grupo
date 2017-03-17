package br.edu.faculdadedelta.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Cidade")
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private CidadePK cidadePK;
	
	@OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
	private List<Endereco> enderecos;
	
	public Cidade() {
	}
	
	
	public CidadePK getCidadePk() {
		return cidadePK;
	}


	public void setCidadePk(CidadePK cidadePk) {
		this.cidadePK = cidadePk;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	/**@Id
	*@GeneratedValue(strategy = GenerationType.AUTO)
	*@Column(name = "id_cidade", nullable = false)
	*private Long id;
	*
	*@Column(name = "nm_cidade", nullable = false, length = 150)
	*private String nome;
	*
	*@Column(name = "uf_cidade", nullable = false, length = 3)
	*private String ufCidade;
	*
	*
	*/
	
	
	/**@Override
	*public Long getId() {
	*	return id;
	*}

	*public String getNome() {
	*	return nome;
	*}

	*public void setNome(String nome) {
	*	this.nome = nome;
	*}

	*public String getUfCidade() {
	*	return ufCidade;
	*}

	*public void setUfCidade(String ufCidade) {
	*	this.ufCidade = ufCidade;
	*}

	*public void setId(Long id) {
	*	this.id = id;
	*}
*/

	
	
	
}
