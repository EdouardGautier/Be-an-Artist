package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilForme;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Class allowing to create a new :
 * <ul>
 * <li>{@code OutilLigne}</li>
 * <li>{@code OutilEllipse}</li>
 * <li>{@code OutilCercle}</li>
 * </ul>
 * 
 * @see OutilCercle
 * @see OutilEllipse
 * @see OutilLigne
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.9
 */
public class ActionChoisirForme extends AbstractAction {
    /**
     * Identifies the {@code actionCommand} of the form and will be used as a label
     * for the associated {@code JButton}
     * <p>
     * Here it is the {@value} action.
     */
    public static final String NOM_ACTION_LIGNE = "Ligne";

    /**
     * Identifies the {@code actionCommand} of the form and will be used as a label
     * for the associated {@code JButton}
     * <p>
     * Here it is the {@value} action.
     */
    public static final String NOM_ACTION_ELLIPSE = "Ellipse";

    /**
     * Identifies the {@code actionCommand} of the form and will be used as a label
     * for the associated {@code JButton}
     * <p>
     * Here it is the {@value} action.
     */
    public static final String NOM_ACTION_CERCLE = "Cercle";

    /**
     * Identifies the {@code actionCommand} of the form and will be used as a label
     * for the associated {@code JButton}
     * <p>
     * Here it is the {@value} action.
     */
    public static final String NOM_ACTION_ETOILE = "Etoile";

    /**
     * Allows you to memorize the {@code PanneauDessin} you are using.
     */
    private final PanneauDessin panneauDessin;

    /**
     * Attribute of the class allowing to memorize the {@code PanneauBarreOutils}
     * that we use.
     */
    private final PanneauBarreOutils panneauOutils;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Builder of a new {@code ActionChoisirForme}.
     * 
     * @param p_panneauDessin {@code PanneauDessin} that we want to use
     * @param p_panneauOutils {@code PanneauBarreOutils} that we want to use
     * @param p_nomAction     The name used to identify the action
     * 
     * @since 0.3.4.9
     */
    public ActionChoisirForme(final PanneauDessin p_panneauDessin, final PanneauBarreOutils p_panneauOutils,
            final String p_nomAction) {
        super(p_nomAction);
        this.panneauDessin = p_panneauDessin;
        this.panneauOutils = p_panneauOutils;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * We compare the {@code actionCommand} retrieved in the {@link ActionEvent}
     * with the different class constants, this allows to call the constructor
     * allowing to create the right {@link OutilForme}.
     * 
     * @param event {@code ActionEvent} associated with the click on the button.
     * 
     * @since 0.3.4.9
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        switch (event.getActionCommand()) {
        case ActionChoisirForme.NOM_ACTION_CERCLE:
            this.panneauDessin.associerOutil(new OutilCercle());
            break;
        case ActionChoisirForme.NOM_ACTION_ELLIPSE:
            this.panneauDessin.associerOutil(new OutilEllipse());
            break;
        case ActionChoisirForme.NOM_ACTION_LIGNE:
            this.panneauDessin.associerOutil(new OutilLigne());
            break;
        case ActionChoisirForme.NOM_ACTION_ETOILE:
            this.panneauDessin.associerOutil(new OutilEtoile(this.panneauOutils));
            break;
        default:
        }
    }
}