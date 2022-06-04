package controlador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import dao.DesaparecidoDAO;
import dao.DesaparecidoDAOimpl;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.desaparecido;
@WebServlet(name = "DesaparecidoControlador", urlPatterns = {"/DesaparecidoControlador"})
public class DesaparecidoControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               try {
            DesaparecidoDAO dao_desaparecido = new DesaparecidoDAOimpl();
            int id;
            desaparecido des = new desaparecido();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("desaparecido", des);
                    request.getRequestDispatcher("frmDesaparecido.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    des = dao_desaparecido.getById(id);
                    request.setAttribute("desaparecido", des);
                    request.getRequestDispatcher("frmDesaparecido.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao_desaparecido.delete(id);
                    response.sendRedirect("DesaparecidoControlador");
                    break;
                case "view":
                    List<desaparecido> lista = dao_desaparecido.getAll();
                    request.setAttribute("desaparecido", lista);
                    request.getRequestDispatcher("Desaparecido.jsp").forward(request, response);
                    break;                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        String descripcion = request.getParameter("descripcion");
        String fecha = request.getParameter("fecha");
        desaparecido des = new desaparecido();
        des.setId(id);
        des.setNombre(nombre);
        des.setApellido(apellido);
        des.setEdad(edad);
        des.setSexo(sexo);
        des.setDescripcion(descripcion);
        des.setFecha(convierteFecha(fecha));
        DesaparecidoDAO dao = new DesaparecidoDAOimpl();
        if (id == 0) {
            try {
                // Nuevo
                dao.insert(des);
            } catch (Exception ex) {
                System.out.println("Error al Insertar: "  + ex.getMessage());
            }
        } else {
            try {
                // Edicion
                dao.update(des);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("DesaparecidoControlador");
    }
      public Date convierteFecha(String fecha){
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


