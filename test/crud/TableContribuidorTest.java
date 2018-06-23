/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
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
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar(){
        System.out.println("cadastar");
        TableContribuidor instance = new TableContribuidor();
        Contribuidor informacao = new Contribuidor();
        //setando as informacoes basicas de contribuidor
        informacao.setCpf("183750627-23");
        informacao.setNome("Isabella Mariah Sales");
        informacao.setSexo("F");
        informacao.setOrgaoAssociado("APERJ");
        //
        //informacoes sobre o rg
       informacao.setNumeroRg("27948313-2");
       informacao.setEstadorg("RJ");
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        informacao.setDataNascimento(Utilitarios.strDate("1968-10-19"));
        //
        
        try {
            instance.cadastar(informacao);
        } 
        catch (SQLException ex) {
            fail("erro ao inserir o dado na tabela CONTRIBUIDOR.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
    }

    /**
     * Test of idByNameAndOrgao method, of class TableContribuidor.
     */
    @Test
    public void testIdByNameAndOrgao() throws Exception {
        System.out.println("idByNameAndOrgao");
        String name = "Mateus Fernandes Melo";
        String orgao = "POLICIA FEDERAL";
        TableContribuidor instance = new TableContribuidor();
        int result = instance.idByNameAndOrgao(name, orgao);
        if (result != 1 ){ //id esperado da funcao
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of lastId method, of class TableContribuidor.
     */
    @Test
    public void testLastId() {
        System.out.println("lastId");
        TableContribuidor instance = new TableContribuidor();
        int result = instance.lastId();
        if (result == 0){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of recuperarContribuidores method, of class TableContribuidor.
     */
    @Test
    public void testRecuperarContribuidores() throws Exception {
        System.out.println("recuperarContribuidores");
        TableContribuidor instance = new TableContribuidor();
        ArrayList<Contribuidor> result = null;
        result = instance.recuperarContribuidores();
        if (result == null){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of restaurarById method, of class TableContribuidor.
     */
    @Test
    public void testRestaurarById() throws Exception {
        System.out.println("restaurarById");
        int idContribuidor = 1;
        TableContribuidor instance = new TableContribuidor();
        Contribuidor result = instance.restaurarById(idContribuidor);
        if ( !result.getNome().equals("Mateus Fernandes Melo") ){
            fail("The test case is a prototype.");
        }
    }
    
}
