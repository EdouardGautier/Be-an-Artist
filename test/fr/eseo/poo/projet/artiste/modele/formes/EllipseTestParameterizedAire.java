package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Parameterized test class of {@link Ellipse#aire()}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class EllipseTestParameterizedAire {

    /**
     * The tested ellipse.
     */
    private final Ellipse ellipse;

    /**
     * Reference aire.
     */
    private final double aireReference;

    /**
     * Builder for each test for Coordinates.
     * 
     * @param p_ellipse     the tested ellipse.
     * @param aireReference reference aire.
     */
    public EllipseTestParameterizedAire(final Ellipse p_ellipse, final double p_aireAttendue) {
        this.ellipse = p_ellipse;
        this.aireReference = p_aireAttendue;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested ellipse. {1} reference aire.
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0 the expected area is 0.25π.
                { new Ellipse(1, 1), 0.25 * Math.PI },
                // Test 1 the expected area is 0.5π.
                { new Ellipse(1, 2), 0.5 * Math.PI },
                // Test 2 the expected area is 176.71.
                { new Ellipse(15.0, 15.0), 176.71 },
                // Test 3 the expected area is 329.86.
                { new Ellipse(28.0, 15.0), 329.86 } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link Ellipse#aire()}
     */
    @Test
    public void testAireEllipse() {
        assertEquals("Test de aire(): ", this.aireReference, this.ellipse.aire(), Forme.EPSILON);
    }
}