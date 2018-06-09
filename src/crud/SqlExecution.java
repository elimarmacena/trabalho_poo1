/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 20161bsi0314
 */
public  class SqlExecution {
    public static void executeSQL(String sql) throws SQLException, ClassNotFoundException {
		Connection conexao = null;
		Statement stament = null;
                Class.forName("org.sqlite.JDBC");
                conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
                stament = conexao.createStatement();
                stament.executeUpdate(sql);
                stament.close();
                conexao.close();
		
	}
}
