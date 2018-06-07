package model;

public class Condutor extends Pessoa {
    private Cnh cnh;
    private boolean titularVeiculo;

    
    /* Gets e Sets*/
    
    public boolean isTitularVeiculo() {
        return titularVeiculo;
    }

    public void setTitularVeiculo(boolean titularVeiculo) {
        this.titularVeiculo = titularVeiculo;
    }

    public Cnh getCnh() {
            return cnh;
    }

    public void setCnh(Cnh cnh) {
        this.cnh = cnh;
    }
}
