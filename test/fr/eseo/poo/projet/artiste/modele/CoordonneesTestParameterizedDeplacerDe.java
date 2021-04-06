package fr.eseo.poo.projet.artiste.modele;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Parameterized test class of {@link Coordonnees#deplacerDe(double, double)}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class CoordonneesTestParameterizedDeplacerDe {

    /**
     * Initial abscissa
     */
    private final double x1;

    /**
     * Initial order
     */
    private final double y1;

    /**
     * Abscissa final
     */
    private final double x2;

    /**
     * Order final
     */
    private final double y2;

    /**
     * Builder for each test for Coordinates.
     * 
     * @param p_x1 initial abscissa
     * @param p_y1 initial order
     * @param p_x2 abscissa final
     * @param p_y2 order final
     */
    public CoordonneesTestParameterizedDeplacerDe(final double p_x1, final double p_y1, final double p_x2,
            final double p_y2) {
        this.x1 = p_x1;
        this.y1 = p_y1;
        this.x2 = p_x2;
        this.y2 = p_y2;
    }

    /**
     * Creation of the test list.
     * 
     * {0} initial abscissa {1} initial order {2} abscissa final {3} order final
     * 
     * @return all the tests
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0: no move.
                { 0.0, 0.0, 0.0, 0.0 },
                // Test 1: move 1 up.
                { 0.0, 0.0, 0.0, 1.0 },
                // Test 2: move 1 down
                { 0.0, 0.0, 0.0, -1.0 },
                // Test 3: move 1 to the left.
                { 0.0, 0.0, -1.0, 0.0 },
                // Test 4: move 1 to the right.
                { 0.0, 0.0, 1.0, 0.0 },
                // Test 5: deplacement de 12 vers la gauche et de 3 vers le bas.
                { 0.0, 0.0, -12.0, -3.0 },
                // Test 6: deplacement de 12 vers la droite et de 3 vers le haut.
                { 0.0, 0.0, 12.0, 3.0 }, };
        return Arrays.asList(data);
    }

    // Couverture des instructions pour deplacerDe : 100%

    /**
     * Test de {@link Coordonnees#deplacerDe(double, double)}.
     */
    @Test
    public void testDeplacerDe() {
        final Coordonnees c1 = new Coordonnees(this.x1, this.y1);
        final Coordonnees c2 = new Coordonnees(this.x1 + this.x2, this.y1 + this.y2);

        c1.deplacerDe(this.x2, this.y2);

        assertEquals("Test deplacerDe(): ", c2, c1);
    }
}
