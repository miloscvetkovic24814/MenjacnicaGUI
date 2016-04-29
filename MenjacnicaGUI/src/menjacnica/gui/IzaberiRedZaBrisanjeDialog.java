package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IzaberiRedZaBrisanjeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IzaberiRedZaBrisanjeDialog dialog = new IzaberiRedZaBrisanjeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IzaberiRedZaBrisanjeDialog() {
		setTitle("Greska!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzaberiRedZaBrisanjeDialog.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		setBounds(100, 100, 444, 132);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblMorateDaIzaberete = new JLabel("Morate da izaberete red za brisanje!");
			lblMorateDaIzaberete.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblMorateDaIzaberete);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
