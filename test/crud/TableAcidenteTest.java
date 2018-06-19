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
     * Test of cadastar method, of class TableAcidente.
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableAcidente instance = new TableAcidente();
        
        //instanciando veiculo para classe acidente
        Veiculo car = new Veiculo();
        //setando informacoes do veiculo
        car.setAno(2018);
        car.setRenavam("24249387031");
        car.setCor("preto");
        car.setMarca("Jeep");
        car.setModelo("Renegade");
        car.setPlaca("LAN-7777");
        //
        //instanciando condutor para classe condutor
        Condutor condutor = new Condutor();
        Cnh cnh = new Cnh();
        //setando informacoes da CNH
        cnh.setNumCnh("39770613360");
        cnh.setCategoria("A");
        condutor.setCnh(cnh);
        //
        //setando as informacoes basicas de contribuidor
        condutor.setCpf("748145697-69");
        condutor.setNome("Patrícia Evelyn Eliane Baptista");
        condutor.setSexo("F");
        //
        //informacoes sobre o rg
       condutor.setNumeroRg("30246102-4");
       condutor.setEstadorg("ES");
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1985, 11, 21); //ANO, MES, DIA
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
        double[] localizacao = new double[2];
        localizacao[0] = 37.806312;
        localizacao[1] = -122.475768;
        acidente.setLocalizacao(localizacao);
        //
        acidente.setDescricao("derrapagem seguido de capotagem");
        
        
        try {
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




}
