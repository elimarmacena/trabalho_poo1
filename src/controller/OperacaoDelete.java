/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import crud.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
/**
 *
 * @author elmr
 */
public class OperacaoDelete {
    
    public static void apagarRelatorio(int idRelatorio){
        TableRelatorioAcidente tbRA = new TableRelatorioAcidente();
        try {
            tbRA.deletarRelatorio(idRelatorio);
            JOptionPane.showMessageDialog(null, "RELATORIO APAGADO");
        } 
        catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "NAO FOI POSSIVEL APAGAR O RELATORIO");
        }
        
    }
}
