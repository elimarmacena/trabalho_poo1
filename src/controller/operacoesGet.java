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
public class operacoesGet {
    
    
    public static Veiculo getVeiculo(String placa){
        TableVeiculo tbVeiculo = new TableVeiculo();
        Veiculo recuperado = null;
        try {
            recuperado = tbVeiculo.recuperarByPlaca(placa);
        } catch (SQLException | ClassNotFoundException ex ) {
            JOptionPane.showMessageDialog(null, "PLACA NAO ENCONTRADA.");
        }
        return recuperado;
    }
    
    public static Condutor getContudor(String numeroCnh){
        TableBancoCondutores tbBCondutores = new TableBancoCondutores();
        Condutor recuperado = null;
        try{
            recuperado = tbBCondutores.buscaByCnh(numeroCnh);
        }
        catch(SQLException | ClassNotFoundException tr){
            try{
            TableCondutor tbCondutores = new TableCondutor();
            recuperado = tbCondutores.recuperarPorCnh(numeroCnh);
            }
            catch(SQLException | ClassNotFoundException rt){
                JOptionPane.showMessageDialog(null, "DADO NAO ENCONTRADO NA BASE");
            }
            
        }
        return recuperado;
    }
}
