package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Base test class of the {@link Ligne}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.4
 */
public class LigneTest {

    /**
     * Test of {@link Ligne#Ligne()}.
     * 
     * @since 0.3.2.4
     */
    @Test
    public void testConstructeurVide() {
        final Ligne ligne = new Ligne();

        assertEquals("Test de la position de la ligne", new Coordonnees(), ligne.getPosition());
        assertEquals("Test de la hauteur de la ligne", Ligne.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), Ligne.EPSILON);
        assertEquals("Test de la largeur de la ligne", Ligne.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), Ligne.EPSILON);
    }

    /**
     * Test of {@link Ligne#Ligne(Coordonnees)}.
     * 
     * @since 0.3.2.4
     */
    @Test
    public void testConstructeurCoordonnees() {
        final Coordonnees position = new Coordonnees(17, 21);

        final Ligne ligne = new Ligne(position);

        assertEquals("Test de la position de la ligne", position, ligne.getPosition());
        assertEquals("Test de la hauteur de la ligne", Ligne.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), Ligne.EPSILON);
        assertEquals("Test de la largeur de la ligne", Ligne.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), Ligne.EPSILON);
    }

    /**
     * Test of {@link Ligne#Ligne(double, double)}.
     * 
     * @since 0.3.2.4
     */
    @Test
    public void testConstructeurHauteurLargeur() {
        double hauteur = 17;
        double largeur = 21;
        Ligne ligne = new Ligne(largeur, hauteur);

        assertEquals("Test de la position de la ligne", new Coordonnees(), ligne.getPosition());
        assertEquals("Test de la hauteur de la ligne", hauteur, ligne.getHauteur(), Ligne.EPSILON);
        assertEquals("Test de la largeur de la ligne", largeur, ligne.getLargeur(), Ligne.EPSILON);
    }

    /**
     * Test of {@link Ligne#Ligne(Coordonnees, double, double)}.
     * 
     * @since 0.3.2.4
     */
    @Test
    public void testConstructeur() {
        final double hauteur = 10.0;
        final double largeur = 15.0;
        final Coordonnees position = new Coordonnees();
        final Ligne ligne = new Ligne(position, largeur, hauteur);

        assertEquals("Test de la position de la ligne", position, ligne.getPosition());
        assertEquals("Test de la hauteur de la ligne", hauteur, ligne.getHauteur(), Ligne.EPSILON);
        assertEquals("Test de la largeur de la ligne", largeur, ligne.getLargeur(), Ligne.EPSILON);
    }

    /**
     * Test of {@link Ligne#aire()}.
     * 
     * @since 0.3.2.4
     */
    @Test
    public void testAire() {
        final Ligne ligne = new Ligne();

        assertEquals("Test de l'aire de la ligne", 0, ligne.aire(), Ligne.EPSILON);
    }

    /**
     * Test of {@link Ligne#perimetre()}.
     * 
     * @since 0.3.2.4
     */
    @Test
    public void testPerimetre() {
        final Ligne ligne = new Ligne();

        assertEquals("Test du périmètre de la ligne", 14.14, ligne.perimetre(), Ligne.EPSILON);
    }

    /**
     * Test of {@link Ligne#toString()}.
     * 
     * @since 0.3.2.4
     */
    @Test
    public void testToString() {
        final Ligne ligne = new Ligne(new Coordonnees(10, 10), -5, 20);

        String description = "[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 angle : 104,04°";
        assertEquals("Test de la representation de la ligne", description, ligne.toString());
    }
}
