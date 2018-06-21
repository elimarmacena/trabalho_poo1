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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.DadosRotina;
import model.Veiculo;
/**
 *
 * @author elmr
 */
public class TableDadosRotina implements OperacoesBaseDados<DadosRotina>{

    public static String dataToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatoData.format(data));
        return formatoData.format(data);
    }
    
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

    @Override
    public void cadastar(DadosRotina informacao)throws SQLException, ClassNotFoundException {
        TableVeiculo tbVeiculo = new TableVeiculo();
        int idVeiculo =tbVeiculo.idByPlaca (informacao.getVeiculo().getPlaca());
        String sql = "INSERT INTO dados_rotina (velocidade,latitude,longitude,data,FK_Veiculo_id) VALUES("+
                informacao.getVelocidade()+","+
                informacao.getLatitude()+","+
                informacao.getLongitude()+","+
                "'"+this.dataToString( informacao.getDataColeta() )+"',"+
                idVeiculo+")";/*acessa a placa referente ao veiculo que os dados esta sendo enviado*/
        Utilitarios.executeSQL(sql);
    }
    
    public DadosRotina recuperarByPlaca(String placa) throws ClassNotFoundException, SQLException{
        TableVeiculo tbVeiculo = new TableVeiculo();
        DadosRotina dados = new DadosRotina();
        String sql = "SELECT * FROM Dados_rotina " +
                "INNER JOIN Veiculo vi ON vi.placa = '"+ placa +"' AND vi.id = Dados_rotina.FK_Veiculo_id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        //por se tratar de uma unica linha os dados sao restaurados sem a necessidade de um laco
        Veiculo veiculo = new Veiculo();
        veiculo = tbVeiculo.recuperarById(Integer.parseInt( resultado.getString("FK_Veiculo_id") ));
        dados.setVeiculo(veiculo);
        dados.setLatitude(Double.parseDouble(resultado.getString("latitude") ));
        dados.setLongitude(Double.parseDouble( resultado.getString("longitude") ));
        dados.setVelocidade(Integer.parseInt( resultado.getString("velocidade") ));
        Date dataHora = Utilitarios.strDateTime(resultado.getString("data"));
        dados.setDataColeta(dataHora);
        dados.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
        statement.close();
        conexao.close();
        return dados;
    }

}
