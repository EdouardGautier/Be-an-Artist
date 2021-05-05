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
 * Parameterized test class of {@link Etoile#aire()}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.1
 */
@RunWith(Parameterized.class)
public class EtoileTestParameterizedAire {
    /**
     * The tested Etoile.
     */
    private final Etoile etoile;

    /**
     * Reference aire.
     */
    private final double aireReference;

    /**
     * Builder for each test for Coordinates.
     * 
     * @param etoile        the tested Etoile.
     * @param aireReference reference aire.
     */
    public EtoileTestParameterizedAire(final Etoile etoile, final double aireAttendue) {
        this.etoile = etoile;
        this.aireReference = aireAttendue;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested Etoile. {1} reference aire.
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0
                { new Etoile(), 0 },
                // Test 1
                { new Etoile(new Coordonnees(), 215.42, 5, 2.29, 0.75), 8523.94 },
                // Test 2
                { new Etoile(new Coordonnees(), 100, 13, 2.29, 0.5), 3888.87 },
                // Test 3
                { new Etoile(new Coordonnees(), 50, 3, 2.29, 0.25), 1217.84 } };
        return Arrays.asList(data);
    }

    /**
     * Test of {@link Etoile#aire()}
     */
    @Test
    public void testAireEtoile() {
        assertEquals("Test de aire(): ", this.aireReference, this.etoile.aire(), Forme.EPSILON);
    }
}
