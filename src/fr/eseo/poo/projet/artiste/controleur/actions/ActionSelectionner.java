package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Class {@code ActionSelectionner} allowing the user to to select
 * {@code Formes} that have already been drawn.
 * 
 * @author EdouardGautier
 *
 * @since 0.3.4.10
 */
public class ActionSelectionner extends AbstractAction {

    /**
     * Identifies the {@code actionCommand} of the button and will be used as a
     * label for the {@code JButton}.
     * <p>
     * Here it is about the action {@value}.
     *
     * @since 0.3.4.10
     */
    public static final String NOM_ACTION = "Sélectionner";

    /**
     * Allows you to memorize the {@code PanneauDessin} you are using.
     *
     * @since 0.3.4.10
     */
    private final PanneauDessin panneauDessin;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Builder of a new {@code ActionSeletionner}.
     *
     * @param p_panneauDessin {@code PanneauDessin} that we want to use
     *
     * @since 0.3.4.10
     */
    public ActionSelectionner(final PanneauDessin p_panneauDessin) {
        this.panneauDessin = p_panneauDessin;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Function executed when the button associated with this action is pressed.
     * <p>
     * We associate the tool {@code OutilSelectionner}.
     *
     * @param event {@code ActionEvent} associated with the button you clicked on
     *
     * @see OutilSelectionner
     * 
     * @since 0.3.4.10
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        this.panneauDessin.associerOutil(new OutilSelectionner());
    }
}