package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Base test class of the {@link Cercle}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
public class CercleTest {

    /**
     * Test of {@link Cercle#Cercle()}.
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testConstructeurVide() {
        final Cercle cercle = new Cercle();

        assertEquals("Test de la position du cercle", new Coordonnees(), cercle.getPosition());
        assertEquals("Test de la hauteur du cercle", Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du cercle", cercle.getLargeur(), cercle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Cercle#Cercle(Coordonnees)}.
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testConstructeurCoordonnees() {
        final Coordonnees origine = new Coordonnees(5.0, 10.0);

        final Cercle cercle = new Cercle(origine);

        assertEquals("Test de la position du cercle", origine, cercle.getPosition());
        assertEquals("Test de la hauteur du cercle", Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du cercle", cercle.getLargeur(), cercle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Cercle#Cercle(double)}.
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testConstructeurTaille() {
        final double taille = 10.0;
        final Cercle cercle = new Cercle(taille);

        assertEquals("Test de la position du cercle", new Coordonnees(), cercle.getPosition());
        assertEquals("Test de la hauteur du cercle", taille, cercle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du cercle", taille, cercle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Cercle#Cercle(Coordonnees, double)}.
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testConstructeurPlein() {
        final double taille = 10.0;
        final Coordonnees origine = new Coordonnees();
        final Cercle cercle = new Cercle(origine, taille);

        assertEquals("Test de la position de l'Cercle", origine, cercle.getPosition());
        assertEquals("Test de la hauteur de l'Cercle", taille, cercle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'Cercle", taille, cercle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Cerlce#setHauteur(double)} with a height lower than 0. The
     * {@link IllegalArgumentException} error is expected.
     * 
     * @since 0.3.2.8
     */
    public void testSetHauteurError() throws IllegalArgumentException {
        Cercle cercle = new Cercle();
        assertThrows(IllegalArgumentException.class, () -> cercle.setHauteur(-10));
        assertThrows(IllegalArgumentException.class, () -> cercle.setHauteur(0));
    }

    /**
     * Test of {@link Cerlce#setLargeur(double)} with a height lower than 0. The
     * {@link IllegalArgumentException} error is expected.
     * 
     * @since 0.3.2.8
     */
    @Test
    public void testSetLargeurError() throws IllegalArgumentException {
        Cercle cercle = new Cercle();
        assertThrows(IllegalArgumentException.class, () -> cercle.setLargeur(-10));
        assertThrows(IllegalArgumentException.class, () -> cercle.setLargeur(0));
    }

}