package fr.eseo.poo.projet.artiste.modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.modele.formes.CarreTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.CercleTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.EllipseTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.EtoileTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.LigneTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.RectangleTestAll;

/**
 * Test suite allowing to launch all the tests of the model package.
 * 
 * @see CoordonneesTestAll
 * @see LigneTestAll
 * @see EllipseTestAll
 * @see CercleTestAll
 * @see EtoileTestAll
 * @see RectangleTestAll
 * @see CarreTestAll
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.2
 * 
 * @version 1.3.1
 */
@RunWith(Suite.class)
@SuiteClasses({ CoordonneesTestAll.class, LigneTestAll.class, EllipseTestAll.class, CercleTestAll.class,
        EtoileTestAll.class, RectangleTestAll.class, CarreTestAll.class })
public class ModeleTests {

}
