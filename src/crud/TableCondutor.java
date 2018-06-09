/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.Condutor;
/**
 *
 * @author elmr
 */
public class TableCondutor implements OperacoesBaseDados<Condutor> {

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE condutor"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_cadastro INTEGER,"+
                "titular_veiculo INTEGER,"+
                "id_cnh INTEGER,"+
                "FOREIGN KEY (id_cadastro) REFERENCES cadastro(id),"+
                "FOREIGN KEY (id_cnh) REFERENCES cnh(id) )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Condutor informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
