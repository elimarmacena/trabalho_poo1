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
import java.util.Date;
import model.Contribuidor;
import model.Pessoa;


public class TableContribuidor implements OperacoesBaseDados<Contribuidor> {
    
    /**
     *O metodo retorna um inteiro representando o id do contribuidor no banco de dados com base no nome e orgao passado como parametro.
     * @param name string com o nome do contribuidor
     * @param orgao string com o nome do orgao
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public int idByNameAndOrgao(String name, String orgao) throws SQLException, ClassNotFoundException{
        int id = 0;
        String sql = "SELECT contribuidor.id FROM contribuidor INNER JOIN cadastro ca ON ca.nome = '"+name+"' WHERE contribuidor.orgao_associado='"+orgao+"'";
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
     *O metodo retorna um inteiro representando o id do ultimo adicionado a tabela no banco de dados
     * @return id
     */
    public int lastId(){
        int id = 0;
        String sql = "SELECT id FROM contribuidor ORDER BY id DESC LIMIT 1";
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
    
    /**
     *O metodo cria a tabela contribuidor no banco de dados caso nao exista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Contribuidor (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "orgao_associado CHAR(40)," +
            "FK_Cadastro_id INTEGER," +
            "FOREIGN KEY (FK_Cadastro_id)" +
            "REFERENCES Cadastro (id) " +
            ")";
        Utilitarios.executeSQL(sql);
    }

    /**
     *O metodo recebe um objeto contribuidor e faz o registro do mesmo no banco de dados.
     * @param informacao objeto condutor
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void cadastar(Contribuidor informacao) throws SQLException, ClassNotFoundException {
        TableCadastro tbCadastro = new TableCadastro();
        tbCadastro.cadastar((Pessoa)informacao);
        int idCadastro = tbCadastro.lastId();
        String sql = "INSERT INTO Contribuidor (FK_Cadastro_id, orgao_associado) VALUES("
                + idCadastro+","
                + "'"+informacao.getOrgaoAssociado()+"')"; //getOrgaoAssociado retorna o nome do orgao no qual o contribuidor possui vinculo.
        Utilitarios.executeSQL(sql);
    }
    
    /**
     * Metodo no qual retorna todos os contribuidores(objeto) disponiveis no sistema
     * @return contribuidores ArrayList
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ArrayList<Contribuidor> recuperarContribuidores() throws SQLException, ClassNotFoundException{
        ArrayList<Contribuidor> contribuidores = new ArrayList();
        String sql = "SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "ct.id AS 'id', ct.Orgao_associado AS 'orgao_associado' "
                + "FROM Contribuidor ct " +
                "INNER JOIN Cadastro ca ON ct.FK_Cadastro_id = ca.id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            Contribuidor contribuidor = new Contribuidor();
            contribuidor.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
            contribuidor.setNome(resultado.getString("nome"));
            contribuidor.setCpf(resultado.getString("cpf"));
            contribuidor.setNumeroRg(resultado.getString("rg"));
            contribuidor.setEstadorg(resultado.getString("estado_rg"));
            contribuidor.setSexo(resultado.getString("sexo"));
            Date dataNasc = Utilitarios.strDate( resultado.getString("data_nasc") );
            contribuidor.setDataNascimento(dataNasc);
            contribuidor.setOrgaoAssociado(resultado.getString("orgao_associado"));
            contribuidores.add(contribuidor);
        }
        statement.close();
        conexao.close();
        return contribuidores;
    }
 
    /**
     *O metodo recria um objeto contribuidor com base no id informado
     * @param idContribuidor
     * @return contribuidor Objeto contribuidor
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Contribuidor restaurarById(int idContribuidor)throws SQLException, ClassNotFoundException {
        String sql = "SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "ct.id AS 'id', ct.Orgao_associado AS 'orgao_associado' "
                + "FROM Contribuidor ct " +
                "INNER JOIN Cadastro ca ON ct.FK_Cadastro_id = ca.id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        Contribuidor contribuidor = new Contribuidor();
        contribuidor.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
        contribuidor.setNome(resultado.getString("nome"));
        contribuidor.setCpf(resultado.getString("cpf"));
        contribuidor.setNumeroRg(resultado.getString("rg"));
        contribuidor.setEstadorg(resultado.getString("estado_rg"));
        contribuidor.setSexo(resultado.getString("sexo"));
        Date dataNasc = Utilitarios.strDate( resultado.getString("data_nasc") );
        contribuidor.setDataNascimento(dataNasc);
        contribuidor.setOrgaoAssociado(resultado.getString("orgao_associado"));
        return contribuidor;   
    }
}
