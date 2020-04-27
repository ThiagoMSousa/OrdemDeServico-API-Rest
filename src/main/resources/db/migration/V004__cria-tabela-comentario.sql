CREATE TABLE tb_comentario (
	id 					BIGINT 		NOT NULL AUTO_INCREMENT,
    ordem_servico_id 	BIGINT 		NOT NULL,
    descricao 			TEXT 		NOT NULL,
    data_envio			DATETIME 	NOT NULL,
    
    PRIMARY KEY (id)
);

ALTER TABLE tb_comentario ADD CONSTRAINT fk_comentario_ordem_servico
FOREIGN KEY (ordem_servico_id) REFERENCES tb_ordem_servico (id);