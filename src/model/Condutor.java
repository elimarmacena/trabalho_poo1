package model;

public class Condutor extends Pessoa {
    private int campoIdentificacao;
    private Cnh cnh;

    /* Gets e Sets*/
    public int getCampoIdentificacao() {
        return campoIdentificacao;
    }
        
    public void setCampoIdentificacao(int campoIdentificacao) {    
        this.campoIdentificacao = campoIdentificacao;
    }

    public Cnh getCnh() {
        return cnh;
    }

    public void setCnh(Cnh cnh) {
        this.cnh = cnh;
    }
}
