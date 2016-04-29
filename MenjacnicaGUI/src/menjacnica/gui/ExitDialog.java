package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ExitDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public ExitDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ExitDialog.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		setTitle("Izlazak?");
		setBounds(100, 100, 436, 148);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel lblDaLiZelite = new JLabel("Da li \u017Eelite da iza\u0111ete iz programa?");
			contentPanel.add(lblDaLiZelite);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnYes = new JButton("Yes");
				btnYes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnYes.setActionCommand("OK");
				buttonPane.add(btnYes);
				getRootPane().setDefaultButton(btnYes);
			}
			{
				JButton btnNo = new JButton("No");
				btnNo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnNo);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
