package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Base test class of the {@link Ellipse}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
public class EllipseTest {

    /**
     * Test of {@link Ellipse#Ellipse()}
     * 
     * @since 0.3.2.8
     * 
     * @version 0.3.6.1
     */
    @Test
    public void testConstructeurVide() {
        final Ellipse ellipse = new Ellipse();

        assertEquals("Test de la position de l'ellipse", new Coordonnees(), ellipse.getPosition());
        assertEquals("Test de la hauteur de l'ellipse", Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'ellipse", Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Ellipse#Ellipse(Coordonnees)}
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testConstructeurCoordonnees() {
        final Coordonnees position = new Coordonnees(5.0, 10.0);

        final Ellipse ellipse = new Ellipse(position);

        assertEquals("Test de la position de l'ellipse", position, ellipse.getPosition());
        assertEquals("Test de la hauteur de l'ellipse", Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'ellipse", Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Ellipse#Ellipse(double, double)}
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testConstructeurHauteurLargeur() {
        final double hauteur = 10.0;
        final double largeur = 15.0;
        final Ellipse ellipse = new Ellipse(largeur, hauteur);

        assertEquals("Test de la position de l'ellipse", new Coordonnees(), ellipse.getPosition());
        assertEquals("Test de la hauteur de l'ellipse", hauteur, ellipse.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'ellipse", largeur, ellipse.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Ellipse#Ellipse(Coordonnees, double, double)}
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testConstructeurPlein() {
        final double hauteur = 10.0;
        final double largeur = 15.0;
        final Coordonnees position = new Coordonnees();
        final Ellipse ellipse = new Ellipse(position, largeur, hauteur);

        assertEquals("Test de la position de l'ellipse", position, ellipse.getPosition());
        assertEquals("Test de la hauteur de l'ellipse", hauteur, ellipse.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'ellipse", largeur, ellipse.getLargeur(), Forme.EPSILON);
    }

    /**
	 * Test of {@link Ellipse#setHauteur(double)} with a height lower than 0.
	 * The {@link IllegalArgumentException} error is expected.
	 * 
	 * @since 0.3.2.8
	 */
	@Test
	public void testSetHauteurError() throws IllegalArgumentException {
        Ellipse ellipse = new Ellipse();
        assertThrows(IllegalArgumentException.class, () -> ellipse.setHauteur(-10));
        assertThrows(IllegalArgumentException.class, () -> ellipse.setHauteur(0));
	}

    /**
     * Test of {@link Ellipse#setLargeur(double)} with a height lower than 0.
	 * The {@link IllegalArgumentException} error is expected.
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testSetLargeurError() throws IllegalArgumentException {
        Ellipse ellipse = new Ellipse();
        assertThrows(IllegalArgumentException.class, () -> ellipse.setLargeur(-10));
        assertThrows(IllegalArgumentException.class, () -> ellipse.setLargeur(0));
    }

    /**
     * Test of {@link Ellipse#toString()}.
     * 
     * @since 0.3.6.1
     */
    @Test
    public void testToString() {
        Ellipse ellipse = new Ellipse(new Coordonnees(10, 10), 5, 20);

        String description = "[Ellipse] : pos (10,0 , 10,0) dim 5,0 x 20,0 périmètre : 42,89 aire : 78,54 couleur = R51,V51,B51";
        assertEquals("Test de la representation de la ligne", description, ellipse.toString());

        ellipse.setRempli(true);

        description = "[Ellipse-Rempli] : pos (10,0 , 10,0) dim 5,0 x 20,0 périmètre : 42,89 aire : 78,54 couleur = R51,V51,B51";
        assertEquals("Test de la representation de la ligne", description, ellipse.toString());
    }
}