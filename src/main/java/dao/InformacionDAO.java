
package dao;

import java.util.List;
import modelo.informacion;

public interface InformacionDAO {
 public void insert(informacion inf) throws Exception;
    public void update(informacion inf) throws Exception;
    public void delete(int id) throws Exception;
    public informacion getById(int id) throws Exception;
    public List<informacion> getAll() throws Exception;
       
}
