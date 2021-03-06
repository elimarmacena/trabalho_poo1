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
import model.Funcionario;
import model.Pessoa;
/**
 *
 * @author 20161bsi0314
 */
public class TableFuncionario implements OperacoesBaseDados<Funcionario>{
    
    /**
     *O metodo cria a tabela funcionario no banco de dados caso nao exista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    
    /**
     *O metodo recebe um objeto funcionario e efetua o cadastro do mesmo nao banco de dados
     * @param dadosDaPessoa objeto funcionario
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void cadastar(Funcionario dadosDaPessoa) throws SQLException, ClassNotFoundException {
        TableCadastro bancoCadastro = new TableCadastro();
        bancoCadastro.cadastar((Pessoa)dadosDaPessoa);
        int idCadastro = bancoCadastro.lastId();
        String sql = "INSERT INTO Funcionario(FK_Cadastro_id, senha, ativo) VALUES("+
                idCadastro+","
                +"'"+dadosDaPessoa.getSenha()+"',"
                +"1)";//UM POIS TODO FUNCIONARIO CADASTRADO ESTA ATIVO NO SISTEMA
        Utilitarios.executeSQL(sql);   
    }
    
    /**
     * Metodo responsavel por retornar todos os objetos Funcionarios disponiveis no banco 
     * @return funcionarios arraylist de funcionarios
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    
    public ArrayList<Funcionario> recuperarFuncionariosAtivos() throws SQLException, ClassNotFoundException{
        ArrayList<Funcionario> funcionarios = new ArrayList();
        String sql = "SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "fn.id as 'id' ,fn.senha AS 'senha', fn.ativo AS 'ativo' "
                + "FROM Funcionario fn "
                + "INNER JOIN Cadastro ca ON fn.FK_Cadastro_id = ca.id"
                +" WHERE fn.ativo=1";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
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
    public ArrayList<Funcionario> recuperarFuncionarios() throws SQLException, ClassNotFoundException{
        ArrayList<Funcionario> funcionarios = new ArrayList();
        String sql = "SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "fn.id as 'id' ,fn.senha AS 'senha', fn.ativo AS 'ativo' "
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
            funcionario.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
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
     *Metodo utilizado para efetuar pesquisas na tabela funcionario utilizando o nome ou apenas letras do nome de um funcionario
     * e entao retorna todos os objetos referentes a pesquisa
     * @param like string com o parametro de busca
     * @return funcionarios arraylist de objetos.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Funcionario> recuperarLike(String like) throws SQLException, ClassNotFoundException{
        ArrayList<Funcionario> funcionarios = new ArrayList();
        String sql = "SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "fn.id AS 'id', fn.senha AS 'senha', fn.ativo AS 'ativo' "
                + "FROM Cadastro ca " +
                "INNER JOIN Funcionario fn ON fn.FK_Cadastro_id = ca.id " +
                "WHERE ca.nome LIKE '"+like+"%'";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
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
	
	public Funcionario recuperarPorRg(String rg) throws SQLException, ClassNotFoundException{
        Funcionario funcionario = new Funcionario();
        String sql = "SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "fn.id AS 'id', fn.senha AS 'senha', fn.ativo AS 'ativo' "
                + "FROM Cadastro ca " +
                "INNER JOIN Funcionario fn ON fn.FK_Cadastro_id = ca.id " +
                "WHERE ca.numero_rg = '"+rg+"'";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        if (resultado.next()){ //TODO checar se precisa
            funcionario.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setCpf(resultado.getString("cpf"));
            funcionario.setNumeroRg(resultado.getString("rg"));
            funcionario.setEstadorg(resultado.getString("estado_rg"));
            funcionario.setSexo(resultado.getString("sexo"));
            Date dataNasc = Utilitarios.strDate(resultado.getString("data_nasc"));
            funcionario.setDataNascimento(dataNasc);
            funcionario.setSenha(resultado.getString("senha"));
            boolean ativo = resultado.getString("ativo").equals("1");
            funcionario.setAtivo(ativo);;
        }
        statement.close();
        conexao.close();
        return funcionario;
    }
        
        public Funcionario recuperarById(int id) throws SQLException, ClassNotFoundException{
        Funcionario funcionario = new Funcionario();
        String sql = "SELECT ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc', "
                + "fn.id AS 'id', fn.senha AS 'senha', fn.ativo AS 'ativo' "
                + "FROM Cadastro ca " +
                "INNER JOIN Funcionario fn ON fn.FK_Cadastro_id = ca.id " +
                "WHERE fn.id = "+id;
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        if (resultado.next()){ //TODO checar se precisa
            funcionario.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
            funcionario.setNome(resultado.getString("nome"));
            funcionario.setCpf(resultado.getString("cpf"));
            funcionario.setNumeroRg(resultado.getString("rg"));
            funcionario.setEstadorg(resultado.getString("estado_rg"));
            funcionario.setSexo(resultado.getString("sexo"));
            Date dataNasc = Utilitarios.strDate(resultado.getString("data_nasc"));
            funcionario.setDataNascimento(dataNasc);
            funcionario.setSenha(resultado.getString("senha"));
            boolean ativo = resultado.getString("ativo").equals("1");
            funcionario.setAtivo(ativo);;
        }
        statement.close();
        conexao.close();
        return funcionario;
    }
    
    /**
     * Metodo com intuito de agir como um delete, uma vez que apagar o funcionario do sistema poderia causar impactos.
     * Visto isto ao inves de apagar eh feita uma atualizacao de permicoes de um funcionario.
     * @param funcionario objeto funcionario que se encontra no banco de dados
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void removerFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE Funcionario " +
                "SET ativo = 0 "+
                " WHERE id = "+funcionario.getCampoIdentificacao();
        Utilitarios.executeSQL(sql);
    }
    
    /**
     *Metodo utilizado para reestabelecer as permicoes do funcionario no sistema
     * @param funcionario objeto funcionario que se encontra no banco de dados do sistema
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void AtivarFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE Funcionario " +
                "SET ativo = 1 "+
                " WHERE id = "+funcionario.getCampoIdentificacao();
        Utilitarios.executeSQL(sql);
    }
    
    /**
     * O medoto recebe o objeto condento o campo de identificacao do item na sua respectiva tabela.
     * Por de se passar um objeto torna o update mais facil, podendo ser aplicado genericamente e sua chamada pode ser aplicado em diferentes cenarios.
     * @param funcionario objeto funcionario contendo todas as informacoes do mesmo, sendo assim possivel o update generio.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void updateDados(Funcionario funcionario) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE Funcionario " +
                "SET senha = '" + funcionario.getSenha()+"'"+
                "WHERE id = "+funcionario.getCampoIdentificacao()+";"+
                "UPDATE Cadastro " +
                "Set nome = '" + funcionario.getNome() +"', numero_cpf = '"+funcionario.getCpf()+"',numero_rg = '"+funcionario.getNumeroRg()+"', estado_rg = '"+funcionario.getEstadorg()+"',"+
                "sexo = '"+funcionario.getSexo()+"', data_nasc = '"+Utilitarios.dataToString(funcionario.getDataNascimento())+"'"+
                "WHERE EXISTS (SELECT FK_Cadastro_id FROM Funcionario WHERE Funcionario.id ="+funcionario.getCampoIdentificacao()+"  AND Cadastro.id = Funcionario.FK_Cadastro_id )";
        Utilitarios.executeSQL(sql);
                
    }
    /**
     *Metodo respostavel pela verificacao do login do funcionario no sistema, caso seja bem sucedido eh retornado as informacoes referente ao funcionario conectado.
     * @param login
     * @param senha
     * @return funcionario objeto funcionario referente ao login informado
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IllegalArgumentException lancado caso um dos parametros passados nao sejam iguais ao do banco de dados
     * @throws UnsupportedOperationException lancado caso o funcionario nao seja mais ativo no sistema
     */
    public Funcionario checkLogin(String login, String senha)throws ClassNotFoundException,SQLException, IllegalArgumentException,UnsupportedOperationException{
        Funcionario funcionario = new Funcionario();
        String sql = "SELECT ca.nome as 'nome', ca.numero_cpf as 'numero_cpf',ca.numero_rg AS 'numero_rg',ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc',"
                + "fu.id AS 'id', fu.senha AS 'senha', fu.ativo AS 'ativo' "
                + "FROM Funcionario fu "
                + "INNER JOIN Cadastro ca ON ca.numero_cpf = '"+login+"' AND ca.id = fu.FK_Cadastro_id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        if ( !resultado.getString("senha").equals(senha)  || !resultado.getString("numero_cpf").equals(login) ) {
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
        funcionario.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
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
