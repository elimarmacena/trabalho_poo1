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
import model.Acidente;
import model.Cnh;
import model.Condutor;
import model.Rg;
import model.Veiculo;
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
        car.setChassi("A44433FBD33R30J83");
        car.setCor("preto");
        car.setMarca("jeep");
        car.setModelo("renegade");
        car.setPlaca("LAN-7777");
        //
        //instanciando condutor para classe condutor
        Condutor condutor = new Condutor();
        Cnh cnh = new Cnh();
        //setando informacoes da CNH
        cnh.setNumCnh("77777777777");
        cnh.setCategoria("B");
        condutor.setCnh(cnh);
        //
        //setando as informacoes basicas de contribuidor
        condutor.setCpf("557777755-77");
        condutor.setNome("paulo antonio");
        condutor.setSexo("m");
        //
        //criando e setando o objeto RG
        Rg rgComplete = new Rg();
        rgComplete.setEstado("PR");
        rgComplete.setOrgaoEmissor("LEAN");
        rgComplete.setNumRg("7777337-PR");
        condutor.setRg(rgComplete);
        //
        //setando data de nascimento fazendo uso de calendar e apos solicitando Date
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(1990, 7, 7);
        condutor.setDataNascimento(nascimento.getTime());
        //
        Acidente informacao = new Acidente();
        //setando informacoes acidente
        informacao.setCondutor(condutor);
        informacao.setVeiculo(car);
        informacao.setOcupantes(2);
        informacao.setVelocidade(80);
        Date data = new Date();
        informacao.setData(data);
        //vetor de localizacao
        double[] localizacao = new double[2];
        localizacao[0] = 37.806312;
        localizacao[1] = -122.475768;
        informacao.setLocalizacao(localizacao);
        //
        informacao.setDescricao("derrapagem seguido de capotagem");
        
        
        try {
            instance.cadastar(informacao);
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            fail("falha ao inserir dado na table ACIDENTE.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
        // TODO review the generated test code and remove the default call to fail.
        
    }




}
