/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import crud.TableAcidente;
import crud.TableFuncionario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author elmr
 */
public class OperacoesPut {
    public static void salvarAcidente(Acidente acidenteCadastro){
        TableAcidente tbAcidente = new TableAcidente();
        try {
            tbAcidente.cadastar(acidenteCadastro);
        } catch (SQLException  ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "NAO FOI POSSIVEL SALVAR OS DADOS NO BANCO DE DADOS (sql)");
        }
        catch(ClassNotFoundException cc){
            cc.printStackTrace();
            JOptionPane.showMessageDialog(null, "class");
        }
    }
    public static void salvarFuncionario(Funcionario funcionario){
        TableFuncionario tbFuncionario = new TableFuncionario();
        try{
            tbFuncionario.cadastar(funcionario);
        }
        catch(SQLException | ClassNotFoundException err){
            JOptionPane.showMessageDialog(null, "NAO FOI POSSIVEL EFETUAR O CADASTRO DO FUNCIONARIO");
        }
    }
}
