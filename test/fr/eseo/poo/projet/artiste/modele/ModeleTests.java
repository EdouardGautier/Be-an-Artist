package fr.eseo.poo.projet.artiste.modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.modele.formes.CercleTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.EllipseTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.LigneTestAll;

/**
 * Test suite allowing to launch all the tests of the model package.
 * 
 * @see CoordonneesTestAll
 * @see LigneTestAll
 * @see EllipseTestAll
 * @see CercleTestAll
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.2
 * 
 * @version 0.3.2.8
 */
@RunWith(Suite.class)
@SuiteClasses({ CoordonneesTestAll.class, LigneTestAll.class, EllipseTestAll.class, CercleTestAll.class })
public class ModeleTests {

}
