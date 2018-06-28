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
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import view.JanelaLogin;
/*import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig.Pragma;*/



public class teste {
    public static void main (String[] args) {
		
		JanelaLogin jLogin = new JanelaLogin();
                jLogin.setVisible(true);
		
    }
}
