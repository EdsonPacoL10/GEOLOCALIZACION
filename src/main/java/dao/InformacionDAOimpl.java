package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.informacion;
import utiles.ConexionDB;

public class InformacionDAOimpl extends ConexionDB implements InformacionDAO {
    @Override
    public void insert(informacion inf) throws Exception {
        String sql = "insert into informacion (desaparecido_id,usuario_id,nombre,apellido,descripcion,fecha) values (?,?,?,?,?,?);";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, inf.getDesaparecido_id());
        ps.setInt(2, inf.getUsuario_id());
        ps.setString(3, inf.getNombre());
        ps.setString(4, inf.getApellido());
        ps.setString(5, inf.getDescripcion());
        ps.setDate(6, inf.getFecha());
        ps.executeUpdate();
        this.desconectar();
    }
    @Override
    public void update(informacion inf) throws Exception {
        String sql;
        sql = "update informacion set desaparecido_id=?,usuario_id=?,nombre=?,apellido=?,descripcion=?,fecha=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, inf.getDesaparecido_id());
        ps.setInt(2, inf.getUsuario_id());
        ps.setString(3, inf.getNombre());
        ps.setString(4, inf.getApellido());
        ps.setString(5, inf.getDescripcion());
        ps.setDate(6, inf.getFecha());
        ps.setInt(7, inf.getId());
        ps.executeUpdate();
        this.desconectar();
    }
    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from informacion where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
   }
    @Override
    public informacion getById(int id) throws Exception {
        informacion inf = new informacion();
        String sql = "select * from informacion where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            inf.setId(rs.getInt("id"));
            inf.setDesaparecido_id(rs.getInt("desaparecido_id"));
            inf.setUsuario_id(rs.getInt("usuario_id"));
            inf.setNombre(rs.getString("nombre"));
            inf.setApellido(rs.getString("apellido"));
            inf.setDescripcion(rs.getString("descripcion"));
            inf.setFecha(rs.getDate("fecha"));
        }
        this.desconectar();
        return inf;
    }
    @Override
    public List<informacion> getAll() throws Exception {
        List<informacion> lista = null;
        String sql = "SELECT i.id as id ,i.desaparecido_id as desaparecido_id,d.nombre as desaparecido ,i.usuario_id as usuario_id,"
                + "u.nombres as usuario ,i.nombre as nombre ,"
                + "i.apellido as apellido,i.descripcion as descripcion ,i.fecha as fecha"
                + " FROM desaparecido D, informacion I, usuario u WHERE D.id = i.desaparecido_id AND i.usuario_id= u.id;";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<informacion>();
        while (rs.next()) {
            informacion inf = new informacion();
            inf.setId(rs.getInt("id"));
            inf.setDesaparecido_id(rs.getInt("desaparecido_id"));
            inf.setDesaparecido(rs.getString("desaparecido"));
            inf.setUsuario_id(rs.getInt("usuario_id"));
            inf.setUsuario(rs.getString("usuario"));
            inf.setNombre(rs.getString("nombre"));
            inf.setApellido(rs.getString("apellido"));
            inf.setDescripcion(rs.getString("descripcion"));
            inf.setFecha(rs.getDate("fecha"));
            lista.add(inf);
        }
        this.desconectar();
        return lista;
    }
}
