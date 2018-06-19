/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import model.OcorrenciaAcidente;

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
        SqlExecution.executeSQL(sql);
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
        SqlExecution.executeSQL(sql);
    }


    
}
