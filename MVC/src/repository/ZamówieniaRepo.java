package repository;

import java.util.List;

import dao.DAOFactory;
import dao.IZamówienieDAO;
import model.Zamawianie_badan;

public class ZamówieniaRepo implements IZamówieniaRepo{

	DAOFactory Factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);
	IZamówienieDAO zamówienieDAO = Factory.getZamówienieDAO();

//	@Override
	public List<Zamawianie_badan> getZamówienie() {
       return zamówienieDAO.readAll();
	}
	
//	@Override
	public void insertZamówienie(Zamawianie_badan zamówienie) {
		zamówienieDAO.create(zamówienie);
	}
	
	
	public void updateZamówienie(Zamawianie_badan zamówienie) {
		zamówienieDAO.update(zamówienie);	
	}
	
	public void deleteZamówienie(Integer zamówienieId) {
		zamówienieDAO.delete(zamówienieId);
	}
}