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
import model.OcorrenciaAcidente;
/**
 *
 * @author elmr
 */
public class TableAcidente implements OperacoesBaseDados<Acidente>{
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
        Utilitarios.executeSQL(sql);
    }

    @Override
    public void cadastar(Acidente informacao) throws SQLException, ClassNotFoundException {
        TableCondutor tbCondutor = new TableCondutor();
        TableVeiculo tbVeiculo = new TableVeiculo();
        String sql = "INSERT INTO acidente (pessoas_envolvidas,latitude,longitude,data,descricao) "+
                "VALUES ("+
                informacao.getPessoasEnvolvidas()+","+
                informacao.getLatitude()+","+
                informacao.getLongitude()+","+
                "'"+Utilitarios.dataToString( informacao.getData() )+"',"+
                "'"+informacao.getDescricao()+"')";
        Utilitarios.executeSQL(sql);
    }
    
    /**
     *O metodo retorna todos os Acidentes(classe java) possiveis de restaurar no banco de dados.
     * @return array de Acidentes.
     */
    public ArrayList<Acidente> recuperarAcidentes() throws ClassNotFoundException, SQLException{
        TableOcorrenciaAcidente tbOA = new TableOcorrenciaAcidente(); //instanciando classe para poder ter acesso aos metodos da mesma
        ArrayList<Acidente> acidentes = new ArrayList();
        String sql = "SELECT ac.id AS'id', ac.latitude AS 'latitude', ac.longitude AS 'longitude', ac.descricao AS 'descricao', ac.data AS 'data', ac.pessoas_envolvidas as 'pessoas_envolvidas' "
                + "FROM Acidente ac";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            Acidente acidente = new Acidente();
            ArrayList<OcorrenciaAcidente> ocorrencias = new ArrayList();
            ocorrencias = tbOA.getOcorrenciaByAcidenteId(Integer.parseInt( resultado.getString("id") ));
            acidente.setVeiculosEnvolvidos(ocorrencias);
            acidente.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
            acidente.setLatitude(Double.parseDouble(resultado.getString("latitude") ));
            acidente.setLongitude(Double.parseDouble( resultado.getString("longitude") ));
            acidente.setDescricao(resultado.getString("descricao"));
            Date dataHora = Utilitarios.strDateTime(resultado.getString("data"));
            acidente.setData(dataHora);
            acidente.setPessoasEnvolvidas(Integer.parseInt( resultado.getString("pessoas_envolvidas") ));
            acidentes.add(acidente);
        }
        statement.close();
        conexao.close();
        return acidentes;
    }
    
    /**
     *Metodo responsavel por consultada personalizada de acidentes, pode receber tanto um intervalo de data, quanto apenas um limite superior ou um limite inferior
     * @param dataInf
     * @param dataSup
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Acidente> acidentesByDate(Date dataInf,Date dataSup) throws ClassNotFoundException, SQLException{
        TableOcorrenciaAcidente tbOcorrencia = new TableOcorrenciaAcidente();
        ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
        String sql=null;
        if (dataInf==null){
            sql= "SELECT ac.id AS'id', ac.latitude AS 'latitude', ac.longitude AS 'longitude', ac.descricao AS 'descricao', " +
                    "ac.data AS 'data', ac.pessoas_envolvidas as 'pessoas_envolvidas' " +
                    "FROM Acidente ac WHERE ac.data<='"+dataSup+"'";
        }
        else if(dataSup == null){
            sql= "SELECT ac.id AS'id', ac.latitude AS 'latitude', ac.longitude AS 'longitude', ac.descricao AS 'descricao', " +
                    "ac.data AS 'data', ac.pessoas_envolvidas as 'pessoas_envolvidas' " +
                    "FROM Acidente ac WHERE ac.data>='"+dataInf+"'";
        }
        else{ //caso os dois campos sejam preenchidos
            sql = "SELECT ac.id AS'id', ac.latitude AS 'latitude', ac.longitude AS 'longitude', ac.descricao AS 'descricao', ac.data AS 'data', ac.pessoas_envolvidas as 'pessoas_envolvidas' "
                + "FROM Acidente ac WHERE data>='"+Utilitarios.dataToString(dataInf)+"' AND date<='"+Utilitarios.dataToString(dataSup)+"'";
        }
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            Acidente acidente = new Acidente();
            ArrayList<OcorrenciaAcidente> ocorrencias = new ArrayList();
            ocorrencias = tbOcorrencia.getOcorrenciaByAcidenteId(Integer.parseInt( resultado.getString("id") ));
            acidente.setVeiculosEnvolvidos(ocorrencias);
            acidente.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
            acidente.setLatitude(Double.parseDouble(resultado.getString("latitude") ));
            acidente.setLongitude(Double.parseDouble( resultado.getString("longitude") ));
            acidente.setDescricao(resultado.getString("descricao"));
            Date dataHora = Utilitarios.strDateTime(resultado.getString("data"));
            acidente.setData(dataHora);
            acidente.setPessoasEnvolvidas(Integer.parseInt( resultado.getString("pessoas_envolvidas") ));
            acidentes.add(acidente);
        }
        statement.close();
        conexao.close();
        return acidentes;
    }
    
    
    /**
     *Metodo efetua uma busca no banco de dados refente aos acidentes ligados a uma marca de veiculo especifica ou apenas por letras que compoe a mesma
     * sendo possivel efetuar uma busca procurando acidentes no qual o modelo do veiculo se inicia com A.
     * os objetos gerados no metodo possuem apenas as informacoes basicas do acidente (id, data, descricao, pessoas envolvidas, latitude e longitude). Com apenas esses dados basicos eh possivel recuperar,
     * caso necessario as informacoes referente aos veiculos e condutores envolvidos em tal acidente.
     * @param dataInf
     * @param dataSup
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Acidente> infosAcidenteMarca(String marca) throws ClassNotFoundException, SQLException{
        ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
        String sql = "SELECT ac.id AS'id_acidente', ac.latitude AS 'latitude', ac.longitude AS 'longitude', ac.descricao AS 'descricao', ac.data AS 'data', ac.pessoas_envolvidas as 'pessoas_envolvidas' "
                + "FROM ocorrencia_acidente oa "
                + "INNER JOIN Veiculo vi on vi.marca LIKE '"+marca+"%' AND vi.id = oa.FK_Veiculo_id "
                + "INNER JOIN Acidente ac ON oa.FK_Acidente_id = ac.id";
        Connection conexao = null;
        Statement statement = null;
        Class.forName("org.sqlite.JDBC");
        conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
        statement = conexao.createStatement();
        ResultSet resultado = statement.executeQuery(sql);
        while (resultado.next()){
            Acidente acidente = new Acidente();
            acidente.setCampoIdentificacao(Integer.parseInt( resultado.getString("id") ));
            acidente.setLatitude(Double.parseDouble(resultado.getString("latitude") ));
            acidente.setLongitude(Double.parseDouble( resultado.getString("longitude") ));
            acidente.setDescricao(resultado.getString("descricao"));
            Date dataHora = Utilitarios.strDateTime(resultado.getString("data"));
            acidente.setData(dataHora);
            acidente.setPessoasEnvolvidas(Integer.parseInt( resultado.getString("pessoas_envolvidas") ));
            acidentes.add(acidente);
        }
        statement.close();
        conexao.close();
        return acidentes;
    }

    
}
