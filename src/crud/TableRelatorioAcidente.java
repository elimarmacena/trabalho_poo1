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
import model.Contribuidor;
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
        Utilitarios.executeSQL(sql);
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
                + informacao.getLatitude()+","
                + informacao.getLongitude()+","
                + "'" + this.dataToString( informacao.getData() ) + "')";
        Utilitarios.executeSQL(sql);
    }
    
    public ArrayList<RelatorioAcidente> recuperarRelatorios() throws SQLException, ClassNotFoundException{
        ArrayList<RelatorioAcidente> relatorios = new ArrayList();
        String sql = "SELECT ra.placa AS 'placa', ra.nome_condutor AS 'nome_condutor', ra.cnh_condutor as 'cnh_condutor', ra.numero_ocupantes as 'numero_ocupantes',"
                + "ra.info_acidente as 'info_acidente', ra.latitude as 'latitude', ra.longitude as 'longitude', ra.data as 'data',"
                + " ca.nome AS 'nome', ca.numero_cpf AS 'cpf', ca.numero_rg AS 'rg', ca.estado_rg AS 'estado_rg', ca.sexo AS 'sexo', ca.data_nasc AS 'data_nasc',"
                + " ct.Orgao_associado AS 'orgao_associado' "
                + "FROM Relatorio_acidente ra "
                + "INNER JOIN contribuidor ct ON ct.id = ra.FK_Contribuidor_id "
                + "INNER JOIN cadastro ca ON ca.id = ct.FK_Cadastro_id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            Contribuidor contribuidor = new Contribuidor();
            //setando informacoes referente ao contribuidor que enviou o relatorio
            contribuidor.setNome(resultado.getString("nome"));
            contribuidor.setCpf(resultado.getString("cpf"));
            contribuidor.setNumeroRg(resultado.getString("rg"));
            contribuidor.setEstadorg(resultado.getString("estado_rg"));
            contribuidor.setSexo(resultado.getString("sexo"));
            Date dataNasc = Utilitarios.strDate( resultado.getString("data_nasc") );
            contribuidor.setDataNascimento(dataNasc);
            contribuidor.setOrgaoAssociado(resultado.getString("orgao_associado"));
            //
            RelatorioAcidente relatorio = new RelatorioAcidente();
            relatorio.setAuxiliador(contribuidor); //adicionando o contribuidor ao relatorio
            relatorio.setPlaca(resultado.getString("placa"));
            relatorio.setNomeCondutor(resultado.getString("nome_condutor"));
            relatorio.setNumCnh(resultado.getString("cnh_condutor"));
            relatorio.setNumOcupantes(Integer.parseInt( resultado.getString("numero_ocupantes") ));
            relatorio.setDescricao(resultado.getString("info_acidente"));
            relatorio.setLatitude(Double.parseDouble( resultado.getString("latitude") ));
            relatorio.setLongitude(Double.parseDouble( resultado.getString("longitude") ));
            relatorio.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
            Date dataHora = Utilitarios.strDateTime(resultado.getString("data") );
            relatorio.setData(dataHora);
            relatorios.add(relatorio);
        }
        statement.close();
        conexao.close();
        return relatorios;
    }
    


    
}
