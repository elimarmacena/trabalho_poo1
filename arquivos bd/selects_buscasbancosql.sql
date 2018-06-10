ta/*BUSCA POR DATA (data a partir de 2018-08-10)*/
SELECT cadastro.nome, veiculo.modelo, acidente.numero_ocupantes FROM cadastro INNER JOIN acidente ON acidente.data >= '2017-08-10' INNER JOIN veiculo ON veiculo.id = acidente.id_veiculo INNER JOIN condutor ON condutor.id = acidente.id_condutor AND condutor.id_cadastro = cadastro.id

/*BUSCA POR MARCA (marca smart)*/
SELECT placa AS 'placa veiculo' FROM veiculo INNER JOIN acidente ac on ac.id_veiculo = veiculo.id AND veiculo.marca='smart'

/*BUSCA POR NOME (Ruthe Rubino)*/
SELECT ca.nome AS 'nome condutor', ac.descricao AS 'descricao acidente', ac.velocidade AS 'velocidade',vc.modelo 'modelo veiculo', ac.numero_ocupantes AS 'numero ocupantes', ac.data AS 'data acidente' FROM acidente ac 
INNER JOIN cadastro ca ON ca.nome='Ruthe Rubino'INNER JOIN veiculo vc INNER JOIN condutor ct ON  ct.id = ac.id_condutor AND ac.id_veiculo = vc.id AND ct.id_cadastro = ca.id

/*BUSCA POR VELOCIDADE (velocidade acima de 90 km)*/
SELECT ca.nome AS 'nome condutor', vi.modelo AS 'modelo veiculo', vi.marca AS 'marca veiculo',ac.velocidade AS 'velocidade durante acidente', ac.latitude AS 'latitude', ac.longitude AS 'longitude' FROM veiculo vi
INNER JOIN acidente ac ON vi.id= ac.id_veiculo and ac.velocidade>=90 INNER JOIN condutor INNER JOIN cadastro ca ON ac.id_condutor= condutor.id AND condutor.id_cadastro = ca.id

/*RECUPERANDO O OBJETO FUNCIONARIO <CLASSE JAVA> */
SELECT ca.nome AS 'nome', ca.data_nasc AS 'data_nasc', ca.sexo AS 'sexo', ca.num_cpf AS 'num_cpf', rg.num_rg AS 'num_rg', rg.orgao AS 'orgao', rg.estado AS 'estado', fun.senha AS 'senha' FROM funcionario fun
INNER JOIN rg INNER JOIN cadastro ca ON fun.id_cadastro= ca.id AND ca.id_rg= rg.id

/*RECUPERANDO O OBJETO CONTRIBUIDOR <CLASSE JAVA>*/
SELECT ca.nome AS 'nome',cont.orgao_associado AS 'orgao associado',  ca.data_nasc AS 'data_nasc', ca.sexo AS 'sexo', ca.num_cpf AS 'num_cpf', rg.num_rg AS 'num_rg', rg.orgao AS 'orgao', rg.estado AS 'estado' FROM contribuidor cont
INNER JOIN rg INNER JOIN cadastro ca ON cont.id_cadastro= ca.id AND ca.id_rg= rg.id

/*RECUPERANDO O OBJETO CONDUTOR <CLASSE JAVA>*/
SELECT ca.nome AS 'nome',cond.titular AS 'titular',  ca.data_nasc AS 'data_nasc', ca.sexo AS 'sexo', ca.num_cpf AS 'num_cpf', rg.num_rg AS 'num_rg', rg.orgao AS 'orgao', rg.estado AS 'estado', cnh.num_cnh AS 'num_cnh', cnh.categoria AS 'categoria' FROM condutor cond
INNER JOIN rg INNER JOIN cadastro ca ON cond.id_cadastro= ca.id AND ca.id_rg= rg.id  INNER JOIN cnh ON cnh.id = cond.id_cnh

/*RECUPERANDO O OBJETO VEICULO <CLASSE JAVA>*/
SELECT renavam,placa,modelo,cor,marca,ano FROM veiculo

/*RECUPERANDO O OBJETO RELATORIO ACIDENTE <CLASSE JAVA>*/
SELECT ra.placa AS 'placa', ra.nome_condutor AS 'nome_condutor', ra.num_cnh AS 'num_cnh', ra.num_ocupantes AS 'num_ocupantes', ra.info_acidente AS 'info_acidente', ca.nome AS 'nome',cont.orgao_associado AS 'orgao associado',  ca.data_nasc AS 'data_nasc', ca.sexo AS 'sexo', ca.num_cpf AS 'num_cpf', rg.num_rg AS 'num_rg', rg.orgao AS 'orgao', rg.estado AS 'estado' FROM relatorio_acidente ra
INNER JOIN contribuidor cont ON cont.id=ra.id_contribuidor  INNER JOIN rg INNER JOIN cadastro ca ON cont.id_cadastro= ca.id AND ca.id_rg= rg.id

/*RECUPERANDO O OBJETO DADOS ROTINA <CLASSE JAVA>*/
SELECT dr.velocidade AS 'velocidade', dr.latitude AS 'latitude', dr.longitude AS 'longitude', dr.data AS 'data', vi.renavam AS 'renavam',vi.placa AS 'placa',vi.modelo AS 'modelo',vi.cor AS 'cor',vi.marca AS 'marca',vi.ano AS 'ano' FROM dados_rotina dr
INNER JOIN veiculo vi ON dr.id_veiculo = vi.id

/*RECUPERANDO O OBJETO ACIDENTE <CLASSE JAVA>*/
SELECT ac.descricao AS 'descricao', ac.velocidade AS 'velocidade', ac.numero_ocupantes AS 'numero_ocupantes', ac.latitude AS 'latitude', ac.longitude AS 'longitude', ac.data as 'data', vi.renavam AS 'renavam',vi.placa AS 'placa',vi.modelo AS 'modelo',vi.cor AS 'cor',vi.marca AS 'marca',vi.ano AS 'ano', ca.nome AS 'nome',cond.titular AS 'titular',  ca.data_nasc AS 'data_nasc', ca.sexo AS 'sexo', ca.num_cpf AS 'num_cpf', rg.num_rg AS 'num_rg', rg.orgao AS 'orgao', rg.estado AS 'estado', cnh.num_cnh AS 'num_cnh', cnh.categoria AS 'categoria' FROM acidente ac
INNER JOIN veiculo vi ON ac.id_veiculo = vi.id INNER JOIN rg  INNER JOIN condutor cond INNER JOIN cadastro ca ON cond.id_cadastro= ca.id AND ca.id_rg= rg.id AND ac.id_condutor = cond.id  INNER JOIN cnh ON cnh.id = cond.id_cnh