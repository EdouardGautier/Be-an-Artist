package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized test class of {@link Carre#perimetre()}.
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.2
 */
@RunWith(Parameterized.class)
public class CarreTestParameterizedPerimetre {

    /**
     * The tested square.
     */
    private final Carre carre;

    /**
     * Reference perimetre.
     */
    private final double perimetreReference;

    /**
     * Builder for each test for Coordinates.
     * 
     * @param carre              the tested square.
     * @param perimetreReference reference perimetre
     */
    public CarreTestParameterizedPerimetre(final Carre carre, final double perimetreReference) {
        this.carre = carre;
        this.perimetreReference = perimetreReference;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested square. {1} reference perimetre.
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0
                { new Carre(), 40 },
                // Test 1
                { new Carre(1), 4 },
                // Test 2
                { new Carre(2), 8 },
                // Test 3
                { new Carre(750.15), 3000.6 } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link Carre#perimetre()}.
     */
    @Test
    public void testPerimetre() {
        assertEquals("Test de perimetre: ", this.perimetreReference, this.carre.perimetre(), Forme.EPSILON);
    }
}