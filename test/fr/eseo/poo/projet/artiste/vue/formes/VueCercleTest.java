package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class of the{@linkplain VueCercleTest}.
 * 
 * @see VueCercle
 * @see PanneauDessin
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.3.8
 */
public class VueCercleTest {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueCercleTest();
            }
        });
    }

    /**
     * Test of {@linkplain VueCercleTest}. Allows the creation of the window and
     * circle for a visual test.
     * 
     * @since 0.3.3.8
     */
    public VueCercleTest() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneau = new PanneauDessin();

        frame.getContentPane().add(panneau);
        frame.setTitle("VueCercleTest");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final VueEllipse cercle1 = new VueCercle(new Cercle());
        final VueEllipse cercle2 = new VueCercle(new Cercle(new Coordonnees(50, 100)));
        final VueEllipse cercle3 = new VueCercle(new Cercle(new Coordonnees(100, 100), 50));

        panneau.ajouterVueForme(cercle1);
        panneau.ajouterVueForme(cercle2);
        panneau.ajouterVueForme(cercle3);
    }
}