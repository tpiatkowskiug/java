package repository;

import java.util.List;

import dao.DAOFactory;
import dao.IKlientDAO;
import model.Klient;

public class KlientRepo implements IKlientRepo{

	DAOFactory Factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRES);
    IKlientDAO klientDAO = Factory.getKlientDAO();

//	@Override
	public List<Klient> getKlienci() {
        return klientDAO.readAll();
	}
	
//	@Override
	public void insertKlient(Klient klient) {
        klientDAO.create(klient);
	}
	
	public void updateKlient(Klient klient) {
		klientDAO.update(klient);	
	}
	
	public void deleteKlient(Integer klientId) {
		klientDAO.delete(klientId);
	}

}
