package fr.eseo.poo.projet.artiste.modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite allowing to launch all the tests of {@linkplain Coordonnees}.
 * 
 * @see CoordonneesTest
 * @see CoordonneesTestParameterizedAngleVers
 * @see CoordonneesTestParameterizedDeplacerDe
 * @see CoordonneesTestParameterizedDeplacerVers
 * @see CoordonneesTestParameterizedDistanceVers
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Suite.class)
@SuiteClasses({ CoordonneesTest.class, CoordonneesTestParameterizedAngleVers.class,
        CoordonneesTestParameterizedDeplacerDe.class, CoordonneesTestParameterizedDeplacerVers.class,
        CoordonneesTestParameterizedDistanceVers.class })
public class CoordonneesTestAll {
}