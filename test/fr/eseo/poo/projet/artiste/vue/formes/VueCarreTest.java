package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Carre;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class of the{@linkplain VueCarreTest}.
 * 
 * @see VueCarre
 * @see PanneauDessin
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.2
 */
public class VueCarreTest {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueCarreTest();
            }
        });
    }

    /**
     * Test of {@linkplain VueCarreTest}. Allows the creation of the window and
     * circle for a visual test.
     * 
     * @since 1.3.2
     */
    public VueCarreTest() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneau = new PanneauDessin();

        frame.getContentPane().add(panneau);
        frame.setTitle("VueCarreTest");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final VueCarre carre1 = new VueCarre(new Carre());
        final VueCarre carre2 = new VueCarre(new Carre(new Coordonnees(50, 100)));
        final VueCarre carre3 = new VueCarre(new Carre(new Coordonnees(100, 100), 50));

        panneau.ajouterVueForme(carre1);
        panneau.ajouterVueForme(carre2);
        panneau.ajouterVueForme(carre3);

        final Carre carre = new Carre(new Coordonnees(50, 80));
        carre.setRempli(true);
        final VueCarre carre4 = new VueCarre(carre);

        panneau.ajouterVueForme(carre4);
    }
}