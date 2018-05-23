package test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import sistema.Veiculo;

class TestVeiculo {
	
	@Test
	public void testEnvioDados() {
		//escrevendo o dado
		String placaEsperada = "PPX-4321"; 
		Veiculo tVeiculo = new Veiculo();
		tVeiculo.setPlaca(placaEsperada);
		tVeiculo.envioDados();
		
		//verificacao do dado escrito
		BufferedReader bufferLeitura = null;
		String linha = "";
		String[] vetLinha = null;
		try {
			bufferLeitura = new BufferedReader( new FileReader(".\\dados_viagem.csv") );
			linha = bufferLeitura.readLine();
			vetLinha = linha.split(";");
			assertEquals(placaEsperada, vetLinha[4]);
		}
		catch(IOException rd) {
			rd.printStackTrace();
		}
		finally {
			try{
				bufferLeitura.close();
			}
			catch(IOException cl) {
				cl.printStackTrace();
			}
		}
	}

}
