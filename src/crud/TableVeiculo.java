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
import model.Veiculo;

/**
 *
 * @author 20161bsi0314
 */
public class TableVeiculo implements OperacoesBaseDados<Veiculo> {
    public int idByPlaca(String placa){
        int id = 0;
        String sql = "SELECT id FROM veiculo WHERE placa='" + placa + "'";
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
        String sql = "CREATE TABLE IF NOT EXISTS Veiculo (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "renavam CHAR(11)," +
                "placa CHAR(8)," +
                "modelo CHAR(40)," +
                "cor CHAR(40)," +
                "marca CHAR(40)," +
                "ano INTEGER" +
                ")";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Veiculo informacao) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO veiculo(renavam,placa,modelo,cor,marca,ano) "
                + "VALUES("+
                "'" + informacao.getRenavam() + "',"+
                "'" + informacao.getPlaca() + "',"+
                "'" + informacao.getModelo() + "',"+
                "'" + informacao.getCor() + "',"+
                "'" + informacao.getMarca() + "',"+
                informacao.getAno()+")";
        SqlExecution.executeSQL(sql);
    }

    
}
