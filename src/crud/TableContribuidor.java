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
        String sql = "CREATE TABLE IF NOT EXISTS contribuidor"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_cadastro INTEGER,"+
                "orgao_associado CHAR(40),"+
                "FOREIGN KEY  (id_cadastro) REFERENCES cadastro(id) )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Contribuidor informacao) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO contribuidor (id_cadastro,orgao_associado)";
        TableCadastro tbCadastro = new TableCadastro();
        tbCadastro.cadastar((Pessoa)informacao);
        sql= sql+ "VALUES("+
                tbCadastro.lastId()+","+
                "'"+informacao.getOrgaoAssociado()+"')";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastrarMulti(ArrayList<Contribuidor> informacoes) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
