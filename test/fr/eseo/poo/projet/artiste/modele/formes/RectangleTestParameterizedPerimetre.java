package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized test class of {@link Rectangle#perimetre()}.
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.1
 */
@RunWith(Parameterized.class)
public class RectangleTestParameterizedPerimetre {

    /**
     * The tested rectangle.
     */
    private final Rectangle rectangle;

    /**
     * Reference perimetre.
     */
    private final double perimetreReference;

    /**
     * Builder for each test for Coordinates.
     * 
     * @param p_rectangle          the tested rectangle.
     * @param p_perimetreReference reference perimetre.
     */
    public RectangleTestParameterizedPerimetre(final Rectangle p_rectangle, final double p_perimetreReference) {
        this.rectangle = p_rectangle;
        this.perimetreReference = p_perimetreReference;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested rectangle. {1} reference perimetre.
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0
                { new Rectangle(1, 1), 4 },
                // Test 1
                { new Rectangle(1, 2), 6 },
                // Test 2
                { new Rectangle(15.05, 15.05), 60.2 },
                // Test 3
                { new Rectangle(28.1, 15.05), 86.3 } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link Rectangle#perimetre()}
     */
    @Test
    public void testPerimetreRectangle() {
        assertEquals("Test de perimetre(): ", this.perimetreReference, this.rectangle.perimetre(), Forme.EPSILON);
    }
}