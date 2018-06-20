/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Funcionario;
import model.Pessoa;
/**
 *
 * @author 20161bsi0314
 */
public class TableFuncionario implements OperacoesBaseDados<Funcionario>{
    
    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Funcionario (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "FK_Cadastro_id INTEGER," +
            "senha CHAR(12)," +
            "ativo INTEGER, /*1 PARA ATIVO 0 PARA DESATIVADO*/" +
            "FOREIGN KEY (FK_Cadastro_id)" +
            "REFERENCES Cadastro (id) " +
            ")";
        Utilitarios.executeSQL(sql);
    }
    @Override
    public void cadastar(Funcionario informacao) throws SQLException, ClassNotFoundException {
        TableCadastro tbCadastro = new TableCadastro();
        tbCadastro.cadastar((Pessoa)informacao);
        int idCadastro = tbCadastro.lastId();
        String sql = "INSERT INTO Funcionario(FK_Cadastro_id, senha, ativo) VALUES("+
                idCadastro+","+
                "'"+informacao.getSenha()+"',"+
                "1)";//UM POIS TODO FUNCIONARIO CADASTRADO ESTA ATIVO NO SISTEMA
        Utilitarios.executeSQL(sql);   
    }
    
    /**
     * Metodo responsavel por retornar todos os objetos Funcionarios disponiveis no banco 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Funcionario> recuperarFuncionarios() throws SQLException, ClassNotFoundException{
        ArrayList<Funcionario> funcionarios = new ArrayList();
        String sql= "SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', fn.senha AS 'senha', fn.ativo AS 'ativo' "
                + "FROM Funcionario fn "
                + "INNER JOIN Cadastro ca ON fn.FK_Cadastro_id = ca.id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setCpf(resultado.getString("cpf"));
            funcionario.setNumeroRg(resultado.getString("rg"));
            funcionario.setEstadorg(resultado.getString("estado_rg"));
            funcionario.setSexo(resultado.getString("sexo"));
            Date dataNasc = Utilitarios.strDate(resultado.getString("data_nasc"));
            funcionario.setDataNascimento(dataNasc);
            funcionario.setSenha(resultado.getString("senha"));
            boolean ativo = resultado.getString("ativo").equals("1");
            funcionario.setAtivo(ativo);
            funcionarios.add(funcionario);
        }
        statement.close();
        conexao.close();
        return funcionarios;
    }
    
    /**
     *Metodo respostavel pela verificacao do login do funcionario no sistema, caso seja bem sucedido eh retornado as informacoes referente ao funcionario conectado.
     * @param login
     * @param senha
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IllegalArgumentException lancado caso um dos parametros passados nao sejam iguais ao do banco de dados
     * @throws UnsupportedOperationException lancado caso o funcionario nao seja mais ativo no sistema
     */
    public Funcionario checkLogin(String login, String senha)throws ClassNotFoundException,SQLException, IllegalArgumentException,UnsupportedOperationException{
        Funcionario funcionario = new Funcionario();
        String sql = "SELECT ca.nome as 'nome', ca.numero_cpf as 'numero_cpf',ca.numero_rg AS 'numero_rg',ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', fu.senha as 'senha', fu.ativo as 'ativo' "
                + "FROM Funcionario fu "
                + "INNER JOIN Cadastro ca ON ca.numero_cpf = '"+login+"' AND ca.id = fu.FK_Cadastro_id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        if ( !resultado.getString("senha").equals(senha)  && !resultado.getString("numero_cpf").equals(login) ) {
            statement.close();
            conexao.close();
            throw new IllegalArgumentException("Login ou senha incorretos");  //lancado caso um dos parametros passados nao sejam iguais ao do banco de dados
        }
        else if (resultado.getString("ativo").equals("0")){
            statement.close();
            conexao.close();
            throw new UnsupportedOperationException("O funcionario nao possui mais acesso ao sistema"); //lancado caso o funcionario nao seja mais ativo no sistema
        }
        else{
        funcionario.setNome(resultado.getString("nome"));
        funcionario.setCpf(resultado.getString("numero_cpf"));
        funcionario.setNumeroRg(resultado.getString("numero_rg"));
        funcionario.setEstadorg(resultado.getString("estado_rg"));
        funcionario.setSexo(resultado.getString("sexo"));
        Date dataNasc = Utilitarios.strDate(resultado.getString("data_nasc"));
        funcionario.setDataNascimento(dataNasc);
        funcionario.setSenha(resultado.getString("senha"));
        boolean ativo = resultado.getString("ativo").equals("1");
        funcionario.setAtivo(ativo);
        }
        return funcionario;
    }
         


    
    
}
