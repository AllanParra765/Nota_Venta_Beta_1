
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionMySQL {
    String driver = "com.mysql.cj.jdbc.Driver";
    String database = "Bd_Notas";
    String hostname = "localhost";
    String url = "jdbc:mysql://"+hostname+"/"+database+"?useSSL=false";
    String username = "root";
    String password = "";
    
    public Connection conectarMySQL() {
        Connection con = null;
        
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, username, password);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return con;
    }
}
