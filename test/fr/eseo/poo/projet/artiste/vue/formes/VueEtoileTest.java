package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class of the{@linkplain VueLigne}.
 * 
 * @see VueLigne
 * @see PanneauDessin
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.2
 */
public class VueEtoileTest {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueEtoileTest();
            }
        });
    }

    /**
     * Test of {@linkplain VueEtoile}. Allows the creation of the window and lines
     * for a visual test.
     * 
     * @since 0.3.7.2
     */
    public VueEtoileTest() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneau = new PanneauDessin();

        frame.getContentPane().add(panneau);
        frame.setTitle("VueEtoileTest");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final VueEtoile etoile1 = new VueEtoile(new Etoile());
        final VueEtoile etoile2 = new VueEtoile(new Etoile(new Coordonnees(20, 0), 170, 10, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT));
        final VueEtoile etoile3 = new VueEtoile(new Etoile(new Coordonnees(200, 0), 170, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI / 3, 0.5));

        panneau.ajouterVueForme(etoile1);
        panneau.ajouterVueForme(etoile2);
        panneau.ajouterVueForme(etoile3);
    }
}