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
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class parameterized of the {@link OutilLigne}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.4
 */
@RunWith(Parameterized.class)
public class OutilLigneTest {
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
         * Reference line for double click
         */
        private final Ligne ligneReferenceDouble;

        /**
         * Reference line for the click and drag
         */
        private final Ligne ligneReferenceDrag;

        /**
         * Number of π for drag
         */
        private final int nbPie;

        /**
         * Builder for each test for OutilLigne.
         * 
         * @param ligneReferenceDouble line for double click
         * @param ligneReferenceDrag   line for the click and drag
         * @param nbPie                number of π for drag
         */
        public OutilLigneTest(Ligne ligneReferenceDouble, Ligne ligneReferenceDrag, int nbPie) {
                this.frame = new JFrame();
                this.panneau = new PanneauDessin();
                this.outil = new OutilLigne();
                this.panneau.associerOutil(this.outil);
                this.ligneReferenceDouble = ligneReferenceDouble;
                this.ligneReferenceDrag = ligneReferenceDrag;
                this.nbPie = nbPie;

                this.frame.getContentPane().add(panneau);
                this.frame.setTitle("OutilLigneTest");
                this.frame.setSize(this.panneau.getPreferredSize());
                this.frame.setLocationRelativeTo(null);
                this.frame.setVisible(true);
                this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        /**
         * Creation of the test list.
         * 
         * {0} the first line for double click. {1} the second line for the click and
         * drag. {2} the number of π
         * 
         * @return all the tests.
         */
        @Parameters(name = "dt[{index}] : {0} {1} {2}")
        public static Collection<Object[]> dt() {
                final Object[][] data = new Object[][] {
                                // Test 0
                                { new Ligne(new Coordonnees(0, 30)), new Ligne(new Coordonnees(100, 90), 71, 81), 1 },
                                // Test 1
                                { new Ligne(new Coordonnees(30, 30)), new Ligne(new Coordonnees(100, 90), 0, 110), 2 },
                                // Test 2
                                { new Ligne(new Coordonnees(60, 30)), new Ligne(new Coordonnees(100, 90), -71, 81), 3 },
                                // Test 3
                                { new Ligne(new Coordonnees(90, 30)), new Ligne(new Coordonnees(100, 90), -100, 10),
                                                4 },
                                // Test 4
                                { new Ligne(new Coordonnees(120, 30)), new Ligne(new Coordonnees(100, 90), -71, -61),
                                                5 } };
                return Arrays.asList(data);
        }

        /**
         * Test of {@link OutilLigne#creerVueForme()}
         */
        @Test
        public void testOutilLigneDoubleClick() {
                int x = (int) this.ligneReferenceDouble.getC1().getAbscisse();
                int y = (int) this.ligneReferenceDouble.getC1().getOrdonnee();
                // We simulate the double click
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 2, false, MouseEvent.BUTTON1));

                Ligne ligneActual = (Ligne) this.panneau.getVueFormes().get(0).getForme();
                assertEquals("Test du double clic", this.ligneReferenceDouble, ligneActual);
        }

        /**
         * Test of {@link OutilLigne#creerVueForme()}
         */
        @Test
        public void testOutilLigneGlisseClick() {
                final int largeur = (int) Math.round((100 * Math.cos(this.nbPie * Math.PI / 4)));
                final int hauteur = (int) Math.round((100 * Math.sin(this.nbPie * Math.PI / 4)));
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100, 100 - 10, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100 + largeur, 100 + hauteur, 1, false,
                                MouseEvent.BUTTON1));

                Ligne ligneActual = (Ligne) this.panneau.getVueFormes().get(0).getForme();
                assertEquals("Test du clic glissé", this.ligneReferenceDrag, ligneActual);
        }
}
