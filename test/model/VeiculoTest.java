/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author 20161bsi0314
 */
public class VeiculoTest {
    
    public VeiculoTest() {
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
     * Test of getChassi method, of class Veiculo.
     */
    
    /*ADICIONAR AS NOVAS FUNCOES PARA ELABORACAO DOS TESTES*/
    @Test
    public void testEnvioDados() {
    //escrevendo o dado
    String placaEsperada = "PPX-4321"; 
    Veiculo tVeiculo = new Veiculo();
    tVeiculo.setPlaca(placaEsperada);
    tVeiculo.envioDados();

    //verificacao do dado escrito
    BufferedReader bufferLeitura = null;
    String linha = "";
    String[] vetLinha = null;
    try {
            bufferLeitura = new BufferedReader( new FileReader(".\\dados_viagem.csv") );
            linha = bufferLeitura.readLine();
            vetLinha = linha.split(";");
            assertEquals(placaEsperada, vetLinha[4]);
    }
    catch(IOException rd) {
            rd.printStackTrace();
    }
    finally {
            try{
                    bufferLeitura.close();
            }
            catch(IOException cl) {
                    cl.printStackTrace();
            }
    }
}
    
}
