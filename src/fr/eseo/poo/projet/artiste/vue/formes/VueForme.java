package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;

/**
 * Abstriate class {@code VueForme}, this class is the basis for the display of
 * all shapes.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.3.3
 */
public abstract class VueForme {

    /**
     * Constant of the class {@code VueForme}, representing the displayed form.
     * 
     * @since 0.3.3.3
     */
    protected final Forme forme;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Constructor of a new {@code VueForme}. The instance of the class is
     * initialized with the shape given in parameter.
     * 
     * @param p_forme The {@code Forme} that you wish to display.
     * 
     * @since 0.3.3.3
     */
    public VueForme(final Forme p_forme) {
        this.forme = p_forme;
    }

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * Accessor of the {@code Forme}.
     * 
     * @return The {@code Forme} which is linked to the {@code VueForme}.
     * 
     * @since 0.3.3.3
     */
    public Forme getForme() {
        return this.forme;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Function to display the {@form code} that you want to display.
     * 
     * @param g2d The graphical context in which you want the view to be displayed.
     * 
     * @since 0.3.3.3
     */
    public abstract void affiche(Graphics2D g2d);
}
