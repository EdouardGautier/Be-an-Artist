package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Parameterized test class of {@link Etoile#contient()}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.1
 */
@RunWith(Parameterized.class)
public class EtoileTestParameterizedContient {

    /**
     * The tested Etoile.
     */
    private final Etoile etoile;

    /**
     * The point to test.
     */
    private final Coordonnees point;

    /**
     * If the point is on the Etoile
     */
    private final boolean estContenue;

    /**
     * Builder for each test for Ligne.
     * 
     * @param etoile      the tested Etoile.
     * @param point       the point to test.
     * @param estContenue if the point is on the Etoile
     */
    public EtoileTestParameterizedContient(final Etoile etoile, final Coordonnees point, boolean estContenue) {
        this.etoile = etoile;
        this.point = point;
        this.estContenue = estContenue;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested Etoile. {1} the point to test. {2} if the point is on the
     * Etoile
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // It is not on the Etoile.
                // Test 0
                { new Etoile(), new Coordonnees(122.20, 90.59), false },
                // Test 1
                { new Etoile(), new Coordonnees(101.91, 125.50), false },
                // Test 2
                { new Etoile(), new Coordonnees(138.44, 134.43), false },
                // Test 3
                { new Etoile(), new Coordonnees(8.54, 21.58), false },
                // Test 4
                { new Etoile(), new Coordonnees(72.68, 167), false },
                // It is on the Etoile.
                // The point is in the Etoile
                // Test 5
                { new Etoile(new Coordonnees(), 215.42, 5, 2.29, 0.75), new Coordonnees(36.75, 26.68), true },
                // Test 6
                { new Etoile(new Coordonnees(), 100, 13, 2.29, 0.5), new Coordonnees(29.51, 35.68), true },
                // Test 7
                { new Etoile(new Coordonnees(), 50, 3, 2.29, 0.25), new Coordonnees(35, 30), true },
                // The point is on the outline of the Etoile
                // Test 8
                { new Etoile(), new Coordonnees(2.06, 9.05), true },
                // Test 9
                { new Etoile(), new Coordonnees(5, 5), true } };
        return Arrays.asList(data);
    }

    /**
     * Test de {@link Etoile#contient()}
     */
    @Test
    public void testContientFalse() {
        if (this.estContenue) {
            assertTrue("Test de contient()", this.etoile.contient(this.point));
        } else {
            assertFalse("Test de contient()", this.etoile.contient(this.point));
        }
    }
}