package crud;

import model.Condutor;
import model.Acidente;
import model.Funcionario;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastramentosArquivos {
    
    /* define formato data */
    public static String dataNascString(Date data) {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData.format(data);
    }
    
    public static String dataToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatoData.format(data);
    }
    
    /* cadastra o funcionario escrevendo no arquivo*/
    public static void cadastroFuncionario(Funcionario funcionario) {
        FileWriter arquivo = null;
        try {
            arquivo = new FileWriter(".\\funcionarios_cadastrados.csv",true);
            //INDEX 0 NOME; | INDEX 1 DATANASC; | INDEX 2 SEXO; | INDEX 3 CPF; | INDEX 4 RG; | INDEX 5 LOGIN; | INDEX 6 SENHA
            //numero rg vai servir como uma FK (chave estrangeira) na pratica para poder acessar as outras informacoes referente ao rg
            arquivo.append( funcionario.getNome()+ ";" );
            arquivo.append( dataNascString( funcionario.getDataNascimento() ) + ";" );
            arquivo.append(funcionario.getSexo() + ";");
            //arquivo.append(funcionario.getCpf()[0]+"-"+funcionario.getCpf()[1]+";"); @@ANTIGO
            arquivo.append(funcionario.getCpf() + ";");
            arquivo.append(funcionario.getRg().getNumRg() + ";");
            arquivo.append(funcionario.getLogin() + ";");
            arquivo.append(funcionario.getSenha() + "\n");
            arquivo.flush();
        }
        catch(IOException w) {
            w.printStackTrace();
        }
        finally {
            try {
                arquivo.close();
            }
            catch(IOException c) {
                c.printStackTrace();
            }
        }
    }
    
    /* cadastra condutor escrevendo no arquivo*/
    public static void cadastroCondutor(Condutor condutor) {
        FileWriter arquivo = null;
        try {
            arquivo = new FileWriter(".\\condutores_cadastrados.csv",true);
            //INDEX 0 NOME | INDEX 1 DATANASC |  INDEX 2 SEXO | INDEX 3 CPF | INDEX 4 NUMRG | INDEX 5 NUMCNH
            //numero chn vai servir como uma FK na pratica para poder acessar as informarcoes referentes a CNH
            //numero rg vai servir como uma FK na pratica para poder acessar as outras informacoes referente ao rg
            arquivo.append( condutor.getNome()+ ";" );
            arquivo.append( dataNascString( condutor.getDataNascimento() ) + ";" );
            arquivo.append(condutor.getSexo() + ";");
            //arquivo.append(condutor.getCpf()[0]+"-"+condutor.getCpf()[1]+";"); @@Antigo
            arquivo.append(condutor.getCpf() + ";");
            arquivo.append(condutor.getRg().getNumRg() + ";");
            arquivo.append(condutor.getCnh().getNumCnh() + "\n");
            arquivo.flush();
            }
        catch(IOException w) {
            w.printStackTrace();
        }
        finally {
            try {
                arquivo.close();
            }
            catch(IOException c) {
                c.printStackTrace();
            }
        }
    }
    
    /* cadastra titular do veiculo escrevendo no arquivo*/
    /*
    public static void cadastroTitularVeiculo(Titular titular) {
        FileWriter arquivo = null;
        try {
            arquivo = new FileWriter(".\\titulares_cadastrados.csv",true);
            //INDEX 0 NOME | INDEX 1 DATA | INDEX 2 SEXO | INDEX 3 CPF | INDEX 4 NUM RG
            //numero rg vai servir como uma FK na pratica para poder acessar as outras informacoes referente ao rg
            arquivo.append( titular.getNome()+ ";" );
            arquivo.append( dataNascString( titular.getDataNascimento() ) + ";" );
            arquivo.append(titular.getSexo() + ";");
            //arquivo.append(titular.getCpf()[0]+"-"+titular.getCpf()[1]+";"); @@Antigo
            arquivo.append(titular.getCpf() + ";");
            arquivo.append(titular.getRg().getNumRg() + "\n");
            arquivo.flush();
        }
        catch(IOException w) {
            w.printStackTrace();
    	}
    	finally {
            try {
                arquivo.close();
            }
            catch(IOException c) {
                c.printStackTrace();
            }
    	}
    }
    */
    /* cadastra acidentes escrevendo no arquivo*/
    public static void cadastroAcidentes(Acidente acidente) {
        FileWriter arquivo = null; 
        try {
            //INDEX 0 PLACA | INDEX 1 VELOCIDADE | INDEX 2 OCUPANTES | INDEX 3 LATITUDE | INDEX 4 LONGITUDE | INDEX 5 SAIDAPISTA 
            //INDEX 6 DERRAPAGEM | INDEX 7 CAPOTAGEM | INDEX 8 COLISAO | INDEX 9 DATA | INDEX NUMCNH
            //a placa sera usada para chegar no veiculo que por sua vez ira possuir mais informacoes para a geracao de relatorios
            //numero chn tambem usada para atrela insforma�oes complementares referente ao acidente.
            arquivo = new FileWriter(".\\acidentes_cadastrados.csv",true);
            arquivo.append(acidente.getPlaca() +";");
            arquivo.append(acidente.getVelocidade() + ";");
            arquivo.append(acidente.getOcupantes() + ";");
            arquivo.append(acidente.getLocalizacao()[0]+";"+acidente.getLocalizacao()[1]+";");
            arquivo.append(acidente.isSaidaPista()+";");
            arquivo.append(acidente.isDerrapagem()+";");
            arquivo.append(acidente.isCapotagem()+";");
            arquivo.append(acidente.isColisao()+";");
            arquivo.append(dataToString( acidente.getData() ) + ";");
            arquivo.append(acidente.getCnhCondutor() + "\n");
            arquivo.flush();
        }
        catch(IOException w) {
            w.printStackTrace();
        }
        finally {
            try {
                arquivo.close();
            }
            catch(IOException c) {
                c.printStackTrace();
            }
        }
    }
}

