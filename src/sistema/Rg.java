package sistema;

import java.util.Scanner;

public class Rg {
    private String numRg; //numero do RG propriamente dito
    private String orgaoEmissor;
    private String estado;

    public String getNumRg() {
        return numRg;
    }

    public void setNumRg(String numRg) {
        if(numRg.length() != 9) { //ainda da pra adicionar a regra de só conter numeros
            System.out.println("Entrada invalida\nInforme RG válido: ");
            Scanner scan = new Scanner(System.in);
            String tentativaNumRg = scan.nextLine();
            setNumRg(tentativaNumRg);
        }
        else {
            this.numRg = numRg;    
        }
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
