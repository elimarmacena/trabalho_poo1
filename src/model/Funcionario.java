package model;

import java.util.ArrayList;
import java.util.Scanner;
import crud.BuscaInfosArquivos;
import crud.CadastramentosArquivos;

public class Funcionario extends Pessoa {
    private String login;
    private String senha; //ESSA NAO EH A TIPAGEM FINAL, APENAS USADA PARA A FORMACAO DO TRABALHO.
    
    
    /* Gets e Sets*/
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if(login.length() < 4 || login.length() > 20) { //o login deve 4 < login < 20
            System.out.println("O login precisa conter entre 4 e 20 caracteres\nInsira login válido: ");
            Scanner scan = new Scanner(System.in);
            String tentativaLogin = scan.nextLine();
            setLogin(tentativaLogin);
        }
        else {
            this.login = login;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha.length() < 6 || senha.contains(" ")) {
            System.out.println("A senha deve conter no mínimo 6 caracteres\nInsira senha válida: ");
            Scanner scan = new Scanner(System.in);
            String tentativaSenha = scan.nextLine();
            setSenha(tentativaSenha);  
        }
        else {
            this.senha = senha;
        }
    }

    public void cadastroFuncionario(Funcionario funcionario) {
        CadastramentosArquivos.cadastroFuncionario(funcionario);
    }
        
    public void cadastroCondutor(Condutor condutor) {
        CadastramentosArquivos.cadastroCondutor(condutor);
    }

    /*public void cadastroTitularVeiculo(Titular titular) {
    CadastramentosArquivos.cadastroTitularVeiculo(titular);
    }*/

    public void cadastroAcidente() {
        //verifica os acidentes informados por terceiros e eh feita uma intersecao entre a base de dados de informacoes de terceiro
        //e a base de dados enviadas pelo odb do veiculo, assim efetuando o preenchimento do banco de dados final com os acidentes propriamente dito
        ArrayList<Acidente> acidentesRegistrados = null; //lista onde os acidentes encontrados sera guardado
        acidentesRegistrados = BuscaInfosArquivos.getInfosAcidentes();
        //nesta parte apenas as seguintes informacoes estao dispostas no objeto acidente
        //placa, ocupante, numero cnh, tipo acidente e data
        acidentesRegistrados = BuscaInfosArquivos.cruzarInfoVeiculo(acidentesRegistrados);
        //neste momento atribui-se as informacoes restantes para o cadastro de um acidente
        //velocidade, localizacao.
        for (Acidente acidenteX : acidentesRegistrados) {
            //adiciona os acidentes registrados ate o momento ao banco de dados.
            CadastramentosArquivos.cadastroAcidentes(acidenteX);
        }
    }
}


