package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Parameterized test class of {@link Ellipse#perimetre()}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class EllipseTestParameterizedPerimetre {

	/**
	 * The tested ellipse.
	 */
	private final Ellipse ellipse;

	/**
	 * Reference perimetre.
	 */
	private final double perimetreReference;

	/**
	 * Builder for each test for Coordinates.
	 * 
	 * @param p_ellipse            the tested ellipse.
	 * @param p_perimetreReference reference perimetre.
	 */
	public EllipseTestParameterizedPerimetre(final Ellipse p_ellipse, final double p_perimetreReference) {
		this.ellipse = p_ellipse;
		this.perimetreReference = p_perimetreReference;
	}

	/**
	 * Creation of the test list.
	 * 
	 * {0} the tested ellipse. {1} reference perimetre.
	 * 
	 * @return all the tests.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Test 0
				{ new Ellipse(1, 1), Math.PI },
				// Test 1
				{ new Ellipse(1, 2), 4.84 },
				// Test 2
				{ new Ellipse(15.05, 15.05), 47.28 },
				// Test 3
				{ new Ellipse(28.1, 15.05), 69.33 } };
		return Arrays.asList(data);
	}

	/**
	 * Test of {@link Ellipse#perimetre()}
	 */
	@Test
	public void testPerimetreEllipse() {
		assertEquals("Test de perimetre(): ", this.perimetreReference, this.ellipse.perimetre(), Forme.EPSILON);
	}
}