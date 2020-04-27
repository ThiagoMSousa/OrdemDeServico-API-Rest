package br.com.ordemservico.rest.thiagomds.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.ordemservico.rest.thiagomds.api.model.Comentario;

@Entity
@Table(name = "tb_ordem_servico")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) // Auto-incremento
	private Long 				id;
	
	//@Valid
	// Quando for efetuar Validaçao do Cliente, não usar o DEFAULT, converter pra ValidationGroups.ClienteId
	//@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	//@NotNull
	@ManyToOne // N-1 - Muitas Ordens de Serviços possui 1 Cliente
	private Cliente 			cliente;
	
	//@NotBlank
	private String 				descricao;
	
	//@NotNull
	private BigDecimal 			preco;
	
	//@JsonProperty(access = Access.READ_ONLY) // Somente LEITURA
	@Enumerated(EnumType.STRING) // Coluna de Status será uma STRING
	private StatusOrdemServico 	status;
	
	//@JsonProperty(access = Access.READ_ONLY)
	//OffsetDateTime = Data/Hora Local
	private OffsetDateTime		dataAbertura;
	
	//@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime		dataFinalizacao;
	
	@OneToMany(mappedBy = "ordemServico") // Uma Ordem de Serviço pode ter Muitos Comentarios
	// mappedBy = "ordemServico" - Vinculando Comentario à OrdemServico
	private List<Comentario> 	comentarios = new ArrayList<>();
	
	// Setters
	public void setId(Long id) 										{ this.id = id; }
	public void setCliente(Cliente cliente) 						{ this.cliente = cliente; }
	public void setDescricao(String descricao)						{ this.descricao = descricao; }
	public void setPreco(BigDecimal preco) 							{ this.preco = preco; }	
	public void setStatus(StatusOrdemServico status) 				{ this.status = status; }
	public void setDataAbertura(OffsetDateTime dataAbertura) 		{ this.dataAbertura = dataAbertura; }
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao)	{ this.dataFinalizacao = dataFinalizacao; }
	public void setComentarios(List<Comentario> comentarios) 		{ this.comentarios = comentarios; }
	
	// Getters
	public Long getId() 						{ return id; }
	public Cliente getCliente() 				{ return cliente; }
	public String getDescricao() 				{ return descricao; }
	public BigDecimal getPreco() 				{ return preco; }
	public StatusOrdemServico getStatus() 		{ return status; }	
	public OffsetDateTime getDataAbertura() 	{ return dataAbertura; }
	public OffsetDateTime getDataFinalizacao()	{ return dataFinalizacao; }	
	public List<Comentario> getComentarios() 	{ return comentarios; }

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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
