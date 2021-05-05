package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Class {@code Outil} abstract from all tools, which allows to draw shapes.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4
 */
public abstract class Outil implements MouseInputListener {

    /**
     * The {@code PanneauDessin} corresponding to our drawing area.
     * 
     * @since 0.3.4.1
     */
    private PanneauDessin panneauDessin;

    /**
     * The {@code Coordonnees} of the mouse click.
     * <p>
     * This will be one of the corners of our {@code Forme}.
     * 
     * @since 0.3.4.1
     */
    private Coordonnees debut;

    /**
     * The {@code Coordinates} of the mouse release.
     * <p>
     * This will be one of the corners of our {@code Forme}.
     * 
     * @since 0.3.4.1
     */
    private Coordonnees fin;

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * Accessor of the {@code PanneauDessin}, corresponding to our design area.
     * 
     * @return the {@code PanneauDessin} which is our drawing area.
     * 
     * @see #setPanneauDessin(PanneauDessin)
     * 
     * @since 0.3.4.1
     */
    public PanneauDessin getPanneauDessin() {
        return this.panneauDessin;
    }

    /**
     * Muttator of {@dode PanneauDessin}, our design area.
     * 
     * @param panneau The {@code PanneauDessin} that will be our new drawing area.
     *                drawing area.
     * 
     * @see #getPanneauDessin()
     * 
     * @since 0.3.4.1
     */
    public void setPanneauDessin(final PanneauDessin panneau) {
        this.panneauDessin = panneau;
    }

    /**
     * Accessor of allowing to know the {@code Coordonnees} at the beginning of the
     * drawing of the {@code Forme}. It is thus one of the corners of the
     * {@code Forme}.
     * 
     * @return The {@code Coordonnees} of the first corner of our {@code Forme}.
     * 
     * @see #getFin()
     * @see #setDebut(Coordonnees)
     * 
     * @since 0.3.4.1
     */
    public Coordonnees getDebut() {
        return this.debut;
    }

    /**
     * Mutator of the {@code Coordonnes} of the beginning of the tracing of our
     * {@code Forme}.
     * 
     * @param debut The {@code Coordonnees} of the beginning of the trace of the
     *              {@code Forme}.
     * 
     * @see #getDebut()
     * @see #setFin(Coordonnees)
     * 
     * @since 0.3.4.1
     */
    public void setDebut(final Coordonnees debut) {
        this.debut = debut;
    }

    /**
     * Accessor of allowing to know the {@code Coordonnees} of the end of the
     * drawing of the {@code Forme}.
     * 
     * @return The {@code Coordonnees} of the last corner of our {@code Forme}.
     * 
     * @see #getDebut()
     * @see #setFin(Coordonnees)
     * 
     * @since 0.3.4.1
     */
    public Coordonnees getFin() {
        return this.fin;
    }

    /**
     * Mutator of the {@code Coordonnes} of the end of the tracing of the
     * {@code Forme}.
     * 
     * @param fin The {@code Coordonnees} of the end of the tracing of the
     *            {@code Forme}.
     * 
     * @see #getFin()
     * @see #setDebut(Coordonnees)
     * 
     * @since 0.3.4.1
     */
    public void setFin(final Coordonnees fin) {
        this.fin = fin;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Function to retrieve {@code MouseEvent} when one of the mouse buttons is
     * pressed and then released without moving the mouse.
     * 
     * @param event The {@code MouseEvent} associated with the click.
     * 
     * @since 0.3.4.1
     */
    @Override
    public void mouseClicked(final MouseEvent event) {
        // We ignore voluntarily
    }

    /**
     * Function allowing the recovery of {@code MouseEvent} when the mouse is moved
     * with one of its buttons pressed.
     * 
     * @param event Le {@code MouseEvent} associé au déplacement.
     * 
     * @since 0.3.4.1
     */
    @Override
    public void mouseDragged(final MouseEvent event) {
        // We ignore voluntarily
    }

    /**
     * Function to retrieve {@code MouseEvent} when the mouse is moved from outside
     * to inside a component.
     * 
     * @param event The {@code MouseEvent} associated with the move.
     * 
     * @since 0.3.4.1
     */
    @Override
    public void mouseEntered(final MouseEvent event) {
        // We ignore voluntarily
    }

    /**
     * Function to retrieve {@code MouseEvent} when the mouse is moved from the
     * inside to the outside of a component
     * 
     * @param event The {@code MouseEvent} associated with the move.
     * 
     * @since 0.3.4.1
     */
    @Override
    public void mouseExited(final MouseEvent event) {
        // We ignore voluntarily
    }

    /**
     * Function allowing the recovery of {@code MouseEvent} when the mouse is moved
     * without any button pressed
     * 
     * @param event The {@code MouseEvent} associated with the move.
     * 
     * @since 0.3.4.1
     */
    @Override
    public void mouseMoved(final MouseEvent event) {
        // We ignore voluntarily
    }

    /**
     * Function to retrieve {@code Coordonnees} when one of the mouse buttons is
     * pressed
     * 
     * @param event The {@code MouseEvent} associated with the button press.
     * 
     * @since 0.3.4.1
     */
    @Override
    public void mousePressed(final MouseEvent event) {
        this.setDebut(new Coordonnees(event.getX(), event.getY()));
    }

    /**
     * Function to retrieve {@code Coordonnees} when a mouse button is released
     * 
     * @param event The {@code MouseEvent} associated with the release of the
     *              button.
     * 
     * @since 0.3.4.1
     */
    @Override
    public void mouseReleased(final MouseEvent event) {
        this.setFin(new Coordonnees(event.getX(), event.getY()));
    }
}