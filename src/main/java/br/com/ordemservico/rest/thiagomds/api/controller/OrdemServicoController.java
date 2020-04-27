package br.com.ordemservico.rest.thiagomds.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordemservico.rest.thiagomds.api.model.OrdemServicoInput;
import br.com.ordemservico.rest.thiagomds.api.model.OrdemServicoModel;
import br.com.ordemservico.rest.thiagomds.domain.model.OrdemServico;
import br.com.ordemservico.rest.thiagomds.domain.repository.OrdemServicoRepository;
import br.com.ordemservico.rest.thiagomds.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	// REPOSTORIOS
	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServico;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRespository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// CADASTRAR ORDEM DE SERVIÇO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	// Recebendo o Dados via OrdemServicoInput
	// E Convertendo via o Método toEnntity para OrdemServico
	public OrdemServicoModel criar( @Valid @RequestBody OrdemServicoInput ordemServicoInput ) {
		OrdemServico ordemServico = toEntity( ordemServicoInput );
		
		return toModel( gestaoOrdemServico.criar(ordemServico) );
	}
	
	// LISTAR TODAS AS ORDENS DE SERVIÇOS
	@GetMapping
	public List<OrdemServicoModel> listar(){
		return toCollectionModel( ordemServicoRespository.findAll() );
	}
	
	// BUSCAR POR ORDEM DE SERVIÇO
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServicoModel> buscar( @PathVariable Long ordemServicoId ) {
		Optional<OrdemServico> ordemServico = ordemServicoRespository.findById(ordemServicoId);
		
		// Se Encontar a Ordem de Serviço, Retorna OK com os Dados da Ordem Serviço
		if( ordemServico.isPresent() ) {
			
			// O ModelMapper, vai instanciar um OrdemServicoModel
			// E vai atribuir as propriedades que estão dentro da OrdemServico, na propria instancia criada
			OrdemServicoModel ordemServicoModel = modelMapper.map(ordemServico.get(), OrdemServicoModel.class);
			return ResponseEntity.ok( ordemServicoModel );
		}
		// Caso Contrario, Retorna 404
		return ResponseEntity.notFound().build();
	}
	
	// Convertendo OrdemServico para OrdemServicoModel
	private OrdemServicoModel toModel( OrdemServico ordemServico ) {
		return modelMapper.map(ordemServico, OrdemServicoModel.class);
	}
	
	// Convertendo uma Coleção de OrdemServico para uma Coleção de OrdemServicoModel
	private List<OrdemServicoModel> toCollectionModel( List<OrdemServico> ordensServico ){
		return ordensServico.stream()
				.map( ordemServico -> toModel(ordemServico) )
				.collect( Collectors.toList() );
				
	}
	
	// Convertendo OrdemServicoInput para OrdemServico
	public OrdemServico toEntity( OrdemServicoInput ordemServicoInput ) {
		return modelMapper.map( ordemServicoInput, OrdemServico.class );
	}
}
