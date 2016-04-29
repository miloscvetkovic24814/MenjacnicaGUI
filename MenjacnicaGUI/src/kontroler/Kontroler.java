package kontroler;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import menjacnica.gui.About;
import menjacnica.gui.DaLiZeliteDaObriseteRed;
import menjacnica.gui.ExitDialog;
import menjacnica.gui.IzaberiRedZaBrisanjeDialog;
import menjacnica.gui.IzvrsiZamenuGui;
import menjacnica.gui.MenjacnicaGUI;
import menjacnica.gui.MorateDaUneseteKurs;
import model.Model;

public class Kontroler {

	private static String[] s = new String[6];

	public static void dodaj(Model m, JTextArea polje, JTextField textFieldSifra, JTextField txtNaziv,
			JTextField txtProdajniKurs, JTextField txtKupovniKurs, JTextField txtSrednjiKurs,
			JTextField txtSkraceniNaziv) {
		s[0] = textFieldSifra.getText();
		s[1] = txtNaziv.getText();
		s[2] = txtProdajniKurs.getText();
		s[3] = txtKupovniKurs.getText();
		s[4] = txtSrednjiKurs.getText();
		s[5] = txtSkraceniNaziv.getText();
		for (int i = 0; i < s.length; i++) {
			if(s[i] == null || s[i].isEmpty()){
				new MorateDaUneseteKurs().setVisible(true);
				return;
			}
		}
		prikazi(polje, s);
		m.addRow(s);
		m.fireTableDataChanged();
	}

	private static void prikazi(JTextArea polje, String[] s) {
		String pom = polje.getText() + "\n";
		String[] nazivi = { "Sifra: ", "Naziv: ", "Prodajni: ", "Kupovni: ", "Srednji: ", "Skraceni naziv: " };
		for (int j = 0; j < s.length; j++) {
			pom = pom + nazivi[j] + s[j] + " ";
		}
		polje.setText(pom);
	}


	public static void aboutDialog() {
		String podaciOAutoru = "Ime i prezime: Milos Cvetkovic \nZanimanje: Student ";
		new About(podaciOAutoru).setVisible(true);
	}

	public static void exitDialog() {
		new ExitDialog().setVisible(true);
	}

	public static String save() {
		JFileChooser jfc = new JFileChooser();
		jfc.showSaveDialog(null);
		if (jfc.getSelectedFile() != null) {
			return "Sacuvan fajl: " + jfc.getSelectedFile().getAbsolutePath();
		} else {
			return null;
		}

	}

	public static String open() {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		if (jfc.getSelectedFile() != null) {
			return "Ucitan fajl: " + jfc.getSelectedFile().getAbsolutePath();
		} else {
			return null;
		}
	}

	public static Model kreirajModel() {
		Model model = new Model();
		String[] naziviKolona = { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv" };
		model.setColumnIdentifiers(naziviKolona);
		return model;
	}
	
	public static void obrisiRed(JTextArea polje, JTable table, Model m){		
		String s = "\nIzbrisan je red: " + table.getSelectedRow();
		m.removeRow(table.getSelectedRow());
		m.fireTableDataChanged();
		polje.setText(polje.getText() + s);
	}
	
	public static void DaLiZeliteDaObriseteRed(JTextArea polje, JTable table, Model model){
		if(table.getSelectedRow() == -1){
			new IzaberiRedZaBrisanjeDialog().setVisible(true);
		}else{
			new DaLiZeliteDaObriseteRed(polje, table, model).setVisible(true);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void zameniKurs(JTextArea polje, String iznos, JRadioButton rdbtnKupovina, JRadioButton rdbtnProdaja, JComboBox comboBox){
		String rb = ", Nije izabrana kupovina/prodaja.";
		if(rdbtnKupovina.isSelected()){
			rb = ", Kupovina.";
		}else if(rdbtnProdaja.isSelected()){
			rb = ", Prodaja.";
		}
		String s = "\nNaziv valute: " + comboBox.getSelectedItem() + " Iznos: " + iznos + rb;
		polje.setText(s);
	}
	
	public static void izvrsiZamenu(JTextArea polje){
		new IzvrsiZamenuGui(polje).setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
