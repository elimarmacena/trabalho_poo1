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
import model.Contribuidor;
import model.Pessoa;
/**
 *
 * @author elmr
 */
public class TableContribuidor implements OperacoesBaseDados<Contribuidor> {
    public int idByNameAndOrgao(String name, String orgao){
        int id = 0;
        String sql = "SELECT contribuidor.id FROM contribuidor INNER JOIN cadastro ca ON ca.nome = '"+name+"' WHERE contribuidor.orgao_associado='"+orgao+"'";
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

    public int lastId(){
        int id = 0;
        String sql = "SELECT id FROM contribuidor ORDER BY id DESC LIMIT 1";
        Connection conexao = null;
        Statement statement = null;
        try{
            Class.forName("org.sqlite.JDBC");
            conexao = DriverManager.getConnection("jdbc:sqllite:sistemaAcidentes.db");
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
        String sql = "CREATE TABLE IF NOT EXISTS Contribuidor (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "orgao_associado CHAR(40)," +
            "FK_Cadastro_id INTEGER," +
            "FOREIGN KEY (FK_Cadastro_id)" +
            "REFERENCES Cadastro (id) " +
            ")";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Contribuidor informacao) throws SQLException, ClassNotFoundException {
        TableCadastro tbCadastro = new TableCadastro();
        tbCadastro.cadastar((Pessoa)informacao);
        int idCadastro = tbCadastro.lastId();
        String sql = "INSERT INTO Contribuidor (FK_Cadastro_id, orgao_associado) VALUES("
                + idCadastro+","
                + "'"+informacao.getOrgaoAssociado()+"')"; //getOrgaoAssociado retorna o nome do orgao no qual o contribuidor possui vinculo.
        SqlExecution.executeSQL(sql);
    }
 
}
