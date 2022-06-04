package utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Validate extends ConexionDB{
    Connection con= this.conectar();
    PreparedStatement pr;
    public boolean checkUser (String email,String password) throws SQLException
    {
     boolean resultado=false;
     try{
         String sql="select* from usuario where correo=? and password=md5(?)";
         pr=con.prepareStatement(sql);
         pr.setString(1,email);
         pr.setString(2,password);
         ResultSet rs= pr.executeQuery();
         resultado=rs.next();
     }catch(SQLException ex){
         System.out.println(""+"error al autenticar"+ex.getMessage());
     }
     return resultado;
    }
}
