package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class of the{@linkplain VueRectangle}.
 * 
 * @see VueRectangle
 * @see PanneauDessin
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.1
 * 
 * @version 0.3.6.2
 */
public class VueRectangleTest {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueRectangleTest();
            }
        });
    }

    /**
     * Test of {@linkplain VueRectangle}. Allows the creation of the window and rectangle
     * for a visual test.
     * 
     * @since 1.3.1
     */
    public VueRectangleTest() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneau = new PanneauDessin();

        frame.getContentPane().add(panneau);
        frame.setTitle("VueRectangleTest");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final VueRectangle rectangle1 = new VueRectangle(new Rectangle());
        final VueRectangle rectangle2 = new VueRectangle(new Rectangle(400, 200));
        final VueRectangle rectangle3 = new VueRectangle(new Rectangle(new Coordonnees(50, 100), 40, 25));

        panneau.ajouterVueForme(rectangle1);
        panneau.ajouterVueForme(rectangle2);
        panneau.ajouterVueForme(rectangle3);

        final Rectangle rectangle = new Rectangle(new Coordonnees(50, 80));
        rectangle.setRempli(true);
        final VueRectangle rectangle4 = new VueRectangle(rectangle);

        panneau.ajouterVueForme(rectangle4);
    }
}