package model;

import java.util.Date;
import java.util.Scanner;

public abstract class Pessoa {
    private String nome;
    private Date dataNascimento;
    private String sexo;
    private String numCpf;
    private Rg rg;

    
    /* Gets e Sets */
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if(sexo.length() == 1 && (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F"))) {
            this.sexo = sexo;
        }
        else {
            System.out.println("Entrada invalida\nInforme (M)asculino ou (F)eminino: ");
            Scanner scan = new Scanner(System.in);
            String tentativaSexo = scan.nextLine();
            setSexo(tentativaSexo);
        }
    }

    public Rg getRg() {
        return rg;
    }

    public void setRg(Rg rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return numCpf;
    }

    public void setCpf(String cpf) { //EXEMPLO CPF: 123456789-10 (length 12)
        if(cpf.length() != 12) {
            System.out.println("Entrada invalida\nO campo CPF deve conter 12 caracteres\nInsira novamente o CPF: ");
            Scanner scan = new Scanner(System.in);
            String tentativaCPF = scan.nextLine();
            setCpf(tentativaCPF);
        }
        else {
            this.numCpf = cpf;
        }
    }  
}
