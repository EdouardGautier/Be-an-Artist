package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Base test class of the {@link Rectangle}
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.1
 */
public class RectangleTest {
    /**
     * Test of {@link Rectangle#Rectangle()}
     * 
     * @since 1.3.1
     */
    @Test
    public void testConstructeurVide() {
        final Rectangle rectangle = new Rectangle();

        assertEquals("Test de la position du rectangle", new Coordonnees(), rectangle.getPosition());
        assertEquals("Test de la hauteur du rectangle", Forme.HAUTEUR_PAR_DEFAUT, rectangle.getHauteur(),
                Forme.EPSILON);
        assertEquals("Test de la largeur du rectangle", Forme.LARGEUR_PAR_DEFAUT, rectangle.getLargeur(),
                Forme.EPSILON);
    }

    /**
     * Test of {@link Rectangle#Rectangle(Coordonnees)}
     * 
     * @since 1.3.1
     */
    @Test
    public void testConstructeurCoordonnees() {
        final Coordonnees position = new Coordonnees(5.0, 10.0);

        final Rectangle rectangle = new Rectangle(position);

        assertEquals("Test de la position du rectangle", position, rectangle.getPosition());
        assertEquals("Test de la hauteur du rectangle", Forme.HAUTEUR_PAR_DEFAUT, rectangle.getHauteur(),
                Forme.EPSILON);
        assertEquals("Test de la largeur du rectangle", Forme.LARGEUR_PAR_DEFAUT, rectangle.getLargeur(),
                Forme.EPSILON);
    }

    /**
     * Test of {@link Rectangle#Rectangle(double, double)}
     * 
     * @since 1.3.1
     */
    @Test
    public void testConstructeurHauteurLargeur() {
        final double hauteur = 10.0;
        final double largeur = 15.0;
        final Rectangle rectangle = new Rectangle(largeur, hauteur);

        assertEquals("Test de la position du rectangle", new Coordonnees(), rectangle.getPosition());
        assertEquals("Test de la hauteur du rectangle", hauteur, rectangle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du rectangle", largeur, rectangle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Rectangle#Rectangle(Coordonnees, double, double)}
     * 
     * @since 1.3.1
     */
    @Test
    public void testConstructeurPlein() {
        final double hauteur = 10.0;
        final double largeur = 15.0;
        final Coordonnees position = new Coordonnees();
        final Rectangle rectangle = new Rectangle(position, largeur, hauteur);

        assertEquals("Test de la position du rectangle", position, rectangle.getPosition());
        assertEquals("Test de la hauteur du rectangle", hauteur, rectangle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du rectangle", largeur, rectangle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Rectangle#setHauteur(double)} with a height lower than 0. The
     * {@link IllegalArgumentException} error is expected.
     * 
     * @since 1.3.1
     */
    @Test
    public void testSetHauteurError() throws IllegalArgumentException {
        final Rectangle rectangle = new Rectangle();
        assertThrows(IllegalArgumentException.class, () -> rectangle.setHauteur(-10));
        assertThrows(IllegalArgumentException.class, () -> rectangle.setHauteur(0));
    }

    /**
     * Test of {@link Rectangle#setLargeur(double)} with a height lower than 0. The
     * {@link IllegalArgumentException} error is expected.
     * 
     * @since 1.3.1
     */
    @Test
    public void testSetLargeurError() throws IllegalArgumentException {
        Rectangle rectangle = new Rectangle();
        assertThrows(IllegalArgumentException.class, () -> rectangle.setLargeur(-10));
        assertThrows(IllegalArgumentException.class, () -> rectangle.setLargeur(0));
    }

    /**
     * Test of {@link Rectangle#toString()}.
     * 
     * @since 1.3.1
     */
    @Test
    public void testToString() {
        Rectangle rectangle = new Rectangle(new Coordonnees(10, 10), 5, 20);

        String description = "[Rectangle] : pos (10,0 , 10,0) dim 5,0 x 20,0 périmètre : 50,0 aire : 100,0 couleur = R51,V51,B51";
        assertEquals("Test de la representation du rectangle", description, rectangle.toString());

        rectangle.setRempli(true);

        description = "[Rectangle-Rempli] : pos (10,0 , 10,0) dim 5,0 x 20,0 périmètre : 50,0 aire : 100,0 couleur = R51,V51,B51";
        assertEquals("Test de la representation du rectangle", description, rectangle.toString());
    }
}