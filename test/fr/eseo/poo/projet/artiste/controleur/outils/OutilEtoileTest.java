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
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

//TODO : Revoir la tabulation 
/**
 * Base test class parameterized of the {@link OutilEtoileTest}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.3
 */
@RunWith(Parameterized.class)
public class OutilEtoileTest {
        /**
         * Frame where the drawing area will be placed.
         */
        private final JFrame frame;

        /**
         * The drawing area.
         */
        private final PanneauDessin panneauDessin;

        /**
         * Tool tested.
         */
        private final OutilEtoile outil;

        /**
         * Reference Etoile for double click
         */
        private final Etoile etoileReferenceDouble;

        /**
         * Reference Etoile for the click and drag
         */
        private final Etoile etoileReferenceDrag;

        /**
         * /**
	 * We get the information about the star to be
	 * drawn
         */
        private final PanneauBarreOutils panneauOutils;

        /**
         * Number of π for drag
         */
        private int nbPie;

        /**
         * Builder for each test for OutilLigne.
         * 
         * @param p_etoileReferenceDouble Etoile for double click
         * @param p_etoileReferenceDrag   Etoile for the click and drag
         * @param p_nbPie                 number of π for drag
         */
        public OutilEtoileTest(Etoile p_etoileReferenceDouble, Etoile p_etoileReferenceDrag, int p_nbPie) {
                this.frame = new JFrame();
                this.panneauDessin = new PanneauDessin();
                this.panneauOutils = new PanneauBarreOutils(panneauDessin);
                this.outil = new OutilEtoile(panneauOutils);
                this.panneauDessin.associerOutil(this.outil);
                this.etoileReferenceDouble = p_etoileReferenceDouble;
                this.etoileReferenceDrag = p_etoileReferenceDrag;
                this.nbPie = p_nbPie;

                this.frame.getContentPane().add(panneauDessin);
                this.frame.setTitle("OutilEtoileTest");
                this.frame.setSize(this.panneauDessin.getPreferredSize());
                this.frame.setLocationRelativeTo(null);
                this.frame.setVisible(true);
                this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        /**
         * Creation of the test list.
         * 
         * {0} the first Etoile for double click. {1} the second Etoile for the click
         * and drag. {2} the number of π
         * 
         * @return all the tests.
         */
        @Parameters(name = "dt[{index}] : {0} {1} {2}")
        public static Collection<Object[]> dt() {
                final Object[][] data = new Object[][] {
                                // Test 0
                                { new Etoile(new Coordonnees(0, 30)),
                                                new Etoile(new Coordonnees(63.29, 63.29), 215.42, 5, 2.29, 1), 1 },
                                // Test 1
                                { new Etoile(new Coordonnees(60, 30)),
                                                new Etoile(new Coordonnees(63.29, 63.29), 215.42, 5, 2.29, 1), 3 },
                                // Test 2
                                { new Etoile(new Coordonnees(90, 30)),
                                                new Etoile(new Coordonnees(99.5, -0.5), 201, 5, 2.29, 1), 4 },
                                // Test 3
                                { new Etoile(new Coordonnees(120, 30)),
                                                new Etoile(new Coordonnees(63.29, 63.29), 215.42, 5, 2.29, 1), 5 } };
                return Arrays.asList(data);
        }

        /**
         * Test of {@link OutilEtoile#creerVueForme()}
         */
        @Test
        public void testOutilEtoileDoubleClick() {
                int x = (int) this.etoileReferenceDouble.getPosition().getAbscisse();
                int y = (int) this.etoileReferenceDouble.getPosition().getOrdonnee();
                // We simulate the double click
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 2, false, MouseEvent.BUTTON1));

                Etoile etoileActual = (Etoile) this.panneauDessin.getVueFormes().get(0).getForme();
                assertEquals("Test du double clic", this.etoileReferenceDouble, etoileActual);
        }

        /**
         * Test of {@link OutilEtoile#creerVueForme()}
         */
        @Test
        public void testOutilEtoileGlisseClick() {
                final int largeur = (int) Math.abs(Math.round((100 * Math.cos(this.nbPie * Math.PI / 4))));
                final int hauteur = (int) Math.abs(Math.round((100 * Math.sin(this.nbPie * Math.PI / 4))));
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100, 100 - 10, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100 + largeur, 100 + hauteur, 1, false,
                                MouseEvent.BUTTON1));

                Etoile etoileActual = (Etoile) this.panneauDessin.getVueFormes().get(0).getForme();
                assertEquals("Test du clic glissé", this.etoileReferenceDrag, etoileActual);
        }
}
