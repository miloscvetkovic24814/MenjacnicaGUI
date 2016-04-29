package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import java.awt.Font;

@SuppressWarnings("serial")
public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About(String podaciOAutoru) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		setTitle("Podaci o autoru");
		setBounds(100, 100, 436, 144);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JTextArea textArea = new JTextArea();
			textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
			textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			contentPanel.add(textArea);
			textArea.setEditable(false);
			textArea.setText(podaciOAutoru);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
