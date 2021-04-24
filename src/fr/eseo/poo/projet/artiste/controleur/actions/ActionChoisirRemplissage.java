package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Class {@code ActionChoisirRemplissage} allowing to choose to fill or not the
 * shapes.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.6.3
 */
public class ActionChoisirRemplissage extends AbstractAction {
    /**
     * Saves the name that is used as text displayed on the button.
     */
    public static final String NOM_ACTION = "Remplissage de la Forme";

    /**
     * Assigns the {@code PanneauDessin} on which the
     * {@code ActionChoisirRemplissage} class has an action.
     */
    private final PanneauDessin panneauDessin;

    /**
     * Builder of a new {@code ActionChoisirRemplissage}.
     * 
     * @param p_panneauDessin {@code PanneauDessin} on whom the action will have an
     *                        effect.
     */
    public ActionChoisirRemplissage(final PanneauDessin p_panneauDessin) {
        super(ActionChoisirRemplissage.NOM_ACTION);
        this.panneauDessin = p_panneauDessin;
    }

    /**
     * Function executed when the button associated with this action is pressed.
     * 
     * @param event {@code ActionEvent} associated with the button you clicked on
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        this.panneauDessin.setModeRemplissage(((JCheckBox) event.getSource()).isSelected());
    }

}