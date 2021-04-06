package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite allowing to launch all the tests of {@linkplain Ligne}.
 * 
 * @see LigneTest
 * @see LigneTestParameterizedContient
 * @see LigneTestParameterizedPerimetre
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Suite.class)
@SuiteClasses({ LigneTest.class, LigneTestParameterizedContient.class,
        LigneTestParameterizedPerimetre.class })
public class LigneTestAll {
}