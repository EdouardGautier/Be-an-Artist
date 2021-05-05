package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Class {@code Carre}, a square is an Rectangle whose width and height are equal.
 * <p>
 * 
 * @see Rectangle
 * 
 * @author EdouardGautier
 *
 * @since 1.3.2
 */
public class Carre extends Rectangle {
    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/
    /**
     * Constructor of the class {@code Carre} from a position, a height and
     * width.
     * <p>
     * The height and width must be greater than 0.
     * 
     * @param position The {@code Coordonnees} corresponding to the position of
     *                   the of the rectangle enclosing the square.
     * @param largeur  A {@code double} corresponding to the width of the
     *                   rectangle encompassing the square.
     * 
     * @throws IllegalArgumentException If the width or height is less than or equal
     *                                  to 0.
     * 
     * @see Forme#Forme(Coordonnees, double, double)
     * @see #Carre()
     * @see #Carre(Coordonnees)
     * @see #Carre(double)
     * 
     * @since 1.3.2
     */
    public Carre(Coordonnees position, double largeur) {
        if (largeur <= 0) {
            throw new IllegalArgumentException("La largeur " + getClass().getSimpleName() + " doit être positive");
        } else {
            this.largeur = largeur;
            this.hauteur = largeur;
            super.setPosition(position);
        }
    }

    /**
     * Construct a new {@code Carre} from a width and a height, the height, the
     * position being initialized from the default values.
     * <p>
     * The height and width must be greater than 0.
     * 
     * @param largeur A {@doublecode} corresponding to the width of the rectangle
     *                  encompassing the square.
     * 
     * @throws IllegalArgumentException If the width or height is less than or equal
     *                                  to 0.
     * 
     * @see #Carre()
     * @see #Carre(Coordonnees)
     * @see #Carre(Coordonnees, double)
     * 
     * @since 1.3.2
     */
    public Carre(double largeur) {
        if (largeur <= 0) {
            throw new IllegalArgumentException(
                    "La largeur et la hauteur de " + getClass().getSimpleName() + " doivent être positive");
        } else {
            this.largeur = largeur;
            this.hauteur = largeur;
            super.setPosition(new Coordonnees());
        }
    }

    /**
     * Constructor of a new {@code Carre} from a point, the other attribute being
     * initialized from the default values.
     * 
     * @param position The {@code Coordinates} corresponding to the position of
     *                   the of the rectangle enclosing the square.
     * 
     * @see Forme#Forme(Coordonnees)
     * @see #Carre()
     * @see #Carre(double)
     * @see #Carre(Coordonnees, double)
     * 
     * @since 1.3.2
     */
    public Carre(Coordonnees position) {
        super(position);
    }

    /**
     * Constructor of a new {@code Carre}, it is the constructor by default,
     * initializing the attributes of the class to default values.
     * 
     * @see Forme#Forme()
     * @see #Carre(Coordonnees)
     * @see #Carre(double)
     * @see #Carre(Coordonnees, double)
     * 
     * @since 1.3.2
     */
    public Carre() {
        super();
    }

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * {@inheritDoc}
     * <p>
     * 
     * @param largeur In the case of the square, the height of the rectangle is
     *                  also modified so that its two dimensions remain equal.
     * 
     * @throws IllegalArgumentException If the width is less than or equal to 0.
     * 
     * @see #setHauteur(double)
     * @see Forme#getLargeur()
     * 
     * @since 1.3.2
     */
    @Override
    public void setLargeur(double largeur) {
        if (largeur <= 0) {
            throw new IllegalArgumentException("La largeur de " + getClass().getSimpleName() + " doit être positive");
        } else {
            super.setLargeur(largeur);
            super.setHauteur(largeur);
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * 
     * @param hauteur In the case of the square, the height of the rectangle is
     *                  also modified so that its two dimensions remain equal.
     * 
     * @throws IllegalArgumentException If the width is less than or equal to 0.
     * 
     * @see #setLargeur(double)
     * @see Forme#getHauteur()
     * 
     * @since 1.3.2
     */
    @Override
    public void setHauteur(double hauteur) {
        if (hauteur <= 0) {
            throw new IllegalArgumentException("La largeur de " + getClass().getSimpleName() + " doit être positive");
        } else {
            this.setLargeur(hauteur);
        }
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Calculation of the square perimeter.
     * <p>
     * The formula is: {@code D x π}.
     * <p>
     * where <i>D</i> is the diameter of the square.
     * 
     * @since 1.3.2
     */
    @Override
    public double perimetre() {
        return Math.PI * super.getLargeur();
    }
}
