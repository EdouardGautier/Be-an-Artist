package fr.eseo.poo.projet.artiste.controleur.actions;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite allowing to launch all the tests of the action package.
 * 
 * @see ActionEffacerTest
 * @see ActionChoisirCouleurTest
 * @see ActionChoisirRemplissageTest
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.6
 * 
 * @version 0.3.5.3
 */
@RunWith(Suite.class)
@SuiteClasses({ ActionEffacerTest.class, ActionChoisirCouleurTest.class, ActionChoisirRemplissageTest.class })
public class ActionTests {

}
