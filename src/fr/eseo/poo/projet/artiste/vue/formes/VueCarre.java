package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Carre;

/**
 * Class {@linkplain VueCarre} allowing the display of a square, from the class
 * {@linkplain Carre}.
 * 
 * @see Carre
 * @see VueForme
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.2
 */
public class VueCarre extends VueRectangle {

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Constructor of a new {@code VueCarre}. The instance of the class is
     * initialized with the shape given in parameter.
     * 
     * @param carre The {@code Carre} that you wish to display.
     * 
     * @since 1.3.2
     */
    public VueCarre(Carre carre) {
        super(carre);
    }
}
