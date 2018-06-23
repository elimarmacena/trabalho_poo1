/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import model.*;
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
public class TableCadastroTest {
    
    public TableCadastroTest() {
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
     * Test of createTable method, of class TableCadastro.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableCadastro instance = new TableCadastro();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falha ao criar tabela cadastro.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao foi encontrada.");;
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }


    /**
     * Test of cadastar method, of class TableCadastro.
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar() {
        System.out.println("cadastar");
        TableCadastro tbCadastro = new TableCadastro();
        Pessoa informacao = new Funcionario();
        //setando informacoes basicas de pessoa
        informacao.setCpf("821688047-29");
        informacao.setNome("Carolina Sarah Regina Oliveira");
        informacao.setSexo("f");
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        informacao.setDataNascimento(Utilitarios.strDate("1990-05-25"));
        //
        //instanciando informacoes referentes ao rg
        informacao.setEstadorg("ES");
        informacao.setNumeroRg("42185922-2");
        //
        
        try{
            tbCadastro.cadastar((Pessoa)informacao);
            //>>>>>>>>>FALAR COM PROFESSOR<<<<<<<<<<<<<<
            //ESTA FUNCIONANDO, POREM NO VISUALIZADOR DO NETBEANS NAO MOSTRA OS VALORES DA TABELA
            //JA TESTEI EM OUTROS AMBIENTES E ESTA TUDO CORRETO 
            
        }
        catch(SQLException sqlerr){
            fail("erro ao inserir o dado na tabela CADASTRO.");
        }
        catch(ClassNotFoundException clserr){
            fail("biblioteca sqlite nao encontrada.");
        }
        
    }    

    /**
     * Test of lastId method, of class TableCadastro.
     */
    @Test
    public void testLastId() {
        System.out.println("lastId");
        TableCadastro instance = new TableCadastro();
        int result = instance.lastId();
        if(result == 0){
            fail("The test case is a prototype.");
        }
    }
}
