package sistema;

import java.util.Date;

public class DadosRotina {
    private int velocidade;
    private double localizacao[] = new double[2]; /* DUVIDA: ja instancia aqui ou deixa pro construtor algo do tipo? */
    private Date dataColeta;
    private Veiculo veiculo;
    

    /* GETS E SETS */
    
    /*
    Em especial os sets aqui nao carregam regras pois quem trata desses eventuais
    problemas é o sistema embarcado.
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

     public Veiculo getVeiculo() {
        return veiculo;
    }
    
    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public double[] getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(double[] localizacao) {
        this.localizacao = localizacao;
    }

    public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    
    //AS FUNCOES A SEGUIR SAO APENAS FUNCOES USADAS PARA EMULAR O VERDADEIRO FUNCIONAMENTO APOS A INTEGRACAO COM O SISTEMA DO VEICULO
    /*
    public int getVelociadade() {
    	int velocidade = ThreadLocalRandom.current().nextInt(10, 201);
    	return velocidade;
    }
    public double[] getLocalizacao() {
    	double[] localizacao = new double[2];
    	localizacao[0] = ThreadLocalRandom.current().nextDouble(2);
    	localizacao[1] = ThreadLocalRandom.current().nextDouble(2);
    	return localizacao;
    }
    
    public String getCurrentDate() {
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	Date data = new Date();
    	return dateFormat.format(data);	
    } 
  
    public void envioDados() {
    	//previa de como seria o envio de dados para o banco de dados atraves do obd
    	//OS DADOS SERAO SALVOS NA SEGUINTE ORDEM: VELOCIDADE, LATITUDE, LONGITUTE, DATA/HORA, PLACA
    	FileWriter arquivo = null;
    	try {
            arquivo = new FileWriter(".\\dados_viagem.csv",true);
            arquivo.append(getVelociadade()+";");
            double[] locate = getLocalizacao(); 
            arquivo.append(locate[0]+";"+locate[1]+";");
            arquivo.append(getCurrentDate()+";");
            arquivo.append(this.getPlaca()+"\n");
            arquivo.flush();
    	}
    	catch(IOException w) {
            w.printStackTrace();
    	}
    	finally {
            try {
                arquivo.close();
            } catch (IOException c) {
                c.printStackTrace();
            }
        }
    }
    
    */

    
    
}
