package okiennko;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.JPanel;

public class MyFrame extends JFrame {
	public MyFrame() {
		super("Rysowanie");
		JPanel panel = new MyPanel();

		add(panel);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
