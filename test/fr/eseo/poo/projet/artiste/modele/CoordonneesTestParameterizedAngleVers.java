package fr.eseo.poo.projet.artiste.modele;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Parameterized test class of {@link Coordonnees#angleVers(Coordonnees)}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class CoordonneesTestParameterizedAngleVers {

    /**
     * Attribute representing the first point.
     */
    private final Coordonnees c1;

    /**
     * Attribute representing the second point.
     */
    private final Coordonnees c2;

    /**
     * Attribute representing the reference angle
     */
    private final double angleReference;

    /**
     * Builder for each test for Coordinates.
     * 
     * @param c1             the first point.
     * @param c2             the second point.
     * @param angleReference the reference angle
     */
    public CoordonneesTestParameterizedAngleVers(final Coordonnees c1, final Coordonnees c2,
            final double angleReference) {
        this.c1 = c1;
        this.c2 = c2;
        this.angleReference = angleReference;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the first point. {1} the second point. {2} the reference angle
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0: the two points are superimposed, angle of 0°.
                { new Coordonnees(), new Coordonnees(), 0.0 },
                // Test 1: the second point is above and to the right of the first, angle of 30°
                { new Coordonnees(), new Coordonnees(Math.sqrt(3) / 2, 0.5), Math.PI / 6 },
                // Test 2: the second point is above and to the right of the first, angle of 45°
                { new Coordonnees(), new Coordonnees(Math.sqrt(2) / 2, Math.sqrt(2) / 2), Math.PI / 4 },
                // Test 3: the second point is above and to the right of the first, angle of 60°
                { new Coordonnees(), new Coordonnees(0.5, Math.sqrt(3) / 2), Math.PI / 3 },
                // Test 4: the second point is below the first, angle of 90°
                { new Coordonnees(), new Coordonnees(0.0, 1.0), Math.PI / 2 },
                // Test 5: the second point is above and to the left of the first, at an angle
                // of 120°.
                { new Coordonnees(), new Coordonnees(-0.5, Math.sqrt(3) / 2), 2 * Math.PI / 3 },
                // Test 6: the second point is above and to the left of the first, angle 135°.
                { new Coordonnees(), new Coordonnees(-Math.sqrt(2) / 2, Math.sqrt(2) / 2), 3 * Math.PI / 4 },
                // Test 7: the second point is above and to the left of the first, angle 150.
                { new Coordonnees(), new Coordonnees(-Math.sqrt(3) / 2, 0.5), 5 * Math.PI / 6 },
                // Test 8: the second point is to the left of the first, 180°.
                { new Coordonnees(), new Coordonnees(-1.0, 0.0), Math.PI },
                // Test 9: the second point is below and to the left of the first, angle 210°.
                { new Coordonnees(), new Coordonnees(-Math.sqrt(3) / 2, -0.5), -5 * Math.PI / 6 },
                // Test 10: the second point is below and to the left of the first, angle 225°.
                { new Coordonnees(), new Coordonnees(-Math.sqrt(2) / 2, -Math.sqrt(2) / 2), -3 * Math.PI / 4 },
                // Test 11: the second point is below and to the left of the first, angle 240°.
                { new Coordonnees(), new Coordonnees(-0.5, -Math.sqrt(3) / 2), -2 * Math.PI / 3 },
                // Test 12: the second point is above the first, angle of 270°.
                { new Coordonnees(), new Coordonnees(0.0, -1.0), -Math.PI / 2 },
                // Test 13: the second point is below and to the right of the first, angle of
                // 300°.
                { new Coordonnees(), new Coordonnees(0.5, -Math.sqrt(3) / 2), -Math.PI / 3 },
                // Test 14: the second point is below and to the right of the first, angle of
                // 315°.
                { new Coordonnees(), new Coordonnees(Math.sqrt(2) / 2, -Math.sqrt(2) / 2), -Math.PI / 4 },
                // Test 15: the second point is below and to the right of the first, angle of
                // 330°
                { new Coordonnees(), new Coordonnees(Math.sqrt(3) / 2, -0.5), -Math.PI / 6 } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link Coordonnees#angleVers(Coordonnees)}.
     */
    @Test
    public void testgetAngleVers() {
        assertEquals("Test de angleVers()", this.angleReference, this.c1.angleVers(this.c2), Coordonnees.EPSILON);
    }
}