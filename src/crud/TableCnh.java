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
import model.Cnh;
/**
 *
 * @author elmr
 */
public class TableCnh implements OperacoesBaseDados<Cnh>{
    public int lastId(){
        int id = 0;
        String sql = "SELECT id FROM cnh ORDER BY id DESC LIMIT 1";
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
        String sql = "CREATE TABLE IF NOT EXISTS cnh"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "num_cnh CHAR(12),"+
                "categoria CHAR(13))"; //tamanho da categoria aumentou para que seja possivel fazer a concatenacao de todas as categorias possiveis
        Utilitarios.executeSQL(sql);
    }

    @Override
    public void cadastar(Cnh informacao)throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cnh (numero_cnh,categoria)"+
                "VALUES("+
                "'"+informacao.getNumCnh()+"',"+
                "'"+informacao.getCategoria()+"')";
        Utilitarios.executeSQL(sql);
    }


    
}
