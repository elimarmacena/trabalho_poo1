/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.DadosRotina;
/**
 *
 * @author elmr
 */
public class TableDadosRotina implements OperacoesBaseDados<DadosRotina>{

    @Override
    public void createTable() throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE dados_rotina"+
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
    public void cadastar(DadosRotina informacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
