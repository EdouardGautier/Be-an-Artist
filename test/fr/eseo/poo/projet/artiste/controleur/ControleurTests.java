package fr.eseo.poo.projet.artiste.controleur;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilsTests;

/**
 * Test suite allowing to launch all the tests of the controleur package.
 * 
 * @see OutilsTests
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.4
 */
@RunWith(Suite.class)
@SuiteClasses({ OutilsTests.class })
public class ControleurTests {

}
