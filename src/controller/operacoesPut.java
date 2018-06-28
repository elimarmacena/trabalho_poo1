/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import crud.TableAcidente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Acidente;

/**
 *
 * @author elmr
 */
public class operacoesPut {
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
}
