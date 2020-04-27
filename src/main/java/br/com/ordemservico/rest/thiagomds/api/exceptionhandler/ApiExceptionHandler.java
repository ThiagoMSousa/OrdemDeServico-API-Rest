package br.com.ordemservico.rest.thiagomds.api.exceptionhandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ordemservico.rest.thiagomds.domain.exception.NegocioException;

@ControllerAdvice // Componente do Spring para Tratamento de Controladores de Exception
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	// Traduzindo a Mensagem de Erro
	@Autowired
	private MessageSource messageSource;
	
	// Caso qualquer Exceção seja lançada, cair nesse método que ele efetuará o tratamento
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio( NegocioException ex, WebRequest request ) {
		var status = HttpStatus.BAD_REQUEST;
		var problema = new Problema();
		
		problema.setStatus( status.value() );
		problema.setTitulo( ex.getMessage() );
		problema.setDataHora( OffsetDateTime.now() );
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	// Capturando e Retornando o Tipo e a Mensagem de Erro
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		// Lista de Campos à serem Retornados ao Problema
		var campos = new ArrayList<Problema.Campo>();
		
		// Capturando todos os Erros do BindingResult
		for( ObjectError error : ex.getBindingResult().getAllErrors() ) {
			
			// Capturando o CAMPO
			String nome = ((FieldError) error).getField();
			// Capturando a MENSAGEM e Carregando do Arquivo MESSAGES.PROPERTIES
			String mensagem = messageSource.getMessage( error, LocaleContextHolder.getLocale() );
			
			campos.add( new Problema.Campo(nome, mensagem) );	
		}
		
		// Implementando Reposta após Erro
		var problema = new Problema();
		problema.setStatus( status.value() );
		problema.setTitulo("Um ou mais campos estão inválidos."
				+ "Faça o preenchimento correto, e tente novamente.");
		problema.setDataHora( OffsetDateTime.now() );
		problema.setCampos(campos);
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
	
	

}
