package menjacnica.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import model.Model;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 528);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		
		mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.aboutDialog();
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEast = new JPanel();
		contentPane.add(panelEast, BorderLayout.EAST);
		GridBagLayout gbl_panelEast = new GridBagLayout();
		gbl_panelEast.columnWidths = new int[]{17, 103, 8, 0};
		gbl_panelEast.rowHeights = new int[]{25, 25, 25, 0};
		gbl_panelEast.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelEast.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEast.setLayout(gbl_panelEast);
		
		JButton btnDodajKurs = new JButton("Dodaj kurs");
		GridBagConstraints gbc_btnDodajKurs = new GridBagConstraints();
		gbc_btnDodajKurs.anchor = GridBagConstraints.NORTH;
		gbc_btnDodajKurs.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDodajKurs.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodajKurs.gridx = 1;
		gbc_btnDodajKurs.gridy = 0;
		panelEast.add(btnDodajKurs, gbc_btnDodajKurs);
		
		JButton btnIzbrisiKurs = new JButton("Izbrisi kurs");
		btnIzbrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnIzbrisiKurs = new GridBagConstraints();
		gbc_btnIzbrisiKurs.anchor = GridBagConstraints.NORTH;
		gbc_btnIzbrisiKurs.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIzbrisiKurs.insets = new Insets(0, 0, 5, 5);
		gbc_btnIzbrisiKurs.gridx = 1;
		gbc_btnIzbrisiKurs.gridy = 1;
		panelEast.add(btnIzbrisiKurs, gbc_btnIzbrisiKurs);
		
		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		GridBagConstraints gbc_btnIzvrsiZamenu = new GridBagConstraints();
		gbc_btnIzvrsiZamenu.insets = new Insets(0, 0, 0, 5);
		gbc_btnIzvrsiZamenu.anchor = GridBagConstraints.NORTH;
		gbc_btnIzvrsiZamenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIzvrsiZamenu.gridx = 1;
		gbc_btnIzvrsiZamenu.gridy = 2;
		panelEast.add(btnIzvrsiZamenu, gbc_btnIzvrsiZamenu);	
		
		JScrollPane scrollPaneSouth = new JScrollPane();
		scrollPaneSouth.setAutoscrolls(true);
		scrollPaneSouth.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(scrollPaneSouth, BorderLayout.SOUTH);
		
		JScrollPane scrollPaneCenter = new JScrollPane();
		contentPane.add(scrollPaneCenter, BorderLayout.CENTER);
		
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPaneCenter, popupMenu);
		
		JMenuItem mntmDodajKurs = new JMenuItem("Dodaj kurs");
		popupMenu.add(mntmDodajKurs);
		
		JMenuItem mntmIzbrisiKurs = new JMenuItem("Izbrisi kurs");
		popupMenu.add(mntmIzbrisiKurs);
		
		JMenuItem mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
		popupMenu.add(mntmIzvrsiZamenu);	
		
		Model model = Kontroler.kreirajModel();		
		table = new JTable();
		table.setModel(model);
		scrollPaneCenter.setViewportView(table);
		
		JTextArea textArea = new JTextArea();
		scrollPaneSouth.setViewportView(textArea);
			
		
		
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(textArea.getText() + "\n" + Kontroler.open());
			}
		});
		
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(textArea.getText() + "\n" + Kontroler.save());
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.exitDialog();
			}
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
