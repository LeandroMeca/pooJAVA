
package controller;

import entity.Client;
import java.util.ArrayList;
import java.util.List;





public class Controller implements interfaceController.interfaceController{

    List<Client> data = new ArrayList<>();
    
    @Override
    public void insert(Client client) { 
      data.add(client);
    }

    @Override
    public int update(Client client) {
        int pos=0;
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getName().equals(client.getName())){
                pos = i;
                return pos;
            }else{
                System.out.println("name or age of client not found");
            }
        }
        return -1;
    }

    @Override
    public boolean delete(int pos) {
        try{
        data.remove(pos);
        return true;
        }catch(IndexOutOfBoundsException e){
            System.out.println("index not found of client");
        }
        return false;
    }

    @Override
    public List<Client> getAll() {

        return data;
    }

   

 
   
  
}
