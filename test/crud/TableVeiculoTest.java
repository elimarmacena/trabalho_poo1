/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Veiculo;
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
public class TableVeiculoTest {
    
    public TableVeiculoTest() {
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
     * Test of createTable method, of class TableVeiculo.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableVeiculo instance = new TableVeiculo();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falha ao criar a tabela veiculo.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao foi encontrada.");
        }
        
        
    }



    /**
     * Test of cadastar method, of class TableVeiculo.
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableVeiculo instance = new TableVeiculo();
        Veiculo informacao = new Veiculo();
        //setando informacoes do veiculo
        informacao.setAno(2018);
        informacao.setRenavam("24249387031");
        informacao.setCor("preto");
        informacao.setMarca("Jeep");
        informacao.setModelo("Renegade");
        informacao.setPlaca("LAN-7777");
        
        try {
            instance.cadastar(informacao);
        } 
        catch (SQLException ex) {
            fail("falha ao inserir o dado na tabela VEICULO.");;
        }
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");;
        }
        
        
    }

    /**
     * Test of idByPlaca method, of class TableVeiculo.
     */
    @Test
    public void testIdByPlaca() {
        System.out.println("idByPlaca");
        String placa = "PPX-0000";
        TableVeiculo instance = new TableVeiculo();
        int result = instance.idByPlaca(placa);
        if(result == 0){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of recuperarById method, of class TableVeiculo.
     */
    @Test
    public void testRecuperarById() throws Exception {
        System.out.println("recuperarById");
        int idVeiculo = 1;
        TableVeiculo instance = new TableVeiculo();
        Veiculo result = instance.recuperarById(idVeiculo);
        if(!result.getPlaca().equals("PPX-0000")){
            fail("The test case is a prototype.");
        }
        
    }
}
