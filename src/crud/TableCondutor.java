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
        String sql = "SELECT condutor.id FROM condutor INNER JOIN cnh ON cnh.num_cnh='"+numCnh+"'";
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
        String sql = "CREATE TABLE IF NOT EXISTS condutor"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_cadastro INTEGER,"+
                "titular_veiculo INTEGER,"+
                "id_cnh INTEGER,"+
                "FOREIGN KEY (id_cadastro) REFERENCES cadastro(id),"+
                "FOREIGN KEY (id_cnh) REFERENCES cnh(id) )";
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
        String sql = "INSERT INTO condutor(id_cadastro,titular_veiculo,id_cnh)";
        tbCnh.cadastar(informacao.getCnh());
        tbCadastro.cadastar((Pessoa)informacao);
        int titular = informacao.isTitularVeiculo() ? 1:0; //caso seja titular o valor guardado na tabela eh 1
        sql= sql+"VALUES("+
                tbCadastro.lastId()+","+
                titular+","+
                tbCnh.lastId()+")";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastrarMulti(ArrayList<Condutor> informacoes) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
