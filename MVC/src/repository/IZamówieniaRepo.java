package repository;

import java.util.List;

import model.Zamawianie_badan;;

public interface IZamówieniaRepo {
	
	public List<Zamawianie_badan> getZamówienie();
	public void insertZamówienie(Zamawianie_badan zamówienie);
	public void updateZamówienie(Zamawianie_badan zamówienie);
	public void deleteZamówienie(Integer zamówienieId);
	
//	public void createTableZamówienie();
}