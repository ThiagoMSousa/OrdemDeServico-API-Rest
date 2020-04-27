package br.com.ordemservico.rest.thiagomds.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordemservico.rest.thiagomds.api.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
