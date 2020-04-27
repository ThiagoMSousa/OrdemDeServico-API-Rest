package br.com.ordemservico.rest.thiagomds.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* ModelMapper - Fazer mapeamento de Objetos de Um tipo, sendo que, esses Objetos são tranformados para outro tipo.
 * De um modelo para outro.
 */
  
@Configuration
public class ModelMapperConfig {

	@Bean // Instância/Inicializa/Configura um BEAN do tipo ModeMapper
	// Que vai ser gerenciado pelo Spring, 
	// E vai disponibilizado para injeção de dependencia para outras classe
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
