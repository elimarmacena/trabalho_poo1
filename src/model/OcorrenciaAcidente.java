/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 20161bsi0314
 */
public class OcorrenciaAcidente {
    
    Veiculo veiculo;
    Condutor condutor;
    boolean condutor_titular;
    int velocidade;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public boolean isCondutor_titular() {
        return condutor_titular;
    }

    public void setCondutor_titular(boolean condutor_titular) {
        this.condutor_titular = condutor_titular;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    
}
