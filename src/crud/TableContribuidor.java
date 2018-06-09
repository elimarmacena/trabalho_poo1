/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.Contribuidor;
/**
 *
 * @author elmr
 */
public class TableContribuidor implements OperacoesBaseDados<Contribuidor> {

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE contribuidor"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_cadastro INTEGER,"+
                "orgao_associado CHAR(40),"+
                "FOREIGN KEY  (id_cadastro) REFERENCES cadastro(id) )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Contribuidor informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
