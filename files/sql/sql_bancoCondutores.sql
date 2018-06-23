CREATE TABLE IF NOT EXISTS Banco_condutores(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	nome CHAR(70),
	data_nasc DATE,
	numero_cpf CHAR (12),
	numero_rg CHAR(13),
    estado_rg CHAR(2),
	sexo CHAR(1),
	numero_cnh CHAR(12),
    categoria CHAR(13)
);

INSERT INTO Banco_condutores(nome, data_nasc,numero_cpf,numero_rg,estado_rg,sexo,numero_cnh,categoria) 
VALUES
('Bruno Diego Anderson da Mata','1996-03-27','268328163-32','43083728-8','PI','M','94600241567','A,B'),
('Igor Kaique Marcos da Costa','1996-02-23','468567155-44','50570145-5','SC','M','69689321949','A'),
('Raimundo Caio Pereira','1996-12-15','238120484-93','43091136-1','GO','M','59199504751','B,C'),
('Elias Breno Ramos','1996-03-27','570572293-13','40.223.468-6','PR','M','11795007383','C,D'),
('Enrico Alexandre Teixeira','1996-11-2','026688944-17','16763903-1','PA','M','12237078300','C'),
('Osvaldo Cláudio Ribeiro','1996-02-13','299398460-88','32023467-8','SP','M','87896735841','D'),
('Luiz Enrico Nicolas Aragão','1996-06-27','332744627-05','14226391-6','SP','M','07864253767','E'),
('Raimundo Matheus Mateus Fernandes','1996-03-24','096.321.957-01','26376536-2','RJ','M','81633313880','A,B'),
('Juan Pedro Henrique Manuel Pinto','1996-12-2','476.968.341-34','49.187.856-4','AP','M','15691816006','A,E'),
('Antonio Yuri Rodrigues','1996-03-17','669.910.698-84','35.331.975-2','PA','M','67554203110','B,D'),
('Ruan Severino Martin Galvão','1996-04-8','048.905.265-79','048.905.265-79','MS','M','45725855210','A'),
('Fernando João Fábio Melo','1996-05-26','289.116.132-74','22.596.865-4','PR','M','02389859632','B'),
('Marcos Luís Roberto de Paula','1996-06-18','901.192.139-90','33.420.971-7','PI','M','99254967320','A,B,C'),
('Yuri Breno Diogo Moreira','1996-03-10','931.033.520-34','26.149.728-5','RR','M','19664777116','A'),
('Helena Carla Aparício','1996-10-14','724.903.243-73','27.929.099-8','DF','F','54789809600','B'),
('Eduarda Heloise Martins','1996-12-19','518.282.474-21','35.812.290-9','MA','F','15796579764','E'),
('Esther Elza de Paula','1996-04-09','719.724.651-20','19.113.513-6','ES','F','55501744742','C'),
('Elza Luna Raquel Silva','1996-05-12','477.051.745-96','22.349.731-9','PB','F','93339400184','D'),
('Aline Evelyn Duarte','1996-10-12','046.712.229-65','18.020.253-4','AC','F','79252589314','A'),
('Adriana Carla Emilly Figueiredo','1982-03-15','960.054.649-57','37.627.347-1','CE','F','00220580709','A,C'),
('Evelyn Emanuelly Kamilly Freitas','1982-02-18','227.188.361-05','28.557.146-1','CE','F','25577843003','B,E'),
('Sara Brenda Rayssa Campos','1982-10-06','999.539.279-87','14.412.885-8','GO','F','19690258186','E'),
('Patrícia Isis Antonella Nascimento','1982-09-10','692.117.814-50','11.374.886-3','PB','F','76188087579','E'),
('Valentina Aurora Heloise Figueiredo','1982-04-24','848.167.954-21','14.197.852-1','BA','F','33440099490','E'),
('Lívia Liz Laura Cavalcanti','1982-03-04','194.408.276-02','31.954.530-1','RS','F','18830667385','A'),
('Lorena Maya Fátima Nascimento','1982-05-12','246.389.348-62','30.237.412-7','SP','F','07977233548','D'),
('Luciana Letícia da Silva','1982-03-01','302.355.196-00','36.836.325-9','PE','F','10882414510','E'),
('Clarice Bruna Cláudia Freitas','1982-09-23','425.344.439-33','425.344.439-33','RR','F','73476171710','E'),
('Luiza Sandra Rezende','1982-09-13','046.032.360-18','13.051.337-4','SC','F','14093607167','A,C,E')
