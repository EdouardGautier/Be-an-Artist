package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * Class for selecting a shape that has already been drawn.
 * <p>
 * The selection of a shape is done when a mouse button is pressed. If a shape
 * is under the mouse cursor, then it is selected.
 * <p>
 * If there are multiple shapes under the mouse cursor, then the most recent
 * shape is chosen as the selected one.
 * <p>
 * A window gives a description of the shape.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.10
 */
public class OutilSelectionner extends OutilForme {

    /**
     * Saves the selected {@code VueForme}.
     */
    private VueForme formeSelectionner = null;

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * Accessor of the selected {@code VueForme}.
     * 
     * @return The selected {@code VueForme}
     * 
     * @see #setVueFormeSelectionner(Forme)
     * 
     * @since 0.3.4.10
     */
    public VueForme getVueFormeSelectionner() {
        return this.formeSelectionner;
    }

    /**
     * Mutator of the selected {@code VueForme}.
     * 
     * @param p_formeSelectionner The {@code VueForme} select
     * 
     * @see #getVueFormeSelectionner()
     * 
     * @since 0.3.4.10
     */
    public void setVueFormeSelectionner(VueForme p_formeSelectionner) {
        this.formeSelectionner = p_formeSelectionner;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * {@inheritDoc}
     * <p>
     * It allows you to obtain the information related to the {@code Forme} on which
     * you have just double clicked.
     * 
     * @since 0.3.4.10
     */
    @Override
    public void mouseClicked(final MouseEvent event) {
        if (event.getClickCount() == 2 && this.formeSelectionner != null) {
            JOptionPane.showMessageDialog(super.getPanneauDessin(), this.formeSelectionner.getForme().toString(),
                    ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Pressing one of the mouse buttons will search for a {@code VueForme} under
     * the mouse cursor.
     * 
     * @param event The {@code MouseEvent} associated with the button press.
     * 
     * @since 0.3.4.10
     */
    @Override
    public void mousePressed(final MouseEvent event) {
        Coordonnees coordonnees = new Coordonnees(event.getX(), event.getY());
        for (VueForme vueForme : super.getPanneauDessin().getVueFormes()) {
            // We browse the list of VueForme
            if (vueForme.getForme().contient(coordonnees)) {
                this.setVueFormeSelectionner(vueForme);
            }
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Not useful here
     * 
     * @param event The {@code MouseEvent} associated with the release of the
     *              button.
     * 
     * @since 0.3.4.10
     */
    public void mouseReleased(final MouseEvent event) {
        // We ignore voluntarily
    }

    @Override
    protected VueForme creerVueForme() {
        // TODO Auto-generated method stub
        return null;
    }
}