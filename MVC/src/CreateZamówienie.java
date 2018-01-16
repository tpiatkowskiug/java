

import org.apache.log4j.PropertyConfigurator;

import controller.ZamówieniaController;
import repository.ZamówieniaRepo;
import view.Zamawanie_badanView;

public class CreateZamówienie{

	public static void main(String[] args) {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		ZamówieniaRepo model = new ZamówieniaRepo();
		Zamawanie_badanView view = new Zamawanie_badanView();
		new ZamówieniaController(model, view);
		
		view.setVisible(true);
	}
}