/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.SQLException;
import model.Acidente;
/**
 *
 * @author elmr
 */
public class TableAcidente implements OperacoesBaseDados<Acidente>{

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE acidente"+
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
    public void cadastar(Acidente informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
