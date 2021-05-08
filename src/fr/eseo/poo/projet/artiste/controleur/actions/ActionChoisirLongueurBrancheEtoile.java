package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

/**
 * Class {@code ActionChoisirLongueurBrancheEtoile} for choosing the length of
 * the branches of a star.
 *
 * @see PanneauBarreOutils
 * @see ChangeListener
 * 
 * @author EdouardGautier
 *
 * @since 0.3.7.3
 */
public class ActionChoisirLongueurBrancheEtoile implements ChangeListener {
    /**
     * Used to save the name associated with the component using this action.
     * <p>
     * Here the name is {@value #NOM_ACTION}.
     */
    public static final String NOM_ACTION = "Longueur des branches";

    /**
     * {@code PanneauBarreOutils} where the information is sent
     */
    private final PanneauBarreOutils panneauOutil;

    /**
     * Builder of new {@code ActionChoisirLongueurBrancheEtoile}.
     * 
     * @param panneauOutil {@code PanneauBarreOutils} where the information is sent
     */
    public ActionChoisirLongueurBrancheEtoile(final PanneauBarreOutils panneauOutil) {
        this.panneauOutil = panneauOutil;
    }

    /**
     * Method that is called whenever a location event is on the associated JSinner.
     * 
     * @param event A {@code ChangeEvent} corresponding to the event
     */
    @Override
    public void stateChanged(final ChangeEvent event) {
        this.panneauOutil.setLongueurBranches(((double) ((JSpinner) event.getSource()).getValue()));
    }
}