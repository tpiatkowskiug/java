package okiennko;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class CtoFandReturn extends JFrame implements ActionListener {

	JLabel Celcjusz, Farenhajt;
	JTextField tCelcusz, tFarenhajt;
	JButton bConvert;
	double tC, tF;
	JCheckBox cbZmianaLiter;
	ButtonGroup bGroup;
	JRadioButton rdCtoF, rdFtoC;
	
	public CtoFandReturn(){
		setSize(400, 300);
		setTitle("Przeliczanie stopni");
		//setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		bConvert = new JButton("Przelicz");
		add(bConvert);
		bConvert.setBounds(80, 140, 100, 20);
		bConvert.addActionListener(this);
		
		cbZmianaLiter = new JCheckBox("zmień ");
		add(cbZmianaLiter);
		cbZmianaLiter.setBounds(200, 140, 150, 20);
		cbZmianaLiter.addActionListener(this);
		
		Celcjusz = new JLabel("stonie Celcujsza");
		add(Celcjusz);
		Celcjusz.setBounds(80, 50, 150, 20);
		
		tCelcusz = new JTextField("");
		tCelcusz.setBounds(80, 70, 150, 20	);
		add(tCelcusz);
		tCelcusz.addActionListener(this);
		tCelcusz.setToolTipText("wpisz stopnie cecjusza");
		
		Farenhajt = new JLabel("stopnie Farenhajta");
		add(Farenhajt);
		Farenhajt.setBounds(80, 90, 150, 20);
		
		tFarenhajt = new JTextField("");
		tFarenhajt.setBounds(80, 110, 150, 20	);
		add(tFarenhajt);
		tFarenhajt.addActionListener(this);
		
		bGroup = new ButtonGroup();
		rdCtoF = new JRadioButton("Celcius to Fahrenhejt", true);
		rdCtoF.setBounds(50, 200, 150, 20);
		bGroup.add(rdCtoF);
		add(rdCtoF);
		rdCtoF.addActionListener(this);
		
		rdFtoC = new JRadioButton("Fahernhejt to Celcius", false);
		rdFtoC.setBounds(200, 200, 150, 20);
		bGroup.add(rdFtoC);
		add(rdFtoC);
		rdFtoC.addActionListener(this);

	}
	
	public static void main(String[] args) {
		JFrame oknoCF = new CtoFandReturn();
		oknoCF.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bConvert){
			if(rdCtoF.isSelected()){
				tC = Double.parseDouble(tCelcusz.getText());
				tF = 32.0 + (9.0/5.0) * tC;
				tFarenhajt.setText(String.valueOf(tF));
			}else if (rdFtoC.isSelected()){
				tF = Double.parseDouble(tFarenhajt.getText());
				tC = 32.0 - (5.0/9.0) * tF;
				tCelcusz.setText(String.valueOf(tC));
			}
		}
		if(e.getSource()==tCelcusz){
			tC = Double.parseDouble(tCelcusz.getText());
			tF = 32.0 + (9.0/5.0) * tC;
			tFarenhajt.setText(String.valueOf(tF));
		}else if(e.getSource()==tFarenhajt){
			tF = Double.parseDouble(tFarenhajt.getText());
			tC = 32.0 - (5.0/9.0) * tF;
			tCelcusz.setText(String.valueOf(tC));
		}
		if(cbZmianaLiter.isSelected()){
			tFarenhajt.setFont(new Font("SansSerif", Font.BOLD, 18));
		}else{
			tFarenhajt.setFont(new Font("SansSerif", Font.PLAIN, 12));
		}
	}

}