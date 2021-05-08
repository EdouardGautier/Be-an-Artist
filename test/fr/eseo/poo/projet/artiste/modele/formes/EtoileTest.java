package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Base test class of the {@link Etoile}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.1
 */
public class EtoileTest {
    /**
     * Test de {@link Etoile#Etoile()}
     */
    @Test
    public void testConstructeurVide() {
        final Etoile etoile = new Etoile();

        assertEquals("Test nombre de branche", etoile.getNombreBranches(), Etoile.NOMBRE_BRANCHES_PAR_DEFAUT);

        assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(),
                Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Forme.EPSILON);

        assertEquals("Test longueur branche", etoile.getLongueurBranche(), Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
                Forme.EPSILON);

        assertEquals("Test position", etoile.getPosition(), new Coordonnees());

        assertEquals("Test hauteur", etoile.getHauteur(), Etoile.LARGEUR_PAR_DEFAUT, Forme.EPSILON);

        assertEquals("Test largeur", etoile.getLargeur(), Etoile.LARGEUR_PAR_DEFAUT, Forme.EPSILON);
    }

    /**
     * Test of {@link Etoile#Etoile(double)}
     */
    @Test
    public void testConstructeurTaille() {
        final double taille = 15;
        final Etoile etoile = new Etoile(taille);

        assertEquals("Test nombre de branche", etoile.getNombreBranches(), Etoile.NOMBRE_BRANCHES_PAR_DEFAUT);

        assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(),

                Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Forme.EPSILON);
        assertEquals("Test longueur branche", etoile.getLongueurBranche(), Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
                Forme.EPSILON);

        assertEquals("Test position", etoile.getPosition(), new Coordonnees());

        assertEquals("Test hauteur", etoile.getHauteur(), taille, Forme.EPSILON);

        assertEquals("Test largeur", etoile.getLargeur(), taille, Forme.EPSILON);
    }

    /**
     * Test of {@link Etoile#Etoile(Coordonnees)}
     */
    @Test
    public void testConstructeurCoordonnees() {
        final Coordonnees position = new Coordonnees(15, 7);
        final Etoile etoile = new Etoile(position);

        assertEquals("Test nombre de branche", etoile.getNombreBranches(), Etoile.NOMBRE_BRANCHES_PAR_DEFAUT);

        assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(),
                Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Forme.EPSILON);

        assertEquals("Test longueur branche", etoile.getLongueurBranche(), Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
                Forme.EPSILON);

        assertEquals("Test position", etoile.getPosition(), position);

        assertEquals("Test hauteur", etoile.getHauteur(), Etoile.LARGEUR_PAR_DEFAUT, Forme.EPSILON);

        assertEquals("Test largeur", etoile.getLargeur(), Etoile.LARGEUR_PAR_DEFAUT, Forme.EPSILON);
    }

    /**
     * Test of {@link Etoile#Etoile(Coordonnees, double)}
     */
    @Test
    public void testConstructeurCoordonneesTaille() {
        final double taille = 27;
        final Coordonnees position = new Coordonnees(15, 7);
        final Etoile etoile = new Etoile(position, taille);

        assertEquals("Test nombre de branche", etoile.getNombreBranches(), Etoile.NOMBRE_BRANCHES_PAR_DEFAUT);

        assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(),
                Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Forme.EPSILON);

        assertEquals("Test longueur branche", etoile.getLongueurBranche(), Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
                Forme.EPSILON);

        assertEquals("Test position", etoile.getPosition(), position);

        assertEquals("Test hauteur", etoile.getHauteur(), taille, Forme.EPSILON);

        assertEquals("Test largeur", etoile.getLargeur(), taille, Forme.EPSILON);
    }

    /**
     * Test of {@link Etoile#Etoile(Coordonnees, double, int, double, double)}
     */
    @Test
    public void testConstructeurPlein() {
        final double taille = 27;
        final Coordonnees position = new Coordonnees(15, 7);
        final int nombreBranche = 4;
        final double anglePremiereBranche = 1.5708; // Angle de 90°
        final double longueurBranche = 0.5;
        final Etoile etoile = new Etoile(position, taille, nombreBranche, anglePremiereBranche, longueurBranche);

        assertEquals("Test nombre de branche", etoile.getNombreBranches(), nombreBranche);

        assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(), anglePremiereBranche,
                Forme.EPSILON);

        assertEquals("Test longueur branche", etoile.getLongueurBranche(), longueurBranche, Forme.EPSILON);

        assertEquals("Test position", etoile.getPosition(), position);

        assertEquals("Test hauteur", etoile.getHauteur(), taille, Forme.EPSILON);

        assertEquals("Test largeur", etoile.getLargeur(), taille, Forme.EPSILON);
    }

    /**
     * Test of {@link Etoile#setHauteur(double)}
     */
    @Test
    public void testSetHauteurError() throws IllegalArgumentException {
        Etoile etoile = new Etoile();

        assertThrows(IllegalArgumentException.class, () -> etoile.setHauteur(-15));

        assertThrows(IllegalArgumentException.class, () -> etoile.setHauteur(0));
    }

    /**
     * Test of {@link Etoile#setLargeur(double)}
     */
    @Test
    public void testSetLargeurError() throws IllegalArgumentException {
        Etoile etoile = new Etoile();

        assertThrows(IllegalArgumentException.class, () -> etoile.setLargeur(-15));

        assertThrows(IllegalArgumentException.class, () -> etoile.setLargeur(0));
    }

    /**
     * Test of {@link Etoiles#setLongueurBranche(double)}
     */
    @Test
    public void testSetLongueurBranchesError() throws IllegalArgumentException {
        Etoile etoile = new Etoile();

        assertThrows(IllegalArgumentException.class, () -> etoile.setLongueurBranche(-1));

        assertThrows(IllegalArgumentException.class, () -> etoile.setLongueurBranche(2));
    }

    /**
     * Test of {@link Etoiles#setAnglePremiereBranche(double)}
     */
    @Test
    public void testSetAnglePremiereBrancheError() throws IllegalArgumentException {
        Etoile etoile = new Etoile();

        assertThrows(IllegalArgumentException.class, () -> etoile.setAnglePremiereBranche(-Math.PI - 0.1));

        assertThrows(IllegalArgumentException.class, () -> etoile.setAnglePremiereBranche(Math.PI + 0.1));
    }

    /**
     * Test of {@link Etoiles#setNombreBranches(int)}
     */
    @Test
    public void testSeNombreBrancheError() throws IllegalArgumentException {
        Etoile etoile = new Etoile();
        assertThrows(IllegalArgumentException.class, () -> etoile.setNombreBranches(2));
        assertThrows(IllegalArgumentException.class, () -> etoile.setNombreBranches(16));
    }
}