package utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionDB {
   static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/localizacion";
    static String user = "root";
    static String password = "";
protected Connection conn = null;
    public ConexionDB() {
        try {
            //especificacion de driver
            Class.forName(driver);
            //establece la conecion a la base de datos
            conn = DriverManager.getConnection(url, user, password);
            //verificacion si la conexion fue exitosa;
            if (conn != null) {
                System.out.println( "Conexion OK :. " + conn);
            }
        } catch (SQLException ex) {
            System.out.println( "ERROR DE SQL" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection conectar() {
        return conn;
    }
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
