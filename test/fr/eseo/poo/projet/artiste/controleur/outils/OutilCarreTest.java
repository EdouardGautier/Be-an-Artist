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
import fr.eseo.poo.projet.artiste.modele.formes.Carre;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Base test class parameterized of the {@link OutilCarre}
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.2
 */
@RunWith(Parameterized.class)
public class OutilCarreTest {
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
        private final OutilCarre outil;

        /**
         * Reference square for double click
         */
        private final Carre carreReferenceDouble;

        /**
         * Reference square for the click and drag
         */
        private final Carre carreReferenceDrag;

        /**
         * Number of π for drag
         */
        private final int nbPie;

        /**
         * Builder for each test for OutilLigne.
         * 
         * @param p_carreReferenceDouble square for double click
         * @param p_carreReferenceDrag   square for the click and drag
         * @param p_nbPie                number of π for drag
         */
        public OutilCarreTest(Carre p_carreReferenceDouble, Carre p_carreReferenceDrag, int p_nbPie) {
                this.frame = new JFrame();
                this.panneau = new PanneauDessin();
                this.outil = new OutilCarre();
                this.panneau.associerOutil(this.outil);
                this.carreReferenceDouble = p_carreReferenceDouble;
                this.carreReferenceDrag = p_carreReferenceDrag;
                this.nbPie = p_nbPie;

                this.frame.getContentPane().add(panneau);
                this.frame.setTitle("OutilCarreTest");
                this.frame.setSize(this.panneau.getPreferredSize());
                this.frame.setLocationRelativeTo(null);
                this.frame.setVisible(true);
                this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        /**
         * Creation of the test list.
         * 
         * {0} the first square for double click. {1} the second square for the click
         * and drag. {2} the number of π
         * 
         * @return all the tests.
         */
        @Parameters(name = "dt[{index}] : {0} {1} {2}")
        public static Collection<Object[]> dt() {
                final Object[][] data = new Object[][] {
                                // Test 0
                                { new Carre(new Coordonnees(0, 30)), new Carre(new Coordonnees(100, 90), 81), 1 },
                                // Test 1
                                { new Carre(new Coordonnees(60, 30)), new Carre(new Coordonnees(100, 90), 81), 3 },
                                // Test 2
                                { new Carre(new Coordonnees(90, 30)), new Carre(new Coordonnees(100, 90), 100), 4 },
                                // Test 3
                                { new Carre(new Coordonnees(120, 30)), new Carre(new Coordonnees(100, 90), 81), 5 } };
                return Arrays.asList(data);
        }

        /**
         * Test of {@link OutilCarre#creerVueForme()}
         */
        @Test
        public void testOutilCarreDoubleClick() {
                int x = (int) this.carreReferenceDouble.getPosition().getAbscisse();
                int y = (int) this.carreReferenceDouble.getPosition().getOrdonnee();
                // We simulate the double click
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, x, y, 2, false, MouseEvent.BUTTON1));

                Carre CarreActual = (Carre) this.panneau.getVueFormes().get(0).getForme();
                assertEquals("Test du double clic", this.carreReferenceDouble, CarreActual);
        }

        /**
         * Test of {@link OutilCarre#creerVueForme()}
         */
        @Test
        public void testOutilCarreGlisseClick() {
                final int largeur = (int) Math.abs(Math.round((100 * Math.cos(this.nbPie * Math.PI / 4))));
                final int hauteur = (int) Math.abs(Math.round((100 * Math.sin(this.nbPie * Math.PI / 4))));
                this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100, 100 - 10, 1, false, MouseEvent.BUTTON1));
                this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                                MouseEvent.BUTTON1_DOWN_MASK, 100 + largeur, 100 + hauteur, 1, false,
                                MouseEvent.BUTTON1));

                Carre CarreActual = (Carre) this.panneau.getVueFormes().get(0).getForme();
                assertEquals("Test du clic glissé", this.carreReferenceDrag, CarreActual);
        }
}
