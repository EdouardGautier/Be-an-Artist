package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite allowing to launch all the tests of {@linkplain Carre}.
 * 
 * @see CarreTest
 * @see CarreTestParameterizedPerimetre
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.2
 */
@RunWith(Suite.class)
@SuiteClasses({ CarreTest.class, CarreTestParameterizedPerimetre.class, })
public class CarreTestAll {

}