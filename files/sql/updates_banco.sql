---ATUALIZACAO SENHA FUNCIONARIO COM BASE EM SEU CPF
UPDATE Funcionario 
SET senha = '123senha' /*mudar de acordo com a necessidade*/
WHERE EXISTS (SELECT id FROM Cadastro WHERE numero_cpf = '466461086-68'/*mudar de acordo com a necessidade*/ AND id = Funcionario.FK_Cadastro_id )

---ATUALIZACAO DE DESCRICAO ACIDENTE COM BASE NO ID DO ACIDENTE
UPDATE Acidente
SET descricao = 'CAPOTAGEM'
WHERE id = 1

---ATUALIZACAO DE ORGAO DO CONTRIBUIDOR COM BASE NO SEU NOME
UPDATE Contribuidor
SET orgao_associado = 'CORPO DE BOBEIROS'/*mudar de acordo com a necessidade*/
WHERE EXISTS (SELECT id FROM Cadastro ca WHERE ca.nome='Mateus Fernandes Melo'/*mudar de acordo com a necessidade*/ AND Contribuidor.FK_Cadastro_id = ca.id )

---ATUALIZACAO NOME PESSOA COM BASE EM SEU CPF
UPDATE Cadastro
SET nome = 'Joao Paulo'
WHERE numero_cpf = '755393713-60'

---ATUALIZACAO NOME CONDUTOR COM BASE NO SEU ID
UPDATE Cadastro
SET nome = 'Maria Paula'
WHERE EXISTS (SELECT FK_Cadastro_id FROM Condutor cd WHERE cd.id = 10 AND cd.FK_Cadastro_id = Cadastro.id)

---ATUALIZACAO DOS DADOS DE ROTINA COM BASE NO ID DO VEICULO
UPDATE Dados_rotina
SET velocidade= 100, latitude = -33.523274, longitude =  -54.123588, data = '2018-02-04'
WHERE FK_Veiculo_id = 10/*mudar de acordo com a necessidade*/;

---ATUALIZACAO INFORMACOES DE FUNCIONARIO.
UPDATE Funcionario 
SET senha = '1234567'
WHERE EXISTS (SELECT id FROM Cadastro WHERE Funcionario.id = 1 AND id = Funcionario.FK_Cadastro_id );
UPDATE Cadastro
Set nome= 'Brenda Jahring' 
WHERE EXISTS (SELECT FK_Cadastro_id FROM Funcionario WHERE Funcionario.id =1  AND Cadastro.id = Funcionario.FK_Cadastro_id )
