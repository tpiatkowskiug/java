package okiennko;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CelcujeszedoFarenhajta extends JFrame implements ActionListener{
	JLabel Celcjusz, Farenhajt;
	JTextField tCelcusz, tFarenhajt;
	JButton bConvert;
	double tC, tF;
	JCheckBox cbZmianaLiter;
	ButtonGroup bGroup;
	JRadioButton rbmały, rbsredni, rbduzy;
	
	public CelcujeszedoFarenhajta(){
		setSize(300, 300);
		setTitle("Przeliczanie stopni");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		bConvert = new JButton("Przelicz");
		add(bConvert);
		bConvert.setBounds(80, 140, 100, 20);
		bConvert.addActionListener(this);
		
		cbZmianaLiter = new JCheckBox("zmień ");
		add(cbZmianaLiter);
		cbZmianaLiter.setBounds(200, 140, 150, 20);
		//cbZmianaLiter.addActionListener(this);
		
		Celcjusz = new JLabel("stonie Celcujsza");
		add(Celcjusz);
		Celcjusz.setBounds(80, 50, 150, 20);
		
		tCelcusz = new JTextField("...");
		tCelcusz.setBounds(80, 70, 150, 20	);
		add(tCelcusz);
		tCelcusz.addActionListener(this);
		tCelcusz.setToolTipText("wpisz stopnie cecjusza");
		
		Farenhajt = new JLabel("stopnie Farenhajta");
		add(Farenhajt);
		Farenhajt.setBounds(80, 90, 150, 20);
		
		tFarenhajt = new JTextField("...");
		tFarenhajt.setBounds(80, 110, 150, 20	);
		add(tFarenhajt);
		
		bGroup = new ButtonGroup();
		rbmały = new JRadioButton("Mały", true);
		rbmały.setBounds(80, 200, 65, 20);
		bGroup.add(rbmały);
		add(rbmały);
		rbmały.addActionListener(this);
		
		rbsredni = new JRadioButton("Średni", false);
		rbsredni.setBounds(140, 200, 80, 20);
		bGroup.add(rbsredni);
		add(rbsredni);
		rbsredni.addActionListener(this);
		
		rbduzy = new JRadioButton("Duży", false);
		rbduzy.setBounds(220, 200, 70, 20);
		bGroup.add(rbduzy);
		add(rbduzy);
		rbduzy.addActionListener(this);
	}
	
	public static void main(String[] args) {
		JFrame oknoCF = new CelcujeszedoFarenhajta();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bConvert || e.getSource() == tCelcusz){
			
			if(cbZmianaLiter.isSelected()){
				tFarenhajt.setFont(new Font("SansSerif", Font.BOLD, 18));
			}else{
				tFarenhajt.setFont(new Font("SansSerif", Font.PLAIN, 12));
			}
			
		tC = Double.parseDouble(tCelcusz.getText());
		tF = 32.0 + (9.0/5.0) * tC;
		tFarenhajt.setText(String.valueOf(tF));
		}
//		else if (e.getSource() == cbZmianaLiter){
//			if(cbZmianaLiter.isSelected()){
//				tFarenhajt.setFont(new Font("SansSerif", Font.BOLD, 18));
//			}else{
//				tFarenhajt.setFont(new Font("SansSerif", Font.PLAIN, 12));
//			}
//		}
		else if(e.getSource()==rbmały){
			tFarenhajt.setFont(new Font("SansSerif", Font.BOLD, 12));
		}
		else if(e.getSource()==rbsredni){
			tFarenhajt.setFont(new Font("SansSerif", Font.PLAIN, 16));
		}else if(e.getSource()==rbduzy){
			tFarenhajt.setFont(new Font("SansSerif", Font.ITALIC, 20));
		}
	}

}