/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import model.DadosRotina;
/**
 *
 * @author elmr
 */
public class TableDadosRotina implements OperacoesBaseDados<DadosRotina>{

    @Override
    public void createTable() {
        String sql = "CREATE TABLE dados_rotina"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "placa CHAR(8),"+
                "velocidade INTEGER,"+
                "longitude REAL,"+
                "latitude REAL,"+
                "data DATETIME)";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(DadosRotina informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
