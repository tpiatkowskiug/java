package repository;

import java.util.List;

import model.Klient;

public interface IKlientRepo {
	
	public List<Klient> getKlienci();
	public void insertKlient(Klient klient);
	public void updateKlient(Klient klient);
	public void deleteKlient(Integer klientId);
	
	//public void createTableKlient();
}