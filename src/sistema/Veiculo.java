package sistema;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by 20161bsi0314 on 11/04/2018.
 */
public class Veiculo {
    private String chassi;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private DonoVeiculo proprietario;
    private Condutor motorista;
    private Acidente acontecimento;

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        if(chassi.length() != 17) {
            System.out.println("Entrada invalida\nInforme RG válido: ");
            Scanner scan = new Scanner(System.in);
            String tentativaChassi = scan.nextLine();
            setChassi(tentativaChassi);
        }
        else {
            this.chassi = chassi;
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

    public DonoVeiculo getProprietario() {
        return proprietario;
    }

    public void setProprietario(DonoVeiculo proprietario) {
        this.proprietario = proprietario;
    }

    public Condutor getMotorista() {
        return motorista;
    }

    public void setMotorista(Condutor motorista) {
        this.motorista = motorista;
    }

    public Acidente getAcontecimento() {
        return acontecimento;
    }

    public void setAcontecimento(Acidente acontecimento) {
        this.acontecimento = acontecimento;
    }
    
}

