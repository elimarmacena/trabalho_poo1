/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
import crud.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author elmr
 */
public class OperacoesUpdate {
    public static void updateFuncionario(Funcionario funcionario){
        TableFuncionario tbFuncionario = new TableFuncionario();
        try {
            tbFuncionario.updateDados(funcionario);
            JOptionPane.showMessageDialog(null, "DADOS ATUALIZADOS");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "NAO FOI POSSIVEL ATUALIZAR OS DADOS");
        } 
    }
}
