/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
     * TODA VEZ QUE TESTAR ESSE METODO INFORMAR DADOS QUE AINDA NAO FAZEM PARTE DO BANCO DE DADOS POIS ELE FOI MOLDADO DESSA FORMA,
     * CASO NAO SEJA SEGUIDO ESSE PADRAO O TESTE IRÁ DISPARAR ERRO
     */
    @Test
    public void testCadastar()  {
        System.out.println("cadastar");
        TableDadosRotina instance = new TableDadosRotina();
        TableVeiculo tbVeiculo = new TableVeiculo();
        DadosRotina informacao = new DadosRotina();
        Veiculo car = new Veiculo();
        //setando informacoes do veiculo
        car.setAno(2015);
        car.setRenavam("83844990836");
        car.setCor("Branco");
        car.setMarca("BMW");
        car.setModelo("225i Active Tourer Sport 2.0 TB Aut.");
        car.setPlaca("MQX-6834");
        //setando dados rotina
        informacao.setVeiculo(car);
        informacao.setVelocidade(80);
        //
        //vetor de localizacao
        informacao.setLatitude(36.6780334);
        informacao.setLongitude(-121.6442384);
        //
        //setando data do envio
        Date data = new Date();
        informacao.setDataColeta(data);
        //
        try {
            tbVeiculo.cadastar(car); //pois o veiculo deve ser cadastrado para que possa ser feita o link entre os dados
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

    /**
     * Test of recuperarDadosRotina method, of class TableDadosRotina.
     */
    @Test
    public void testRecuperarDadosRotina() throws Exception {
        System.out.println("recuperarDadosRotina");
        TableDadosRotina instance = new TableDadosRotina();
        ArrayList<DadosRotina> result = null;
        result = instance.recuperarDadosRotina();
        if (result == null){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of recuperarByPlaca method, of class TableDadosRotina.
     */
    @Test
    public void testRecuperarByPlaca() throws Exception {
        System.out.println("recuperarByPlaca");
        String placa = "PPX-0000";
        TableDadosRotina instance = new TableDadosRotina();
        DadosRotina result = instance.recuperarByPlaca(placa);
        if (result.getCampoIdentificacao() !=  4){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of updateDados method, of class TableDadosRotina.
     */
    @Test
    public void testUpdateDados(){
        System.out.println("updateDados");
        DadosRotina dados = new DadosRotina();
        dados.setDataColeta(Utilitarios.strDate("1999-9-9"));
        dados.setLatitude(1);
        dados.setLongitude(1);
        dados.setVelocidade(1000);
        Veiculo vi = new Veiculo();
        vi.setCampoIdentificacao(1); //so eh necessario o id do veiculo para que possa ser feito o updade.
        dados.setVeiculo(vi);
        TableDadosRotina instance = new TableDadosRotina();
        try{
            instance.updateDados(dados);
        }
        catch(SQLException sErr){
            fail("falha nos dados passados");
        }
        catch(ClassNotFoundException cErr){
            fail ("biblioteca sqlite nao encontrada");
        }
    }
}
