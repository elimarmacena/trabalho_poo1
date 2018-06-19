
package model;

import java.util.Date;

public class RelatorioAcidente {
    private String placa;
    private String nomeCondutor; ////nome do condutor
    private String numCnh;
    private int numOcupantes;
    private String descricao;
    private Contribuidor auxiliador;
//informacoes necessarias para o cruzamento de informacoes
    private double [] localizacao = new double[2];
    private Date data;
//fim
    
    
    /* Gets e Sets */ 
    
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

    public double[] getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(double[] localizacao) {
        this.localizacao = localizacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
