package interfaceController;

import entity.Client;
import java.util.List;

public interface interfaceController {

    
    public void insert(Client client);

    public int update(Client client);

    public boolean delete(int pos);

    public List<Client> getAll();
    
    
}
