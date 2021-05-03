package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Base test class of the {@link Carre}
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.2
 */
public class CarreTest {

    /**
     * Test of {@link Carre#Carre()}.
     * 
     * @since 1.3.2
     */
    @Test
    public void testConstructeurVide() {
        final Carre carre = new Carre();

        assertEquals("Test de la position du Carre", new Coordonnees(), carre.getPosition());
        assertEquals("Test de la hauteur du Carre", Forme.LARGEUR_PAR_DEFAUT, carre.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du Carre", carre.getLargeur(), carre.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Carre#Carre(Coordonnees)}.
     * 
     * @since 1.3.2
     */
    @Test
    public void testConstructeurCoordonnees() {
        final Coordonnees origine = new Coordonnees(5.0, 10.0);

        final Carre carre = new Carre(origine);

        assertEquals("Test de la position du Carre", origine, carre.getPosition());
        assertEquals("Test de la hauteur du Carre", Forme.LARGEUR_PAR_DEFAUT, carre.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du Carre", carre.getLargeur(), carre.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Carre#Carre(double)}.
     * 
     * @since 1.3.2
     */
    @Test
    public void testConstructeurTaille() {
        final double taille = 10.0;
        final Carre carre = new Carre(taille);

        assertEquals("Test de la position du Carre", new Coordonnees(), carre.getPosition());
        assertEquals("Test de la hauteur du Carre", taille, carre.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du Carre", taille, carre.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Carre#Carre(Coordonnees, double)}.
     * 
     * @since 1.3.2
     */
    @Test
    public void testConstructeurPlein() {
        final double taille = 10.0;
        final Coordonnees origine = new Coordonnees();
        final Carre carre = new Carre(origine, taille);

        assertEquals("Test de la position de l'Carre", origine, carre.getPosition());
        assertEquals("Test de la hauteur de l'Carre", taille, carre.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'Carre", taille, carre.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test of {@link Cerlce#setHauteur(double)} with a height lower than 0. The
     * {@link IllegalArgumentException} error is expected.
     * 
     * @since 1.3.2
     */
    public void testSetHauteurError() throws IllegalArgumentException {
        Carre carre = new Carre();
        assertThrows(IllegalArgumentException.class, () -> carre.setHauteur(-10));
        assertThrows(IllegalArgumentException.class, () -> carre.setHauteur(0));
    }

    /**
     * Test of {@link Cerlce#setLargeur(double)} with a height lower than 0. The
     * {@link IllegalArgumentException} error is expected.
     * 
     * @since 1.3.2
     */
    @Test
    public void testSetLargeurError() throws IllegalArgumentException {
        Carre carre = new Carre();
        assertThrows(IllegalArgumentException.class, () -> carre.setLargeur(-10));
        assertThrows(IllegalArgumentException.class, () -> carre.setLargeur(0));
    }

    /**
     * Test of {@link Carre#toString()}.
     * 
     * @since 1.3.2
     */
    @Test
    public void testToString() {
        Carre Carre = new Carre(new Coordonnees(10, 10), 5);

        String description = "[Carre] : pos (10,0 , 10,0) dim 5,0 x 5,0 périmètre : 15,71 aire : 25,0 couleur = R51,V51,B51";
        assertEquals("Test de la representation de la ligne", description, Carre.toString());

        Carre.setRempli(true);

        description = "[Carre-Rempli] : pos (10,0 , 10,0) dim 5,0 x 5,0 périmètre : 15,71 aire : 25,0 couleur = R51,V51,B51";
        assertEquals("Test de la representation du carré", description, Carre.toString());
    }
}