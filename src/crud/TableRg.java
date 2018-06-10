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
import model.Rg;
/**
 *
 * @author elmr
 */
public class TableRg implements OperacoesBaseDados<Rg> {

    public int lastId(){
        int id = 0;
        String sql = "SELECT id FROM rg ORDER BY id DESC LIMIT 1";
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
        String sql = "CREATE TABLE IF NOT EXISTS rg "+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "num_rg CHAR(13),"+
                "orgao CHAR (40),"+
                "estado CHAR (2))";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Rg informacao) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO rg (num_rg, orgao, estado)";
        sql = sql+"VALUES("+
                "'"+informacao.getNumRg()+"',"+
                "'"+informacao.getOrgaoEmissor()+"',"+
                "'"+informacao.getEstado()+"'"+
                ")";
        SqlExecution.executeSQL(sql);
    }

    
    @Override
    public void cadastrarMulti(ArrayList<Rg> informacao) throws SQLException, ClassNotFoundException {
        Rg item = null;
        String sql = "INSERT INTO rg (num_rg, orgao, estado)";
        item = informacao.get(0);
        sql = sql + "VALUES ("+
                "'"+item.getNumRg()+"',"+
                "'"+item.getOrgaoEmissor()+"',"+
                "'"+item.getEstado()+"'"+
                ")";
        for (int i = 1; i<informacao.size(); i++){
            item = informacao.get(i);
            sql= sql+ ",("+
                    "'"+item.getNumRg()+"',"+
                    "'"+item.getOrgaoEmissor()+"',"+
                    "'"+item.getEstado()+"'"+
                    ")";
        }
        SqlExecution.executeSQL(sql);
    }
}
