
package model;

import java.util.Date;

public class RelatorioAcidente {
    private int campoIdentificacao;
    private String placa;
    private String nomeCondutor; ////nome do condutor
    private String numCnh;
    private int numOcupantes;
    private String descricao;
    private Contribuidor auxiliador;
//informacoes necessarias para o cruzamento de informacoes
    private double latitude;
    private double longitude;
    private Date data;
//fim
 
    
    
    

    /* Gets e Sets */
    public int getCampoIdentificacao() {
        return campoIdentificacao;
    }
    
    public void setCampoIdentificacao(int campoIdentificacao) {
        this.campoIdentificacao = campoIdentificacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public void setNomeCondutor(String nome) {
        this.nomeCondutor = nome;
    }

    public int getNumOcupantes() {
        return numOcupantes;
    }

    public void setNumOcupantes(int numOcupantes) {
        this.numOcupantes = numOcupantes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Contribuidor getAuxiliador() {
        return auxiliador;
    }

    public void setAuxiliador(Contribuidor auxiliador) {
        this.auxiliador = auxiliador;
    }
    public String getNumCnh() {
        return numCnh;
    }

    public void setNumCnh(String numCnh) {
        this.numCnh = numCnh;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }



    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
