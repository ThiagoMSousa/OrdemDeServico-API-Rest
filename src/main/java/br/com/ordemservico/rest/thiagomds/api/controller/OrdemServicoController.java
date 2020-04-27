package br.com.ordemservico.rest.thiagomds.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	
	
	// CADASTRAR ORDEM DE SERVIÇO
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar( @Valid @RequestBody OrdemServico ordemServico ) {
		return gestaoOrdemServico.criar(ordemServico);
	}
	
	// LISTAR TODAS AS ORDENS DE SERVIÇOS
	@GetMapping
	public List<OrdemServico> listar(){
		return ordemServicoRespository.findAll();
	}
	
	// BUSCAR POR ORDEM DE SERVIÇO
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServico> buscar( @PathVariable Long ordemServicoId ) {
		Optional<OrdemServico> ordemServico = ordemServicoRespository.findById(ordemServicoId);
		
		// Se Encontar a Ordem de Serviço, Retorna OK com os Dados da Ordem Serviço
		if( ordemServico.isPresent() ) {
			return ResponseEntity.ok( ordemServico.get() );
		}
		// Caso Contrario, Retorna 404
		return ResponseEntity.notFound().build();
	}
}
