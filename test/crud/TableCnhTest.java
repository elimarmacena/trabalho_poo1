/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.Cnh;
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
public class TableCnhTest {
    
    public TableCnhTest() {
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
     * Test of createTable method, of class TableCnh.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableCnh instance = new TableCnh();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falha ao criar tabela Cnh.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
    }


    /**
     * Test of cadastar method, of class TableCnh.
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar() {
        System.out.println("cadastar");
        TableCnh instance = new TableCnh();
        Cnh informacao = new Cnh();
        //setando informacoes da CNH
        informacao.setNumCnh("12480757262");
        informacao.setCategoria("B");
        //
        //
        
        try {
            instance.cadastar(informacao);
        } catch (SQLException ex) {
            fail("falha ao inserir os dados na tabela CNH.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        
    }

    /**
     * Test of lastId method, of class TableCnh.
     */
    @Test
    public void testLastId() {
        System.out.println("lastId");
        TableCnh instance = new TableCnh();
        int result = instance.lastId();
        if(result == 0){
            fail("The test case is a prototype.");
        }
    }



    
}
