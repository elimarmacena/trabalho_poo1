/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
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
    public void testCadastar() {
        
    }
    
}
