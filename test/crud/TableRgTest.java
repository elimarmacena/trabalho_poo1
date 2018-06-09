/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TableRgTest {
    
    public TableRgTest() {
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
     * Test of createTable method, of class TableRg.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableRg instance = new TableRg();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falha ao criar a tabela rg.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sql nao foi encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cadastar method, of class TableRg.
     */
    @Test
    public void testCadastar() {
        
    }
    
}
