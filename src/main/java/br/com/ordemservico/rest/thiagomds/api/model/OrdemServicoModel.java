package br.com.ordemservico.rest.thiagomds.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.ordemservico.rest.thiagomds.domain.model.StatusOrdemServico;

public class OrdemServicoModel {
	
	private Long 				id;
	//private String 				nomeCliente;
	private ClienteResumoModel	cliente;
	private String 				descricao;
	private BigDecimal 			preco;
	private StatusOrdemServico 	status;
	private OffsetDateTime 		dataAbertura;
	private OffsetDateTime 		dataFinalizacao;
	
	public void setId(Long id) 										{ this.id = id; }
	//public void setNomeCliente(String nomeCliente)					{ this.nomeCliente = nomeCliente; }
	public void setCliente(ClienteResumoModel cliente) 				{ this.cliente = cliente; }
	public void setDescricao(String descricao) 						{ this.descricao = descricao; }
	public void setPreco(BigDecimal preco) 							{ this.preco = preco; }
	public void setStatus(StatusOrdemServico status) 				{ this.status = status; }
	public void setDataAbertura(OffsetDateTime dataAbertura)		{ this.dataAbertura = dataAbertura; }	
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao)	{ this.dataFinalizacao = dataFinalizacao; }
	
	public Long getId() 						{ return id; }
	//public String getNomeCliente() 				{ return nomeCliente; }
	public ClienteResumoModel getCliente() 		{ return cliente; }
	public String getDescricao() 				{ return descricao; }
	public BigDecimal getPreco() 				{ return preco; }
	public StatusOrdemServico getStatus() 		{ return status; }
	public OffsetDateTime getDataAbertura() 	{ return dataAbertura; }
	public OffsetDateTime getDataFinalizacao() 	{ return dataFinalizacao; }

}
