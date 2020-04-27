package br.com.ordemservico.rest.thiagomds.api.exceptionhandler;

import java.time.LocalDateTime;

public class Problema {
	
	private Integer 		status;
	private LocalDateTime 	dataHora;
	private String			titulo;

	
	// Setters
	public void setStatus(Integer status) 		{ this.status = status; }
	public void setData(LocalDateTime dataHora) { this.dataHora = dataHora; }
	public void setTitulo(String titulo)		{ this.titulo = titulo; }
	
	// Getters
	public Integer getStatus() 			{ return this.status; }
	public LocalDateTime getDataHora() 	{ return this.dataHora; }
	public String getTitulo() 			{ return this.titulo; }
}
