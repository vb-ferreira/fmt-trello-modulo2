DROP TABLE IF EXISTS paciente CASCADE;
DROP TABLE IF EXISTS nutricionista CASCADE;
DROP TABLE IF EXISTS consulta CASCADE;

-- Ex 02: DDL das tabelas
CREATE TABLE IF NOT EXISTS paciente (
	paciente_id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf VARCHAR(50) NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS nutricionista (
	nutricionista_id SERIAL PRIMARY KEY,
	crn VARCHAR(10) NOT NULL UNIQUE,
	especialidade VARCHAR(20) NOT NULL,
	tempo_experiencia SMALLINT NOT NULL CHECK(tempo_experiencia >= 0)
);

CREATE TABLE IF NOT EXISTS consulta (
	consulta_id SERIAL PRIMARY KEY,
	nutricionista_id INTEGER NOT NULL,
	paciente_id INTEGER NOT NULL,
	data_consulta DATE NOT NULL,
	observacoes VARCHAR(100)
);

-- Ex 03: DML insert das tabelas
INSERT INTO paciente (nome, data_nascimento, cpf, email)
VALUES
	('Vinícius', '1981-09-16', '04218401418', 'vinicius@gmail.com'),
	('Eduardo', '1982-10-22', '04311765514', 'eduardo@hotmail.com'),
	('Maria', '2009-08-31', '23454325677', 'maria@gmail.com');

INSERT INTO nutricionista (crn, especialidade, tempo_experiencia)
VALUES 
	('0111243617', 'Esportiva', 11),
	('8998761543', 'Estetética', 9),
	('1113246756', 'Materno Infantil', 5);

INSERT INTO consulta (nutricionista_id, paciente_id, data_consulta, observacoes)
VALUES 
	(2, 1, '2024-03-03', NULL),
	(1, 2, '2024-04-04', 'Paciente novo'),
	(3, 3, '2024-05-05', 'Exames receitados');

-- Ex 04: DDL relacionamentos
ALTER TABLE consulta
ADD CONSTRAINT consulta_paciente_fkey
FOREIGN KEY (paciente_id)
REFERENCES paciente (paciente_id);

ALTER TABLE consulta
ADD CONSTRAINT consulta_nutricionista_fkey
FOREIGN KEY (nutricionista_id)
REFERENCES nutricionista (nutricionista_id);

-- Ex 07: update e delete
-- atualiza "observacoes" na consulta de id "1"
UPDATE consulta
SET observacoes = 'Cancelada'
WHERE consulta_id = 1;

-- deleta consultas canceladas
DELETE FROM consulta
WHERE observacoes = 'Cancelada';

-- Testes
-- SELECT * FROM paciente;
-- SELECT * FROM nutricionista;
-- SELECT * FROM consulta;

-- SELECT co.data_consulta,
-- 	   co.nutricionista_id,
-- 	   pa.nome AS paciente_nome
-- FROM consulta co
-- INNER JOIN paciente pa ON co.paciente_id = pa.paciente_id
-- INNER JOIN nutricionista nu ON co.nutricionista_id = nu.nutricionista_id;