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
import model.Funcionario;
import model.Pessoa;
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
public class TableFuncionarioTest {
    
    public TableFuncionarioTest() {
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
     * Test of createTable method, of class TableFuncionario.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableFuncionario instance = new TableFuncionario();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falha ao criar a tabela funcionario.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cadastar method, of class TableFuncionario.
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableFuncionario instance = new TableFuncionario();
        Funcionario informacao = new Funcionario();
        //setando informacoes basicas de funcionario
        informacao.setSenha("JUnit123");
        informacao.setCpf("128406532-49");
        informacao.setNome("Letícia Andrea Teixeira");
        informacao.setSexo("f");
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1991, 3, 22);
        informacao.setDataNascimento(nascimento.getTime());
        //
        //setando informacoes do rg
        informacao.setNumeroRg("27978279-2");
        informacao.setEstadorg("AC");
        //
        
        try {
            instance.cadastar((Funcionario)informacao);
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            fail("erro ao inserir o dado na tabela FUNCIONARIO.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
    }

    
    
}
