/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Condutor;
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
    public void testCadastar() {
        
    }
    
}
