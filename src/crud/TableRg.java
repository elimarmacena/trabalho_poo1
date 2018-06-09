/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.Rg;
/**
 *
 * @author elmr
 */
public class TableRg implements OperacoesBaseDados<Rg> {

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE rg "+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "num_rg CHAR(13),"+
                "orgao CHAR (40),"+
                "estado CHAR (2))";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Rg informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
