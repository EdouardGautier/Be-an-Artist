package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Parameterized test class of {@link Cercle#perimetre()}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class CercleTestParameterizedPerimetre {

	/**
	 * The tested circle.
	 */
	private final Cercle cercle;

	/**
	 * Reference perimetre.
	 */
	private final double perimetreReference;

	/**
	 * Builder for each test for Coordinates.
	 * 
	 * @param p_cercle             the tested circle.
	 * @param p_perimetreReference reference perimetre
	 */
	public CercleTestParameterizedPerimetre(final Cercle p_cercle, final double p_perimetreReference) {
		this.cercle = p_cercle;
		this.perimetreReference = p_perimetreReference;
	}

	/**
	 * Creation of the test list.
	 * 
	 * {0} the tested circle. {1} reference perimetre.
	 * 
	 * @return all the tests.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Test 0
				{ new Cercle(), 10 * Math.PI },
				// Test 1
				{ new Cercle(1), Math.PI },
				// Test 2
				{ new Cercle(2), 2 * Math.PI },
				// Test 3
				{ new Cercle(750.15), 750.15 * Math.PI } };
		return Arrays.asList(data);
	}

	/**
	 * Test of {@link Cercle#perimetre()}.
	 */
	@Test
	public void testPerimetre() {
		assertEquals("Test de perimetre: ", this.perimetreReference, this.cercle.perimetre(), Forme.EPSILON);
	}
}