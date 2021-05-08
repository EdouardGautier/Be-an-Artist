package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import java.awt.Color;
import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Class {@code ActionChoisirCouleur} to select the color with which it will
 * draw the {@code VueForme}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.5.3
 */
public class ActionChoisirCouleur extends AbstractAction {
    /**
     * Saves the name that is used as text displayed on the button.
     * <p>
     * Here {@value #NOM_ACTION}.
     * 
     * @since 0.3.5.3
     */
    public static final String NOM_ACTION = "Choisir une Couleur";

    /**
     * Represents the {@code PanneauDessin} on which the
     * {@code ActionChoisirCouleur} class has an action.
     * 
     * @since 0.3.5.3
     */
    private final PanneauDessin panneauDessin;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Constructor of a new {@code ActionChoisirCouleur}.
     * 
     * @param panneauDessin {@code PanneauDessin} on which the action will have an
     *                      effect.
     * 
     * @since 0.3.5.3
     */
    public ActionChoisirCouleur(final PanneauDessin panneauDessin) {
        super(ActionChoisirCouleur.NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    /**
     * Function executed when the button associated with this action is pressed.
     * 
     * @param event {@code ActionEvent} associated with the button you clicked on
     * 
     * @since 0.3.5.3
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        final Color newColor = JColorChooser.showDialog(this.panneauDessin, ActionChoisirCouleur.NOM_ACTION,
                this.panneauDessin.getCouleurCourante());
        if (newColor != null) {
            this.panneauDessin.setCouleurCourante(newColor);
        }
    }

}