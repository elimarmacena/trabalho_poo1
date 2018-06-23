/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;
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
public class TableFuncionarioTest {
    
    public TableFuncionarioTest() {
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
     * Test of createTable method, of class TableFuncionario.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableFuncionario instance = new TableFuncionario();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falha ao criar a tabela funcionario.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cadastar method, of class TableFuncionario.
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableFuncionario instance = new TableFuncionario();
        Funcionario informacao = new Funcionario();
        //setando informacoes basicas de funcionario
        informacao.setSenha("JUnit123");
        informacao.setCpf("128406532-49");
        informacao.setNome("Letícia Andrea Teixeira");
        informacao.setSexo("f");
        //
        
        informacao.setDataNascimento(Utilitarios.strDate("1991-3-22"));
        //
        //setando informacoes do rg
        informacao.setNumeroRg("27978279-2");
        informacao.setEstadorg("AC");
        //
        
        try {
            instance.cadastar((Funcionario)informacao);
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            fail("erro ao inserir o dado na tabela FUNCIONARIO.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
    }

    /**
     * Test of recuperarFuncionarios method, of class TableFuncionario.
     */
    @Test
    public void testRecuperarFuncionarios() throws Exception {
        System.out.println("recuperarFuncionarios");
        TableFuncionario instance = new TableFuncionario();
        ArrayList<Funcionario> result = null;
        result = instance.recuperarFuncionarios();
        if (result == null){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of recuperarLike method, of class TableFuncionario.
     */
    @Test
    public void testRecuperarLike() throws Exception {
        System.out.println("recuperarLike");
        String like = "r";
        TableFuncionario instance = new TableFuncionario();
        ArrayList<Funcionario> result = null;
        result = instance.recuperarLike(like);
        if (result == null){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of removerFuncionario method, of class TableFuncionario.
     */
    @Test
    public void testRemoverFuncionario() {
        System.out.println("removerFuncionario");
        Funcionario funcionario = new Funcionario();
        funcionario.setCampoIdentificacao(1);
        TableFuncionario instance = new TableFuncionario();
        try{
            instance.removerFuncionario(funcionario);
        }
        catch(Exception err){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of AtivarFuncionario method, of class TableFuncionario.
     */
    @Test
    public void testAtivarFuncionario(){
        System.out.println("AtivarFuncionario");
        Funcionario funcionario = new Funcionario();
        funcionario.setCampoIdentificacao(1);
        TableFuncionario instance = new TableFuncionario();
        try{
            instance.AtivarFuncionario(funcionario);
        }
        catch(Exception er){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of updateDados method, of class TableFuncionario.
     */
    @Test
    public void testUpdateDados() {
        System.out.println("updateDados");
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Joao Paulo da Silva");
        funcionario.setNumeroRg("35821731-3");
        funcionario.setEstadorg("SP");
        funcionario.setDataNascimento(Utilitarios.strDate("1938-03-18"));
        funcionario.setSexo("m");
        funcionario.setCpf("466461086-68");
        funcionario.setCampoIdentificacao(1);
        funcionario.setSenha("testeteste");
        TableFuncionario instance = new TableFuncionario();
        try{
            instance.updateDados(funcionario);
        }
        catch(Exception err){
            fail("The test case is a prototype.");
        }
        
    }

    /**
     * Test of checkLogin method, of class TableFuncionario.
     */
    @Test
    public void testCheckLogin() throws Exception {
        System.out.println("checkLogin");
        String login = "855937020-88";
        String senha = "sys123";
        TableFuncionario instance = new TableFuncionario();
        Funcionario result = null;
        result = instance.checkLogin(login, senha);
        if(result == null){
            fail("The test case is a prototype.");
        }
    }

    
    
}
