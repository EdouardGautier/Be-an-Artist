package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Base test class (with asserts and not parameterized) of the
 * {@linkplain PanneauDessin}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.3.2
 * 
 */
public class PanneauDessinTest {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanneauDessinTest();
            }
        });
    }

    public PanneauDessinTest() {
        this.testConstructeurParDefaut();
        this.testConstructeur();
    }

    /**
     * Test of {@linkplain PanneauDessin#PanneauDessin()}.
     * <p>
     * We would create a main window with the title {@code Etre un Artiste}, then
     * change the size of the window and display it.
     * <p>
     * Closing the window will stop the application.
     */
    private void testConstructeurParDefaut() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneau = new PanneauDessin();

        frame.getContentPane().add(panneau);
        frame.setTitle("Etre un Artiste");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocation(100, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Test of {@linkplain PanneauDessin#PanneauDessin(int, int, Color)}.
     * <p>
     * We created a main window with the title {@code  Blues du Businessman}, then we
     * change the size of the window.
     * <p>
     * Closing the window will stop the application.
     */
    private void testConstructeur() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneau = new PanneauDessin(600, 600, Color.blue);

        frame.getContentPane().add(panneau);
        frame.setTitle("Blues du Businessman");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocation(550, 50);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
