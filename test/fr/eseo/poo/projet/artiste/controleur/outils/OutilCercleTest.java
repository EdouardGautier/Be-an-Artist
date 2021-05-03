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
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

//TODO : Revoir la tabulation 
/**
 * Base test class parameterized of the {@link OutilCercle}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.8
 */
@RunWith(Parameterized.class)
public class OutilCercleTest {
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
        private final OutilCercle outil;

        /**
         * Reference circle for double click
         */
        private final Cercle cercleReferenceDouble;

        /**
         * Reference circle for the click and drag
         */
        private final Cercle cercleReferenceDrag;

        /**
         * Number of π for drag
         */
        private final int nbPie;

        /**
         * Builder for each test for OutilLigne.
         * 
         * @param p_cercleReferenceDouble circle for double click
         * @param p_cercleReferenceDrag   circle for the click and drag
         * @param p_nbPie                 number of π for drag
         */
        public OutilCercleTest(Cercle p_cercleReferenceDouble, Cercle p_cercleReferenceDrag, int p_nbPie) {
                this.frame = new JFrame();
                this.panneau = new PanneauDessin();
                this.outil = new OutilCercle();
                this.panneau.associerOutil(this.outil);
                this.cercleReferenceDouble = p_cercleReferenceDouble;
                this.cercleReferenceDrag = p_cercleReferenceDrag;
                this.nbPie = p_nbPie;

                this.frame.getContentPane().add(panneau);
                this.frame.setTitle("OutilCercleTest");
                this.frame.setSize(this.panneau.getPreferredSize());
                this.frame.setLocationRelativeTo(null);
                this.frame.setVisible(true);
                this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        /**
         * Creation of the test list.
         * 
         * {0} the first circle for double click. {1} the second circle for the click
         * and drag. {2} the number of π
         * 
         * @return all the tests.
         */
        @Parameters(name = "dt[{index}] : {0} {1} {2}")
        public static Collection<Object[]> dt() {
                final Object[][] data = new Object[][] {
                                // Test 0
                                { new Cercle(new Coordonnees(0, 30)), new Cercle(new Coordonnees(100, 90), 81), 1 },
                                // Test 1
                                { new Cercle(new Coordonnees(60, 30)), new Cercle(new Coordonnees(100, 90), 81), 3 },
                                // Test 2
                                { new Cercle(new Coordonnees(90, 30)), new Cercle(new Coordonnees(100, 90), 100), 4 },
                                // Test 3
                                { new Cercle(new Coordonnees(120, 30)), new Cercle(new Coordonnees(100, 90), 81), 5 } };
                return Arrays.asList(data);
        }

        /**
         * Test of {@link OutilCercle#creerVueForme()}
         */
        @Test
        public void testOutilCercleDoubleClick() {
                int x = (int) this.cercleReferenceDouble.getPosition().getAbscisse();
                int y = (int) this.cercleReferenceDouble.getPosition().getOrdonnee();
                // We simulate the double click
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 2, false, MouseEvent.BUTTON1));

                Cercle cercleActual = (Cercle) this.panneau.getVueFormes().get(0).getForme();
                assertEquals("Test du double clic", this.cercleReferenceDouble, cercleActual);
        }

        /**
         * Test of {@link OutilCercle#creerVueForme()}
         */
        @Test
        public void testOutilCercleGlisseClick() {
                final int largeur = (int) Math.abs(Math.round((100 * Math.cos(this.nbPie * Math.PI / 4))));
                final int hauteur = (int) Math.abs(Math.round((100 * Math.sin(this.nbPie * Math.PI / 4))));
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100, 100 - 10, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100 + largeur, 100 + hauteur, 1, false,
                                MouseEvent.BUTTON1));

                Cercle cercleActual = (Cercle) this.panneau.getVueFormes().get(0).getForme();
                assertEquals("Test du clic glissé", this.cercleReferenceDrag, cercleActual);
        }
}
