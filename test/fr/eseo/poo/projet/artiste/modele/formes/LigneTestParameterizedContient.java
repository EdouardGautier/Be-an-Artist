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
 * Parameterized test class of {@link Ligne#contient()}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class LigneTestParameterizedContient {

    /**
     * The tested line.
     */
    private final Ligne ligne;

    /**
     * The point to test.
     */
    private final Coordonnees point;

    /**
     * If the point is on the line
     */
    private final boolean estContenue;

    /**
     * Builder for each test for Ligne.
     * 
     * @param ligne         the tested line.
     * @param p_point       the point to test.
     * @param p_estContenue if the point is on the line
     */
    public LigneTestParameterizedContient(final Ligne ligne, final Coordonnees p_point, boolean p_estContenue) {
        this.ligne = ligne;
        this.point = p_point;
        this.estContenue = p_estContenue;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested line. {1} the point to test. {2} if the point is on the line
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // It is not on the line.
                // Test 0
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(8.19, 9.42), false },
                // Test 1
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(10.94, 6.25), false },
                // Test 2
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(2.57, 3.38), false },
                // Test 3
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(15.07, 11.19), false },
                // It is on the line.
                // Test 4
                { new Ligne(0, 0), new Coordonnees(), true },
                // Test 5
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(5.68, 5.33), true },
                // Test 6
                { new Ligne(new Coordonnees(6.07574, 4.33543), 9.41, 9.35), new Coordonnees(10.78, 9.01), true },
                // Test 7
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(9.82, 7.91), true } };
        return Arrays.asList(data);

    }

    /**
     * Test of {@link Ligne#contient()}.
     */
    @Test
    public void testContientFalse() {
        if (this.estContenue) {
            assertTrue("Test de contient()", this.ligne.contient(this.point));
        } else {
            assertFalse("Test de contient()", this.ligne.contient(this.point));
        }
    }
}