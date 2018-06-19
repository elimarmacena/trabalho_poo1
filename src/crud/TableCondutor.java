/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Condutor;
import model.Pessoa;
/**
 *
 * @author elmr
 */
public class TableCondutor implements OperacoesBaseDados<Condutor> {
    public int idByNumCnh(String numCnh){
        int id = 0;
        String sql = "SELECT condutor.id FROM Condutor INNER JOIN Cnh ON cnh.numero_cnh='"+numCnh+"' AND Condutor.FK_Cnh_id = Cnh.id";
        Connection conexao = null;
        Statement statement = null;
        try{
            Class.forName("org.sqlite.JDBC");
            conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
            statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            id = Integer.parseInt(resultado.getString("id") );
            statement.close();
            conexao.close();
        }
        catch(SQLException sqler){
            sqler.printStackTrace();
        }
        catch(ClassNotFoundException clser){
           clser.printStackTrace();
        }
        return id;
    }
    
    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Condutor (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "FK_Cadastro_id INTEGER," +
            "FK_cnh_id INTEGER," +
            "FOREIGN KEY (FK_Cadastro_id)" +
            "REFERENCES Cadastro (id)," +
            "FOREIGN KEY (FK_cnh_id)" +
            "REFERENCES Cnh(id) ON DELETE CASCADE" +
            ")";
        SqlExecution.executeSQL(sql);
    }

    /**
     *o metodo funciona de maneira que se informa o objeto condutor e faz todo o preenchimento das tabelas necessarias, como cadastro, rg e cnh
     * @param informacao
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     */
    @Override
    public void cadastar(Condutor informacao) throws SQLException, ClassNotFoundException{
        TableCnh tbCnh  = new TableCnh();
        TableCadastro tbCadastro = new TableCadastro();
        tbCnh.cadastar(informacao.getCnh());
        tbCadastro.cadastar((Pessoa)informacao);
        int idCadastro = tbCadastro.lastId();
        int idCnh = tbCnh.lastId();
        String sql= "INSERT INTO condutor (FK_Cadastro_id,FK_cnh_id) "
                + "VALUES("
                + idCadastro+","
                + idCnh+")";
        SqlExecution.executeSQL(sql);
    }


    
}
