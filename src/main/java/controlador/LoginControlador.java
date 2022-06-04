package controlador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utiles.Validate;
@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action");
        action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
        if (action.equals("logout")){
            HttpSession ses =  request.getSession();
            ses.invalidate();
        }
        response.sendRedirect("login.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String email= request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("datos.."+email+"  "+password);
        Validate v=new Validate();
        try {
            if(v.checkUser(email, password)){
               // System.out.println("todo ok");
               HttpSession ses =request.getSession();
               ses.setAttribute("login", "OK");
               response.sendRedirect("DesaparecidoControlador");
            }else{
                //System.out.println("incorrecto");
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException ex) {
           Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
              
    
    }

}
