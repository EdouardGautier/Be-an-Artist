package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized test class of {@link Rectangle#aire()}.
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.1
 */
@RunWith(Parameterized.class)
public class RectangleTestParameterizedAire {
    /**
     * The tested rectangle.
     */
    private final Rectangle rectangle;

    /**
     * Reference aire.
     */
    private final double aireReference;

    /**
     * Builder for each test for Coordinates.
     * 
     * @param rectangle     the tested rectangle.
     * @param aireReference reference aire.
     */
    public RectangleTestParameterizedAire(final Rectangle rectangle, final double aireReference) {
        this.rectangle = rectangle;
        this.aireReference = aireReference;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested rectangle. {1} reference aire.
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0
                { new Rectangle(1, 1), 1 },
                // Test 1
                { new Rectangle(1, 2), 2 },
                // Test 2
                { new Rectangle(15.0, 15.0), 225 },
                // Test 3
                { new Rectangle(28.0, 15.0), 420 } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link Rectangle#aire()}
     */
    @Test
    public void testAireRectangle() {
        assertEquals("Test de aire(): ", this.aireReference, this.rectangle.aire(), Forme.EPSILON);
    }
}