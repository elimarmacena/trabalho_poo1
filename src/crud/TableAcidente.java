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
import model.Acidente;
/**
 *
 * @author elmr
 */
public class TableAcidente implements OperacoesBaseDados<Acidente>{

    public static String dataToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatoData.format(data));
        return formatoData.format(data);
    }
    
    public int lastId(){
        int id = 0;
        String sql = "SELECT id FROM Acidente ORDER BY id DESC LIMIT 1";
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
        String sql = "CREATE TABLE IF NOT EXISTS Acidente ("+
            "pessoas_envolvidas INTEGER,"+
            "latitude REAL,"+
            "longitude REAL,"+
            "descricao CHAR(400),"+
            "data DATETIME,"+
            "id INTEGER PRIMARY KEY AUTOINCREMENT"+
            ")";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(Acidente informacao) throws SQLException, ClassNotFoundException {
        TableCondutor tbCondutor = new TableCondutor();
        TableVeiculo tbVeiculo = new TableVeiculo();
        String sql = "INSERT INTO acidente (pessoas_envolvidas,latitude,longitude,data,descricao) "+
                "VALUES ("+
                informacao.getPessoasEnvolvidas()+","+
                informacao.getLocalizacao()[0]+","+
                informacao.getLocalizacao()[1]+","+
                "'"+this.dataToString(informacao.getData() )+"',"+
                "'"+informacao.getDescricao()+"')";
        SqlExecution.executeSQL(sql);
    }

    
}
