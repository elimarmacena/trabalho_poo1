/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DadosRotina;
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
public class TableDadosRotinaTest {
    
    public TableDadosRotinaTest() {
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
     * Test of createTable method, of class TableDadosRotina.
     */
    @Test
    public void testCreateTable() {
        System.out.println("createTable");
        TableDadosRotina instance = new TableDadosRotina();
        try {
            instance.createTable();
        } catch (SQLException ex) {
           fail("falha ao criar tabalea dados_rotina");
        } catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao foi encontrada.");
        }
        
        
    }

    /**
     * Test of cadastar method, of class TableDadosRotina.
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableDadosRotina instance = new TableDadosRotina();
        DadosRotina informacao = new DadosRotina();
        Veiculo car = new Veiculo();
        //setando informacoes do veiculo
        car.setAno(2018);
        car.setChassi("A44433FBD33R30J83");
        car.setCor("preto");
        car.setMarca("jeep");
        car.setModelo("renegade");
        car.setPlaca("LAN-7777");
        //
        //setando dados rotina
        informacao.setVeiculo(car);
        informacao.setVelocidade(80);
        //
        //vetor de localizacao
        double[] localizacao = new double[2];
        localizacao[0] = 37.806312;
        localizacao[1] = -122.475768;
        informacao.setLocalizacao(localizacao);
        //
        //setando data do envio
        Date data = new Date();
        informacao.setDataColeta(data);
        //
        try {
            instance.cadastar(informacao);
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            fail("erro ao inserir o dado na tabela DADOS_ROTINA.");
        } 
        catch (ClassNotFoundException ex) {
            fail("biblioteca sqlite nao encontrada.");
        }
    }
}
