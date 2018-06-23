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

    /**
     *O metodo retorna um inteiro representando o id do veiculo com base na placa informada
     * @param placa
     * @return id inteiro representando o id do veiculo no banco de dados
     */
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
            id = Integer.parseInt( resultado.getString("id") );
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
    
    /**
     * O metodo cria a tabela veiculo no banco de dados caso ainda nao exista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
        Utilitarios.executeSQL(sql);
    }

    /**
     *O metodo cadastra um objeto veiculo no banco de dados
     * @param informacao objeto veiculo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
        Utilitarios.executeSQL(sql);
    }
    
    /**
     *O metodo recebe um inteiro representando o id do veiculo e recria o objeto do mesmo
     * @param idVeiculo inteiro representando id do veiculo
     * @return veiculo objeto veiculo
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Veiculo recuperarById(int idVeiculo)throws SQLException, ClassNotFoundException{
        Veiculo veiculo = new Veiculo();
        String sql = "SELECT * FROM Veiculo vi WHERE vi.id = "+idVeiculo;
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
         //setando informacoes para o objeto veiculo
        veiculo.setRenavam(resultado.getString("renavam"));
        veiculo.setPlaca(resultado.getString("placa"));
        veiculo.setModelo(resultado.getString("modelo"));
        veiculo.setCor(resultado.getString("cor"));
        veiculo.setMarca(resultado.getString("marca"));
        veiculo.setAno( Integer.parseInt( resultado.getString("ano") ) );
        veiculo.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
        statement.close();
        conexao.close();
        return veiculo;
    }

    
}
