/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Cnh;
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
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableCondutor instance = new TableCondutor();
        Condutor informacao = new Condutor();
         //instanciando Cnh para condutor
        Cnh cnh = new Cnh();
        //setando informacoes da CNH
        cnh.setNumCnh("39770613360");
        cnh.setCategoria("A");
        informacao.setCnh(cnh);
        //
        //setando as informacoes basicas de contribuidor
        informacao.setCpf("748145697-69");
        informacao.setNome("Patrícia Evelyn Eliane Baptista");
        informacao.setSexo("F");
        //
        //informacoes sobre o rg
       informacao.setNumeroRg("30246102-4");
       informacao.setEstadorg("ES");
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date       
        informacao.setDataNascimento(Utilitarios.strDate("1985-11-21"));
        //
        try {
            instance.cadastar(informacao);
        } 
        catch (SQLException ex) {
            fail("erro ao inserir os dados na tabela CONDUTOR.");;
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of idByNumCnh method, of class TableCondutor.
     */
    @Test
    public void testIdByNumCnh() throws Exception {
        System.out.println("idByNumCnh");
        String numCnh = "35113468463";
        TableCondutor instance = new TableCondutor();
        int result = instance.idByNumCnh(numCnh);
        if(result != 1){ //id referente a cnh passada
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of recuperarCondutoes method, of class TableCondutor.
     */
    @Test
    public void testRecuperarCondutoes() throws Exception {
        System.out.println("recuperarCondutoes");
        TableCondutor instance = new TableCondutor();
        ArrayList<Condutor> result = null;
        result = instance.recuperarCondutoes();
        if (result == null){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of restaurarById method, of class TableCondutor.
     */
    @Test
    public void testRestaurarById() throws Exception {
        System.out.println("restaurarById");
        int idCondutor = 1;
        TableCondutor instance = new TableCondutor();
        String expResult = "Haydee Harlin"; //nome referente ao id passado para teste
        Condutor result = instance.restaurarById(idCondutor);
        if (!result.getNome().equals(expResult)){
            fail("The test case is a prototype.");
        }
    }




    
}
