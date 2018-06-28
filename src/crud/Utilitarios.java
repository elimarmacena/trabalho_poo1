/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 20161bsi0314
 */
public  class Utilitarios {

    /**
     *Metodo criado para diminuir repeticao de codigo.
     * utilizado para executar um sql, fechando e abrindo a conexao com o banco de dados
     * @param sql sql que metodo deve executar
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void executeSQL(String sql) throws SQLException, ClassNotFoundException {
		Connection conexao = null;
		Statement stament = null;
                Class.forName("org.sqlite.JDBC");
                conexao = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db");
                stament = conexao.createStatement();
                stament.executeUpdate(sql);
                stament.close();
                conexao.close();
		
	}

    /**
     *O metodo recebe uma string representando uma data no formato yyyy-mm-dd e retorna o objeto Date
     * @param strData string com a data no formato yyyy-mm-dd
     * @return data objeto Date
     */
	public static Date strDate(String strData) {
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = (Date) formato.parse(strData);
        } catch (ParseException ex) {
            Logger.getLogger(TableCondutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
	
	/**
	 * recebe o formato brasileiro e retorna um objeto date
	 * @param strData
	 * @return 
	 */
	public static Date strDateBrToDate(String strData) {
        DateFormat formato =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (strData == null){
            return null;
        }
        Date data = null;
        try {
            data = (Date) formato.parse(strData);
            return data;
        } catch (ParseException ex) {
            return null;
        }
        
    }
    
	/**
	 * 
	 * @param strData
	 * @return 
	 */
    public static Date strBrDate(String strData) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (strData == null){
            return null;
        }
        Date data = null;
        try {
            data = (Date) formato.parse(strData);
        } catch (ParseException ex) {
            return null;
        }
        return data;
    }
    
    /**
     *O metodo recebe uma string repreentando uma data e um horario o formato yyyy-MM-dd HH:mm:ss e retorna um objeto Date
     * @param strData string com a data no formato yyyy-MM-dd HH:mm:ss
     * @return data objeto date
     */
    public static Date strDateTime(String strData) {
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (strData == null){
            return null;
        }
        Date data = null;
        try {
            data = (Date) formato.parse(strData);
        } catch (ParseException ex) {
            Logger.getLogger(TableCondutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    /**
     *O metodo recebe um objeto date e retorna uma string da data no formato yyyy-mm-dd
     * @param data objeto date
     * @return stringData string com data no formato yyyy-mm-dd
     */
    public static String dataToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        String stringData = formatoData.format(data);
        return stringData;
    }

    /**
     *O metodo recebe um objeto date e retorna uma string data no formato yyyy-MM-dd HH:mm:ss
     * @param data objeto data
     * @return stringDataHora string com a data no formato yyyy-MM-dd HH:mm:ss
     */
    public static String dataHoraToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stringDataHora = formatoData.format(data);
        return stringDataHora;
    }
    
    public static String dataToStringBR(Date data) {
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String stringDataHora = formatoData.format(data);
        return stringDataHora;
    }
    
    public static String converteSexo(String itemAt) {
        if(itemAt.equals("Masculino")) {
            return "m";
        }
        else {
            return "f";
        }
    }
}
