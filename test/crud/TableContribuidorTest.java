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
import model.Contribuidor;
import model.Funcionario;
import model.Pessoa;
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
public class TableContribuidorTest {
    
    public TableContribuidorTest() {
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
     * Test of createTable method, of class TableContribuidor.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableContribuidor instance = new TableContribuidor();
        try{
        instance.createTable();
        }
        catch (SQLException sqlErr){
            fail("falaha ao criar tabela contribuidor.");
        }
        catch (ClassNotFoundException clss){
            fail("biblioteca sqlite nao encontrada.");
        }
        
    }

   

    /**
     * Test of cadastar method, of class TableContribuidor.
     */
    @Test
    public void testCadastar(){
        System.out.println("cadastar");
        TableContribuidor instance = new TableContribuidor();
        Contribuidor informacao = new Contribuidor();
        //setando as informacoes basicas de contribuidor
        informacao.setCpf("777777777-77");
        informacao.setNome("raffa moreira mano");
        informacao.setSexo("m");
        informacao.setOrgaoAssociado("fxnxndx");
        //
        //criando e setando o objeto RG
        Rg rgComplete = new Rg();
        rgComplete.setEstado("SP");
        rgComplete.setOrgaoEmissor("LEAN");
        rgComplete.setNumRg("7777777-SP");
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
            fail("erro ao inserir o dado na tabela CONTRIBUIDOR.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
    }
    
}
