package br.com.ordemservico.rest.thiagomds.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ordemservico.rest.thiagomds.domain.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	// Pesquisar por NOME
	List<Cliente> findByNome(String nome);
	// Pesquisar por NOME contendo a palavra
	List<Cliente> findByNomeContaining(String nome);

}
