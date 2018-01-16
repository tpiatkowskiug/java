package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import controller.ZamówieniaController;
import model.Zamawianie_badan;

public class Zamawanie_badanView extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private static final Object[] COLUMN_NAMES = {"ID", "Rodzaj badan", "Ilosc prób", "Cena", "Klient id"};

	private ZamówieniaController controller;

	private JLabel lBadanie, lilośćPrób, lCena, lKlienta;
	public static JTextField tfilośćPrób, tfCena, tfKlienta;
	private JTable table2;
	private DefaultTableModel tableModel2;
	public static JComboBox<String> cbBadania;
	double tC, tF;
	
	public Zamawanie_badanView() {
		super();
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300, 300);
		this.setLayout(new BorderLayout());
		
	    tableModel2 = new DefaultTableModel(COLUMN_NAMES, 0);
	    table2 = new JTable(tableModel2);
        table2.setFont(new Font("Arial", Font.PLAIN, 26));
        table2.setRowHeight(table2.getRowHeight() + 16);
	    table2.setAutoCreateRowSorter(true);

	    JButton zapiszZamówienie = new JButton("Zapisz");
	    zapiszZamówienie.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e){
	    		Zamawianie_badan zamówienie = new Zamawianie_badan(
	    				cbBadania.getName(),
	    				Integer.parseInt(tfilośćPrób.getText()),
	    				tfCena.getText(),
	    				Integer.parseInt(tfKlienta.getText()));
	    		controller.insertZamówienie(zamówienie);
	    	}
	    });
	    
	    JButton edytujZamówienie = new JButton("Edytuj zamówienie");
	    edytujZamówienie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table2.getSelectedRow();
				if (selectedRow >= 0) {
					Integer id_zamówienia = (Integer) tableModel2.getValueAt(selectedRow, 0);
					Zamawianie_badan zamówienie = new Zamawianie_badan(
							id_zamówienia,
							cbBadania.getName(),
		    				Integer.parseInt(tfilośćPrób.getText()),
		    				tfCena.getText(),
							Integer.parseInt(tfKlienta.getText()));
					controller.updateZamówienie(zamówienie);
				}
			}
	    });

	    JButton usunZamówienie = new JButton("Usuń zamówienie");
	    usunZamówienie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table2.getSelectedRow();
				if (selectedRow >= 0) {
					Integer id_zamówienia = (Integer) tableModel2.getValueAt(selectedRow, 0);
					controller.deleteZamówienie(id_zamówienia);
				}
			}
	    });
	    
	    table2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = table2.getSelectedRow();
				if (selectedRow >= 1) {
					cbBadania.setName(cbBadania.getSelectedItem().toString());
					tfilośćPrób.setText("" + (Integer) tableModel2.getValueAt(selectedRow, 2));
					tfCena.setText((String) tableModel2.getValueAt(selectedRow, 3));
					tfKlienta.setText("" + (Integer) tableModel2.getValueAt(selectedRow, 4));
				}
			}
	    });
	    
	    JScrollPane scrollPane = new JScrollPane(table2);

	    lBadanie = new JLabel("Rodzaj badań");
	    lilośćPrób = new JLabel("Ilość prób");
	    lCena = new JLabel("Kwota");
	    lKlienta = new JLabel("id_klienta");
	   
	    cbBadania = new JComboBox<String>();
	    cbBadania.setEditable(true);
	    cbBadania.addItem("Badania rolnicze");
	    cbBadania.addItem("Badania ogrodnicze");
	    cbBadania.addItem("Badania sadownicze");
		add(cbBadania);
		cbBadania.addActionListener(this);
	    
	    tfilośćPrób = new JTextField(5);
	    tfilośćPrób.setToolTipText("wpisz ilość prób");
	    tfilośćPrób.addActionListener(this);
	    tfCena = new JTextField(10);
	    tfKlienta = new JTextField(10);
	    
	    
	    JPanel inputPanel = new JPanel();
	    inputPanel.add(lBadanie);
	    inputPanel.add(cbBadania);
	    inputPanel.add(lilośćPrób);
	    inputPanel.add(tfilośćPrób);
	    inputPanel.add(lCena);
	    inputPanel.add(tfCena);
	    inputPanel.add(lKlienta);
	    inputPanel.add(tfKlienta);
	    
	    inputPanel.add(zapiszZamówienie);
	    inputPanel.add(usunZamówienie);
	    inputPanel.add(edytujZamówienie);
	    
	    this.add(scrollPane, BorderLayout.CENTER);
	    this.add(inputPanel, BorderLayout.SOUTH);
	}
	
	public void setController(ZamówieniaController controller) {
		this.controller = controller;
	}
	
	public void refreshZamówienia(List<Zamawianie_badan> zamówienia) {
		
		if (zamówienia.size() > 0){
			tableModel2.getDataVector().clear();
			for (Zamawianie_badan zamówienie : zamówienia) {
				tableModel2.addRow(new Object[] {zamówienie.getId(), zamówienie.getRodzaj_badan(), zamówienie.getIlosc_prob(),
						zamówienie.getKwota(), zamówienie.getKlient_id()});
			}
		} else {
			tableModel2.setRowCount(0);
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == tfilośćPrób){
				String badania = cbBadania.getSelectedItem().toString();
				if(badania.equals("Badania rolnicze")){
					tC = Double.parseDouble(tfilośćPrób.getText());
					tF = 13.12 * tC;
					tfCena.setText(String.valueOf(tF));
					tfCena.setForeground(Color.BLUE);
				}else if(badania.equals("Badania ogrodnicze")){
					tC = Double.parseDouble(tfilośćPrób.getText());
					tF = 52.48 * tC;
					tfCena.setText(String.valueOf(tF));
					tfCena.setForeground(Color.RED);
				}else if(badania.equals("Badania sadownicze")){
					tC = Double.parseDouble(tfilośćPrób.getText());
					tF = 26.24 * tC;
					tfCena.setText(String.valueOf(tF));
					tfCena.setForeground(Color.GREEN);
				}
			}
		}
	}

