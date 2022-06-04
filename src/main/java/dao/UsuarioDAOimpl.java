package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.usuario;
import utiles.ConexionDB;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{
   @Override
    public void insert(usuario usr) throws Exception {
        String sql = "insert into usuario (nombres,apellidos,correo,password) values (?,?,?,md5(?))";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,usr.getNombres());
        ps.setString(2,usr.getApellidos());
        ps.setString(3,usr.getCorreo());
        ps.setString(4,usr.getPassword());
        ps.executeUpdate();
        this.desconectar();
    }
    @Override
    public void update(usuario usr) throws Exception {
        String sql;
        if (usr.getPassword().equals("")){
            sql = "update usuario set nombres=?, apellidos=?, correo=? where id=?";
        }
        else{
            sql = "update usuario set nombres=?, apellidos=?, correo=?, password=md5(?) where id=?";
        }
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        if (usr.getPassword().equals("")){
            ps.setString(1,usr.getNombres());
            ps.setString(2,usr.getApellidos());
            ps.setString(3,usr.getCorreo());
            ps.setInt(4,usr.getId());
        }
        else{
            ps.setString(1,usr.getNombres());
            ps.setString(2,usr.getApellidos());
            ps.setString(3,usr.getCorreo());
            ps.setString(4,usr.getPassword());
            ps.setInt(5,usr.getId());
        }
        ps.executeUpdate();
        this.desconectar();
    }
    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from usuario where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }
    @Override
    public usuario getById(int id) throws Exception {
        usuario usr = new usuario();
        String sql = "select * from usuario where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            usr.setId(rs.getInt("id"));
            usr.setNombres(rs.getString("nombres"));
            usr.setApellidos(rs.getString("apellidos"));
            usr.setCorreo(rs.getString("correo"));
        }
        this.desconectar();
        return usr;
    }

    @Override
    public List<usuario> getAll() throws Exception {
        List<usuario> lista = null;
        String sql = "select * from usuario";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<usuario>();
        while (rs.next()) {            
            usuario usu = new usuario();
            
            usu.setId(rs.getInt("id"));
            usu.setNombres(rs.getString("nombres"));
            usu.setApellidos(rs.getString("apellidos"));
            usu.setCorreo(rs.getString("correo"));

            lista.add(usu);
        }
        this.desconectar();
        return lista;
    }
}
