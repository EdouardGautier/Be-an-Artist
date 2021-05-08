package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

/**
 * Class {@linkplain VueLigne} allowing the display of a line, from the class
 * {@linkplain Ligne}.
 * 
 * @see Ligne
 * @see VueForme
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.3.5
 * 
 * @version 0.3.5.2
 */
public class VueLigne extends VueForme {
    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Constructor of a new {@code VueLigne}.
     * 
     * @param ligne La {@code Ligne} que l'on souhaite afficher.
     * 
     * @see VueForme#VueForme(Forme)
     * 
     * @since 0.3.3.5
     */
    public VueLigne(final Ligne ligne) {
        super(ligne);
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Function to display the {@form code} that you want to display.
     * 
     * @param g2d The graphical context in which you want the view to be displayed.
     * 
     * @since 0.3.3.5
     * 
     * @version 0.3.5.2
     */
    @Override
    public void affiche(final Graphics2D g2d) {
        final Ligne ligne = (Ligne) super.getForme();
        final Color colorOld = g2d.getColor(); // Save the current color

        g2d.setColor(ligne.getCouleur()); // Use of the VueForme cast

        g2d.drawLine((int) ligne.getPosition().getAbscisse(), (int) ligne.getPosition().getOrdonnee(),
                (int) (ligne.getPosition().getAbscisse() + ligne.getLargeur()),
                (int) (ligne.getPosition().getOrdonnee() + ligne.getHauteur()));

        g2d.setColor(colorOld); // We restore the color save
    }
}