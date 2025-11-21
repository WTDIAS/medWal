CREATE TABLE endereco(
	id SERIAL PRIMARY KEY,
	cep VARCHAR(8) NOT NULL,
	logradouro VARCHAR(100) NOT NULL,
	bairro VARCHAR(100) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	uf VARCHAR(2) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	complemento VARCHAR(100),
	medico_id INT,
	CONSTRAINT fk_medico
		FOREIGN KEY (medico_id)
		REFERENCES medico(id)
);