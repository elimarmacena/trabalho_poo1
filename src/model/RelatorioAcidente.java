
package model;

public class RelatorioAcidente {
    private String placa;
    private String condutor; //nome do condutor
    private String numCnh;
    private int numOcupantes;
    private String tipoAcidente;
    private Contribuidor auxiliador;
    
    
    /* Gets e Sets */ 
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCondutor() {
        return condutor;
    }

    public void setCondutor(String condutor) {
        this.condutor = condutor;
    }

    public int getNumOcupantes() {
        return numOcupantes;
    }

    public void setNumOcupantes(int numOcupantes) {
        this.numOcupantes = numOcupantes;
    }

    public String getTipoAcidente() {
        return tipoAcidente;
    }

    public void setTipoAcidente(String tipoAcidente) {
        this.tipoAcidente = tipoAcidente;
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
    
    
}
