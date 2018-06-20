package sistema;
import crud.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Funcionario;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig.Pragma;



public class teste {
    public static void main (String[] args) throws SQLException{
        ArrayList<Condutor> condutores = new ArrayList();
        TableCondutor tbCondutor = new TableCondutor();
        try {
            condutores =tbCondutor.selectCondutores();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Condutor teste : condutores){
            System.out.println(teste.getNome());
        }

    }
}
