/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import model.Contribuidor;
class TestAuxiliador {
	
@BeforeClass
static void setUpBeforeClass() throws Exception {

}

        
@AfterClass
static void tearDownAfterClass() throws Exception {
}

@BeforeClass
void setUp() throws Exception {
}

@After
void tearDown() throws Exception {
}

@Test
void testEnvioInfoAcidente() {
    //informacoes para escrita
    String auxEsperado = "joaozin";
    Contribuidor tAuxiliador = new Contribuidor();
    tAuxiliador.setNome(auxEsperado);
    tAuxiliador.setOrgaoAssociado("samu");
    tAuxiliador.envioInfoAcidente("PPX-4111", 2, "333442", new Date());		
    //confirmacao da escrita no arquivo
    BufferedReader bufferLeitura = null;
    String linha = "";
    String[] vetLinha= null;
    try {
        bufferLeitura = new BufferedReader(new FileReader(".\\acidentes_info.csv") );
        linha = bufferLeitura.readLine();
        vetLinha = linha.split(";");
        assertEquals(auxEsperado,vetLinha[0]);
    }
    catch(IOException rd) {
        rd.printStackTrace();
    }
    finally {
        try {
            bufferLeitura.close();
        }
        catch(IOException c) {
            c.printStackTrace();
        }
    }
}
}
