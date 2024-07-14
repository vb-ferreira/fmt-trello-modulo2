DROP TABLE IF EXISTS funcionario CASCADE;
DROP TABLE IF EXISTS nutricionista CASCADE;
DROP TABLE IF EXISTS paciente CASCADE;
DROP TABLE IF EXISTS consulta CASCADE;
DROP TABLE IF EXISTS endereco CASCADE;

// Criação das tabelas

CREATE TABLE IF NOT EXISTS funcionario (
	funcionario_id SERIAL PRIMARY KEY,
	nome VARCHAR(60) NOT NULL,
	matricula VARCHAR(10) NOT NULL,
	tempo_experiencia SMALLINT NOT NULL CHECK(tempo_experiencia >= 0),
	id_endereco INTEGER REFERENCES endereco(endereco_id)
);

CREATE TABLE IF NOT EXISTS nutricionista (
	nutricionista_id SERIAL PRIMARY KEY,
	crn VARCHAR(10) NOT NULL UNIQUE,
	especialidade VARCHAR(20) NOT NULL,
);

CREATE TABLE IF NOT EXISTS paciente (
	paciente_id SERIAL PRIMARY KEY,
	nome VARCHAR(60) NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf VARCHAR(50) NOT NULL UNIQUE,
	telefone VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	id_endereco INTEGER NOT NULL REFERENCES endereco(endereco_id)
);

CREATE TABLE IF NOT EXISTS consulta (
	consulta_id SERIAL PRIMARY KEY,
	id_nutricionista INTEGER NOT NULL REFERENCES nutricionista(nutricionista_id), 
	id_paciente INTEGER NOT NULL REFERENCES paciente(paciente_id),
	data_consulta DATE NOT NULL,
	observacoes VARCHAR(120)
);

CREATE TABLE IF NOT EXISTS endereco (
	endereco_id SERIAL PRIMARY KEY,
	logradouro VARCHAR(50) NOT NULL,
	estado VARCHAR(20) NOT NULL,
	cidade VARCHAR(30) NOT NULL,
	numero VARCHAR(5) NOT NULL,
	cep VARCHAR(8) NOT NULL
);

-- Inserindo dados nas tabelas

INSERT INTO funcionario (nome, matricula, tempo_experiencia, id_endereco)
VALUES 
	('Herman Melville','120238', 7, 1),
	('Elias Canneti','156908', 8, 2),
	('Ricardo Piglia','131667', 11, 3);

INSERT INTO nutricionista (crn, especialidade)
VALUES 
	('0111243617', 'Esportiva'),
	('8998761543', 'Estetética'),
	('1113246756', 'Materno Infantil');

INSERT INTO paciente (nome, data_nascimento, cpf, telefone, email, id_endereco)
VALUES
	('Vinícius Ferreira', '1981-09-16', '04218401418', '81987760245', 'vinicius@gmail.com', 4),  
	('Eduardo Borba', '1982-10-22', '04311765514', '75968761345', 'eduardo@hotmail.com', 5),
	('Maria Clara', '2009-08-31', '23454325677', '85917445249', 'maria@gmail.com', 6);

INSERT INTO consulta (id_nutricionista, id_paciente, data_consulta, observacoes)
VALUES 
	(2, 1, '2024-03-03', NULL),
	(1, 2, '2024-04-04', 'Paciente novo'),
	(3, 3, '2024-05-05', 'Exames receitados');

INSERT INTO endereco (logradouro, estado, cidade, numero, cep)
VALUES 
	('Rua da Saudade', 'Pernambuco', 'Recife', '1245', '52120-000'),
	('Rua das Ninfas', 'Pernambuco', 'Recife', '1110', '52130-000'),
	('Rua do Sossego', 'Pernambuco', 'Recife', '998', '52120-000'),
	('Rua do Sol', 'Pernambuco', 'Recife', '1388', '52180-000'),
	('Rua dos Martírios', 'Pernambuco', 'Recife', '55', '52280-000'),
	('Rua da Aurora', 'Pernambuco', 'Recife', '3245', '52300-000');

-- Atualiza os dados

UPDATE paciente 
SET telefone = '81987750678' WHERE nome = 'Eduardo Borba';

DELETE FROM consulta 
WHERE id_nutricionista = 2;