package fr.eseo.poo.projet.artiste.modele;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Parameterized test class of {@link Coordonnees#distanceVers(Coordonnees)}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class CoordonneesTestParameterizedDistanceVers {

	/**
	 * Frist point.
	 */
	private final Coordonnees c1;

	/**
	 * Second point.
	 */
	private final Coordonnees c2;

	/**
	 * Reference distance between the two points.
	 */
	private final double distanceReference;

	/**
	 * Constructeur pour chaque donne de test.
	 * 
	 * @param c1                frist point.
	 * @param c2                second point.
	 * @param distanceReference reference distance between the two points.
	 */
	public CoordonneesTestParameterizedDistanceVers(final Coordonnees c1, final Coordonnees c2,
			final double distanceReference) {
		this.c1 = c1;
		this.c2 = c2;
		this.distanceReference = distanceReference;
	}

	/**
	 * Creation of the test list.
	 * 
	 * {0} initial point {1} final point {2} distance
	 * 
	 * @return all the tests
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Test 0: the two points are superposed.
				{ new Coordonnees(), new Coordonnees(), 0.0 },
				// Test 1: the second point is above
				{ new Coordonnees(), new Coordonnees(0.0, 1.0), 1.0 },
				// Test 2: the second point is below
				{ new Coordonnees(), new Coordonnees(0.0, -1.0), 1.0 },
				// Test 3: the second point is on the right
				{ new Coordonnees(), new Coordonnees(1.0, 0.0), 1.0 },
				// Test 4: the second point is on the left.
				{ new Coordonnees(), new Coordonnees(-1.0, 0.0), 1.0 },
				// Test 5: the second point is at the bottom left
				{ new Coordonnees(), new Coordonnees(-12.0, -3.0), 12.369 },
				// Test 6: the second point is at the bottom right.
				{ new Coordonnees(), new Coordonnees(12.0, -3.0), 12.369 },
				// Test 7: the second point is at the top left.
				{ new Coordonnees(), new Coordonnees(-12.0, 3.0), 12.369 },
				// Test 8: the second point is at the top right.
				{ new Coordonnees(), new Coordonnees(12.0, 3.0), 12.369 }, };
		return Arrays.asList(data);
	}

	/**
	 * Test of {@link Coordonnees#distanceVers(Coordonnees)}.
	 */
	@Test
	public void testDistanceVers() {

		assertEquals("Test de distanceVers(): ", this.distanceReference, this.c1.distanceVers(this.c2),
				Coordonnees.EPSILON);
	}
}