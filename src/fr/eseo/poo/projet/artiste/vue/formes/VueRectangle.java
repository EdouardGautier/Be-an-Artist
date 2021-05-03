package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;

/**
 * Class {@linkplain VueRectangle} allowing the display of a line, from the
 * class {@linkplain Rectangle}.
 * 
 * @see Rectangle
 * @see VueForme
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.1
 */
public class VueRectangle extends VueForme {

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Constructor of a new {@code VueRectangle}. The instance of the class is
     * initialized with the shape given in parameter.
     * 
     * @param p_rectangle The {@code rectangle} that you wish to display.
     * 
     * @since 1.3.1
     */
    public VueRectangle(final Rectangle p_rectangle) {
        super(p_rectangle);
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Function to display the {@code Forme} that you want to display.
     * 
     * @param g2d The graphical context in which you want the view to be displayed.
     * 
     * @since 1.3.1
     */
    @Override
    public void affiche(final Graphics2D g2d) {
        final Rectangle rectangle = (Rectangle) super.getForme();
        final Color colorOld = g2d.getColor(); // Save the current color

        g2d.setColor(rectangle.getCouleur());

        if (rectangle.estRempli()) {
            g2d.fillRect((int) rectangle.getPosition().getAbscisse(), (int) rectangle.getPosition().getOrdonnee(),
                    (int) rectangle.getLargeur(), (int) rectangle.getHauteur());
        }
        g2d.drawRect((int) rectangle.getPosition().getAbscisse(), (int) rectangle.getPosition().getOrdonnee(),
                (int) rectangle.getLargeur(), (int) rectangle.getHauteur());
        g2d.setColor(colorOld);
    }
}
