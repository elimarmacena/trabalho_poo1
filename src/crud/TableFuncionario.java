/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.*;
/**
 *
 * @author 20161bsi0314
 */
public class TableFuncionario implements OperacoesBaseDados<Funcionario>{
    private void executeSQL(String sql) {
		Connection conexao = null;
		Statement stament = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
			stament = conexao.createStatement();
			stament.executeUpdate(sql);
			stament.close();
			conexao.close();
		}
		catch(ClassNotFoundException cls) {
			cls.printStackTrace();
		}
		catch(SQLException sqxp) {
			sqxp.printStackTrace();
		}
	}
    @Override
    public void createTable() {
        String sql = "CREATE TABLE funcionario"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "numRG CHAR(7),"+
                "numCPF CHAR(11),"+
                "nome CHAR(70),"+
                "dataNasc DATETIME,"+
                "sexo CHAR(1),"+
                "senha CHAR(12) )"; //senha expressada dessa forma apenas para testes.
        this.executeSQL(sql);
    }
    @Override
    public void cadastar(Funcionario informacao) {
        
    }

    
    
}
