package controller;


import java.util.List;

import model.Zamawianie_badan;
import repository.ZamówieniaRepo;
import view.Zamawanie_badanView;

public class ZamówieniaController {

	private ZamówieniaRepo model;
	private Zamawanie_badanView view;
	
	public ZamówieniaController(ZamówieniaRepo model, Zamawanie_badanView view) {
		this.model = model;
		this.view = view;
		
		view.setController(this);
		
		refreshKlienci();
	}
	
	public void insertZamówienie(Zamawianie_badan zamówienie) {
		model.insertZamówienie(zamówienie);
		refreshKlienci();
	}
	
	public void updateZamówienie(Zamawianie_badan zamówienie)  {
		model.updateZamówienie(zamówienie);
		refreshKlienci();
	}
	
	public void deleteZamówienie(Integer zamówienieId) {
		model.deleteZamówienie(zamówienieId);
		refreshKlienci();
	}
	
	private void refreshKlienci() {
		List<Zamawianie_badan> zamówienia = model.getZamówienie();
		view.refreshZamówienia(zamówienia);
	}
}