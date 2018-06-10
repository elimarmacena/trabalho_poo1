/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.DadosRotina;
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
        String sql = "CREATE TABLE IF NOT EXISTS dados_rotina"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_veiculo INTEGER,"+
                "velocidade INTEGER,"+
                "longitude REAL,"+
                "latitude REAL,"+
                "data DATETIME,"+
                "FOREIGN KEY (id_veiculo) REFERENCES veiculo(id) )"; //com id_veiculo eh possivel buscar outras informacoes referente o veiculo para poder fazer uma interseccao de dados com o relatorio.
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(DadosRotina informacao)throws SQLException, ClassNotFoundException {
        TableVeiculo tbVeiculo = new TableVeiculo();
        String sql = "INSERT INTO dados_rotina (id_veiculo, velocidade,longitude,latitude,data)"+
                "VALUES ("+
                tbVeiculo.idByPlaca(informacao.getVeiculo().getPlaca())+","+ /*acessa a placa referente ao veiculo que os dados esta sendo enviado*/
                informacao.getVelocidade()+","+
                informacao.getLocalizacao()[0]+","+
                informacao.getLocalizacao()[1]+","+
                "'"+this.dataToString(informacao.getDataColeta())+"')";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastrarMulti(ArrayList<DadosRotina> informacoes) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
