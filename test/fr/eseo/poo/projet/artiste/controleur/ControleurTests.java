package fr.eseo.poo.projet.artiste.controleur;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionTests;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilsTests;

/**
 * Test suite allowing to launch all the tests of the controleur package.
 * 
 * @see OutilsTests
 * @see ActionTests
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.4
 * 
 * @version 0.3.4.6
 */
@RunWith(Suite.class)
@SuiteClasses({ OutilsTests.class, ActionTests.class })
public class ControleurTests {

}
