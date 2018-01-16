package okiennko;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Mojeokienko extends JFrame implements ActionListener{
	
	public Mojeokienko(){
		setSize(300,300	);
		setTitle("moje piersze okienko");
		JButton button = new JButton("Podaj date");
		setLayout(null);
		button.setBounds(100, 50, 100, 50);
		add(button);
		button.addActionListener(this);
	}
	public static void main(String[] args){
		Mojeokienko okno = new Mojeokienko();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(new Date());
		
	}
	
	
}
