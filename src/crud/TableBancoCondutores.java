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
import model.Cnh;
import model.Condutor;

/**
 *ESTA TABELA DO BANCO DE DADOS NAO APARECE NO MODELO LOGICO POIS NO TRABALHO ELA EH USADA PRA SIMULAR O FUNCIONAMENTO DO BANCO DE CONDUTORES CADASTRADOS PELO DETRAN
 * @author elmr
 */

public class TableBancoCondutores {
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Banco_condutores( " +
            "	id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "	nome CHAR(70), " +
            "	data_nasc DATE, " +
            "	numero_cpf CHAR (12), " +
            "	numero_rg CHAR(13), " +
            "    estado_rg CHAR(2), " +
            "	sexo CHAR(1), " +
            "	numero_cnh CHAR(12), " +
            "    categoria CHAR(13) " +
            ")";
        Utilitarios.executeSQL(sql);
    }
    
    /**
     *Metodo utilizado para efetuar a busca de um condutor que ainda possuia registros de acidente em seu nome
     * @param cnh numero da cnh no formato string
     * @return condutor retorna o condutor referente a cnh
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Condutor buscaByCnh(String cnh) throws SQLException, ClassNotFoundException{
        Condutor condutor = new Condutor();
        Cnh cnhCondutor = new Cnh();
        String sql = "SELECT * FROM Banco_condutores WHERE numero_cnh ='"+cnh+"'";
        
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        //cnh
        cnhCondutor.setNumCnh(resultado.getString("numero_cnh"));
        cnhCondutor.setCategoria(resultado.getString("categoria"));
        //fim
        
        //condutor
        condutor.setNome(resultado.getString("nome"));
        condutor.setDataNascimento(Utilitarios.strDate( resultado.getString("data_nasc") ));
        condutor.setCpf(resultado.getString("numero_cpf"));
        condutor.setNumeroRg(resultado.getString("numero_rg"));
        condutor.setEstadorg(resultado.getString("estado_rg"));
        condutor.setSexo(resultado.getString("sexo"));
        condutor.setCnh(cnhCondutor);
        //fim
        statement.close();
        conexao.close();
        return condutor;
    }
}
