/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import model.Pessoa;
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
     */
    @Test
    public void testCadastar() {
        System.out.println("cadastar");
        TableCadastro tbCadastro = new TableCadastro();
        Pessoa informacao = new Funcionario();
        //setando informacoes basicas de pessoa
        informacao.setCpf("111222333-44");
        informacao.setNome("joao paulo");
        informacao.setSexo("m");
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1990, 5, 25);
        informacao.setDataNascimento(nascimento.getTime());
        //
        //criando e setando o objeto RG
        Rg rgComplete = new Rg();
        rgComplete.setEstado("ES");
        rgComplete.setOrgaoEmissor("POLICIA FEDERAL");
        rgComplete.setNumRg("9999999-ES");
        informacao.setRg(rgComplete);
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
}
