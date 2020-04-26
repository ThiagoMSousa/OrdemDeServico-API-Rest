package br.com.ordemservico.rest.thiagomds.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordemservico.rest.thiagomds.domain.model.Cliente;
import br.com.ordemservico.rest.thiagomds.domain.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes") // Declarando que esse CONTROLADOR irá responder tudo que estiver em /clientes
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	// Instância de ClienteRepository
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	// LISTAR TODOS OS CLIENTES
	@GetMapping
	public List<Cliente> listar() {
		// Buscando TODOS os registros
		return clienteRepository.findAll();
		
		// Buscando por NOME
		//return clienteRepository.findByNome("Maria");
		
		// Buscando contendo o NOME
		//return clienteRepository.findByNomeContaining("Jo");
		
		/*
		// JPQL (JPA) //
		 - Interação direta com o controlador
		return manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
				
		*/
	}
	
	// BUSCAR POR UM CLIENTE
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar( @PathVariable Long clienteId ) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if( cliente.isPresent() ) {
			// ResponseEntity = tipo que representa a resposta que vai ser retornada
			// Código 200 = OK
			return ResponseEntity.ok( cliente.get() );
		}
		
		
		// orElse - Retorna o valor presenta na VARIAVEL, no caso cliente, ou retorna NULL
		return ResponseEntity.notFound().build();
	}
	
	// CADASTRAR CLIENTE
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar( @RequestBody Cliente cliente ) {
		return clienteRepository.save(cliente);		
	}
	
	// ATUALIZAR CLIENTE
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, 
			@RequestBody Cliente cliente){
		
		if( !clienteRepository.existsById(clienteId) ) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		cliente	= clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	// EXCLUIR CLIENTE
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		
		if( !clienteRepository.existsById(clienteId) ) {
			return ResponseEntity.notFound().build();	
		}
		
		clienteRepository.deleteById(clienteId);
		
		return ResponseEntity.noContent().build();
	}

}
