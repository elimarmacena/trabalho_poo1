
package model;

public class RelatorioAcidente {
    private String placa;
    private String condutor;
    private int numOcupantes;
    private String tipoAcidente;
    private AuxiliadorExterno auxiliador;
    
    
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

    public AuxiliadorExterno getAuxiliador() {
        return auxiliador;
    }

    public void setAuxiliador(AuxiliadorExterno auxiliador) {
        this.auxiliador = auxiliador;
    }
    
    
}
