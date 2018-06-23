/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import model.OcorrenciaAcidente;
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
public class TableOcorrenciaAcidenteTest {
    
    public TableOcorrenciaAcidenteTest() {
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
     * Test of createTable method, of class TableOcorrenciaAcidente.
     */
    @Test
    public void testCreateTable()  {
        System.out.println("createTable");
        TableOcorrenciaAcidente instance = new TableOcorrenciaAcidente();
        try{
        instance.createTable();
        } 
        catch (SQLException ex) {
            fail("falha ao criar a tabela funcionario.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
    }

    /**
     * Test of cadastar method, of class TableOcorrenciaAcidente.
     */
    @Test
    public void testCadastar()  {
       /*OS TESTE REFERENTES A INSERCAO DE UMA OCORRENCIA NO BANCO DE DADOS ACONTECE NO ARQUIVO
        TableAcidenteTest.java UMA VEZ QUE PARA A CONSOLIDACAO DE UM ACIDENTE NO SISTEMA
        EH NECESSARIO OCORRENCIAS REFERENCIADO OS VEICULOS E CONDUTORES QUE NELE ESTAO 
        ENVOLVIDOS*/
    }

    /**
     * Test of getOcorrenciaByAcidenteId method, of class TableOcorrenciaAcidente.
     */
    @Test
    public void testGetOcorrenciaByAcidenteId() throws Exception {
        System.out.println("getOcorrenciaByAcidenteId");
        int idAcidente = 1;
        TableOcorrenciaAcidente instance = new TableOcorrenciaAcidente();
        ArrayList<OcorrenciaAcidente> result = null;
        result = instance.getOcorrenciaByAcidenteId(idAcidente);
        
        if (result == null ){
            fail("The test case is a prototype.");
        }
    }
    
}
