package kontroler;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import domen.Kurs;
import menjacnica.gui.About;
import menjacnica.gui.ExitDialog;
import menjacnica.gui.MenjacnicaGUI;
import model.Model;

public class Kontroler {

	private static String[] s = new String[6];
	private static LinkedList<Kurs> kursevi = new LinkedList<Kurs>();

	public static LinkedList<Kurs> getKursevi() {
		return kursevi;
	}

	private static void dodajKurs(Kurs kurs) {
		kursevi.add(kurs);
	}

	public static void dodaj(Model m, JTextArea polje, JTextField textFieldSifra, JTextField txtNaziv,
			JTextField txtProdajniKurs, JTextField txtKupovniKurs, JTextField txtSrednjiKurs,
			JTextField txtSkraceniNaziv) {
		s[0] = textFieldSifra.getText();
		s[1] = txtNaziv.getText();
		s[2] = txtProdajniKurs.getText();
		s[3] = txtKupovniKurs.getText();
		s[4] = txtSrednjiKurs.getText();
		s[5] = txtSkraceniNaziv.getText();
		Kurs kurs = new Kurs(s[0], s[1], Double.parseDouble(s[2]), Double.parseDouble(s[3]), Double.parseDouble(s[4]),
				s[5]);
		dodajKurs(kurs);
		prikazi(polje, s);
		ucitajPodatkeUModel(m);
	}

	private static void prikazi(JTextArea polje, String[] s) {
		String pom = polje.getText() + "\n";
		String[] nazivi = { "Sifra: ", "Naziv: ", "Prodajni: ", "Kupovni: ", "Srednji: ", "Skraceni naziv: " };
		for (int j = 0; j < s.length; j++) {
			pom = pom + nazivi[j] + s[j] + " ";
		}
		polje.setText(pom);
	}

	private static void ucitajPodatkeUModel(Model m) {
		for (int i = 0; i < kursevi.size(); i++) {
			String[] s = { kursevi.get(i).getSifra(), kursevi.get(i).getNaziv(), "" + kursevi.get(i).getProdajni(),
					"" + kursevi.get(i).getKupovni(), "" + kursevi.get(i).getSrednji(),
					kursevi.get(i).getSkraceniNaziv() };
			m.addRow(s);
		}
		m.fireTableDataChanged();
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
