package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite allowing to launch all the tests of {@linkplain Rectangle}.
 * 
 * @see RectangleTest
 * @see RectangleTestParameterizedAire
 * @see RectangleTestParameterizedContient
 * @see RectangleTestParameterizedPerimetre
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.1
 */
@RunWith(Suite.class)
@SuiteClasses({ RectangleTest.class, RectangleTestParameterizedAire.class, RectangleTestParameterizedContient.class,
        RectangleTestParameterizedPerimetre.class })
public class RectangleTestAll {
}