/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.Cnh;
/**
 *
 * @author elmr
 */
public class TableCnh implements OperacoesBaseDados<Cnh>{

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE cnh"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "numCnh CHAR(12),"+
                "categoria CHAR(3))";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Cnh informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
