import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Test2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Panel panelHasła;
	
	JPasswordField hasło;
	JTextArea notatnik;
	JScrollPane scrolln;
	JButton haslouzytkowniaka;
	
	public Test2(){
		setSize(400, 400);
		setTitle("Podaj dddd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		hasło=new JPasswordField();
		hasło.setBounds(50, 50, 200, 20);
		hasło.addActionListener(this);
		add(hasło);
		
		notatnik = new JTextArea();
		notatnik.setWrapStyleWord(true);
		scrolln = new JScrollPane(notatnik);
		scrolln.setBounds(50, 80, 200, 200);
		add(scrolln);
		
		haslouzytkowniaka = new JButton("Hasło Użytkownika");
		haslouzytkowniaka.setBounds(50, 300, 200, 20);
		add(haslouzytkowniaka);
		haslouzytkowniaka.addActionListener(this);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame handd = new Test2();
		handd.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		//JOptionPane.showMessageDialog(null, String.valueOf(hasło.getPassword()));
		
		if(panelHasła == null){
			panelHasła = new Panel(this);
		}
		panelHasła.setVisible(true);
		if(panelHasła.isOK()==true){
			notatnik.append(panelHasła.getUser()+ ", ");
			notatnik.append(panelHasła.getPassword()+ "\n");
		}
		}
		}
		
	


class Panel extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lUser, lHasło;
	private JTextField tUser;
	private JPasswordField tHasło;
	private JButton bOK, bCancel;
	private boolean okDate;
	
	public Panel(JFrame owner){
		super(owner, "wprwadzenie hasła", true);
		setSize(300, 200);
		setLayout(null);
		
		lUser = new JLabel("Użytkownik", JLabel.RIGHT);
		lUser.setBounds(0, 0, 100, 20);
		add(lUser);
		tUser = new JTextField();
		tUser.setBounds(150, 0, 100, 20);
		add(tUser);
		
		lHasło = new JLabel("Hasło", JLabel.RIGHT);
		lHasło.setBounds(0, 50, 100, 20);
		add(lHasło);
		tHasło = new JPasswordField();
		tHasło.setBounds(150, 50, 100, 20);
		add(tHasło);
		
		bOK = new JButton("OK");
		bOK.setBounds(0, 100, 100, 20);
		bOK.addActionListener(this);
		add(bOK);
		bCancel = new JButton("Cancel");
		bCancel.setBounds(150, 100, 100, 20);
		bCancel.addActionListener(this);
		add(bCancel);
		
	}
	public String getUser(){
		return tUser.getText();
	}
	public String getPassword(){
		return new String(tHasło.getPassword());
	}
	public boolean isOK(){
		return okDate;
	}
	public void setFocus(){
		tUser.requestFocusInWindow();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if(z==bOK){
			okDate = true;
		}else{
			okDate = false;
		}
		setVisible(false);					
	
	}
	
}




