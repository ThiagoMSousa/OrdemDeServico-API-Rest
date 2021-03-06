package br.com.ordemservico.rest.thiagomds.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ordemservico.rest.thiagomds.domain.ValidationGroups;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	//@NotNull(groups = ValidationGroups.ClienteId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank // Não aceita Valor NULL, VAZIO e NEM SÓ COM ESPAÇOS
	@Size(max = 60) // Tamanho Máximo
	private String nome;
	
	@NotBlank
	@Email // = Não aceita Valor NULL, e Válida Formato do E-MAIL( @ e .com )
	@Size(max = 255)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "fone")
	private String telefone;
	
	// Setters
	public void setId(Long id) 	  		  	 { this.id = id; }
	public void setNome(String nome) 		 { this.nome = nome; }
	public void setEmail(String email) 	  	 { this.email = email; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	
	// Getters
	public Long getId()      	{ return this.id; }
	public String getNome()  	{ return this.nome; }
	public String getEmail() 	{ return this.email; }
	public String getTelefone() { return this.telefone; }
	
	
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
