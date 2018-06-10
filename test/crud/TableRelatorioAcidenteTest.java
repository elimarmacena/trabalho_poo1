/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contribuidor;
import model.RelatorioAcidente;
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
        System.out.println("cadastar");
        TableRelatorioAcidente instance = new TableRelatorioAcidente();
        //instanciando o contribuidor do realtorio
        Contribuidor contribuidor = new Contribuidor();
        //setando as informacoes basicas de contribuidor
        contribuidor.setCpf("777777777-77");
        contribuidor.setNome("raffa moreira mano");
        contribuidor.setSexo("m");
        contribuidor.setOrgaoAssociado("fxnxndx");
        //
        //criando e setando o objeto RG
        Rg rgComplete = new Rg();
        rgComplete.setEstado("SP");
        rgComplete.setOrgaoEmissor("LEAN");
        rgComplete.setNumRg("7777777-SP");
        contribuidor.setRg(rgComplete);
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1990, 7, 7);
        contribuidor.setDataNascimento(nascimento.getTime());
        //
        
        //instanciando o relatorio
        RelatorioAcidente informacao = new RelatorioAcidente();
        informacao.setAuxiliador(contribuidor);
        informacao.setCondutor("bilbo");
        informacao.setNumCnh("333333333333");
        informacao.setNumOcupantes(2);
        informacao.setPlaca("PPX-0000");
        informacao.setTipoAcidente("derrapagem seguido de capotagem");
        
        try {
            instance.cadastar(informacao);
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            fail("erro ao inserir o dado na tabela RELATORIO_ACIDENTE.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
    
}
