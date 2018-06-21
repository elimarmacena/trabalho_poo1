package sistema;
import crud.*;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.Funcionario;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig.Pragma;



public class teste {
    public static void main (String[] args) {
        
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            ArrayList<Funcionario> orcorrencias = new ArrayList();
            TableFuncionario tbOA = new TableFuncionario();
            try {
            orcorrencias =tbOA.recuperarLike("r");
            } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Funcionario teste : orcorrencias){
            System.out.println( teste.getNome());
            }
            /*DadosRotina dr = new DadosRotina();
            TableDadosRotina tbDr = new TableDadosRotina();
            try {
            dr= tbDr.recuperarByPlaca("MRA-7540");
            System.out.println(dr.getVelocidade());
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
        
            
        
        
    }
}
