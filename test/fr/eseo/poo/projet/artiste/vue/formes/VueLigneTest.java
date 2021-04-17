package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class of the{@linkplain VueLigne}.
 * 
 * @see VueLigne
 * @see PanneauDessin
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.3.6
 */
public class VueLigneTest {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueLigneTest();
            }
        });
    }

    /**
     * Test of {@linkplain VueLigne}. Allows the creation of the window and lines
     * for a visual test.
     * 
     * @since 0.3.3.6
     */
    public VueLigneTest() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneau = new PanneauDessin();

        frame.getContentPane().add(panneau);
        frame.setTitle("VueLigneTest");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final VueLigne ligne1 = new VueLigne(new Ligne());
        final VueLigne ligne2 = new VueLigne(new Ligne(new Coordonnees(210, 56), 35, 85));
        final VueLigne ligne3 = new VueLigne(new Ligne(new Coordonnees(300, 10), 64, 64));

        panneau.ajouterVueForme(ligne1);
        panneau.ajouterVueForme(ligne2);
        panneau.ajouterVueForme(ligne3);
    }
}