
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Test extends JFrame implements ActionListener {
	JMenuBar menubar;
	JMenu menuPlik, menuNarzędzia, menuOpcje, menuPomoc;
	JMenuItem mOtwórz, mZapisz, mWyjście, mNarz1, mNarz2, mOpcja1, mOpcja2, mOProgramie, pKopiuj, pWklej;
	JCheckBox chOpcja;
	JTextArea notanik;
	JButton Szukaj, bKolor;
	JTextField tfszukaj;
	JPopupMenu popup;
	String tekstKopiownay;
	JComboBox colory;
	
	public Test(){
		setSize(800,500);
		setTitle("Menu - Pasek");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
		setLayout(null);
		
		menubar = new JMenuBar();
		
		menuPlik = new JMenu("Plik");
		mOtwórz = new JMenuItem("Otwórz");
		mOtwórz.addActionListener(this);
		mZapisz = new JMenuItem("Zapisz");
		mZapisz.addActionListener(this);
		mWyjście = new JMenuItem("Wyjście");
		menuPlik.add(mOtwórz);
		menuPlik.add(mZapisz);
		menuPlik.addSeparator();
		menuPlik.add(mWyjście);
		
		mWyjście.addActionListener(this);
		mWyjście.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		
		menuNarzędzia = new JMenu("Narzędzia");
		mNarz1 = new JMenuItem("Narz1");
		mNarz2 = new JMenuItem("Narz2");
		mNarz2.addActionListener(this);
		menuNarzędzia.add(mNarz1);
		menuNarzędzia.add(mNarz2);
			
			menuOpcje = new JMenu("Opcje");
			mOpcja1 = new JMenuItem("Opcja1");
			mOpcja2 = new JMenuItem("Opcja2");
			menuOpcje.add(mOpcja1);
			menuOpcje.add(mOpcja2);
			chOpcja = new JCheckBox("Opcja3");
			chOpcja.addActionListener(this);
			menuOpcje.add(chOpcja);
		menuNarzędzia.add(menuOpcje);
			
		
		menuPomoc = new JMenu("Pomoc");
		mOProgramie = new JMenuItem("O Programie");
		mOProgramie.addActionListener(this);
		menuPomoc.add(mOProgramie);
		
		setJMenuBar(menubar);
		menubar.add(menuPlik);
		menubar.add(menuNarzędzia);
		menubar.add(menuPomoc);
		
		notanik = new JTextArea();
		JScrollPane sp = new JScrollPane(notanik);
		sp.setBounds(50, 50, 200, 300);
		add(sp);
		
		Szukaj = new JButton("Szukaj");
		add(Szukaj);
		Szukaj.setBounds(150, 400, 100, 20);
		Szukaj.addActionListener(this);
		tfszukaj = new JTextField();
		add(tfszukaj);
		tfszukaj.setBounds(50, 400, 100, 20);
		tfszukaj.addActionListener(this);
		
		bKolor = new JButton("Kolor");
		bKolor.setBounds(250,400, 100, 20);
		add(bKolor);
		bKolor.addActionListener(this);
		
		
		popup = new JPopupMenu();
		pKopiuj = new JMenuItem("Kopiuj");
		pKopiuj.addActionListener(this);
		pWklej = new JMenuItem("Wklej");
		pWklej.addActionListener(this);
		popup.add(pKopiuj);
		popup.add(pWklej);
		
		notanik.setComponentPopupMenu(popup);
		
		colory = new JComboBox();
		colory.setBounds(400, 50, 150, 20);
		colory.addItem("Niebieski");
		colory.addItem("Czerwony");
		colory.addItem("Zielony");
		add(colory);
		colory.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object z = e.getSource();
		if(z==mOtwórz){
			JFileChooser fc = new JFileChooser();
			if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			File plik = fc.getSelectedFile();
			try {
				Scanner sc = new Scanner(plik);
				while(sc.hasNext()){
					notanik.append(sc.nextLine()+"\n");
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}}else if(z==mZapisz){
			JFileChooser fc = new JFileChooser();
			if(fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
			File plik = fc.getSelectedFile();
			try {
				PrintWriter pw = new PrintWriter(plik);
				Scanner sc = new Scanner(notanik.getText());
				while(sc.hasNext()){
					pw.println(sc.nextLine()+"\n");
				}
				pw.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}}
		
		if(z==Szukaj){
		String tekst = notanik.getText();
		String szukaj = tfszukaj.getText();
		String wystąpienia = "";
		int index, i=0, startindex=0;
		while((index = tekst.indexOf(szukaj, startindex)) !=-1){
			startindex = index +szukaj.length();
			i++;
			wystąpienia = wystąpienia + " "+ index;
		}
		JOptionPane.showMessageDialog(null, szukaj + " wystąpiło "+ i + " razy " +wystąpienia + " "+ startindex);
		}else if(z==bKolor){
			Color zmianaKoloru = JColorChooser.showDialog(null, "wybór koloru", Color.BLACK);
			notanik.setForeground(zmianaKoloru);
		}
		
		if(z == mWyjście){
			int odp = JOptionPane.showConfirmDialog(null, "czy wyjść z programu?", "wyjście", JOptionPane.YES_NO_OPTION);
			if(odp == JOptionPane.YES_OPTION){
			dispose();
			}else if(odp == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "good choice");
			}
		}
		if (z == mNarz2){
			String input = JOptionPane.showInputDialog("Podaj długość w metrach");
			double metry = Double.parseDouble(input);
			double stopy = metry/0.3048;
			String sStopy = String.format("%.2f", stopy);
			JOptionPane.showMessageDialog(this, metry + "metrów to"+ sStopy +"stóp");
		}
		if(z == chOpcja){
			if(chOpcja.isSelected()){
				mNarz1.setEnabled(true);
			}else if(!chOpcja.isSelected()){
				mNarz1.setEnabled(false);
			}
		}
		if(z == mOProgramie){
			JOptionPane.showMessageDialog(this, "wersja 1.0");
		}else if(z==pKopiuj){
			tekstKopiownay = notanik.getSelectedText();
		}else if(z==pWklej){
			notanik.insert(tekstKopiownay, notanik.getCaretPosition());
		}else if(z==colory){
			String kolor = colory.getSelectedItem().toString();
			if(kolor.equals("Niebieski")){
				notanik.setForeground(Color.BLUE);
			}else if(kolor.equals("Czerwony")){
				notanik.setForeground(Color.RED);
			}else if(kolor.equals("Zielony")){
				notanik.setForeground(Color.GREEN);
			}
		}
			
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame menu = new Test();
		menu.setVisible(true);
	}
	}


