/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Acidente;
/**
 *
 * @author elmr
 */
public class TableAcidente implements OperacoesBaseDados<Acidente>{

    public static String dataToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatoData.format(data));
        return formatoData.format(data);
    }
    
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
        String sql = "INSERT INTO acidente (id_condutor,id_veiculo,num_ocupantes,velocidade,descricao,latitude,longitude,data)"+
                "VALUES ("+
                tbCondutor.idByNumCnh(informacao.getCondutor().getCnh().getNumCnh())+","+
                tbVeiculo.idByPlaca(informacao.getVeiculo().getPlaca())+","+
                informacao.getOcupantes()+","+
                informacao.getVelocidade()+","+
                "'"+informacao.getDescricao()+"',"+
                informacao.getLocalizacao()[0]+","+
                informacao.getLocalizacao()[1]+","+
                "'"+this.dataToString(informacao.getData() )+"' )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastrarMulti(ArrayList<Acidente> informacoes) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
