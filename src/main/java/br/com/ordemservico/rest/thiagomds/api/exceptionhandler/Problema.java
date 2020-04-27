package br.com.ordemservico.rest.thiagomds.api.exceptionhandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL) // Só inclua campos NÃO NULO
public class Problema {
	
	private Integer 		status;
	private OffsetDateTime 	dataHora;
	private String			titulo;
	private List<Campo>		campos;
	
	// Setters
	public void setStatus(Integer status) 				{ this.status = status; }
	public void setDataHora(OffsetDateTime dataHora) 	{ this.dataHora = dataHora; }
	public void setTitulo(String titulo)				{ this.titulo = titulo; }
	public void setCampos(List<Campo> campos) 			{ this.campos = campos;	}
	
	// Getters
	public Integer getStatus()			{ return this.status; }
	public OffsetDateTime getDataHora()	{ return this.dataHora; }
	public String getTitulo()			{ return this.titulo; }
	public List<Campo> getCampos()		{ return campos; }
	
	// Classe Interna
	public static class Campo {
		
		private String nome;
		private String mensagem;
		
		// Construtor
		public Campo(String nome, String mensagem) {
			super();
			setNome(nome);
			setMensagem(mensagem);
		}
		
		// Setters
		public void setNome(String nome) 			{ this.nome = nome; }
		public void setMensagem(String mensagem) 	{ this.mensagem = mensagem; }
		
		// Getters
		public String getNome() 	{ return this.nome; }
		public String getMensagem() { return this.mensagem; }
	}
}
