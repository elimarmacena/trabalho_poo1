package sistema;

/**
 * Created by 20161bsi0314 on 11/04/2018.
 */
public class Condutor extends Pessoa {
    private Cnh cnh;
    private boolean titular;

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }
    
    public Cnh getCnh() {
            return cnh;
    }

    public void setCnh(Cnh cnh) {
        this.cnh = cnh;
    }
}
