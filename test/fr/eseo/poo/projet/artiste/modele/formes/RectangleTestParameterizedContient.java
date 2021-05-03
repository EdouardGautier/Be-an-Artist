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
 * Parameterized test class of {@link Rectangle#contient()}.
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.1
 */
@RunWith(Parameterized.class)
public class RectangleTestParameterizedContient {

    /**
     * The tested rectangle.
     */
    private final Rectangle rectangle;

    /**
     * The point to test.
     */
    private final Coordonnees point;

    /**
     * If the point is on the Rectangle
     */
    private final boolean estContenue;

    /**
     * Builder for each test for Ligne.
     * 
     * @param p_rectangle   the tested Rectangle.
     * @param p_point       the point to test.
     * @param p_estContenue if the point is on the Rectangle
     */
    public RectangleTestParameterizedContient(final Rectangle p_rectangle, final Coordonnees p_point,
            boolean p_estContenue) {
        this.rectangle = p_rectangle;
        this.point = p_point;
        this.estContenue = p_estContenue;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested Rectangle. {1} the point to test. {2} if the point is on the
     * Rectangle
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // It is not on the Rectangle.
                // Test 0
                { new Rectangle(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(20, 40), false },
                // Test 1
                { new Rectangle(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(76.79, 37.13), false },
                // Test 2
                { new Rectangle(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(76.54, 5.39), false },
                // Test 3
                { new Rectangle(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(12.35, 9.51), false },
                // Test 4
                { new Rectangle(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(46.99, 47.30), false },
                // It is on the Rectangle.
                // The point is in the Rectangle
                // Test 5
                { new Rectangle(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(41.17, 32.52), true },
                // Test 6
                { new Rectangle(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(20, 20), true },
                // Test 7
                { new Rectangle(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(65.16, 13.38), true },
                // The point is on the outline of the Rectangle
                // Test 8
                { new Rectangle(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(42.84, 46.29), true },
                // Test 9
                { new Rectangle(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(50.12, 27.06), true } };
        return Arrays.asList(data);
    }

    /**
     * Test de {@link Rectangle#contient()}
     */
    @Test
    public void testContientFalse() {
        if (this.estContenue) {
            assertTrue("Test de contient()", this.rectangle.contient(this.point));
        } else {
            assertFalse("Test de contient()", this.rectangle.contient(this.point));
        }
    }
}