package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Cercle;

/**
 * Class {@linkplain VueCercle} allowing the display of a line, from the class
 * {@linkplain Cercle}.
 * 
 * @see Cercle
 * @see VueForme
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.3.7
 */
public class VueCercle extends VueEllipse {

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Constructor of a new {@code VueCercle}. The instance of the class is
     * initialized with the shape given in parameter.
     * 
     * @param p_cercle The {@code Cercle} that you wish to display.
     * 
     * @since 0.3.3.7
     */
    public VueCercle(Cercle p_cercle) {
        super(p_cercle);
    }
}
