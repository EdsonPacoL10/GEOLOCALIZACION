
package dao;

import java.util.List;
import modelo.usuario;

public interface UsuarioDAO {

   public void insert(usuario usr) throws Exception;
    public void update(usuario usr) throws Exception;
    public void delete(int id) throws Exception;
    public usuario getById(int id) throws Exception;
    public List<usuario> getAll() throws Exception;
    
}
