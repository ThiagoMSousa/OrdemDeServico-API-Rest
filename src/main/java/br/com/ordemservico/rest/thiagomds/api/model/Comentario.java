package br.com.ordemservico.rest.thiagomds.api.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ordemservico.rest.thiagomds.domain.model.OrdemServico;

@Entity
@Table(name = "tb_comentario")
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long 			id;
	
	@ManyToOne // Muitos Comentarios Tem Uma Ordem de Serviço
	private OrdemServico 	ordemServico;
	
	private String 			descricao;
	private OffsetDateTime 	dataEnvio;
	
	
	// Setters
	public void setId(Long id) 								{ this.id = id; }
	public void setOrdemServico(OrdemServico ordemServico) 	{ this.ordemServico = ordemServico; }	
	public void setDescricao(String descricao) 				{ this.descricao = descricao; }
	public void setDataEnvio(OffsetDateTime dataEnvio) 		{ this.dataEnvio = dataEnvio; }
	
	// Getters
	public OffsetDateTime getDataEnvio() 	{ return dataEnvio; }
	public Long getId() 					{ return id; }
	public OrdemServico getOrdemServico() 	{ return ordemServico; }
	public String getDescricao() 			{ return descricao; }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
