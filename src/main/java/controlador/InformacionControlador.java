package controlador;
import dao.DesaparecidoDAO;
import dao.DesaparecidoDAOimpl;
import dao.InformacionDAO;
import dao.InformacionDAOimpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOimpl;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.desaparecido;
import modelo.informacion;
import modelo.usuario;
@WebServlet(name = "InformacionControlador", urlPatterns = {"/InformacionControlador"})
public class InformacionControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            InformacionDAO dao = new InformacionDAOimpl();
            DesaparecidoDAO daoProducto = new DesaparecidoDAOimpl();
            UsuarioDAO daoCliente = new UsuarioDAOimpl();
            int id;
            List<desaparecido> lista_productos = null;
            List<usuario> lista_clientes = null;
            informacion informacion = new informacion();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_productos = daoProducto.getAll();
                    lista_clientes = daoCliente.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("informacion", informacion);
                    request.getRequestDispatcher("frmInformacion.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    informacion = dao.getById(id);
                    lista_productos = daoProducto.getAll();
                    lista_clientes = daoCliente.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("informacion", informacion);
                    request.getRequestDispatcher("frmInformacion.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("InformacionControlador");
                    break;
                case "view":
                    List<informacion> lista = dao.getAll();
                    request.setAttribute("informacion", lista);
                    request.getRequestDispatcher("Informacion.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_desaparecido = Integer.parseInt(request.getParameter("desaparecido_id"));
        int id_usuario = Integer.parseInt(request.getParameter("usuario_id"));
        String desaparecido = request.getParameter("desaparecido");
        String usuario = request.getParameter("usuario");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        informacion inf = new informacion();
        System.out.println("" + inf.getDesaparecido());
        inf.setId(id);
        inf.setDesaparecido_id(id_desaparecido);
        inf.setUsuario_id(id_usuario);
        inf.setNombre(nombre);
        inf.setApellido(apellido);
        inf.setDescripcion(descripcion);
        inf.setFecha(convierteFecha(fecha));
        if (id == 0) {
            InformacionDAO dao = new InformacionDAOimpl();
            try {
                // Nuevo
                dao.insert(inf);
                response.sendRedirect("InformacionControlador");
            } catch (Exception ex) {
                System.out.println("Error al Insertar: " + ex.getMessage());
            }
        } else {
            InformacionDAO dao = new InformacionDAOimpl();
            try {
                // Edicion
                response.sendRedirect("InformacionControlador");
                dao.update(inf);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
    }
    public Date convierteFecha(String fecha) {
        Date fechaBD = null;
        SimpleDateFormat formato;
        formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            System.out.println("Error en la conversion de fecha: " + ex.getMessage());
        }

        return fechaBD;
    }

}
