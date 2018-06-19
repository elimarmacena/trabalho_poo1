/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;
import model.Pessoa;
/**
 *
 * @author 20161bsi0314
 */
public class TableFuncionario implements OperacoesBaseDados<Funcionario>{
    
    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Funcionario (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "FK_Cadastro_id INTEGER," +
            "senha CHAR(12)," +
            "ativo INTEGER, /*1 PARA ATIVO 0 PARA DESATIVADO*/" +
            "FOREIGN KEY (FK_Cadastro_id)" +
            "REFERENCES Cadastro (id) " +
            ")";
        SqlExecution.executeSQL(sql);
    }
    @Override
    public void cadastar(Funcionario informacao) throws SQLException, ClassNotFoundException {
        TableCadastro tbCadastro = new TableCadastro();
        tbCadastro.cadastar((Pessoa)informacao);
        int idCadastro = tbCadastro.lastId();
        String sql = "INSERT INTO Funcionario(FK_Cadastro_id, senha, ativo) VALUES("+
                idCadastro+","+
                "'"+informacao.getSenha()+"',"+
                "1)";//UM POIS TODO FUNCIONARIO CADASTRADO ESTA ATIVO NO SISTEMA
        SqlExecution.executeSQL(sql);
        
    }


    
    
}
