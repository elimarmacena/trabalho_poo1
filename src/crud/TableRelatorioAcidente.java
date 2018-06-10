/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import model.RelatorioAcidente;
/**
 *
 * @author elmr
 */
public class TableRelatorioAcidente implements OperacoesBaseDados<RelatorioAcidente>{

    @Override
    public void createTable() throws SQLException, ClassNotFoundException{
        String sql= "CREATE TABLE IF NOT EXISTS relatorio_acidente"+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "id_contribuidor INTEGER,"+
                "placa CHAR(8),"+
                "nome_condutor CHAR(70),"+
                "num_cnh CHAR(11),"+
                "num_ocupantes INTEGER,"+
                "info_acidente CHAR(400),"+
                "FOREIGN KEY (id_contribuidor) REFERENCES contribuidor(id) )";
        SqlExecution.executeSQL(sql);
    }

    @Override
    public void cadastar(RelatorioAcidente informacao) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO relatorio_acidente(id_contribuidor,placa,nome_condutor,num_cnh,num_ocupantes,info_acidente)";
        TableContribuidor tbContribuidor = new TableContribuidor();
        sql = sql+"VALUES ("+
                tbContribuidor.idByNameAndOrgao(informacao.getAuxiliador().getNome(), informacao.getAuxiliador().getOrgaoAssociado())+","+
                "'"+informacao.getPlaca()+"',"+
                "'"+informacao.getCondutor()+"',"+
                "'"+informacao.getNumCnh()+"',"+
                informacao.getNumOcupantes()+","+
                "'"+informacao.getTipoAcidente()+"')";
        SqlExecution.executeSQL(sql);
        
        
    }

    @Override
    public void cadastrarMulti(ArrayList<RelatorioAcidente> informacoes) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
