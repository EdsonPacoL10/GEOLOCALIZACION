
package dao;

import java.util.List;
import modelo.desaparecido;

public interface DesaparecidoDAO {
public void insert(desaparecido des) throws Exception;
    public void update(desaparecido des) throws Exception;
    public void delete(int id) throws Exception;
    public desaparecido getById(int id) throws Exception;
    public List<desaparecido> getAll() throws Exception;
       
}
