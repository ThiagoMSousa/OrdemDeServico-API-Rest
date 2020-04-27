package br.com.ordemservico.rest.thiagomds.api.model;

import javax.validation.constraints.NotBlank;

public class ComentarioInput {
	
	@NotBlank
	private String descricao;

	// Setters
	public void setDescricao( String descricao ) { this.descricao = descricao; }
	
	// Getters
	public String getDescricao() { return this.descricao; }
}
