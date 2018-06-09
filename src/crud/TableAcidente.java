/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Acidente;
/**
 *
 * @author elmr
 */
public class TableAcidente implements OperacoesBaseDados<Acidente>{

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS acidente"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_condutor INTEGER,"+
                "id_veiculo INTEGER,"+
                "num_ocupantes INTEGER,"+
                "velocidade INTEGER,"+
                "descricao CHAR(400),"+
                "latitude REAL,"+
                "longitude REAL,"+
                "data DATETIME,"+
                "FOREIGN KEY (id_condutor) REFERENCES condutor(id),"+
                "FOREIGN KEY (id_veiculo) REFERENCES veiculo(id) )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Acidente informacao) throws SQLException, ClassNotFoundException {
        TableCondutor tbCondutor = new TableCondutor();
        TableVeiculo tbVeiculo = new TableVeiculo();
        String sql = "INSERT INTO acidente (id_condutor,id_veiculo,num_ocupantes,velocidade,descicao,latitude,longitude,data)"+
                "VALUES ("+
                tbCondutor.idByNumCnh(informacao.getCnhCondutor())+","+
                tbVeiculo.idByPlaca(informacao.getPlaca())+","+
                informacao.getOcupantes()+","+
                informacao.getVelocidade()+","+
                "'"+informacao.getDescricao()+"',"+
                informacao.getLocalizacao()[0]+","+
                informacao.getLocalizacao()[1]+","+
                "DATE('"+informacao.getData()+"') )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastrarMulti(ArrayList<Acidente> informacoes) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
