package model;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Contribuidor extends Pessoa {
    private String orgaoAssociado;

    /* Gets e Sets */
    
    public String getOrgaoAssociado() {
        return orgaoAssociado;
    }

    public void setOrgaoAssociado(String orgaoAssociado) {
        this.orgaoAssociado = orgaoAssociado;
    }
	
    
    /* Metodos */
    
    public String dataToString(Date data) {
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatoData.format(data);
    }

    public void envioInfoAcidente(String placa, int numOcupantes, String condutorCnh, Date data ) {
        FileWriter arquivo = null;
        try {
            arquivo = new FileWriter(".\\acidentes_info.csv",true);
            //INDEX 0 NOME | INDEX 1 ORGAOASSOCIADO | INDEX 2 PLACA | INDEX 3 NUMOCUPANTES | INDEX 4 NUMCHN | INDEX 5 SAIDAPISTA | INDEX 6 DERRAPAGEM
            //INDEX 7 CAPOTAGEM | INDEX 8 COLISAO | INDEX 9 DATA
            arquivo.append(this.getNome() + ";");
            arquivo.append(this.getOrgaoAssociado() + ";");
            arquivo.append( placa + ";");
            arquivo.append(numOcupantes + ";");
            arquivo.append(condutorCnh + ";");
            String saidaPista = JOptionPane.showInputDialog("Acidente envolve saida da pista?");
            arquivo.append(saidaPista.equalsIgnoreCase("sim")+";");
            String derrapagem = JOptionPane.showInputDialog("Acidente envolve derrapagem?");
            arquivo.append(derrapagem.equalsIgnoreCase("sim")+";");
            String capotagem = JOptionPane.showInputDialog("Acidente envolve capotagem?");
            arquivo.append(capotagem.equalsIgnoreCase("sim")+";");
            String colisao = JOptionPane.showInputDialog("Acidente envolve colisao?");
            arquivo.append(colisao.equalsIgnoreCase("sim")+";");
            arquivo.append(dataToString(data)+"\n");
        }
        catch(IOException w) {
            w.printStackTrace();
        }
        finally {
            try {
                arquivo.close();
            }
            catch(IOException c) {
                c.printStackTrace();
            }
        }
    }
}
