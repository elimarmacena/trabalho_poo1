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
    
    public static Date strDateTime(String strData) {
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date data = null;
        try {
            data = (Date) formato.parse(strData);
        } catch (ParseException ex) {
            Logger.getLogger(TableCondutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public static String dataToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(formatoData.format(data));
        return formatoData.format(data);
    }
    public static String dataHoraToString(Date data) {
    DateFormat formatoData = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    System.out.println(formatoData.format(data));
    return formatoData.format(data);
    }
}
