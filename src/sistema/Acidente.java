package sistema;

import java.util.Date;

/**
 * Created by 20161bsi0314 on 11/04/2018.
 */
public class Acidente {
    private boolean saidaPista;
    private boolean derrapagem;
    private boolean capotagem;
    private boolean colisao;
    private int velocidade;
    private int ocupantes;
    private double[] localizacao = new double[2]; //latitude(index 0) e longitude(index 1)
    private Date data; //variavel para guardar dia e hora do acidente.
    private String placa;
    private int numCnhCondutor;

    
    public boolean isSaidaPista() {
        return saidaPista;
    }

    public void setSaidaPista(boolean saidaPista) {
        this.saidaPista = saidaPista;
    }

	public boolean isDerrapagem() {
        return derrapagem;
    }

    public void setDerrapagem(boolean derrapagem) {
        this.derrapagem = derrapagem;
    }

    public boolean isCapotagem() {
        return capotagem;
    }

    public void setCapotagem(boolean capotagem) {
        this.capotagem = capotagem;
    }

    public boolean isColisao() {
        return colisao;
    }

    public void setColisao(boolean colisao) {
        this.colisao = colisao;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(int ocupantes) {
        this.ocupantes = ocupantes;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCnhCondutor() {
		return numCnhCondutor;
	}

	public void setNumCnhCondutor(int cnhCondutor) {
		this.numCnhCondutor = cnhCondutor;
	}
}
