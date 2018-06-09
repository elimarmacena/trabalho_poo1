/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import model.RelatorioAcidente;
/**
 *
 * @author elmr
 */
public class TableRelatorioAcidente implements OperacoesBaseDados<RelatorioAcidente>{

    @Override
    public void createTable() {
        String sql= "CREATE TABLE relatorio_acidente"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_contribuidor INTEGER"+
                "placa CHAR(8),"+
                "nome_condutor CHAR(70),"+
                "num_cnh CHAR(12),"+
                "num_ocupantes INTEGER,"+
                "info_acidente CHAR(400))";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(RelatorioAcidente informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
