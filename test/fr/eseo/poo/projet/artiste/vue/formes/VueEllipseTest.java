package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class of the{@linkplain VueEllipse}.
 * 
 * @see VueEllipse
 * @see PanneauDessin
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.3.8
 */
public class VueEllipseTest {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueEllipseTest();
            }
        });
    }

    /**
     * Test of {@linkplain VueEllipse}. Allows the creation of the window and ellipse
     * for a visual test.
     * 
     * @since 0.3.3.8
     */
    public VueEllipseTest() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneau = new PanneauDessin();

        frame.getContentPane().add(panneau);
        frame.setTitle("VueEllipseTest");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final VueEllipse ellipse1 = new VueEllipse(new Ellipse());
        final VueEllipse ellipse2 = new VueEllipse(new Ellipse(400, 200));
        final VueEllipse ellipse3 = new VueEllipse(new Ellipse(new Coordonnees(50, 100), 40, 25));

        panneau.ajouterVueForme(ellipse1);
        panneau.ajouterVueForme(ellipse2);
        panneau.ajouterVueForme(ellipse3);
    }
}