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

//ESSA TABLE SERA USADA PARA QUARDAR OS DADOS DA CLASSE PESSOA
public class TableCadastro implements OperacoesBaseDados<Pessoa> {

    @Override
    public void createTable() {
        String sql = "CREATE TABLE cadastro"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nome CHAR(70),"+
                "data_nasc DATETIME,"+
                "id_rg INTEGER,"+
                "num_cpf CHAR(11),"+
                "sexo CHAR(1))";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Pessoa informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
