package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Parameterized test class of {@link Ligne#perimetre()}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class LigneTestParameterizedPerimetre {

    /**
     * The tested line.
     */
    private final Ligne ligne;

    /**
     * Reference length.
     */
    private double longueurReference;

    /**
     * Builder for each test for Ligne.
     * 
     * @param p_ligne             the tested line.
     * @param p_longueurReference reference length.
     */
    public LigneTestParameterizedPerimetre(final Ligne p_ligne, final double p_longueurReference) {
        this.ligne = p_ligne;
        this.longueurReference = p_longueurReference;
    }

    /**
     * Creation of the test list.
     * 
     * {0} the tested line. {1} reference length.
     * 
     * @return all the tests.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0: line of width 0 and height 0. The representation of the length of the
                // line is 0,0
                { new Ligne(0, 0), 0.0 },
                // Test 1: line of width 15 and height 15. The representation of the length of
                // the line is 21,213
                { new Ligne(15, 15), 21.213 },
                // Test 2: line of width 15 and height -15. The representation of the length of
                // the line is 21,213
                { new Ligne(15, -15), 21.213 },
                // Test 3: line of width -15 and height -15. The representation of the length of
                // the line is 21,213
                { new Ligne(-15, -15), 21.213 },
                // Test 4: line of width -15 and height 15. The representation of the length of
                // the line is 21,213
                { new Ligne(-15, 15), 21.213 } };

        return Arrays.asList(data);
    }

    /**
     * Test de {@link Ligne#perimetre()}
     */
    @Test
    public void testperimetre() {

        assertEquals("Test de perimetre()", this.longueurReference, this.ligne.perimetre(), Ligne.EPSILON);

    }
}