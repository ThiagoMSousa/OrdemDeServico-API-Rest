package br.com.ordemservico.rest.thiagomds.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ordemservico.rest.thiagomds.domain.exception.NegocioException;
import br.com.ordemservico.rest.thiagomds.domain.model.Cliente;
import br.com.ordemservico.rest.thiagomds.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail( cliente.getEmail() );
		
		if( clienteExistente != null && !clienteExistente.equals(cliente) ) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
		}
		
		return clienteRepository.save(cliente);		
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}
