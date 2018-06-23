# trabalho_poo1<br>
repositório referente ao trabalho desenvolvido na disciplina  programação orientada a objeto 1 (professor Felipe @felipefo)

# Sumário

### 1. COMPONENTES<br>
Integrantes do grupo<br>
Elimar Macena: @elimarmacena<br>
Hellesandro Gonzaga: @gonzH<br>
Luiz Amorim: @LuizLk<br>

### 2.INFORMACOES REFERENTE AO SISTEMA<br>
#### 2.1 MOTIVAÇAO<br>
   Em 2016 foi liberada uma pesquisa da OMS(Organização Mundial de Saúde) sobre os países da América com maior índice de mortes acidentes de trânsito. Nesta pesquisa o Brasil ocupou a quarta colocação, perdendo apenas para Belize, República Dominicana e Venezuela.<br>

   Tendo em vista o grande número de acidentes, não apenas os que resultaram em morte, no Brasil é possível visualizar a necessidade de uma conscientização que traga um impacto de fato. Com essa visão o sistema busca trazer um maior conhecimento das pessoas que se envolve em acidentes e tentar traçar certos perfis através dos dados coletados referentes aos acidentes, tendo assim a possibilidade de uma conscientização realmente efetiva.<br><br>
#### 2.2 MINI-MUNDO<br>
   O sistema de monitoramento de acidentes será acessado apenas pelos funcionários dos locais onde houver o sistema implementado, e este acesso só será liberado através do uso de login e senha, no qual o login irá ser representado pelo CPF do funcionário. <br>

   Os acidentes que o sistema irá guardar possuem as seguintes informações: os acontecimentos que nele ocorreram (capotagem, derrapagem,...), veículos no quais fazem parte com seus respectivos condutores e velocidade, dia e hora em que ocorreram, número de pessoas envolvidas e localização de onde ocorreu.<br>

   Os funcionários serão os responsáveis pela inserção de dados referentes a acidentes, dados esses que necessitam de uma série de informações que serão enviadas ao sistema por meio do veículo e de um contribuidor externo.<br>

   Os dados sobre o veículo envolvido no acidente são os dados de momentos antes de que o mesmo ocorresse, essa extração se dá por meio do OBD, um sistema embarcado que é obrigatório em carros produzidos a partir de 2010,  e através deste sistema embarcado é saber o estado do seu mecanismo e averiguar se houve parte no acontecimento. Os dados atrelados ao veículo são: RENAVAM, placa marca, modelo, ano(de fabricação) e sua finalidade (passeio, carga,...).<br>

   Já as informações sobre o condutor serão obtidas a partir do momento em que ocorre um acidente e serão enviadas por um contribuído que possua vínculo com algum órgão, uma vez que o condutor do veículo pode não ser o seu titular e poder variar por viagem. Os dados atrelados ao condutor são: data de nascimento, CPF, RG, nome, sexo, CNH.<br>

   O sistema possui a necessidade de gerar relatórios, relatórios esses que variam de acordo com a necessidade do momento sendo necessário a possibilidade de organizá-lo pelo intervalo de tempo, tipo de acidente, modelo de carro, quantidade de ocupantes do veículo, velocidade em que o acidente ocorreu, a partir de uma limitação de área e etc.<br><br>
### 3.DIAGRMAS DO SISTEMA<br>
#### 3.1 DIAGRAMA DE CLASSES<br>
![Alt text](https://github.com/elimarmacena/trabalho_poo1/blob/master/files/diagramas/img/diagrama_classes_tpoo.svg "Diagrama de Classes")<br><br>
##### 3.2 MODELO CONCEITUAL DO BANCO DE DADOS<br>
![Alt text](https://github.com/elimarmacena/trabalho_poo1/blob/master/files/diagramas/img/modeloconceitual_sistemaAcidente.png "Modelo Conceitual")<br><br>
##### 3.3 MODELO LOGICO DO BANCO DE DADOS<br>
![Alt text](https://github.com/elimarmacena/trabalho_poo1/blob/master/files/diagramas/img/modelologico_sistemaAcidente.png "Modelo Logico")<br><br>
### 4.TECNOLOGIAS UTILIZADAS<br>
#### 4.1 DESENVOLVIMENTO DO CODIGO<br>
   Para o desenvolvimento do sistema foi utilizado a linguagem Java juntamente com a biblioteca gráfica swing e a framework para teste JUnit 4.<br><br>
#### 4.2 BANCO DE DADOS UTILIZADO<br>
   Foi feita a utilização do sqlite3<br><br>
#### 4.3 MODELAGEM <br>
   Para a elaboração diagrama de classes foi utilizado o software Astah. Já para o modelo conceitual e para o diagrama logico foi feito uso do software BrModelos 3.<br>
