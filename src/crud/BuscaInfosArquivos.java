package crud;

import model.Acidente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BuscaInfosArquivos {

    public static ArrayList<Acidente> getInfosAcidentes(){
        ArrayList<Acidente> acidentesInformados = null; //lista onde os acidentes encontrados sera guardado
        String[] vetLinha = null;
        BufferedReader bufferLeitura = null;
        String linha = "";
        try {
            acidentesInformados =  new ArrayList<Acidente>();
            bufferLeitura = new BufferedReader(new FileReader (".\\acidentes_info.csv") );
            while( ( linha = bufferLeitura.readLine() ) != null) {
                Acidente acidenteX = new Acidente();
                vetLinha = linha.split(";");//INDEX 0 NOME AUXILIADOR | INDEX 1 ORGAO DO AUXLIADOR | INDEX 2 PLACA
                //INDEX 3 OCUPANTES | INDEX 4 NUM CNH | INDEX 5 AO 9 TIPO ACIDENTE | INDEX 9 DATA
                acidenteX.setPlaca(vetLinha[2]); //atribui a placa do veiculo
                acidenteX.setOcupantes( Integer.parseInt( vetLinha[3] ) ); //atribui a quantidade de ocupantes
                acidenteX.setNumCnhCondutor( Integer.parseInt(vetLinha[4]) );//atribui o numero da cnh do condutor
                acidenteX.setSaidaPista( vetLinha[5].equals("true") );//atribui tipo acidente
                acidenteX.setDerrapagem( vetLinha[6].equals("true") );//*
                acidenteX.setCapotagem( vetLinha[7].equals("true") );//*
                acidenteX.setColisao( vetLinha[8].equals("true") );//*
                DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//atribui a data do acidente

                try {
                    acidenteX.setData( formato.parse(vetLinha[9]) );//funcao que transorma uma string em data seguindo um
                                                                    //determinado modelo expecificado ao criar o formato de data
                } catch (ParseException dt) {
                    dt.printStackTrace();
                } 
                acidentesInformados.add(acidenteX);
            }
        }
        catch(IOException rd) {
            rd.printStackTrace();
        }
        finally {
            try {
                bufferLeitura.close();
            }
            catch(IOException w) {
                w.printStackTrace();
            }
        }
        return acidentesInformados;
    }

    public static ArrayList<Acidente> cruzarInfoVeiculo(ArrayList<Acidente> acidentes){
    //funcao que traca as informacoes recebidas sobre acidentes e interliga com os dados enviados 
    //pelo veiculo em sua viagem de momentos antes do acidente propriamente dito
        BufferedReader bufferLeitura = null;
        String[] vetLinha = null;
        String linha = "";
            try {
                bufferLeitura = new BufferedReader( new FileReader(".\\dados_viagem.csv") );
                while ( ( linha = bufferLeitura.readLine() ) != null) {
                    vetLinha = linha.split(";");//INDEX 0 VELOCIDADE | INDEX 1 LATITUDE | INDEX 2 LONGITUDE | INDEX 3 DATA | INDEX 4 PLACA
                    for (Acidente acidenteX :acidentes) {
                            if( vetLinha[4].equals( acidenteX.getPlaca() ) ) {
                                    double [] localizacacao = new double[2];
                                    acidenteX.setVelocidade( Integer.parseInt(vetLinha[0]) );//atribui velocidade do veiculo
                                    localizacacao[0] =Double.parseDouble(vetLinha[1]);//atribui a localizacao do veiculo
                                    localizacacao[1] =Double.parseDouble(vetLinha[2]);//atribui a localizacao do veiculo
                                    acidenteX.setLocalizacao(localizacacao);//atribui a localizacao do veiculo
                            }
                    }
                }
            }
            catch(IOException r) {
                r.printStackTrace();
            }
            try {
                bufferLeitura.close();
            }
            catch(IOException c) {
                c.printStackTrace();
            }
        return acidentes;
    }
}
