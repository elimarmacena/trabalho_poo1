/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cnh;
import model.Condutor;
import model.Rg;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elmr
 */
public class TableCondutorTest {
    
    public TableCondutorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createTable method, of class TableCondutor.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableCondutor instance = new TableCondutor();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("Falha ao criar tabela condutor.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao foi encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }



    /**
     * Test of cadastar method, of class TableCondutor.
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableCondutor instance = new TableCondutor();
        Condutor informacao = new Condutor();
        Cnh cnh = new Cnh();
        //setando informacoes da CNH
        cnh.setNumCnh("77777777777");
        cnh.setCategoria("B");
        informacao.setCnh(cnh);
        //
        //setando as informacoes basicas de contribuidor
        informacao.setCpf("557777755-77");
        informacao.setNome("paulo antonio");
        informacao.setSexo("m");
        //
        //criando e setando o objeto RG
        Rg rgComplete = new Rg();
        rgComplete.setEstado("PR");
        rgComplete.setOrgaoEmissor("LEAN");
        rgComplete.setNumRg("7777337-PR");
        informacao.setRg(rgComplete);
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1990, 7, 7);
        informacao.setDataNascimento(nascimento.getTime());
        //
        try {
            instance.cadastar(informacao);
        } 
        catch (SQLException ex) {
            fail("erro ao inserir os dados na tabela CONDUTOR.");;
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }




    
}
