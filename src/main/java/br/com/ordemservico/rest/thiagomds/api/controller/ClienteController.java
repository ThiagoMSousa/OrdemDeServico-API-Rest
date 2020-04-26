package br.com.ordemservico.rest.thiagomds.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordemservico.rest.thiagomds.domain.model.Cliente;


@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		// JPQL (JPA)
		
		return manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}

}
