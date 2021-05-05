package fr.eseo.poo.projet.artiste.controleur.actions;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class parameterized of the {@link ActionChoisirCouleur}
 * 
 * @see ActionChoisirCouleur
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.5.3
 */
@RunWith(Parameterized.class)
public class ActionChoisirCouleurTest {
    /**
     * Frame where the drawing area will be placed.
     */
    private final JFrame frame;

    /**
     * The drawing area.
     */
    private final PanneauDessin panneau;

    /**
     * Tool tested.
     */
    private final OutilEllipse outil;

    /**
     * The action to be tested
     */
    private ActionChoisirCouleur actionChoisirCouleur;

    /**
     * Ellipses to be drawn
     */
    private Ellipse ellipse;

    /**
     * Builder for each test for ActionChoisirCouleur.
     * 
     * @param ellipse ellipses to be drawn
     */
    public ActionChoisirCouleurTest(Ellipse ellipse) {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin();
        this.outil = new OutilEllipse();
        this.actionChoisirCouleur = new ActionChoisirCouleur(this.panneau);

        this.panneau.associerOutil(this.outil);
        this.frame.getContentPane().add(panneau);
        this.frame.setTitle("ActionChoisirCouleurTest");
        this.frame.setSize(this.panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.ellipse = ellipse;
    }

    /**
     * Creation of the test list.
     * 
     * {0} ellipses to be drawn
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}")
    public static List<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 1
                { new Ellipse() },
                // Test 2
                { new Ellipse(400, 200) },
                // Test 3
                { new Ellipse(new Coordonnees(50, 100), 40, 25) } };
        return Arrays.asList(data);
    }

    @Test
    public void testActionChoisirCouleur() {

        this.actionChoisirCouleur.actionPerformed(null);
        Color color = this.panneau.getCouleurCourante();

        int x = (int) this.ellipse.getPosition().getAbscisse();
        int y = (int) this.ellipse.getPosition().getOrdonnee();
        // We simulate the double click
        this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
        this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
        this.outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                MouseEvent.BUTTON1_DOWN_MASK, x, y, 2, false, MouseEvent.BUTTON1));

        Ellipse ellispeActual = (Ellipse) this.panneau.getVueFormes().get(0).getForme();

        assertEquals("Test de l'action choisir couleur", color, ellispeActual.getCouleur());
    }
}
