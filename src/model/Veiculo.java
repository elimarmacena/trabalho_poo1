package model;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Veiculo {
    private String renavam;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    //proprietario pode ser indicado na classe condutor, uma vez que ele só cadastrado caso o acidente aconteca
    /*private Condutor proprietario;
    private ArrayList<Condutor> condutores; //Lista de condutores
    private Acidente acontecimento;/*
    //Nao eh o acidente que esta relacionado com o veiculo e sim o veiculo com acidente, sendo o veiculo q eh referenciado pelo acidente, nao o contrario.
    */

    
    /* Gets e Sets*/
    public String getRenavam() {
        return this.renavam;
    }

    public void setRenavam(String renavam) {
        if(renavam.length() != 11) {
            System.out.println("Entrada invalida\nInforme RENAVAM válido: ");
            Scanner scan = new Scanner(System.in);
            String tentativaRenavam = scan.nextLine();
            setRenavam(tentativaRenavam);
        }
        else {
            this.renavam = renavam;
        }
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) { //exemplo considerado: PLA-0000
        if(placa.length() != 8) {
            System.out.println("Entrada invalida\nInforme RG válido: ");
            Scanner scan = new Scanner(System.in);
            String tentativaPlaca = scan.nextLine();
            setPlaca(tentativaPlaca);
        }
        else {
            this.placa = placa;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    
}

