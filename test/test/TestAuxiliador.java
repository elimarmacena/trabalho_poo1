package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.AuxiliadorExterno;
class TestAuxiliador {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

        
        
        
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEnvioInfoAcidente() {
		//informacoes para escrita
		String auxEsperado = "joaozin";
		AuxiliadorExterno tAuxiliador = new AuxiliadorExterno();
		tAuxiliador.setNome(auxEsperado);
		tAuxiliador.setOrgaoAssociado("samu");
		tAuxiliador.envioInfoAcidente("PPX-4111", 2, 333442, new Date());
		
		//confirmacao da escrita no arquivo
		BufferedReader bufferLeitura = null;
		String linha = "";
		String[] vetLinha= null;
		try {
			bufferLeitura = new BufferedReader(new FileReader(".\\acidentes_info.csv") );
			linha = bufferLeitura.readLine();
			vetLinha = linha.split(";");
			assertEquals(auxEsperado,vetLinha[0]);
		}
		catch(IOException rd) {
			rd.printStackTrace();
		}
		finally {
			try {
				bufferLeitura.close();
			}
			catch(IOException c) {
				c.printStackTrace();
			}
		}
	}

}
