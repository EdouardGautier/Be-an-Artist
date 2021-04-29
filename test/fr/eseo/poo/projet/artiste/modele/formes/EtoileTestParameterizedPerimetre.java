package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Parameterized test class of {@link Etoile#perimetre()}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.1
 */
@RunWith(Parameterized.class)
public class EtoileTestParameterizedPerimetre {

    /**
     * The tested Etoile.
     */
    private final Etoile etoile;

    /**
     * Reference perimetre.
     */
    private final double perimetreReference;

    /**
     * Builder for each test for Coordinates.
     * 
     * @param p_etoile             the tested Etoile.
     * @param p_perimetreReference reference perimetre.
     */
    public EtoileTestParameterizedPerimetre(final Etoile p_etoile, final double p_perimetreReference) {
        this.etoile = p_etoile;
        this.perimetreReference = p_perimetreReference;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested Etoile. {1} reference perimetre.
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0
                { new Etoile(), 50 },
                // Test 1
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.9), 46.04 },
                // Test 2
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 15, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 150 },
                // Test 3
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, -0.5137,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 50 } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link Etoile#perimetre()}
     */
    @Test
    public void testPerimetreEtoile() {
        assertEquals("Test de perimetre(): ", this.perimetreReference, this.etoile.perimetre(), Forme.EPSILON);
    }
}