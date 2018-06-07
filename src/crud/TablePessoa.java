/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import model.Pessoa;
/**
 *
 * @author 20161bsi0314
 */
public class TablePessoa implements OperacoesBaseDados<Pessoa> {

    @Override
    public void createTable() {
        String sql = "CREATE TABLE pessoa"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "numRG CHAR(7),"+
                "numCPF CHAR(11),"+
                "nome CHAR(70),"+
                "dataNasc DATETIME,"+
                "sexo CHAR(1))";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Pessoa informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
