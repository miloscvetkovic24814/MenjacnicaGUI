package menjacnica.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import kontroler.Kontroler;

import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class IzvrsiZamenuGui extends JFrame {

	private JPanel contentPane;
	private JTextField txtKupovnikurs;
	private JTextField txtProdajnikurs;
	private JTextField txtIznos;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGui(JTextArea polje) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvrsiZamenuGui.class.getResource("/sun/print/resources/tumble.png")));
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 471, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKupovniKurs.setBounds(29, 32, 84, 16);
		contentPane.add(lblKupovniKurs);
		
		txtKupovnikurs = new JTextField();
		txtKupovnikurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtKupovnikurs.setEditable(false);
		txtKupovnikurs.setBounds(29, 61, 116, 22);
		contentPane.add(txtKupovnikurs);
		txtKupovnikurs.setColumns(10);
		
		String[] comboVrednosti = {"EUR","USD","CHF"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(comboVrednosti);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(183, 61, 97, 22);
		contentPane.add(comboBox);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProdajniKurs.setBounds(321, 32, 97, 16);
		contentPane.add(lblProdajniKurs);
		
		txtProdajnikurs = new JTextField();
		txtProdajnikurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtProdajnikurs.setEditable(false);
		txtProdajnikurs.setBounds(321, 61, 116, 22);
		contentPane.add(txtProdajnikurs);
		txtProdajnikurs.setColumns(10);
		
		JLabel lblIznos = new JLabel("Iznos");
		lblIznos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIznos.setBounds(29, 130, 56, 16);
		contentPane.add(lblIznos);
		
		txtIznos = new JTextField();
		txtIznos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtIznos.setBounds(29, 159, 116, 22);
		contentPane.add(txtIznos);
		txtIznos.setColumns(10);
		
		JLabel lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		lblVrstaTransakcije.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVrstaTransakcije.setBounds(271, 118, 127, 16);
		contentPane.add(lblVrstaTransakcije);
		
		JRadioButton rdbtnKupovina = new JRadioButton("Kupovina");
		rdbtnKupovina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(rdbtnKupovina);
		rdbtnKupovina.setBounds(257, 158, 127, 25);
		contentPane.add(rdbtnKupovina);
		
		JRadioButton rdbtnProdaja = new JRadioButton("Prodaja");
		rdbtnProdaja.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup.add(rdbtnProdaja);
		rdbtnProdaja.setBounds(257, 198, 127, 25);
		contentPane.add(rdbtnProdaja);
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Tahoma", Font.PLAIN, 13));
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(29, 244, 408, 65);
		contentPane.add(slider);
		
		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.zameniKurs(polje, txtIznos.getText(), rdbtnKupovina, rdbtnProdaja, comboBox);
			}
		});
		btnIzvrsiZamenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIzvrsiZamenu.setBounds(29, 336, 173, 37);
		contentPane.add(btnIzvrsiZamenu);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOdustani.setBounds(257, 336, 180, 37);
		contentPane.add(btnOdustani);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtIznos.setText("" + slider.getValue());
			}
		});
	}
}
