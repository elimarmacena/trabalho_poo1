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
import model.Pessoa;
/**
 *
 * @author 20161bsi0314
 */

//ESSA TABLE SERA USADA PARA QUARDAR OS DADOS DA CLASSE PESSOA
public class TableCadastro implements OperacoesBaseDados<Pessoa> {    

    /**
     * O metodo retorna um inteiro que representa o id do ultimo cadastro feito no banco de dados.
     * @return
     */
    public int lastId(){
        int id = 0;
        String sql = "SELECT id FROM cadastro ORDER BY id DESC LIMIT 1";
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
        catch(SQLException | ClassNotFoundException sqler){
            sqler.printStackTrace();
        }
        return id;
    }
    
    /**
     *O metodo cria a tabela de cadastros no banco de dados caso nao exista.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Cadastro (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "numero_rg CHAR(13)," +
            "estado_rg CHAR(2)," +
            "nome CHAR(70)," +
            "data_nasc DATE," +
            "sexo CHAR(1)," +
            "numero_cpf CHAR(12)" +
            ")";
        Utilitarios.executeSQL(sql);
    }

    /**
     *O metodo registra as informacoes referente a classe pessoa no banco de dados
     * @param informacao objeto pessoa
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void cadastar(Pessoa informacao) throws SQLException, ClassNotFoundException {
        String nascimento = Utilitarios.dataToString(informacao.getDataNascimento());
        String sql = "INSERT INTO cadastro(nome,data_nasc,numero_cpf,sexo,numero_rg,estado_rg)"
                + " VALUES("
                +"'"+informacao.getNome()+"',"
                +"'"+nascimento+"',"
                + "'"+informacao.getCpf()+"',"
                + "'"+informacao.getSexo()+"',"
                + "'"+informacao.getNumeroRg()+"',"
                + "'"+informacao.getEstadorg()+"')";
        Utilitarios.executeSQL(sql);
        
    }


    
}
