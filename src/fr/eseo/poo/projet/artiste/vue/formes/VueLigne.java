package fr.eseo.poo.projet.artiste.vue.formes;

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
 */
public class VueLigne extends VueForme {
    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Constructor of a new {@code VueLigne}.
     * 
     * @param p_ligne La {@code Ligne} que l'on souhaite afficher.
     * 
     * @see VueForme#VueForme(Forme)
     * 
     * @since 0.3.3.5
     */
    public VueLigne(final Ligne p_ligne) {
        super(p_ligne);
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
     */
    @Override
    public void affiche(final Graphics2D g2d) {
        g2d.drawLine((int) super.getForme().getPosition().getAbscisse(),
                (int) super.getForme().getPosition().getOrdonnee(),
                (int) (super.getForme().getPosition().getAbscisse() + super.getForme().getLargeur()),
                (int) (super.getForme().getPosition().getOrdonnee() + super.getForme().getHauteur()));
    }
}