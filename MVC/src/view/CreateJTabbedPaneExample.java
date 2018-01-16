package view;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import repository.KlientRepo;
import repository.ZamówieniaRepo;
import controller.KlientController;
import controller.ZamówieniaController;
import view.KlientView;
import view.Zamawanie_badanView;

public class CreateJTabbedPaneExample {


	public static JTabbedPane tabbedPane;

	private static void createAndShowGUI() {
		// Create and set up the window.
		final JFrame frame = new JFrame("Relacja Klient-Zamówienie");

		frame.setSize(1300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 1));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		KlientRepo model = new KlientRepo();
		KlientView view = new KlientView();
		new KlientController(model, view);
		view.setVisible(true);
		
		ZamówieniaRepo model1 = new ZamówieniaRepo();
		Zamawanie_badanView view1 = new Zamawanie_badanView();
		new ZamówieniaController(model1, view1);
		view.setVisible(true);
		
		tabbedPane.addTab("Tab1", view);
		tabbedPane.addTab("Tab2", view1);
		frame.getContentPane().add(tabbedPane);

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
				}
					});
    			}
	}