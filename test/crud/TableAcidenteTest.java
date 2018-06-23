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
public class TableAcidenteTest {
    
    public TableAcidenteTest() {
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
     * Test of createTable method, of class TableAcidente.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableAcidente instance = new TableAcidente();
        try {
            instance.createTable();
        } catch (SQLException ex) {
            fail("falaha ao criar a table acidente.");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao foi encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of cadastar method, of class.  
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableAcidente instance = new TableAcidente();
        TableCondutor tbcondutor = new TableCondutor();
        //instanciando veiculo para classe acidente
        Veiculo car = new Veiculo();
        //setando informacoes do veiculo
        car.setAno(2003);
        car.setRenavam("01511364316");
        car.setCor("Cinza");
        car.setMarca("Audi");
        car.setModelo("RS6 4.2 Avant  BI-TB Quattro Tiptron. 5p");
        car.setPlaca("MQJ-8533");
        //
        //instanciando condutor para classe condutor
        Condutor condutor = new Condutor();
        Cnh cnh = new Cnh();
        //setando informacoes da CNH
        cnh.setNumCnh("22222856744");
        cnh.setCategoria("A,B,C");
        condutor.setCnh(cnh);
        //
        //setando as informacoes basicas de contribuidor
        condutor.setCpf("459246603-97");
        condutor.setNome("Carlos Eduardo Igor Benício Silveira");
        condutor.setSexo("M");
        //
        //informacoes sobre o rg
       condutor.setNumeroRg("21087373-5");
       condutor.setEstadorg("PR");
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1996, 12, 04); //ANO, MES, DIA
        condutor.setDataNascimento(nascimento.getTime());
        //instanciando ocorrencia de acidente
        OcorrenciaAcidente ocorrencia = new OcorrenciaAcidente();
        ocorrencia.setCondutor(condutor);
        ocorrencia.setVeiculo(car);
        ocorrencia.setCondutor_titular(true);
        ocorrencia.setVelocidade(90);
        //
        //instanciando objeto acidente
        ArrayList<OcorrenciaAcidente> ocorrenciasA = new ArrayList();
        ocorrenciasA.add(ocorrencia);
        Acidente acidente = new Acidente();
        //setando informacoes acidente
        
        acidente.setVeiculosEnvolvidos(ocorrenciasA);
        Date data = new Date();
        acidente.setData(data);
        acidente.setPessoasEnvolvidas(10);
        //vetor de localizacao
        acidente.setLatitude(37.806312);
        acidente.setLongitude(-122.475768);
        //
        acidente.setDescricao("engavetamento");
        
        
        try {
            tbcondutor.cadastar(condutor); //cadastro do novo condutor informado anteriormente
            instance.cadastar(acidente);
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            fail("falha ao inserir dado na table ACIDENTE.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        
        //AO CADASTRAR UM ACIDENTE DEVE-SE CADASTRAR JUNTAMENTE AS OCORRENCIAS LIGADAS AO MESMO
        try{
            TableOcorrenciaAcidente tbOcorrencia = new TableOcorrenciaAcidente();
            for (OcorrenciaAcidente item : ocorrenciasA){
                tbOcorrencia.cadastar(item);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            fail("falha ao inserir dado na table ACIDENTE.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        
        
    }

    /**
     * Test of lastId method, of class TableAcidente.
     */
    @Test
    public void testLastId() {
        System.out.println("lastId");
        TableAcidente instance = new TableAcidente();
        int result = instance.lastId();
        //assertEquals(expResult, result);
        if (result==0){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of recuperarAcidentes method, of class TableAcidente.
     */
    @Test
    public void testRecuperarAcidentes() throws Exception {
        System.out.println("recuperarAcidentes");
        TableAcidente instance = new TableAcidente();
        ArrayList<Acidente> result = null;
        result = instance.recuperarAcidentes();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result == null){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of acidentesByDate method, of class TableAcidente.
     */
    @Test
    public void testAcidentesByDate() throws Exception {
        System.out.println("acidentesByDate");
        Date dataInf = Utilitarios.strDate("2017-01-01");
        Date dataSup = Utilitarios.strDate("2018-12-12");
        TableAcidente instance = new TableAcidente();
        ArrayList<Acidente> result = null;
        result = instance.acidentesByDate(dataInf, dataSup);
        if (result == null){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of infosAcidenteMarca method, of class TableAcidente.
     */
    @Test
    public void testInfosAcidenteMarca() throws Exception {
        System.out.println("infosAcidenteMarca");
        String marca = "f";
        TableAcidente instance = new TableAcidente();
        ArrayList<Acidente> result = null;
        result = instance.infosAcidenteMarca(marca);
        if(result == null){
            fail("The test case is a prototype.");
        }
    }




}
