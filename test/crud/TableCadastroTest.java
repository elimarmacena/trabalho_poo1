/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TableCadastroTest {
    
    public TableCadastroTest() {
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
     * Test of createTable method, of class TableCadastro.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableCadastro instance = new TableCadastro();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falha ao criar tabela cadastro.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao foi encontrada.");;
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cadastar method, of class TableCadastro.
     */
    @Test
    public void testCadastar() {
 
    }
    
}
