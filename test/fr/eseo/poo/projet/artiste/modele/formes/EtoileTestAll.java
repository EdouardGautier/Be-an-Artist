package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite allowing to launch all the tests of {@linkplain Etoile}.
 * 
 * @see EtoileTest
 * @see EtoileTestParameterizedAire
 * @see EtoileTestParameterizedContient
 * @see EtoileTestParameterizedPerimetre
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.3
 */
@RunWith(Suite.class)
@SuiteClasses({ EtoileTest.class, EtoileTestParameterizedAire.class, EtoileTestParameterizedContient.class,
        EtoileTestParameterizedPerimetre.class })
public class EtoileTestAll {

}
