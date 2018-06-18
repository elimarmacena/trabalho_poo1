package model;

import java.util.ArrayList;
import java.util.Date;

public class Acidente {
    private int pessoasEnvolvidas;
    private double[] localizacao = new double[2];
    private String descricao;
    private Date data;
    ArrayList<OcorrenciaAcidente> veiculosEnvolvidos;

    public int getPessoasEnvolvidas() {
        return pessoasEnvolvidas;
    }

    public void setPessoasEnvolvidas(int pessoasEnvolvidas) {
        this.pessoasEnvolvidas = pessoasEnvolvidas;
    }

    public double[] getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(double[] localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<OcorrenciaAcidente> getVeiculosEnvolvidos() {
        return veiculosEnvolvidos;
    }

    public void setVeiculosEnvolvidos(ArrayList<OcorrenciaAcidente> veiculosEnvolvidos) {
        this.veiculosEnvolvidos = veiculosEnvolvidos;
    }
    

}
