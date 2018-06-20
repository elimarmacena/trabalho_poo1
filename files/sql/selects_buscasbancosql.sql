---ACIDENTES A PARTIR DE UMA DATA X
SELECT ac.data AS 'DATA HORA', ac.id AS 'ID', ac.pessoas_envolvidas AS 'PESSOAS ENVOLVIDAS', ac.descricao AS 'DESCRICAO', ac.latitude AS 'LATITUDE', ac.longitude AS 'LONGITUDE' FROM Acidente ac 
WHERE ac.data >= '2017-08-10'; /*apenas alterar esse valor de acordo com a necessidade*/

---CONDUTORES E VEICULOS ENVOLVIDOS EM UM ACIDENTE X A PARTIR DO SEU ID
SELECT ca.nome AS 'NOME CONDUTOR', cnh.numero_cnh AS 'NUMERO CNH', vi.placa AS 'PLACA VEICULO', vi.modelo AS 'MODELO VEICULO' FROM cadastro ca
INNER JOIN ocorrencia_acidente oa ON oa.FK_Acidente_id = 1 
INNER JOIN Veiculo vi ON oa.FK_Veiculo_id = vi.id
INNER JOIN Condutor co ON oa.FK_Condutor_id = co.id AND co.FK_Cadastro_id = ca.id
INNER JOIN Cnh cnh ON co.FK_cnh_id = cnh.id;

---DADOS ROTINAS COM BASE NA PLACA INFORMADA
SELECT * FROM Dados_rotina 
INNER JOIN Veiculo vi ON vi.placa = 'PPX-0000' AND vi.id = Dados_rotina.FK_Veiculo_id

---ACIDENTES A PARTIR DE UMA MARCA X DE VEICULO
SELECT ac.data AS 'DATA HORA', ac.id AS 'ID ACIDENTE', vi.placa as 'PLACA VEICULO',ac.pessoas_envolvidas AS 'PESSOAS ENVOLVIDAS', ac.descricao as 'DESCRICAO',ac.latitude AS 'LATITUDE', ac.longitude AS 'LONGITUDE' FROM Acidente ac
INNER JOIN Veiculo vi ON vi.marca= 'Engesa' /*apenas alterar esse valor de acordo com necessidade*/
INNER JOIN ocorrencia_acidente oa ON oa.FK_Veiculo_id = vi.id  AND oa.FK_Acidente_id = ac.id

---ACIDENTE A PARTIR DO NOME DE UM CONDUTOR
SELECT ac.data as 'DATA HORA', ac.id as 'ID ACIDENTE', vi.placa AS 'PLACA VEICULO', ac.pessoas_envolvidas AS 'PESSOAS ENVOLVIDAS', ac.descricao as 'DESCRICAO', ac.latitude AS 'LATITUDE', ac.longitude AS 'LONGITUDE' FROM Acidente ac
INNER JOIN Cadastro ca ON ca.nome= 'Tambra Trapani' /*apenas alterar esse valor de acordo com a necessidade*/
INNER JOIN Condutor co ON ca.id = co.FK_Cadastro_id
INNER JOIN ocorrencia_acidente oa ON oa.FK_Condutor_id = co.id AND ac.id = oa.FK_Acidente_id
INNER JOIN Veiculo vi ON vi.id = oa.FK_Veiculo_id

---ACIDENTE A PARTIR DA VELOCIDADE DOS VEICULOS ENVOLVIDOS
SELECT ac.data AS 'DATA HORA', ac.id AS 'ID ACIDENTE',vi.placa AS 'PLACA VEICULO', ac.pessoas_envolvidas AS 'PESSOAS ENVOLVIDAS', ac.descricao AS 'DESCRICAO', ac.latitude AS 'LATITUDE', ac.longitude AS 'LONGITUDE' FROM Acidente ac 
INNER JOIN ocorrencia_acidente oa ON oa.velocidade >= 80/*alterar valor e condicao de acordo com a necessidade*/ AND ac.id = oa.FK_Acidente_id
INNER JOIN Veiculo vi ON vi.id = oa.FK_Veiculo_id

---LOCALIZACOES DOS ACIDENTES
SELECT id, latidude, longitude FROM Acidente;

---RECUPERACAO DO OBJETO FUNCIONARIO <CLASSE JAVA>
SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', fn.senha AS 'senha', fn.ativo AS 'ativo' FROM Funcionario fn
INNER JOIN Cadastro ca ON fn.FK_Cadastro_id = ca.id

---RECUPERACAO DO OBJETO  CONTRIBUIDOR <CLASSE JAVA>
SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc',ct.Orgao_associado AS 'orgao_associado' FROM Contribuidor ct
INNER JOIN Cadastro ca ON ct.FK_Cadastro_id = ca.id

---RECUPERACAO DO OBJETO RELATORIO ACIDENTE <CLASSE JAVA>
SELECT ra.placa AS 'placa', ra.nome_condutor AS 'nome_condutor', ra.cnh_condutor as 'cnh_condutor', ra.numero_ocupantes as 'numero_ocupantes',
ra.info_acidente as 'info_acidente', ra.latitude as 'latitude', ra.longitude as 'longitude', ra.data as 'data',
ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc',
ct.Orgao_associado AS 'orgao_associado' FROM Relatorio_acidente ra
INNER JOIN contribuidor ct ON ct.id = ra.FK_Contribuidor_id
INNER JOIN cadastro ca ON ca.id = ct.FK_Cadastro_id

---RECUPERACAO DO OBJETO CONDUTOR <CLASSE JAVA>
SELECT ca.nome AS 'nome', ca.numero_cpf AS 'numero_cpf', ca.numero_rg AS 'numero_rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc',cnh.numero_cnh AS 'cnh', cnh.categoria AS 'categoria' FROM Condutor cd
INNER JOIN Cadastro ca ON ca.id = cd.FK_Cadastro_id
INNER JOIN Cnh cnh ON cnh.id = cd.FK_cnh_id

---RECUPERACAO DO OBJETO VEICULO <CLASSE JAVA>
SELECT vi.renavam AS 'renavam', vi.placa AS 'placa', vi.modelo AS 'modelo', vi.cor AS 'cor', vi.marca AS 'marca', vi.ano AS 'ano' FROM Veiculo vi


---RECUPERACAO DO OBJETO ACIDENTE <CLASSE JAVA>
SELECT ac.id AS'id', ac.latitude AS 'latitude', ac.longitude AS 'longitude', ac.descricao AS 'descricao', ac.data AS 'data', ac.pessoas_envolvidas as 'pessoas_envolvidas' FROM Acidente ac
---PARA QUE SEJA POSSIVEL RECUPERAR O OBJETO COMO UM TODO EH NECESSARIO O USO DO SELECT A SEGUIR

---RECUPERACAO OBJETO OCORRENCIA ACIDENTE <CLASSE JAVA>
SELECT oa.condutor_titular AS 'condutor_titular', oa.velocidade AS 'velocidade',
ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc',cnh.numero_cnh AS 'cnh', cnh.categoria AS 'categoria', /*condutor do veiculo na seguinte ocorrencia*/
vi.renavam AS 'renavam', vi.placa AS 'placa', vi.modelo AS 'modelo', vi.cor AS 'cor', vi.marca AS 'marca', vi.ano AS 'ano' /*veiculo na seguinte ocorrencia*/
 FROM ocorrencia_acidente oa 
INNER JOIN Condutor cd ON cd.id = oa.FK_Condutor_id
INNER JOIN Cnh cnh ON cnh.id = cd.FK_cnh_id
INNER JOIN Veiculo vi ON vi.id = oa.FK_Veiculo_id
INNER JOIN Cadastro ca ON ca.id = cd.FK_Cadastro_id
WHERE oa.FK_Acidente_id =1 /*mudar de acordo com necessidade*/