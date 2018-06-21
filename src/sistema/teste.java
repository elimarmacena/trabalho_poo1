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
        
            /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            ArrayList<RelatorioAcidente> orcorrencias = new ArrayList();
            TableRelatorioAcidente tbOA = new TableRelatorioAcidente();
            try {
            orcorrencias =tbOA.recuperarRelatorios();
            } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (RelatorioAcidente teste : orcorrencias){
            System.out.println( teste.getPlaca());
            }*/
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
        
            String login = "155937020-88";
            String senha = "sys123";
            Funcionario fn = new Funcionario();
            TableFuncionario tbF = new TableFuncionario();
        try {
            //fn= tbF.checkLogin(login, senha);
            tbF.updateStatus(1, 0);
            System.out.println("BEM VINDO "+fn.getNome());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedOperationException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
}
