/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.Veiculo;

/**
 *
 * @author 20161bsi0314
 */
public class TableVeiculo implements OperacoesBaseDados<Veiculo> {

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE  veiculo "+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "chassi CHAR(17),"+
                "placa CHAR(7),"+
                "marca CHAR(40),"+
                "modelo CHAR(40),"+
                "cor CHAR(40),"+
                "ano INTEGER )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Veiculo informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
