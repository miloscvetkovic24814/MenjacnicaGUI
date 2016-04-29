package menjacnica.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import kontroler.Kontroler;
import model.Model;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSifra;
	private JLabel lblNaziv;
	private JTextField txtNaziv;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtProdajniKurs;
	private JTextField txtKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSrednjiKurs;
	private JTextField txtSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private MenjacnicaGUI menjacnica;

	/**
	 * Create the frame.
	 */
	public DodajKursGUI(MenjacnicaGUI m, Model modelRoditelja) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodajKursGUI.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png")));
		menjacnica = m;
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 313, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[139.00px][136.00px]", "[16px][22px][16px][22px][16px][22px][25px]"));
		
		JLabel lblNewLabel = new JLabel("Sifra");
		contentPane.add(lblNewLabel, "cell 0 0,growx,aligny top");
		
		textFieldSifra = new JTextField();
		contentPane.add(textFieldSifra, "cell 0 1,growx,aligny top");
		textFieldSifra.setColumns(10);
		
		lblNaziv = new JLabel("Naziv");
		contentPane.add(lblNaziv, "cell 1 0,growx,aligny top");
		
		txtNaziv = new JTextField();
		contentPane.add(txtNaziv, "cell 1 1,growx,aligny top");
		txtNaziv.setColumns(10);
		
		lblProdajniKurs = new JLabel("Prodajni kurs");
		contentPane.add(lblProdajniKurs, "cell 0 2,growx,aligny top");
		
		lblKupovniKurs = new JLabel("Kupovni kurs");
		contentPane.add(lblKupovniKurs, "cell 1 2,growx,aligny top");
		
		txtProdajniKurs = new JTextField();
		contentPane.add(txtProdajniKurs, "cell 0 3,growx,aligny top");
		txtProdajniKurs.setColumns(10);
		
		txtKupovniKurs = new JTextField();
		contentPane.add(txtKupovniKurs, "cell 1 3,growx,aligny top");
		txtKupovniKurs.setColumns(10);
		
		lblSrednjiKurs = new JLabel("Srednji kurs");
		contentPane.add(lblSrednjiKurs, "cell 0 4,growx,aligny top");
		
		lblSkraceniNaziv = new JLabel("Skraceni naziv");
		contentPane.add(lblSkraceniNaziv, "cell 1 4,growx,aligny top");
		
		txtSrednjiKurs = new JTextField();
		contentPane.add(txtSrednjiKurs, "cell 0 5,growx,aligny top");
		txtSrednjiKurs.setColumns(10);
		
		txtSkraceniNaziv = new JTextField();
		contentPane.add(txtSkraceniNaziv, "cell 1 5,growx,aligny top");
		txtSkraceniNaziv.setColumns(10);
		
		btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kontroler.dodaj(modelRoditelja, menjacnica.getPolje(), textFieldSifra, txtNaziv, txtProdajniKurs, txtKupovniKurs, txtSrednjiKurs, txtSkraceniNaziv);
				dispose();
			}
			
		});
		contentPane.add(btnDodaj, "cell 0 6,growx,aligny top");
		
		btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnOdustani, "cell 1 6,growx,aligny top");
	}
}
