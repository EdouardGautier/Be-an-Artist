package fr.eseo.poo.projet.artiste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.controleur.ControleurTests;
import fr.eseo.poo.projet.artiste.modele.ModeleTests;

/**
 * Test suite allowing to launch all the tests of the project.
 * 
 * @see ModeleTests
 * @see ControleurTests
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.4
 */
@RunWith(Suite.class)
@SuiteClasses({ ModeleTests.class, ControleurTests.class })
public class AllTests {
    
}
