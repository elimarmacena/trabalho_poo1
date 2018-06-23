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
import model.DadosRotina;
import model.Veiculo;
/**
 *
 * @author elmr
 */
public class TableDadosRotina implements OperacoesBaseDados<DadosRotina>{    

    /**
     *O metodo cria a tabela referente a dados de rotina no banco de dados caso nao exista
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS Dados_rotina (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "velocidade INTEGER," +
            "latitude REAL," +
            "longitude REAL," +
            "data DATETIME," +
            "FK_Veiculo_id INTEGER," +
            "FOREIGN KEY (FK_Veiculo_id)" +
            "REFERENCES Veiculo (id)" +
            ")"; //com id_veiculo eh possivel buscar outras informacoes referente o veiculo para poder fazer uma interseccao de dados com o relatorio.
        Utilitarios.executeSQL(sql);
    }

    /**
     *O metodo recebe um objeto dados rotina e efetua o cadastro do mesmo no banco de dados
     * @param informacao objeto dados de rotina
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public void cadastar(DadosRotina informacao)throws SQLException, ClassNotFoundException {
        TableVeiculo tbVeiculo = new TableVeiculo();
        int idVeiculo =tbVeiculo.idByPlaca ( informacao.getVeiculo().getPlaca() );
        String sql = "INSERT INTO dados_rotina (velocidade,latitude,longitude,data,FK_Veiculo_id) VALUES("+
                informacao.getVelocidade()+","+
                informacao.getLatitude()+","+
                informacao.getLongitude()+","+
                "'"+Utilitarios.dataHoraToString(informacao.getDataColeta() )+"',"+
                idVeiculo+")";/*acessa a placa referente ao veiculo que os dados esta sendo enviado*/
        Utilitarios.executeSQL(sql);
    }
   
    /**
     *O metodo retorna um arraylist com o objeto de todos os dados rotinas registrados no banco de dados
     * @return rotinas arraylist
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<DadosRotina> recuperarDadosRotina() throws ClassNotFoundException, SQLException{
        ArrayList<DadosRotina> rotinas = new ArrayList<>();
        TableVeiculo tbVeiculo = new TableVeiculo();
        String sql = "SELECT dr.id AS 'dr.id', dr.velocidade AS 'dr.velocidade', dr.latitude AS 'dr.latitude', dr.longitude AS 'dr.longitude', dr.data AS 'dr.data', dr.FK_Veiculo_id AS 'dr.FK_Veiculo_id'"
                + "FROM Dados_rotina dr " +
                "INNER JOIN Veiculo vi ON vi.id = dr.FK_Veiculo_id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            DadosRotina dados = new DadosRotina();
            //por se tratar de uma unica linha os dados sao restaurados sem a necessidade de um laco
            Veiculo veiculo = tbVeiculo.recuperarById(Integer.parseInt( resultado.getString("dr.FK_Veiculo_id") ));
            dados.setVeiculo(veiculo);
            dados.setLatitude(Double.parseDouble(resultado.getString("dr.latitude") ));
            dados.setLongitude(Double.parseDouble( resultado.getString("dr.longitude") ));
            dados.setVelocidade(Integer.parseInt( resultado.getString("dr.velocidade") ));
            Date dataHora = Utilitarios.strDateTime(resultado.getString("dr.data"));
            dados.setDataColeta(dataHora);
            dados.setCampoIdentificacao(Integer.parseInt( resultado.getString("dr.id") ));
            rotinas.add(dados);
        }
        statement.close();
        conexao.close();
        return rotinas;
    }
    
    /**
     *O metodo retorna o objeto dados de rotina referente a placa do veiculo passada
     * @param placa string contendo a placa do veiculo
     * @return dados objeto dados de rotina da placa informada
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public DadosRotina recuperarByPlaca(String placa) throws ClassNotFoundException, SQLException{
        TableVeiculo tbVeiculo = new TableVeiculo();
        DadosRotina dados = new DadosRotina();
        String sql = "SELECT dr.id AS 'dr.id', dr.velocidade AS 'dr.velocidade', dr.latitude AS 'dr.latitude', dr.longitude AS 'dr.longitude', dr.data AS 'dr.data', dr.FK_Veiculo_id AS 'dr.FK_Veiculo_id' "
                + "FROM Dados_rotina dr " +
                "INNER JOIN Veiculo vi ON vi.placa = '"+ placa +"' AND vi.id = dr.FK_Veiculo_id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        //por se tratar de uma unica linha os dados sao restaurados sem a necessidade de um laco
        
        dados.setLatitude(Double.parseDouble(resultado.getString("dr.latitude") ));
        dados.setLongitude(Double.parseDouble( resultado.getString("dr.longitude") ));
        dados.setVelocidade(Integer.parseInt( resultado.getString("dr.velocidade") ));
        Date dataHora = Utilitarios.strDateTime(resultado.getString("dr.data"));
        dados.setDataColeta(dataHora);
        dados.setCampoIdentificacao(Integer.parseInt( resultado.getString("dr.id") ));
        Veiculo veiculo = tbVeiculo.recuperarById(Integer.parseInt( resultado.getString("dr.FK_Veiculo_id") ));
        dados.setVeiculo(veiculo);
        statement.close();
        conexao.close();
        return dados;
    }

    /**
     *O metodo recebe um objeto dados rotina e atualiza o mesmo no banco de dados
     * @param dados objeto dados rotina
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void updateDados (DadosRotina dados) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE Dados_rotina " +
                "SET velocidade= "+dados.getVelocidade()+", latitude = "+dados.getLatitude()+", longitude =  "+dados.getLongitude()+", data = '"+Utilitarios.dataHoraToString(dados.getDataColeta())+"' " +
                "WHERE FK_Veiculo_id = "+dados.getVeiculo().getCampoIdentificacao();
        Utilitarios.executeSQL(sql);
    }
}
