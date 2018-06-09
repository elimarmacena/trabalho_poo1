/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import model.Funcionario;
/**
 *
 * @author 20161bsi0314
 */
public class TableFuncionario implements OperacoesBaseDados<Funcionario>{
    
    @Override
    public void createTable() {
        String sql = "CREATE TABLE funcionario"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_cadastro INTEGER,"+
                "senha CHAR(12) )"; //senha expressada dessa forma apenas para testes.
        SqlExecution.executeSQL(sql);
    }
    @Override
    public void cadastar(Funcionario informacao) {
        
    }

    
    
}
