package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Class {@code ActionEffacer} allowing the user to delete everything.
 *
 * @author EdouardGautier
 *
 * @since 0.3.4.5
 */
public class ActionEffacer extends AbstractAction {

    /**
     * Saves the name that is displayed on the button.
     */
    public static final String NOM_ACTION = "Effacer Tout";

    /**
     * Assigns representing the {@code PanneauDessin} on which there is an action.
     */
    private final PanneauDessin panneauDessin;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Builder of {@code ActionEffacer}.
     *
     * @param panneauDessin the {@code PanneauDessin} on which the action will have
     *                      an effect.
     */
    public ActionEffacer(final PanneauDessin panneauDessin) {
        super(ActionEffacer.NOM_ACTION);
        this.panneauDessin = panneauDessin;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Method that is called when an event occurs on the button.
     * <p>
     * A dialog box is opened to confirm the action.
     * 
     * @param event A {@code ActionEvent} corresponding to the event associated with
     *              the button.
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        final int choix = JOptionPane.showConfirmDialog(this.panneauDessin, "Voulez-vous supprimer le dessin?",
                ActionEffacer.NOM_ACTION, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choix == JOptionPane.OK_OPTION) {
            this.panneauDessin.getVueFormes().clear();
            this.panneauDessin.repaint();
        }
    }
}