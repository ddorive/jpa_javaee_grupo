package br.edu.faculdadedelta.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class Cliente_Atributo implements Serializable{
		
		private static final long serialVersionUID = 1L;

		
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id_profissao")
		private Long id;
		
		@Column(name = "nm_Escolaridade", nullable = true, length = 30)
		private String escolaridade;

		@Column(name = "nm_Renda", nullable = true )
		private double renda;
		
		@Column (name = "nm_Raca", nullable = true)
		private String raca;
				


}



