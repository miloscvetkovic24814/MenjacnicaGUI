package kontroler;

import java.awt.EventQueue;
import javax.swing.JFileChooser;

import menjacnica.gui.About;
import menjacnica.gui.ExitDialog;
import menjacnica.gui.MenjacnicaGUI;
import model.Model;

public class Kontroler {

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
