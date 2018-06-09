/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.Contribuidor;
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
    public void testCadastar() {
       
    }
    
}
