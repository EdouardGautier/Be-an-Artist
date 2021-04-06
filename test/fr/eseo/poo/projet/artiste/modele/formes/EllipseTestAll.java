package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite allowing to launch all the tests of {@linkplain Ellipse}.
 * 
 * @see EllipseTest
 * @see EllipseTestParameterizedAire
 * @see EllipseTestParameterizedContient
 * @see EllipseTestParameterizedPerimetre
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.8
 */
@RunWith(Suite.class)
@SuiteClasses({ EllipseTest.class, EllipseTestParameterizedContient.class,
        EllipseTestParameterizedPerimetre.class })
public class EllipseTestAll {
}