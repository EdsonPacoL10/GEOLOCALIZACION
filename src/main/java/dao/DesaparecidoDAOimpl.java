package dao;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.desaparecido;
import utiles.ConexionDB;

public class DesaparecidoDAOimpl extends ConexionDB implements DesaparecidoDAO {
    @Override
    public void insert(desaparecido des) throws Exception {
           String sql = "insert into desaparecido (nombre,apellido,edad,sexo,descripcion,fecha)values (?,?,?,?,?,?);";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,des.getNombre());
        ps.setString(2,des.getApellido());
        ps.setInt(3,des.getEdad());
        ps.setString(4,des.getSexo());
        ps.setString(5,des.getDescripcion());
        ps.setDate(6,des.getFecha());
        ps.executeUpdate();
        this.desconectar();
    }
    @Override
    public void update(desaparecido des) throws Exception {
        String sql;
            sql = "update desaparecido set nombre=?, apellido=?, edad=?, sexo=?, descripcion=?,fecha=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,des.getNombre());
        ps.setString(2,des.getApellido());
        ps.setInt(3,des.getEdad());
        ps.setString(4,des.getSexo());
        ps.setString(5,des.getDescripcion());
        ps.setDate(6,des.getFecha());
        ps.setInt(7,des.getId());
        ps.executeUpdate();
        this.desconectar();
    }
    @Override
    public void delete(int id) throws Exception {
         String sql = "delete from desaparecido where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }
    @Override
    public desaparecido getById(int id) throws Exception {
            desaparecido des = new desaparecido();
        String sql = "select * from desaparecido where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            des.setId(rs.getInt("id"));
            des.setNombre(rs.getString("nombre"));
            des.setApellido(rs.getString("apellido"));
            des.setEdad(rs.getInt("edad"));
            des.setSexo(rs.getString("sexo"));
            des.setDescripcion(rs.getString("descripcion"));
            des.setFecha(rs.getDate("fecha"));
        }
        this.desconectar();
        return des;
    }
    @Override
    public List<desaparecido> getAll() throws Exception {
           List<desaparecido> lista = null;
        String sql = "select * from desaparecido";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<desaparecido>();
        while (rs.next()) {            
            desaparecido des = new desaparecido();
              des.setId(rs.getInt("id"));
            des.setNombre(rs.getString("nombre"));
            des.setApellido(rs.getString("apellido"));
            des.setEdad(rs.getInt("edad"));
            des.setSexo(rs.getString("sexo"));
            des.setDescripcion(rs.getString("descripcion"));
            des.setFecha(rs.getDate("fecha"));
            lista.add(des);
        }
        rs.close();
        ps.close();
        this.desconectar();
        return lista;
    }
}
