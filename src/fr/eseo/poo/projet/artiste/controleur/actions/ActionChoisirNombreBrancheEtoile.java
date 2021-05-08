package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.JSpinner;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class {@code ActionChoisirNombreBrancheEtoile} allows you to choose the
 * number of the branches of a star.
 * 
 * @see PanneauBarreOutils
 * @see ChangeListener
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.3
 */
public class ActionChoisirNombreBrancheEtoile implements ChangeListener {
    /**
     * Used to save the name associated with the component using this action.
     * <p>
     * Here the name is {@value #NOM_ACTION}.
     */
    public static final String NOM_ACTION = "Nombre de branche";

    /**
     * {@code PanneauBarreOutils} where the information is sent
     */
    private final PanneauBarreOutils panneauOutil;

    /**
     * Builder of new {@code ActionChoisirNombreBrancheEtoile}.
     * 
     * @param panneauOutil {@code PanneauBarreOutils} where the information is sent
     */
    public ActionChoisirNombreBrancheEtoile(final PanneauBarreOutils panneauOutil) {
        this.panneauOutil = panneauOutil;
    }

    /**
     * Method that is called whenever a location event is on the associated JSinner.
     * 
     * @param event A {@code ChangeEvent} corresponding to the event
     */
    @Override
    public void stateChanged(final ChangeEvent event) {
        this.panneauOutil.setNbBranches(((int) ((JSpinner) event.getSource()).getValue()));
    }
}