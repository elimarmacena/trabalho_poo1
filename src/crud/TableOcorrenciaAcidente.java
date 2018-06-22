/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Cnh;
import model.Condutor;
import model.OcorrenciaAcidente;
import model.Veiculo;

/*OS TESTE REFERENTES A INSERCAO DE UMA OCORRENCIA NO BANCO DE DADOS ACONTECE NO ARQUIVO
TableAcidenteTest.java UMA VEZ QUE PARA A CONSOLIDACAO DE UM ACIDENTE NO SISTEMA
EH NECESSARIO OCORRENCIAS REFERENCIADO OS VEICULOS E CONDUTORES QUE NELE ESTAO 
ENVOLVIDOS*/

/**
 *
 * @author 20161bsi0314
 */
public class TableOcorrenciaAcidente implements OperacoesBaseDados<OcorrenciaAcidente>{

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Ocorrencia_acidente (" +
            "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "	FK_Acidente_id INTEGER," +
            "    FK_Veiculo_id INTEGER," +
            "    FK_Condutor_id INTEGER," +
            "    condutor_titular INTEGER," +
            "	velocidade INTEGER," +
            "	FOREIGN KEY (FK_Veiculo_id)" +
            "    REFERENCES Veiculo (id)," +
            "	FOREIGN KEY (FK_Acidente_id)" +
            "    REFERENCES Acidente (id)," +
            "	FOREIGN KEY (FK_Condutor_id)" +
            "    REFERENCES Condutor (id)" +
            ")";
        Utilitarios.executeSQL(sql);
    }
    

    @Override
    public void cadastar(OcorrenciaAcidente informacao) throws SQLException, ClassNotFoundException {
        TableVeiculo tbVeiculo = new TableVeiculo();
        TableCondutor tbCondutor = new TableCondutor();
        TableAcidente tbAcidente = new TableAcidente();
        int condutorTitular = (informacao.isCondutor_titular()) ? 1:0; //uso do condicional ternario
        int idCondutor = tbCondutor.idByNumCnh(informacao.getCondutor().getCnh().getNumCnh()); //acessando o objeto cnh e entao coletando o seu numero
        int idAcidente = tbAcidente.lastId();
        int idVeiculo = tbVeiculo.idByPlaca(informacao.getVeiculo().getPlaca()); //acessando a placa do veiculo no qual esta envolvido nesta horrorencia
        String sql = "INSERT INTO Ocorrencia_acidente (condutor_titular,velocidade, FK_Acidente_id, FK_Veiculo_id, FK_Condutor_id)"
                + " VALUES("
                + condutorTitular+","
                + informacao.getVelocidade()+","
                + idAcidente+","
                + idVeiculo+","
                + idCondutor+")";
        Utilitarios.executeSQL(sql);
    }

    /**
     * O metodo recebe um id referente a um acidente no banco de dados e retorna as ocorrencias relacionadasao acidente.
     * @param idAcidente inteiro que represente o id do acidente na tabela do banco de dados.
     * @return array contendo objetos ocorrencia acidente relacionados aquele acidente. 
     */
    public ArrayList<OcorrenciaAcidente> getOcorrenciaByAcidenteId(int idAcidente) throws ClassNotFoundException, SQLException{
        ArrayList <OcorrenciaAcidente> ocorrencias = new ArrayList();
        String sql = "SELECT oa.id AS 'id_ocorrencia', oa.condutor_titular AS 'condutor_titular', oa.velocidade AS 'velocidade', " +
                "ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc',cnh.id AS 'id_cnh', cnh.numero_cnh AS 'cnh', cnh.categoria AS 'categoria', " +
                "vi.id AS 'id_veiculo', vi.renavam AS 'renavam', vi.placa AS 'placa', vi.modelo AS 'modelo', vi.cor AS 'cor', vi.marca AS 'marca', vi.ano AS 'ano', cd.id AS 'id_condutor' " +
                " FROM ocorrencia_acidente oa  " +
                "INNER JOIN Condutor cd ON cd.id = oa.FK_Condutor_id " +
                "INNER JOIN Cnh cnh ON cnh.id = cd.FK_cnh_id " +
                "INNER JOIN Veiculo vi ON vi.id = oa.FK_Veiculo_id " +
                "INNER JOIN Cadastro ca ON ca.id = cd.FK_Cadastro_id " +
                "WHERE oa.FK_Acidente_id ="+idAcidente;
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
           OcorrenciaAcidente ocorrencia = new OcorrenciaAcidente();
            Condutor condutor = new Condutor(); //objeto que compoe a classe ocorrencia acidente
            Veiculo veiculo = new Veiculo(); //objeto que compoe a classe ocorrencia acidente
            
            //setando informacoes para o objeto veiculo
            veiculo.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_veiculo") ));
            veiculo.setRenavam(resultado.getString("renavam"));
            veiculo.setPlaca(resultado.getString("placa"));
            veiculo.setModelo(resultado.getString("modelo"));
            veiculo.setCor(resultado.getString("cor"));
            veiculo.setMarca(resultado.getString("marca"));
            veiculo.setAno( Integer.parseInt( resultado.getString("ano") ) );
            
            //setando informacoes para o objeto condutor
            Cnh cnh = new Cnh();
            cnh.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_cnh") ));
            cnh.setCategoria(resultado.getString("categoria"));
            cnh.setNumCnh(resultado.getString("cnh"));
            
            condutor.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_condutor") ));
            condutor.setNome(resultado.getString("nome"));
            condutor.setCpf(resultado.getString("cpf"));
            condutor.setNumeroRg(resultado.getString("rg"));
            condutor.setEstadorg(resultado.getString("estado_rg"));
            condutor.setSexo(resultado.getString("sexo"));
            Date dataNasc = Utilitarios.strDate(resultado.getString("data_nasc"));
            condutor.setDataNascimento(dataNasc);
            condutor.setCnh(cnh);
            
            //atribuindo objetos gerados para ocorrencia
            ocorrencia.setCondutor(condutor);
            ocorrencia.setVeiculo(veiculo);
            //atribuindo dados para ocorrencia
            ocorrencia.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_ocorrencia") ));
            boolean titular = (resultado.getString("condutor_titular").equals('1'));
            ocorrencia.setCondutor_titular(titular);
            ocorrencia.setVelocidade(Integer.parseInt(resultado.getString("velocidade")));
            ocorrencias.add(ocorrencia); 
        }
        statement.close();
        conexao.close();
        return ocorrencias;
    }

    
}
