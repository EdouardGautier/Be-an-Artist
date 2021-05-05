package fr.eseo.poo.projet.artiste.controleur.actions;

import static org.junit.Assert.assertEquals;

import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class parameterized of the {@link ActionEffacer}
 * 
 * @see ActionEffacer
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.6
 */
@RunWith(Parameterized.class)
public class ActionEffacerTest {
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
    private final OutilLigne outil;

    /**
     * Lines to be drawn
     */
    private Ligne[] listLine;

    /**
     * The action to be tested
     */
    private ActionEffacer actionEffacer;

    /**
     * Builder for each test for ActionEffacer.
     * 
     * @param listLine List of lines to be drawn
     */
    public ActionEffacerTest(Ligne[] listLine) {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin();
        this.outil = new OutilLigne();
        this.actionEffacer = new ActionEffacer(this.panneau);

        this.panneau.associerOutil(this.outil);
        this.frame.getContentPane().add(panneau);
        this.frame.setTitle("ActionEffacerTest");
        this.frame.setSize(this.panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.listLine = listLine;
    }

    /**
     * Creation of the test list.
     * 
     * {0} List of lines to be drawn
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}")
    public static Collection<Ligne[][]> dt() {
        final Ligne[][][] data = new Ligne[][][] {
                // Test 0
                { {} },
                // Test 1
                { { new Ligne() } },
                // Test 2
                { { new Ligne(new Coordonnees(30, 30)), new Ligne() } } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link ActionEffacer#actionPerformed()}
     */
    @Test
    public void testActionEffacer() {
        // The lines are drawn
        for (Ligne line : this.listLine) {
            int x = (int) line.getC1().getAbscisse();
            int y = (int) line.getC1().getOrdonnee();
            this.outil.mousePressed(new MouseEvent(frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                    MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
            this.outil.mouseReleased(new MouseEvent(frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                    MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
            this.outil.mouseClicked(new MouseEvent(frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                    MouseEvent.BUTTON1_DOWN_MASK, x, y, 2, false, MouseEvent.BUTTON1));
        }

        // The operator must click on "Yes".
        this.actionEffacer.actionPerformed(null);
        // The list must be empty.
        List<VueForme> ligneActual = this.panneau.getVueFormes();
        assertEquals("Test de l'action d'effacer", 0, ligneActual.size());
    }
}