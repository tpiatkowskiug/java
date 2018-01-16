package dao;


import java.util.List;
import model.Zamawianie_badan;

public interface IZamówienieDAO {
    
    public int create(Zamawianie_badan zamówienie);
    
 
 
    public Zamawianie_badan read(int id);

    public List<Zamawianie_badan> readAll();
 
    public boolean update(Zamawianie_badan zamówienie);
 
    public boolean delete(int id);
}
