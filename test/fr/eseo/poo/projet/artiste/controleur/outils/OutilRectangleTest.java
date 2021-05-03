package fr.eseo.poo.projet.artiste.controleur.outils;

import static org.junit.Assert.assertEquals;

import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class parameterized of the {@link OutilRectangle}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.8
 */
@RunWith(Parameterized.class)
public class OutilRectangleTest {
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
    private final OutilRectangle outil;

    /**
     * Reference rectangle for double click
     */
    private final Rectangle rectangleReferenceDouble;

    /**
     * Reference rectangle for the click and drag
     */
    private final Rectangle rectangleReferenceDrag;

    /**
     * Number of π for drag
     */
    private final int nbPie;

    /**
     * Builder for each test for OutilLigne.
     * 
     * @param p_rectangleReferenceDouble rectangle for double click
     * @param p_rectangleReferenceDrag   rectangle for the click and drag
     * @param p_nbPie                    number of π for drag
     */
    public OutilRectangleTest(Rectangle p_rectangleReferenceDouble, Rectangle p_rectangleReferenceDrag, int p_nbPie) {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin();
        this.outil = new OutilRectangle();
        this.panneau.associerOutil(this.outil);
        this.rectangleReferenceDouble = p_rectangleReferenceDouble;
        this.rectangleReferenceDrag = p_rectangleReferenceDrag;
        this.nbPie = p_nbPie;

        this.frame.getContentPane().add(panneau);
        this.frame.setTitle("OutilRectangleTest");
        this.frame.setSize(this.panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creation of the test list.
     * 
     * {0} the first rectangle for double click. {1} the second Rectangle for the
     * click and drag. {2} the number of π
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0} {1} {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0
                { new Rectangle(new Coordonnees(0, 30)), new Rectangle(new Coordonnees(100, 90), 71, 81), 1 },
                // Test 1
                { new Rectangle(new Coordonnees(60, 30)), new Rectangle(new Coordonnees(100, 90), 71, 81), 3 },
                // Test 2
                { new Rectangle(new Coordonnees(90, 30)), new Rectangle(new Coordonnees(100, 90), 100, 10), 4 },
                // Test 3
                { new Rectangle(new Coordonnees(120, 30)), new Rectangle(new Coordonnees(100, 90), 71, 81), 5 } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link OutilRectangle#creerVueForme()}
     */
    @Test
    public void testOutilRectangleDoubleClick() {
        int x = (int) this.rectangleReferenceDouble.getPosition().getAbscisse();
        int y = (int) this.rectangleReferenceDouble.getPosition().getOrdonnee();
        // We simulate the double click
        this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
        this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
        this.outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                MouseEvent.BUTTON1_DOWN_MASK, x, y, 2, false, MouseEvent.BUTTON1));

        Rectangle rectangleActual = (Rectangle) this.panneau.getVueFormes().get(0).getForme();
        assertEquals("Test du double clic", this.rectangleReferenceDouble, rectangleActual);
    }

    /**
     * Test of {@link OutilRectangle#creerVueForme()}
     */
    @Test
    public void testOutilRectangleGlisseClick() {
        final int largeur = (int) Math.abs(Math.round((100 * Math.cos(this.nbPie * Math.PI / 4))));
        final int hauteur = (int) Math.abs(Math.round((100 * Math.sin(this.nbPie * Math.PI / 4))));
        this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                MouseEvent.BUTTON1_DOWN_MASK, 100, 100 - 10, 1, false, MouseEvent.BUTTON1));
        this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                MouseEvent.BUTTON1_DOWN_MASK, 100 + largeur, 100 + hauteur, 1, false, MouseEvent.BUTTON1));

        Rectangle RectangleActual = (Rectangle) this.panneau.getVueFormes().get(0).getForme();
        assertEquals("Test du clic glissé", this.rectangleReferenceDrag, RectangleActual);
    }
}
