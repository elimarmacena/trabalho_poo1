/*CRIACAO DAS TABELAS DO SISTEMA*/
/* modelologico_sstemaAcidente: */

CREATE TABLE IF NOT EXISTS Condutor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    FK_Cadastro_id INTEGER,
    FK_cnh_id INTEGER,
	FOREIGN KEY (FK_Cadastro_id)
    REFERENCES Cadastro (id),
	FOREIGN KEY (FK_cnh_id)
	REFERENCES Cnh(id)
);

CREATE TABLE IF NOT EXISTS Cadastro (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    numero_rg CHAR(13),
    estado_rg CHAR(2),
    nome CHAR(70),
    data_nasc DATE,
    sexo CHAR(1),
    numero_cpf CHAR(12)
);

CREATE TABLE IF NOT EXISTS Funcionario (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    FK_Cadastro_id INTEGER,
	senha CHAR(12),
	FOREIGN KEY (FK_Cadastro_id)
    REFERENCES Cadastro (id)
);

CREATE TABLE IF NOT EXISTS Contribuidor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    orgao_associado CHAR(40),
    FK_Cadastro_id INTEGER,
	FOREIGN KEY (FK_Cadastro_id)
    REFERENCES Cadastro (id)
);

CREATE TABLE IF NOT EXISTS Relatorio_acidente (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    placa CHAR(8),
    nome_condutor CHAR(70),
    cnh_condutor CHAR(12),
    numero_ocupantes INTEGER,
    info_acidente CHAR(400),
	latitude REAL,
	longitude REAL,
    FK_Contribuidor_id INTEGER,
	FOREIGN KEY (FK_Contribuidor_id)
    REFERENCES Contribuidor (id)
);

CREATE TABLE IF NOT EXISTS Veiculo (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    renavam CHAR(11),
    placa CHAR(8),
    modelo CHAR(40),
    cor CHAR(40),
    marca CHAR(40),
    ano INTEGER
);

CREATE TABLE IF NOT EXISTS Dados_rotina (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    velocidade INTEGER,
    longitude REAL,
    latitude REAL,
    data DATETIME,
    FK_Veiculo_id INTEGER,
	FOREIGN KEY (FK_Veiculo_id)
    REFERENCES Veiculo (id)
);

CREATE TABLE IF NOT EXISTS Acidente (
    pessoas_envolvidas INTEGER,
    latitude REAL,
    longitude REAL,
    descricao CHAR(400),
    data DATETIME,
    id INTEGER PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE IF NOT EXISTS Cnh (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    numero_cnh CHAR(12),
    categoria CHAR(3)
);

CREATE TABLE IF NOT EXISTS Ocorrencia_acidente (
    FK_Acidente_id INTEGER,
    FK_Veiculo_id INTEGER,
    FK_Condutor_id INTEGER,
    condutor_titular INTEGER,
	velocidade INTEGER,
	FOREIGN KEY (FK_Veiculo_id)
    REFERENCES Veiculo (id),
	FOREIGN KEY (FK_Acidente_id)
    REFERENCES Acidente (id),
	FOREIGN KEY (FK_Condutor_id)
    REFERENCES Condutor (id)
);