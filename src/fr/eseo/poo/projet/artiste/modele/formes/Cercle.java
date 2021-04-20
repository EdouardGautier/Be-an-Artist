package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Class {@code Cercle}, a circle is an ellipse whose width and height are equal.
 * <p>
 * 
 * @see Ellipse
 * 
 * @author EdouardGautier
 *
 * @since 0.3.2.6
 * 
 * @version 0.3.2.8
 */
public class Cercle extends Ellipse {
    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/
    /**
     * Constructor of the class {@linkplain Cercle} from a position, a height and
     * width.
     * <p>
     * The height and width must be greater than 0.
     * 
     * @param p_position The {@code Coordonnees} corresponding to the position of
     *                   the of the rectangle enclosing the circle.
     * @param p_largeur  A {@code double} corresponding to the width of the
     *                   rectangle encompassing the circle.
     * 
     * @throws IllegalArgumentException If the width or height is less than or equal
     *                                  to 0.
     * 
     * @see Forme#Forme(Coordonnees, double, double)
     * @see #Cercle()
     * @see #Cercle(Coordonnees)
     * @see #Cercle(double)
     * 
     * @since 0.3.2.6
     */
    public Cercle(Coordonnees p_position, double p_largeur) {
        if (p_largeur <= 0) {
            throw new IllegalArgumentException("La largeur " + getClass().getSimpleName() + " doit être positive");
        } else {
            this.largeur = p_largeur;
            this.hauteur = p_largeur;
            super.setPosition(p_position);
        }
    }

    /**
     * Construct a new {@code Cercle} from a width and a height, the height, the
     * position being initialized from the default values.
     * <p>
     * The height and width must be greater than 0.
     * 
     * @param p_largeur A {@doublecode} corresponding to the width of the rectangle
     *                  encompassing the circle.
     * 
     * @throws IllegalArgumentException If the width or height is less than or equal
     *                                  to 0.
     * 
     * @see #Cercle()
     * @see #Cercle(Coordonnees)
     * @see #Cercle(Coordonnees, double)
     * 
     * @since 0.3.2.6
     */
    public Cercle(double p_largeur) {
        if (p_largeur <= 0) {
            throw new IllegalArgumentException(
                    "La largeur et la hauteur de " + getClass().getSimpleName() + " doivent être positive");
        } else {
            this.largeur = p_largeur;
            this.hauteur = p_largeur;
            super.setPosition(new Coordonnees());
        }
    }

    /**
     * Constructor of a new {@code Cercle} from a point, the other attribute being
     * initialized from the default values.
     * 
     * @param p_position The {@code Coordinates} corresponding to the position of
     *                   the of the rectangle enclosing the circle.
     * 
     * @see Forme#Forme(Coordonnees)
     * @see #Cercle()
     * @see #Cercle(double)
     * @see #Cercle(Coordonnees, double)
     * 
     * @since 0.3.2.6
     */
    public Cercle(Coordonnees p_position) {
        super(p_position);
    }

    /**
     * Constructor of a new {@code Cercle}, it is the constructor by default,
     * initializing the attributes of the class to default values.
     * 
     * @see Forme#Forme()
     * @see #Cercle(Coordonnees)
     * @see #Cercle(double)
     * @see #Cercle(Coordonnees, double)
     * 
     * @since 0.3.2.6
     */
    public Cercle() {
        super();
    }

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * {@inheritDoc}
     * <p>
     * 
     * @param p_largeur In the case of the circle, the height of the rectangle is
     *                  also modified so that its two dimensions remain equal.
     * 
     * @throws IllegalArgumentException If the width is less than or equal to 0.
     * 
     * @see #setHauteur(double)
     * @see Forme#getLargeur()
     * 
     * @since 0.3.2.6
     */
    @Override
    public void setLargeur(double p_largeur) {
        if (p_largeur <= 0) {
            throw new IllegalArgumentException("La largeur de " + getClass().getSimpleName() + " doit être positive");
        } else {
            super.setLargeur(p_largeur);
            super.setHauteur(p_largeur);
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * 
     * @param p_hauteur In the case of the circle, the height of the rectangle is
     *                  also modified so that its two dimensions remain equal.
     * 
     * @throws IllegalArgumentException If the width is less than or equal to 0.
     * 
     * @see #setLargeur(double)
     * @see Forme#getHauteur()
     * 
     * @since 0.3.2.6
     */
    @Override
    public void setHauteur(double p_hauteur) {
        if (p_hauteur <= 0) {
            throw new IllegalArgumentException("La largeur de " + getClass().getSimpleName() + " doit être positive");
        } else {
            this.setLargeur(p_hauteur);
        }
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Calculation of the circle perimeter.
     * <p>
     * The formula is: {@code D x π}.
     * <p>
     * where <i>D</i> is the diameter of the circle.
     * 
     * @since 0.3.2.6
     */
    @Override
    public double perimetre() {
        return Math.PI * super.getLargeur();
    }
}