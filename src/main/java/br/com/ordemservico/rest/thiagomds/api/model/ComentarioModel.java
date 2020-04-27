package br.com.ordemservico.rest.thiagomds.api.model;

import java.time.OffsetDateTime;

public class ComentarioModel {
	
	private Long 			id;
	private String 			descricao;
	private OffsetDateTime 	dataEnvio;
	
	
	// Setters
	public void setId(Long id) 							{ this.id = id; }
	public void setDescricao(String descricao) 			{ this.descricao = descricao; }
	public void setDataEnvio(OffsetDateTime dataEnvio) 	{ this.dataEnvio = dataEnvio; }
	
	// Getters
	public Long getId() 					{ return id; }
	public String getDescricao() 			{ return descricao; }
	public OffsetDateTime getDataEnvio() 	{ return dataEnvio; }


	
	
}
