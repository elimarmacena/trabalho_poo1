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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cnh;
import model.Condutor;
import model.Pessoa;
/**
 *
 * @author elmr
 */
public class TableCondutor implements OperacoesBaseDados<Condutor> {
    
    /**
     * O metodo retorna o Id de um condutor com base na cnh passada.
     * @param numCnh
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public int idByNumCnh(String numCnh) throws SQLException, ClassNotFoundException{
        int id = 0;
        String sql = "SELECT condutor.id FROM Condutor INNER JOIN Cnh ON cnh.numero_cnh='"+numCnh+"' AND Condutor.FK_Cnh_id = Cnh.id";
        Connection conexao = null;
        Statement statement = null;        
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        id = Integer.parseInt(resultado.getString("id") );
        statement.close();
        conexao.close();
        
        return id;
    }
    
    /**
     * O metodo cria uma tabela condutor no banco de dados caso nao tenha sido criada
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Condutor (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "FK_Cadastro_id INTEGER," +
            "FK_cnh_id INTEGER," +
            "FOREIGN KEY (FK_Cadastro_id)" +
            "REFERENCES Cadastro (id)," +
            "FOREIGN KEY (FK_cnh_id)" +
            "REFERENCES Cnh(id) ON DELETE CASCADE" +
            ")";
        Utilitarios.executeSQL(sql);
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
        tbCnh.cadastar(informacao.getCnh());
        tbCadastro.cadastar((Pessoa)informacao);
        int idCadastro = tbCadastro.lastId();
        int idCnh = tbCnh.lastId();
        String sql= "INSERT INTO condutor (FK_Cadastro_id,FK_cnh_id) "
                + "VALUES("
                + idCadastro+","
                + idCnh+")";
        Utilitarios.executeSQL(sql);
    }
    
     /**
     *O metodo retorna todos os Condutor(classe java) possiveis de restaurar no banco de dados.
     * @return lista com os condutores registrados no sistema
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ArrayList<Condutor> recuperarCondutoes() throws SQLException,ClassNotFoundException{
        ArrayList<Condutor> condutores = new ArrayList();
        Condutor resultadoCondutor;
        String sql = "SELECT cd.id as 'id', ca.nome AS 'nome', ca.numero_cpf AS 'numero_cpf', ca.numero_rg AS 'numero_rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "cnh.id AS 'id_cnh', cnh.numero_cnh AS 'cnh', cnh.categoria AS 'categoria' "+
                "FROM Condutor cd" +
                " INNER JOIN Cadastro ca ON ca.id = cd.FK_Cadastro_id" +
                " INNER JOIN Cnh cnh ON cnh.id = cd.FK_cnh_id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while(resultado.next()){
            resultadoCondutor = new Condutor();
            resultadoCondutor.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
            resultadoCondutor.setNome(resultado.getString("nome"));
            resultadoCondutor.setNumeroRg(resultado.getString("numero_cpf"));
            resultadoCondutor.setNumeroRg(resultado.getString("numero_rg"));
            resultadoCondutor.setEstadorg(resultado.getString("estado_rg"));
            resultadoCondutor.setSexo(resultado.getString("sexo"));
            Date dataNasc = Utilitarios.strDate(resultado.getString("data_nasc"));
            resultadoCondutor.setDataNascimento(dataNasc);
            Cnh cnhCondutor = new Cnh();
            cnhCondutor.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_cnh") ));
            cnhCondutor.setNumCnh(resultado.getString("cnh"));
            cnhCondutor.setCategoria(resultado.getString("categoria"));
            resultadoCondutor.setCnh(cnhCondutor);
            condutores.add(resultadoCondutor);
        }
            statement.close();
            conexao.close();         
        return condutores;
    }
    
    /**
     *O metodo retorna um objeto condutor com base no inteiro passado como parametro.
     * @param idCondutor
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Condutor restaurarById(int idCondutor)throws SQLException,ClassNotFoundException{
        Condutor condutor = new Condutor();
        String sql = "SELECT co.id AS 'id_condutor', ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "cnh.id AS 'id_cnh', cnh.numero_cnh AS 'cnh', cnh.categoria AS 'categoria' "+
                "FROM Condutor co "+
                "INNER JOIN Cadastro ca ON co.FK_Cadastro_id = ca.id "+
                "INNER JOIN Cnh cnh ON co.FK_Cnh_id = cnh.id "+
                "WHERE co.id="+idCondutor;
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        Cnh cnh = new Cnh();
        cnh.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_cnh") ));
        cnh.setCategoria(resultado.getString("categoria"));
        cnh.setNumCnh(resultado.getString("cnh"));
        condutor.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_condutor") ));
        condutor.setNome(resultado.getString("nome"));
        condutor.setCpf(resultado.getString("cpf"));
        condutor.setNumeroRg(resultado.getString("rg"));
        condutor.setEstadorg(resultado.getString("estado_rg"));
        condutor.setSexo(resultado.getString("sexo"));
        Date dataNasc = Utilitarios.strDate(resultado.getString("data_nasc"));
        condutor.setDataNascimento(dataNasc);
        condutor.setCnh(cnh);
        statement.close();
        conexao.close();     
        return condutor;
    }

	public Condutor recuperarPorRg(String rg) throws SQLException, ClassNotFoundException{
        Condutor condutor = new Condutor();
        String sql = "SELECT cd.id as 'id', ca.nome AS 'nome', ca.numero_cpf AS 'numero_cpf', ca.numero_rg AS 'numero_rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "cnh.id AS 'id_cnh', cnh.numero_cnh AS 'cnh', cnh.categoria AS 'categoria' "+
                "FROM Condutor cd " +
                "INNER JOIN Cadastro ca ON ca.id = cd.FK_Cadastro_id " +
                "INNER JOIN Cnh cnh ON cnh.id = cd.FK_cnh_id "+
                "WHERE ca.numero_rg = '"+rg+"'";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        if (resultado.next()){ //TODO checar se precisa
            Cnh cnh = new Cnh();
			cnh.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_cnh") ));
			cnh.setCategoria(resultado.getString("categoria"));
			cnh.setNumCnh(resultado.getString("cnh"));
			condutor.setCampoIdentificacao(Integer.parseInt( resultado.getString("id_condutor") ));
			condutor.setNome(resultado.getString("nome"));
			condutor.setCpf(resultado.getString("cpf"));
			condutor.setNumeroRg(resultado.getString("rg"));
			condutor.setEstadorg(resultado.getString("estado_rg"));
			condutor.setSexo(resultado.getString("sexo"));
			Date dataNasc = Utilitarios.strDate(resultado.getString("data_nasc"));
			condutor.setDataNascimento(dataNasc);
			condutor.setCnh(cnh);
			statement.close();
			conexao.close();
		}
        statement.close();
        conexao.close();
        return condutor;
    }
    
}
