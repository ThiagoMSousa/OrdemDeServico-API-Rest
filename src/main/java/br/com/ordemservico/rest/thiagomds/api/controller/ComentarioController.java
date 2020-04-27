package br.com.ordemservico.rest.thiagomds.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordemservico.rest.thiagomds.api.model.Comentario;
import br.com.ordemservico.rest.thiagomds.api.model.ComentarioInput;
import br.com.ordemservico.rest.thiagomds.api.model.ComentarioModel;
import br.com.ordemservico.rest.thiagomds.domain.exception.EntidadeNaoEncontradaException;
import br.com.ordemservico.rest.thiagomds.domain.model.OrdemServico;
import br.com.ordemservico.rest.thiagomds.domain.repository.OrdemServicoRepository;
import br.com.ordemservico.rest.thiagomds.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {
	
	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServico;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<ComentarioModel> listar( @PathVariable Long ordemServicoId ) {
		OrdemServico ordemServico = ordemServicoRepository.findById( ordemServicoId )
				.orElseThrow( () -> new EntidadeNaoEncontradaException( "Ordem de Serviço Não Encontrada !!!" ) );
		
		return toCollectionModel( ordemServico.getComentarios() );
	}
	
	// ADICIONA COMENTARIO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComentarioModel adicionar( @PathVariable Long ordemServicoId,
			@Valid @RequestBody ComentarioInput comentarioInput ) {
		
		Comentario comentario = gestaoOrdemServico.adicionarComentario( ordemServicoId, 
				comentarioInput.getDescricao() );
		
		return toModel( comentario );
	}
	
	// Retorna um Comentario MODEL
	private ComentarioModel toModel( Comentario comentario ) {
		return modelMapper.map( comentario, ComentarioModel.class );
	}
	
	// Retorna uma LISTA de Comentario MODEL
	private List<ComentarioModel> toCollectionModel( List<Comentario> comentarios) {
		return comentarios.stream()
				.map( comentario -> toModel(comentario) )
				.collect( Collectors.toList() );
	}

}
