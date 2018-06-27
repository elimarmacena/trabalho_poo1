package model;

import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public abstract class Pessoa {
    private String nome;
    private Date dataNascimento;
    private String sexo;
    private String numCpf;
    private String numeroRg;
    private String estadorg;

    
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
            
            String tentativaSexo = JOptionPane.showInputDialog("Entrada invalida\\nInforme (M)asculino ou (F)eminino: " );
            /*System.out.println("Entrada invalida\nInforme (M)asculino ou (F)eminino: ");
            Scanner scan = new Scanner(System.in);
            String tentativaSexo = scan.nextLine();*/
            setSexo(tentativaSexo);
        }
    }

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getEstadorg() {
        return estadorg;
    }

    public void setEstadorg(String estadorg) {
        this.estadorg = estadorg;
    }

    public String getCpf() {
        return numCpf;
    }

    public void setCpf(String cpf) { //EXEMPLO CPF: 123456789-10 (length 12)
        while(cpf.length() != 12) {
            cpf = JOptionPane.showInputDialog("Entrada invalida\nO campo CPF deve conter 12 caracteres\nInsira novamente o CPF: " );
        }
		this.numCpf = cpf;
    }  
}
