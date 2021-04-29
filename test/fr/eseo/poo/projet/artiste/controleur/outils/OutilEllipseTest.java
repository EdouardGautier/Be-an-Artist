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
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

//TODO : Revoir la tabulation 
/**
 * Base test class parameterized of the {@link OutilEllipse}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.8
 */
@RunWith(Parameterized.class)
public class OutilEllipseTest {
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
         * Reference ellipse for double click
         */
        private final Ellipse ellipseReferenceDouble;

        /**
         * Reference ellipse for the click and drag
         */
        private final Ellipse ellipseReferenceDrag;

        /**
         * Number of π for drag
         */
        private final int nbPie;

        /**
         * Builder for each test for OutilLigne.
         * 
         * @param p_ellipseReferenceDouble ellipse for double click
         * @param p_ellipseReferenceDrag   ellipse for the click and drag
         * @param p_nbPie                  number of π for drag
         */
        public OutilEllipseTest(Ellipse p_ellipseReferenceDouble, Ellipse p_ellipseReferenceDrag, int p_nbPie) {
                this.frame = new JFrame();
                this.panneau = new PanneauDessin();
                this.outil = new OutilEllipse();
                this.panneau.associerOutil(this.outil);
                this.ellipseReferenceDouble = p_ellipseReferenceDouble;
                this.ellipseReferenceDrag = p_ellipseReferenceDrag;
                this.nbPie = p_nbPie;

                this.frame.getContentPane().add(panneau);
                this.frame.setTitle("OutilEllipseTest");
                this.frame.setSize(this.panneau.getPreferredSize());
                this.frame.setLocationRelativeTo(null);
                this.frame.setVisible(true);
                this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        /**
         * Creation of the test list.
         * 
         * {0} the first ellipse for double click. {1} the second ellipse for the click
         * and drag. {2} the number of π
         * 
         * @return all the tests.
         */
        @Parameters(name = "dt[{index}] : {0} {1} {2}")
        public static Collection<Object[]> dt() {
                final Object[][] data = new Object[][] {
                                // Test 0
                                { new Ellipse(new Coordonnees(0, 30)), new Ellipse(new Coordonnees(100, 90), 71, 81),
                                                1 },
                                // Test 1
                                { new Ellipse(new Coordonnees(60, 30)), new Ellipse(new Coordonnees(100, 90), 71, 81),
                                                3 },
                                // Test 2
                                { new Ellipse(new Coordonnees(90, 30)), new Ellipse(new Coordonnees(100, 90), 100, 10),
                                                4 },
                                // Test 3
                                { new Ellipse(new Coordonnees(120, 30)), new Ellipse(new Coordonnees(100, 90), 71, 81),
                                                5 } };
                return Arrays.asList(data);
        }

        /**
         * Test of {@link OutilEllipse#creerVueForme()}
         */
        @Test
        public void testOutilEllipseDoubleClick() {
                int x = (int) this.ellipseReferenceDouble.getPosition().getAbscisse();
                int y = (int) this.ellipseReferenceDouble.getPosition().getOrdonnee();
                // We simulate the double click
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 2, false, MouseEvent.BUTTON1));

                Ellipse ellipseActual = (Ellipse) this.panneau.getVueFormes().get(0).getForme();
                assertEquals("Test du double clic", this.ellipseReferenceDouble, ellipseActual);
        }

        /**
         * Test of {@link OutilEllipse#creerVueForme()}
         */
        @Test
        public void testOutilEllipseGlisseClick() {
                final int largeur = (int) Math.abs(Math.round((100 * Math.cos(this.nbPie * Math.PI / 4))));
                final int hauteur = (int) Math.abs(Math.round((100 * Math.sin(this.nbPie * Math.PI / 4))));
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100, 100 - 10, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100 + largeur, 100 + hauteur, 1, false,
                                MouseEvent.BUTTON1));

                Ellipse ellipseActual = (Ellipse) this.panneau.getVueFormes().get(0).getForme();
                assertEquals("Test du clic glissé", this.ellipseReferenceDrag, ellipseActual);
        }
}
