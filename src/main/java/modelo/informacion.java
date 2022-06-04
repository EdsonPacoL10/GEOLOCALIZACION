package modelo;

import java.sql.Date;

public class informacion {
    private int id;
    private int desaparecido_id;
    private String desaparecido;
    private int usuario_id;
    private String usuario;
    private String nombre;
    private String apellido;
    private String descripcion;
    private Date fecha;
    public informacion() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDesaparecido_id() {
        return desaparecido_id;
    }
    public void setDesaparecido_id(int desaparecido_id) {
        this.desaparecido_id = desaparecido_id;
    }
    public String getDesaparecido() {
        return desaparecido;
    }
    public void setDesaparecido(String desaparecido) {
        this.desaparecido = desaparecido;
    }

    public int getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
