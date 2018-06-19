/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.RelatorioAcidente;
/**
 *
 * @author elmr
 */
public class TableRelatorioAcidente implements OperacoesBaseDados<RelatorioAcidente>{

    public static String dataToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatoData.format(data));
        return formatoData.format(data);
    }
    @Override
    public void createTable() throws SQLException, ClassNotFoundException{
        String sql= "CREATE TABLE IF NOT EXISTS Relatorio_acidente (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "placa CHAR(8)," +
            "nome_condutor CHAR(70)," +
            "cnh_condutor CHAR(12)," +
            "numero_ocupantes INTEGER," +
            "info_acidente CHAR(400)," +
            "latitude REAL," +
            "longitude REAL," +
            "data DATE," +
            "FK_Contribuidor_id INTEGER," +
            "FOREIGN KEY (FK_Contribuidor_id)" +
            "REFERENCES Contribuidor (id)" +
            ")";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(RelatorioAcidente informacao) throws SQLException, ClassNotFoundException {
        TableContribuidor tbContribuidor = new TableContribuidor();
        int idContribuidor = tbContribuidor.idByNameAndOrgao(informacao.getAuxiliador().getNome(), informacao.getAuxiliador().getOrgaoAssociado());
        String sql = "INSERT INTO relatorio_acidente (FK_Contribuidor_id,placa,nome_condutor,cnh_condutor,numero_ocupantes,info_acidente, latitude, longitude,data) "
                + "VALUES("
                + idContribuidor+","
                +"'" + informacao.getPlaca() + "',"
                +"'" + informacao.getNomeCondutor() + "',"
                +"'" + informacao.getNumCnh() + "',"
                + informacao.getNumOcupantes()+","
                + "'" + informacao.getDescricao() + "',"
                + informacao.getLocalizacao()[0]+","
                + informacao.getLocalizacao()[1]+","
                + "'" + this.dataToString( informacao.getData() ) + "')";
                
                
        SqlExecution.executeSQL(sql);
        
        
    }


    
}
