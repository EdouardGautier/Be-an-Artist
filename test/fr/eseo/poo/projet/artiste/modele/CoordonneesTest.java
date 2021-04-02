package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Base test class (with asserts and not parameterized) of the
 * {@link Coordonnees}
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.2
 */
public class CoordonneesTest {

	/**
	 * Test of {@link Coordonnees#Coordonnees()}.
	 * 
	 * @since 0.3.2.2
	 */
	@Test
	public void testConstructeurVide() {
		final Coordonnees point = new Coordonnees();

		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, point.getAbscisse(), Coordonnees.EPSILON);
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT, point.getOrdonnee(), Coordonnees.EPSILON);
	}

	/**
	 * Test of {@link Coordonnees#Coordonnees(double, double)}.
	 * 
	 * @since 0.3.2.2
	 */
	@Test
	public void testConstructeur() {
		final Coordonnees point = new Coordonnees(7.0, 5.0);

		assertEquals(7.0, point.getAbscisse(), Coordonnees.EPSILON);
		assertEquals(5.0, point.getOrdonnee(), Coordonnees.EPSILON);
	}

	/**
	 * Test of {@link Coordonnees#angleVers(Coordonnees)}.
	 * 
	 * @since 0.3.2.2
	 */
	@Test
	public void testVersAngle() {
		final Coordonnees point = new Coordonnees();

		assertEquals("Test du calcul d'angle entre deux points", point.angleVers(new Coordonnees()), 0,
				Coordonnees.EPSILON);
	}

	/**
	 * Test of {@link Coordonnees#toString()}.
	 * 
	 * @since 0.3.2.2
	 */
	@Test
	public void testToString() {
		final Coordonnees point = new Coordonnees();

		assertEquals("Test de l'affichage des coordonnées", "(0,0 , 0,0)", point.toString());
	}
}