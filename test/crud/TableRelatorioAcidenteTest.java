/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import model.Contribuidor;
import model.RelatorioAcidente;
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
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar() {
        System.out.println("cadastar");
        TableRelatorioAcidente instance = new TableRelatorioAcidente();
        //instanciando o contribuidor do realtorio
        Contribuidor contribuidor = new Contribuidor();
        //setando as informacoes basicas de contribuidor
        contribuidor.setCpf("137904782-02");
        contribuidor.setNome("Mateus Fernandes Melo");
        contribuidor.setSexo("m");
        contribuidor.setOrgaoAssociado("POLICIA FEDERAL");
        //
        //setando informacoes referente ao RG
        contribuidor.setEstadorg("SP");
        contribuidor.setNumeroRg("45788698-5");
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1982, 9, 8);
        contribuidor.setDataNascimento(nascimento.getTime());
        //
        
        //instanciando o relatorio
        
        
        RelatorioAcidente informacao = new RelatorioAcidente();
        informacao.setLatitude(36.6780334);
        informacao.setLongitude(-121.7442384);
        informacao.setAuxiliador(contribuidor);
        informacao.setNomeCondutor("Patrícia Evelyn Eliane Baptista");
        informacao.setNumCnh("39770613360");
        informacao.setNumOcupantes(2);
        informacao.setPlaca("MQX-6834");
        informacao.setDescricao("derrapagem seguido de capotagem");
        //setando dia e hora do acidente
        Calendar horarioAcidente = Calendar.getInstance();
        horarioAcidente.set(2018,6,19);
        horarioAcidente.set(Calendar.HOUR,18);
        horarioAcidente.set(Calendar.MINUTE,47);
        horarioAcidente.set(Calendar.SECOND,0);
        //
        informacao.setData(horarioAcidente.getTime());
        
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

    /**
     * Test of recuperarRelatorios method, of class TableRelatorioAcidente.
     */
    @Test
    public void testRecuperarRelatorios() throws Exception {
        System.out.println("recuperarRelatorios");
        TableRelatorioAcidente instance = new TableRelatorioAcidente();
        ArrayList<RelatorioAcidente> result = null;
        result = instance.recuperarRelatorios();
        if(result == null){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of deletarRelatorio method, of class TableRelatorioAcidente.
     */
    @Test
    public void testDeletarRelatorio()  {
        System.out.println("deletarRelatorio");
        int idRelatorio = 1;
        TableRelatorioAcidente instance = new TableRelatorioAcidente();
        try{
            instance.deletarRelatorio(idRelatorio);
        }
        catch(Exception err){
            fail("The test case is a prototype.");
        }
    }

   
    
}
