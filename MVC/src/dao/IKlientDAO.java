package dao;


import java.util.List;
import model.Klient;

public interface IKlientDAO {
    
    public int create(Klient klient);
    
   
 
    public Klient read(int id);

    public List<Klient> readAll();
 
    public boolean update(Klient klient);
 
    public boolean delete(int id);
}
