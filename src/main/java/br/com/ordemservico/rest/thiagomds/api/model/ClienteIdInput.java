package br.com.ordemservico.rest.thiagomds.api.model;

import javax.validation.constraints.NotNull;

public class ClienteIdInput {
// Classe para Referencia o ID
	
	@NotNull
	private Long id;
	
	// Setters
	public void setId(Long id) { this.id = id; }
	
	// Getters
	public Long getId() { return this.id; }
	
}
