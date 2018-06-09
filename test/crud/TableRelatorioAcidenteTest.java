/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RelatorioAcidente;
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
public class TableRelatorioAcidenteTest {
    
    public TableRelatorioAcidenteTest() {
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
     * Test of createTable method, of class TableRelatorioAcidente.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableRelatorioAcidente instance = new TableRelatorioAcidente();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falha ao criar a tabela acidente.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        
    }

    /**
     * Test of cadastar method, of class TableRelatorioAcidente.
     */
    @Test
    public void testCadastar() {
        
    }
    
}
