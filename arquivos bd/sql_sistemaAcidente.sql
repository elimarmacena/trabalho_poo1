

CREATE TABLE rg (id INTEGER PRIMARY KEY AUTOINCREMENT, num_rg CHAR(13), orgao CHAR(40), estado CHAR(2) );
CREATE TABLE cadastro ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome CHAR(70),data_nasc DATE, id_rg INTEGER, num_cpf CHAR(12),sexo CHAR(1) );
CREATE TABLE funcionario (id INTEGER PRIMARY KEY AUTOINCREMENT, id_cadastro INTEGER, senha CHAR(20), FOREIGN KEY (id_cadastro) REFERENCES cadastro(id) );
CREATE TABLE contribuidor ( id INTEGER PRIMARY KEY AUTOINCREMENT, id_cadastro integer, orgao_associado char(40) );
CREATE TABLE relatorio_acidente(id INTEGER PRIMARY KEY AUTOINCREMENT,id_contribuidor INTEGER,placa CHAR(8),nome_condutor CHAR(70),num_cnh CHAR(12),num_ocupantes INTEGER,info_acidente CHAR(400), FOREIGN KEY (id_contribuidor) REFERENCES contribuidor(id) );
CREATE TABLE cnh (id INTEGER PRIMARY KEY AUTOINCREMENT, num_cnh CHAR(12),categoria CHAR(3) );
CREATE TABLE condutor (id INTEGER PRIMARY KEY AUTOINCREMENT, id_cadastro INTEGER, id_cnh INTEGER, titular INTEGER, FOREIGN KEY (id_cadastro) REFERENCES cadastro(id), FOREIGN KEY (id_cnh) REFERENCES cnh(id) );
CREATE TABLE veiculo (id INTEGER PRIMARY KEY AUTOINCREMENT, chassi CHAR(17), placa CHAR(8), modelo CHAR(40), cor CHAR(40), marca CHAR(40), ano INTEGER);
CREATE TABLE dados_rotina (id INTEGER PRIMARY KEY AUTOINCREMENT, velocidade INTEGER, longitude REAL, latitude REAL, data DATE, id_veiculo, FOREIGN KEY (id_veiculo) REFERENCES veiculo(id) );
CREATE TABLE acidente (id INTEGER PRIMARY KEY AUTOINCREMENT, id_veiculo INTEGER, id_condutor INTEGER, numero_ocupantes INTEGER, velocidade INTEGER, longitude REAL, latitude REAL, descricao CHAR(400), data DATE, FOREIGN KEY (id_veiculo) REFERENCES veiculo(id), FOREIGN KEY (id_condutor) REFERENCES condutor(id) );

INSERT INTO cadastro(nome,data_nasc,id_rg,num_cpf,sexo) 
INSERT INTO cadastro(nome,data_nasc,id_rg,num_cpf,sexo) 
INSERT INTO cadastro(nome,data_nasc,id_rg,num_cpf,sexo) 

INSERT INTO contribuidor(id_cadastro,orgao_associado) 
INSERT INTO contribuidor(id_cadastro,orgao_associado) 

INSERT INTO relatorio_acidente(id_contribuidor,placa,nome_condutor,num_cnh,num_ocupantes,info_acidente)  
INSERT INTO relatorio_acidente(id_contribuidor,placa,nome_condutor,num_cnh,num_ocupantes,info_acidente)  



SELECT contribuidor.id FROM contribuidor INNER JOIN cadastro ca ON ca.nome = "elimar xx" WHERE contribuidor.orgao_associado = 'SAMU';