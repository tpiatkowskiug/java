package okiennko;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MojeTP extends JFrame implements ActionListener {
	JButton podajdate, wyjscie;
	JLabel wyświetldate;
	public MojeTP(){
		setSize(400, 200);
		setTitle("okienko");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		podajdate = new JButton("Podaj date");
		add(podajdate);
		podajdate.setBounds(80, 50, 120, 20);
		podajdate.addActionListener(this);
		wyjscie = new JButton("Wyjście");
		add(wyjscie);
		wyjscie.setBounds(200, 50, 120, 20);
		wyjscie.addActionListener(this);
		wyświetldate = new JLabel("Aktulana data to ");
		add(wyświetldate);
		wyświetldate.setBounds(80, 100, 200, 50);
		wyświetldate.setForeground(Color.BLUE);
	
	}

	public static void main(String[] args){
		JFrame okno = new MojeTP();
	}

	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
		if(zrodlo == podajdate){
			wyświetldate.setText(new Date().toString());
		//System.out.println(new Date());
		}else if(zrodlo == wyjscie){
			dispose();
		}
	}
	
}
