package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * {@code OutilForme} is an abstract class associated with all the tools of a
 * {@code Forme}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.2
 */
public abstract class OutilForme extends Outil {

    /**
     * {@inheritDoc}
     * 
     * @param event The {@code MouseEvent} associated with the release of the
     *              button.
     * 
     * @since 0.3.4.2
     */
    @Override
    public void mouseReleased(final MouseEvent event) {
        super.mouseReleased(event);
        if (!super.getDebut().equals(super.getFin())) {
            super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
            super.getPanneauDessin().repaint();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @param event The {@code MouseEvent} associated with the click.
     * 
     * @since 0.3.4.2
     */
    @Override
    public void mouseClicked(final MouseEvent event) {
        if (event.getClickCount() == 2) {
            super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
            super.getPanneauDessin().repaint();
        }
    }

    /**
     * Function to plot a {@shape Forme}.
     * <p>
     * The {@code Coordonnees} are that of the position of the mouse at the time of
     * mouse press and release.
     * <p>
     * In the case where the two {@code Coordonnees} are identical, we draw the
     * shape with the default parameterss
     * 
     * @see #mouseClicked(MouseEvent)
     * @see #mousePressed(MouseEvent)
     * 
     * @since 0.3.4.2
     */
    protected abstract VueForme creerVueForme();
}