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
import model.Pessoa;
/**
 *
 * @author 20161bsi0314
 */

//ESSA TABLE SERA USADA PARA QUARDAR OS DADOS DA CLASSE PESSOA
public class TableCadastro implements OperacoesBaseDados<Pessoa> {

     public int lastId(){
        int id = 0;
        String sql = "SELECT id FROM cadastro ORDER BY id DESC LIMIT 1";
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
        String sql = "CREATE TABLE IF NOT EXISTS cadastro"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nome CHAR(70),"+
                "data_nasc DATETIME,"+
                "id_rg INTEGER,"+
                "num_cpf CHAR(11),"+
                "sexo CHAR(1),"+
                "FOREIGN KEY (id_rg) REFERENCES rg(id) )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Pessoa informacao) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cadastro (nome,data_nasc,id_rg,num_cpf,sexo)";
        TableRg tbRg = new TableRg();
        tbRg.cadastar(informacao.getRg());
        sql = sql+"VALUES("+
                "'"+informacao.getNome()+"',"+
                "DATE('"+informacao.getDataNascimento()+"'),"+
                tbRg.lastId()+","+
                "'"+informacao.getCpf()+"',"+
                "'"+informacao.getSexo()+"' )";
        SqlExecution.executeSQL(sql);
        
    }

    @Override
    public void cadastrarMulti(ArrayList<Pessoa> informacoes) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
