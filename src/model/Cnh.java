package model;

import java.util.Scanner;

public class Cnh {
    private String numCnh;
    private String categoria;

    
    /* Gets e Sets */
    
    public String getNumCnh() {
        return numCnh;
    }

    public void setNumCnh(String numCnh) { //CNH tem 11 digitos 12346578910
        if(numCnh.length() != 11) {
            System.out.println("Entrada invalida\nO campo CNH deve conter 11 caracteres\nInsira novamente o CNH: ");
            Scanner scan = new Scanner(System.in);
            String tentativaCNH = scan.nextLine();
            setNumCnh(tentativaCNH);
        }
        else {
            this.numCnh = numCnh;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    /*CATEGORIAS DETRAN: http://www.detran.pr.gov.br/modules/catasg/servicos-detalhes.php?tema=motorista&id=130 */
    public void setCategoria(String categoria) {
        if(categoria.length() == 1 &&
                (categoria.equalsIgnoreCase("a") ||
                 categoria.equalsIgnoreCase("b") ||
                 categoria.equalsIgnoreCase("c") ||
                 categoria.equalsIgnoreCase("d") ||
                 categoria.equalsIgnoreCase("e"))) {
            this.categoria = categoria;
        }
        else if(categoria.length() == 3 && categoria.equalsIgnoreCase("acc")) { //categoria ACC
            this.categoria = categoria;
        }
        else if(categoria.length() == 10 && categoria.equalsIgnoreCase("motor-casa")) {
            this.categoria = categoria;
        }
        else {
            System.out.println("Entrada invalida\nO campo categoria deve ser preenchido com A, B, C, D, E, ACC ou MOTOR-CASA\nInsira novamente a categoria da habilitacao: ");
            Scanner scan = new Scanner(System.in);
            String tentativaCat = scan.nextLine();
            setCategoria(tentativaCat);
        }
    }
}
