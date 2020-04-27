package br.com.ordemservico.rest.thiagomds.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ordemservico.rest.thiagomds.api.model.Comentario;
import br.com.ordemservico.rest.thiagomds.domain.exception.NegocioException;
import br.com.ordemservico.rest.thiagomds.domain.model.Cliente;
import br.com.ordemservico.rest.thiagomds.domain.model.OrdemServico;
import br.com.ordemservico.rest.thiagomds.domain.model.StatusOrdemServico;
import br.com.ordemservico.rest.thiagomds.domain.repository.ClienteRepository;
import br.com.ordemservico.rest.thiagomds.domain.repository.ComentarioRepository;
import br.com.ordemservico.rest.thiagomds.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	// Injeção do Diretório dos Comentarios	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	
	// Criar Ordem de Serviço
	public OrdemServico criar( OrdemServico ordemServico ) {
		// Se encontrar o CLIENTE, salva na variavel CLIENTE
		// Caso contrario, enviar a EXCEPTION
		Cliente cliente = clienteRepository.findById( ordemServico.getCliente().getId() )
				.orElseThrow( () -> new NegocioException("Cliente Não Encontrado !!!") );
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus( StatusOrdemServico.ABERTA );
		ordemServico.setDataAbertura( OffsetDateTime.now() );
		
		return ordemServicoRepository.save( ordemServico );
	}
	
	// Adicionar Comentario
	public Comentario adicionarComentario( Long ordemServicoId, String descricao ) {
		// Buscando a OrdemServico no Repositorio
		OrdemServico ordemServico= ordemServicoRepository.findById( ordemServicoId )
				.orElseThrow( () -> new NegocioException("Ordem de Serviço Não Encontrada !!!") );
		
		// Buscando e Instanciando as Propriedades do Comentario
		Comentario comentario = new Comentario();
		comentario.setDataEnvio( OffsetDateTime.now() );
		comentario.setDescricao( descricao );
		comentario.setOrdemServico( ordemServico );
		
		return comentarioRepository.save( comentario );
	}
}
