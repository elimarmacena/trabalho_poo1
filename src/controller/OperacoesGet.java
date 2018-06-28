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
public class OperacoesGet {
    
    
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
        TableCondutor tbCondutores = new TableCondutor();
        Condutor recuperado = null;
        try{
            recuperado = tbBCondutores.buscaByCnh(numeroCnh);
            tbCondutores.cadastar(recuperado);
        }
        catch(SQLException | ClassNotFoundException tr){
            try{
            recuperado = tbCondutores.recuperarPorCnh(numeroCnh);
            }
            catch(SQLException | ClassNotFoundException rt){
                JOptionPane.showMessageDialog(null, "DADO NAO ENCONTRADO NA BASE");
            }
            
        }
        return recuperado;
    }
    
    public static Funcionario getFuncinarioById(int id){
        TableFuncionario tbFuncionario = new TableFuncionario();
        Funcionario recuperado = null;
        try{
            recuperado = tbFuncionario.recuperarById(id);
        }
        catch(SQLException | ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "NAO FOI POSSIVEL RECUPERAR O DADO NO MOMENTO");
        }
        return recuperado;
    }
}
