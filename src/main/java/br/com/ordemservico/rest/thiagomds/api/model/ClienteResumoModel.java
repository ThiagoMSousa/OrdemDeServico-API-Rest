package br.com.ordemservico.rest.thiagomds.api.model;

public class ClienteResumoModel {
	
	private Long id;
	private String nome;
	
	// Setters
	public void setId(Long id) 			{ this.id = id; }
	public void setNome(String nome)	{ this.nome = nome; }
	
	// Getters
	public Long getId() 	{ return id; }
	public String getNome() { return nome; }	

}
