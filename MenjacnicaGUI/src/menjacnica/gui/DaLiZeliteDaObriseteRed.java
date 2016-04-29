package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import model.Model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class DaLiZeliteDaObriseteRed extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public DaLiZeliteDaObriseteRed(JTextArea polje, JTable table, Model model) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DaLiZeliteDaObriseteRed.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		setTitle("Potvrda");
		setBounds(100, 100, 421, 138);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblDaLiSte = new JLabel("Da li ste sigurni da zelite da obrisete red?");
			lblDaLiSte.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblDaLiSte);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDa = new JButton("Da");
				btnDa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Kontroler.obrisiRed(polje, table, model);
						dispose();
					}
				});
				btnDa.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnDa.setActionCommand("OK");
				buttonPane.add(btnDa);
				getRootPane().setDefaultButton(btnDa);
			}
			{
				JButton btnNe = new JButton("Ne");
				btnNe.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnNe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnNe.setActionCommand("Cancel");
				buttonPane.add(btnNe);
			}
		}
	}

}
