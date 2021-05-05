package fr.eseo.poo.projet.artiste.controleur.outils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite allowing to launch all the tests of the outils package.
 * 
 * @see OutilLigneTest
 * @see OutilEllipseTest
 * @see OutilEllipseTest
 * @see OutilEtoileTest
 * @see OutilRectangleTest
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.4
 * 
 * @version 1.3.1
 */
@RunWith(Suite.class)
@SuiteClasses({ OutilLigneTest.class, OutilEllipseTest.class, OutilEllipseTest.class, OutilEtoileTest.class,
        OutilRectangleTest.class })
public class OutilsTests {

}
