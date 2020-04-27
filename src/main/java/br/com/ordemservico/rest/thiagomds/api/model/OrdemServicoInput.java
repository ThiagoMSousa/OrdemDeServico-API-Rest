package br.com.ordemservico.rest.thiagomds.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemServicoInput {
	
	@NotBlank
	private String 			descricao;
	
	@NotNull
	private BigDecimal 		preco;

	@Valid
	@NotNull
	private ClienteIdInput 	cliente;
	
	// Setters
	public void setDescricao(String descricao) 		{ this.descricao = descricao; }
	public void setPreco(BigDecimal preco) 			{ this.preco = preco; }	
	public void setCliente(ClienteIdInput cliente) 	{ this.cliente = cliente; }
	
	// Getters
	public String getDescricao() 		{ return descricao; }
	public BigDecimal getPreco() 		{ return preco; }
	public ClienteIdInput getCliente() 	{ return cliente; }

	
}
