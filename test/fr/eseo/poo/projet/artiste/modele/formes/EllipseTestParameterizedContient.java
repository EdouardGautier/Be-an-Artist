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
 * Parameterized test class of {@link Ellipse#contient()}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class EllipseTestParameterizedContient {

    /**
     * The tested ellipse.
     */
    private final Ellipse ellipse;

    /**
     * The point to test.
     */
    private final Coordonnees point;

    /**
     * If the point is on the ellipse
     */
    private final boolean estContenue;

    /**
     * Builder for each test for Ligne.
     * 
     * @param p_ellipse     the tested ellipse.
     * @param p_point       the point to test.
     * @param p_estContenue if the point is on the ellipse
     */
    public EllipseTestParameterizedContient(final Ellipse p_ellipse, final Coordonnees p_point, boolean p_estContenue) {
        this.ellipse = p_ellipse;
        this.point = p_point;
        this.estContenue = p_estContenue;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested ellipse. {1} the point to test. {2} if the point is on the
     * ellipse
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // It is not on the ellipse.
                // Test 0
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(20, 40), false },
                // Test 1
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(76.79, 37.13), false },
                // Test 2
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(76.54, 5.39), false },
                // Test 3
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(12.35, 9.51), false },
                // Test 4
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(46.99, 47.30), false },
                // It is on the ellipse.
                // The point is in the ellipse
                // Test 5
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(41.17, 32.52), true},
                // Test 6
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(20, 20), true},
                // Test 7
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(65.16, 13.38), true},
                // The point is on the outline of the ellipse
                // Test 8
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(42.84, 46.29), true},
                // Test 9
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(50.12, 27.06), true}
            };
        return Arrays.asList(data);
    }

    /**
     * Test de {@link Ellipse#contient()}
     */
    @Test
    public void testContientFalse() {
        if (this.estContenue) {
            assertTrue("Test de contient()", this.ellipse.contient(this.point));
        } else {
            assertFalse("Test de contient()", this.ellipse.contient(this.point));
        }
    }
}