/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;

	JMenu mVisites;

	/**
	 * 
	 */
	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
													// JInternalFrame a la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("GSB");
		setSize(500, 400);

		// Ajout d'une barre de menus a la fenetre
		mbar = new JMenuBar();
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un ecouteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);

		mMedicaments = new JMenu("Medicaments");
		JMenuItem mE1 = new JMenuItem("Consultation Medicament");
		mE1.addActionListener(this); // installation d'un ecouteur d'action
		mMedicaments.add(mE1);
		JMenuItem mE2 = new JMenuItem("Ajout Medicaments");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);
		JMenuItem mE3 = new JMenuItem("Medicament par Famille");
		mE3.addActionListener(this);
		mMedicaments.add(mE3);

		mVisites = new JMenu("Visites");
		JMenuItem mA1 = new JMenuItem("Mise à Jour d'une Visite");
		mA1.addActionListener(this); // installation d'un ecouteur d'action
		mVisites.add(mA1);
		JMenuItem mA2 = new JMenuItem("Ajout d'une Visite");
		mA2.addActionListener(this);
		mVisites.add(mA2);
		JMenuItem mA3 = new JMenuItem("Liste de Visite");
		mA3.addActionListener(this);
		mVisites.add(mA3);

		mbar.add(mMedecins);
		mbar.add(mMedicaments);
		mbar.add(mVisites);
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Raccord de methode auto-genere
		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();

			if (ChoixOption.equals("Consultation Medecin")) {
				// Creation d'une sous-fenetre
				ouvrirFenetre(new JIFMedecinCons());

			} else if (ChoixOption.equals("Liste Medecins")) {
				ouvrirFenetre(new JIFMedecinListeDic(this));
			}
			else if (ChoixOption.equals("Consultation Medicament")) {
				ouvrirFenetre(new JIFMedicamentsList(this));
			}
			else if (ChoixOption.equals("Ajout Medicaments")) {
				ouvrirFenetre(new JIFMedicamentsAjout(this));
			}
			else if (ChoixOption.equals("Medicament par Famille")) {
				ouvrirFenetre(new JIFMedicamentsFamille(this));
			}
			else if (ChoixOption.equals("Mise à Jour d'une Visite")) {
				ouvrirFenetre(new JIFVisiteMaj (this));
			}
			else if (ChoixOption.equals("Ajout d'une Visite")) {
				ouvrirFenetre(new JIFVisiteAjout(this));
			}
			else if (ChoixOption.equals("Liste de Visite")) {
				ouvrirFenetre(new JIFVisiteList(this));
			}
			
		}
	}
	

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fenetre etait deja affichee, elle
									// est liberee
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(480, 380);
		desktopPane.add(myJInternalFrame);
	}

}
