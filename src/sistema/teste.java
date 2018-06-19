package sistema;
import crud.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Funcionario;
import java.util.ArrayList;
import java.util.Properties;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConfig.Pragma;



public class teste {
    public static void main (String[] args) throws SQLException{
        SQLiteConfig sqLiteConfig = new SQLiteConfig();
        Properties properties = sqLiteConfig.toProperties();
        properties.setProperty(Pragma.DATE_STRING_FORMAT.pragmaName, "yyyy-MM-dd HH:mm:ss");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:sistemaAcidentes.db", properties);

    }
}
