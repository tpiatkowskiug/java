import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class RównanieGUI extends JFrame implements ActionListener{

JLabel a, b, c, lwynik;	
JTextField tfa, tfb, tfc, twynik;
JButton wyjście, rozwiąż;
	
public RównanieGUI(){
	setSize(350, 300);
	setTitle("Równanie kwadratowe");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setLayout(null);
	
	a = new JLabel("a: ");
	a.setBounds(50, 50, 50, 20);
	add(a);
	b = new JLabel("b: ");
	b.setBounds(150, 50, 50, 20);
	add(b);
	c = new JLabel("c: ");
	c.setBounds(250, 50, 50, 20);
	add(c);
	lwynik = new JLabel("Wynik: ");
	lwynik.setBounds(10, 100, 110, 20);
	add(lwynik);
	
	tfa = new JTextField("");
	tfa.setBounds(70, 50, 50, 20);
	add(tfa);
	tfa.setToolTipText("podaj wsółczynik a");
	tfb = new JTextField("");
	tfb.setBounds(170, 50, 50, 20);
	add(tfb);
	tfb.setToolTipText("podaj wsółczynik b");
	tfc = new JTextField("");
	tfc.setBounds(270, 50, 50, 20);
	add(tfc);
	tfc.setToolTipText("podaj wsółczynik c");
	twynik = new JTextField("");
	twynik.setBounds(70, 100, 250, 20);
	add(twynik);
	
	wyjście = new JButton("Wyjście");
	wyjście.setBounds(180, 170, 150, 20);
	add(wyjście);
	wyjście.addActionListener(this);
	rozwiąż = new JButton("Oblicz");
	rozwiąż.setBounds(50, 170, 150, 20);
	add(rozwiąż);
	rozwiąż.addActionListener(this);
	
}
	
	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == rozwiąż){
		int a = Integer.parseInt(tfa.getText());
		int b = Integer.parseInt(tfb.getText());
		int c = Integer.parseInt(tfc.getText());
		
		RównanieKwadratowe rw = new RównanieKwadratowe(a, b, c);
		String rozwiązanie = rw.rozwiąż();
		twynik.setText(rozwiązanie);
		
	}else if(e.getSource() == wyjście){
		dispose();
	}
	
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame app = new RównanieGUI();
	}

}
