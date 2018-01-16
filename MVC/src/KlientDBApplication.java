import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import controller.KlientController;
import repository.KlientRepo;
import view.KlientView;

public class KlientDBApplication {
	private static final Logger log = Logger.getLogger(KlientDBApplication.class);
	public static void main(String[] args) {
		
		String log4jConfPath = "log4j.properties";
		log.info("Start application");
		PropertyConfigurator.configure(log4jConfPath);
		
		KlientRepo model = new KlientRepo();
		KlientView view = new KlientView();
		new KlientController(model, view);
		
		view.setVisible(true);
	}
}