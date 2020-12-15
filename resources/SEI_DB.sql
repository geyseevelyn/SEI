CREATE TABLE usuario (
	IdUsu SERIAL PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	cpf VARCHAR (14) NOT NULL UNIQUE,
	Endereco VARCHAR (50) NOT NULL,
	email VARCHAR (30) NOT NULL,
	login VARCHAR (15) NOT NULL UNIQUE,
	senha VARCHAR (15) NOT NULL
)

CREATE TABLE turma (
	IdTurma SERIAL PRIMARY KEY,
	CodTurma VARCHAR (5) NOT NULL UNIQUE,
	Nome VARCHAR (20) NOT NULL,
	Sala VARCHAR(20) NOT NULL,
	Horario VARCHAR(30) NOT NULL
)

CREATE TABLE aluno (
	IdAluno SERIAL PRIMARY KEY,
	Matricula VARCHAR(10) NOT NULL UNIQUE,
	IdTurma INT REFERENCES Turma(IdTurma) ON UPDATE CASCADE ON DELETE CASCADE,
	IdUsu INT REFERENCES Usuario(IdUsu) ON UPDATE CASCADE ON DELETE CASCADE
)

CREATE TABLE professor (
	IdProf SERIAL PRIMARY KEY,
	IdUsu INT REFERENCES Usuario(IdUsu) ON UPDATE CASCADE ON DELETE CASCADE
)

CREATE TABLE diretor (
	IdDir SERIAL PRIMARY KEY,
	IdUsu INT REFERENCES Usuario(IdUsu) ON UPDATE CASCADE ON DELETE CASCADE
)

CREATE TABLE disciplina (
	IdDisc SERIAL PRIMARY KEY,
	CodDisc VARCHAR (7) UNIQUE,
	Nome VARCHAR(50),
	Status BOOL,
	IdProf INT REFERENCES Professor(IdProf) ON UPDATE CASCADE ON DELETE CASCADE
)

CREATE TABLE nota (
	IdNota SERIAL UNIQUE,
	IdAluno INT REFERENCES aluno(IdAluno) ON UPDATE CASCADE ON DELETE CASCADE,
	IdDisc INT REFERENCES Disciplina(IdDisc) ON UPDATE CASCADE ON DELETE CASCADE,
	n1 FLOAT,
	n2 FLOAT,
	n3 FLOAT,
	media FLOAT,
	faltas INT,
	PRIMARY KEY (IdAluno, IdDisc)
)

CREATE TABLE turmadisc (
	IdTurma INT REFERENCES Turma(IdTurma) ON UPDATE CASCADE ON DELETE CASCADE,
	IdDisc INT REFERENCES Disciplina(IdDisc) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY (IdTurma, IdDisc)
)

CREATE TABLE turmaprof (
	IdTurma INT REFERENCES Turma(IdTurma) ON UPDATE CASCADE ON DELETE CASCADE,
	IdProf INT REFERENCES Professor(IdProf) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(IdTurma,IdProf)
)

CREATE TABLE boletim (
	IdAluno INT REFERENCES aluno(IdAluno) ON UPDATE CASCADE ON DELETE CASCADE,
	IdDisc INT REFERENCES Disciplina(IdDisc) ON UPDATE CASCADE ON DELETE CASCADE,
	n1 FLOAT,
	n2 FLOAT,
	n3 FLOAT,
	media FLOAT,
	faltas INT,
	situacao VARCHAR(10),
	PRIMARY KEY (IdAluno, IdDisc)
)

CREATE VIEW UsuariosAlunos AS 
(SELECT u.nome, u.cpf, u.endereco, u.email 
FROM Usuario u, Aluno a 
WHERE u.IdUsu = a.IdUsu)

CREATE VIEW UsuariosProfs AS 
(SELECT u.nome, u.cpf, u.endereco, u.email 
FROM Usuario u, Professor p
WHERE u.IdUsu = p.IdUsu)

CREATE FUNCTION func_insert_boletim() RETURNS trigger AS $$
BEGIN
	INSERT INTO boletim (idaluno, iddisc, n1, n2, n3, media, faltas) VALUES
	(new.idaluno, new.iddisc, new.n1, new.n2, new.n3, new.media, new.faltas); 
	RETURN NEW;
END;
$$ 
LANGUAGE 'plpgsql';

CREATE TRIGGER insert_boletim
AFTER INSERT ON nota
FOR EACH ROW EXECUTE PROCEDURE func_insert_boletim()

CREATE FUNCTION func_update_boletim() RETURNS trigger AS $$
BEGIN
	UPDATE boletim SET idaluno = new.idaluno, iddisc = new.iddisc, n1 = new.n1, n2 = new.n2, n3 = new.n3,
	media = new.media, faltas = new.faltas where idaluno = new.idaluno and iddisc = new.iddisc;
	RETURN NEW;
END;
$$ 
LANGUAGE 'plpgsql';

CREATE TRIGGER update_boletim
AFTER UPDATE ON nota
FOR EACH ROW EXECUTE PROCEDURE func_update_boletim()

CREATE FUNCTION func_delete_boletim() RETURNS trigger AS $$
BEGIN
	DELETE FROM boletim WHERE idaluno = old.idaluno and iddisc = old.iddisc;
	RETURN NEW;
END;
$$ 
LANGUAGE 'plpgsql';

CREATE TRIGGER delete_boletim
AFTER DELETE ON nota
FOR EACH ROW EXECUTE PROCEDURE func_delete_boletim()

CREATE RULE insert_aprovado_rule AS ON INSERT TO nota
WHERE NEW.media >= 7
DO UPDATE boletim SET situacao = 'Aprovado' 
WHERE idaluno = new.idaluno and iddisc = new.iddisc;

CREATE RULE update_aprovado_rule AS ON UPDATE TO nota
WHERE NEW.media >= 7
DO UPDATE boletim SET idaluno = new.idaluno, iddisc = new.iddisc, n1 = new.n1,
n2 = new.n2, n3 = new.n3, media = new.media, faltas = new.faltas, situacao = 'Aprovado'
where idaluno = new.idaluno and iddisc = new.iddisc;

CREATE RULE insert_reprovado_rule AS ON INSERT TO nota
WHERE NEW.media < 7
DO UPDATE boletim SET situacao = 'Reprovado' 
WHERE idaluno = new.idaluno and iddisc = new.iddisc;

CREATE RULE update_reprovado_rule AS ON UPDATE TO nota
WHERE NEW.media < 7
DO UPDATE boletim SET idaluno = new.idaluno, iddisc = new.iddisc, n1 = new.n1,
n2 = new.n2, n3 = new.n3, media = new.media, faltas = new.faltas, situacao = 'Reprovado'
where idaluno = new.idaluno and iddisc = new.iddisc;
