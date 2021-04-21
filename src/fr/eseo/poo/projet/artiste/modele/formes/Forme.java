package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Class {@code Forme} is the abstract class that allows you to size and place a
 * shape.
 * <p>
 * A shape is characterized by:
 * <ul>
 * <li>The <B>width</B> of the rectangle enclosing the shape.</li>
 * <li>The <B>height</B> of the rectangle enclosing the shape.</li>
 * <li>The <B>position</B> of the upper left corner of the rectangle enclosing
 * the shape from a point (see {@linkplain Coordonnees}).</li>
 * </ul>
 * Default:
 * <ul>
 * <li>Width is initialized to {@value #LARGEUR_PAR_DEFAUT}.</li>
 * <li>The length is initialized to {@value #HAUTEUR_PAR_DEFAUT}.</li>
 * <li>The position is initialized to ({@value Coordonnees#DEFAULT_COORD_X},
 * ({@value Coordinates#DEFAULT_COORD_Y}).</li>
 * </ul>
 * It is possible to determine the coordinates of the other corners of the
 * rectangle.
 * <p>
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.3
 * 
 * @version 0.3.2.8
 */
public abstract class Forme {
    /**
     * Default {@code double} value of the width the rectangle enclosing the shape.
     * <p>
     * Of value {@value #LARGEUR_PAR_DEFAUT} for <B>width</B>
     * 
     * @since 0.3.2.3
     */
    public static final double LARGEUR_PAR_DEFAUT = 10;

    /**
     * Default {@code double} value of the length of the rectangle enclosing the
     * shape.
     * <p>
     * Of value {@value #HAUTEUR_PAR_DEFAUT} For the <B>length</B>.
     * 
     * @since 0.3.2.3
     */
    public static final double HAUTEUR_PAR_DEFAUT = 10;

    /**
     * Attribute representing the length of the rectangle enclosing the shape.
     * 
     * @see #getHauteur()
     * @see #setHauteur(double)
     * @see #HAUTEUR_PAR_DEFAUT
     * 
     * @since 0.3.2.3
     */
    protected double hauteur;

    /**
     * Attribute representing the width of the rectangle enclosing the shape.
     * 
     * @see #getLargeur()
     * @see #setLargeur(double)
     * @see #LARGEUR_PAR_DEFAUT
     * 
     * @since 0.3.2.3
     */
    protected double largeur;

    /**
     * Attribute representing the upper left corner of the rectangle enclosing the
     * shape.
     * 
     * @see #getAbscisse()
     * @see #getOrdonnee()
     * @see Coordonnees#ABSCISSE_PAR_DEFAUT
     * @see Coordonnees#ORDONNEE_PAR_DEFAUT
     * 
     * @since 0.3.2.3
     */
    private Coordonnees position;

    /***
     * Value of type {@code double}, for comparison between two points.
     * <p>
     * The precision of the comparison is {@value #EPSILON}.
     * 
     * @since 0.3.2.5
     */
    public final static double EPSILON = 0.01;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Construct a new {@code Forme} from a point, a height and a width.
     * 
     * @param p_largeur A {@code double} corresponding to the width of the rectangle
     *                  enclosing the shape.
     * @param p_hauteur A {@code double} corresponding to the height of the
     *                  rectangle enclosing the shape.
     * @param p_point   A {@code Coordonnees} corresponding to the position of the
     *                  upper left corner of the rectangle enclosing the shape.
     * 
     * @see #Forme()
     * @see #Forme(Coordonnees)
     * @see #Forme(double, double)
     * 
     * @since 0.3.2.3
     * 
     * @version 0.1
     */
    public Forme(Coordonnees p_point, double p_largeur, double p_hauteur) {
        this.largeur = p_largeur;
        this.hauteur = p_hauteur;
        this.position = p_point;
    }

    /**
     * Construct a new {@code Forme} from a point, a height and a width.
     * <p>
     * The other attributes being initialized from the default values.
     * </p>
     * 
     * @param p_largeur A {@code double} corresponding to the width of the rectangle
     *                  rectangle enclosing the shape.
     * @param p_hauteur A {@doublecode} corresponding to the height of the rectangle
     *                  encompassing the shape.
     * 
     * @see #Forme()
     * @see #Forme(Coordonnees)
     * @see #Forme(Coordonnees, double, double)
     * 
     * @since 0.3.2.3
     */
    public Forme(double p_largeur, double p_hauteur) {
        this(new Coordonnees(0, 0), p_largeur, p_hauteur);
    }

    /**
     * Construct a new {@code Forme} from a point.
     * <p>
     * The other attributes being initialized from the default values.
     * </p>
     * 
     * @param p_point The {@code Coordonnees} corresponding to the position of the
     *                upper left corner of the rectangle enclosing the shape.
     * 
     * @see #Forme()
     * @see #Forme(double, double)
     * @see #Forme(Coordonnees, double, double)
     * 
     * 
     * @since 0.3.2.3
     */
    public Forme(Coordonnees p_point) {
        this(p_point, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    /**
     * Constructor of a new {@code Form}. this is the default constructor.
     * <p>
     * Instances will be initialized to the default values
     * </p>
     * 
     * @see #Forme(double, double)
     * @see #Forme(Coordonnees)
     * @see #Forme(Coordonnees, double, double)
     * 
     * @since 0.3.2.3
     */
    public Forme() {
        this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * Accessor of the {@code largeur} of the rectangle enclosing the shape.
     * 
     * @return The {@code double} corresponding to the width of the shape.
     * 
     * @see #setLargeur(double)
     * 
     * @since 0.3.2.3
     */
    public double getLargeur() {
        return this.largeur;
    }

    /**
     * Mutator of the {@code largeur} of the rectangle enclosing the shape.
     * 
     * @param p_largeur A {@code double} corresponding to the new width of the
     *                  shape.
     * 
     * @see #getLargeur()
     * 
     * @since 0.3.2.3
     */
    public void setLargeur(double p_largeur) {
        this.largeur = p_largeur;
    }

    /**
     * Accessor of the {@code HAUTEUR} of the rectangle enclosing the shape.
     * 
     * @return The {@code double} corresponding to the length of the shape.
     * 
     * @see #setHauteur(double)
     * 
     * @since 0.3.2.3
     */
    public double getHauteur() {
        return this.hauteur;
    }

    /**
     * Mutator of the {@code HAUTEUR} of the rectangle enclosing the shape.
     * 
     * @param p_hauteur A {@code double} corresponding to the new length of the
     *                  shape.
     * 
     * @see #getHauteur()
     * 
     * @since 0.3.2.3
     */
    public void setHauteur(double p_hauteur) {
        this.hauteur = p_hauteur;
    }

    /**
     * Accessor of the {@code point} of the rectangle enclosing the shape.
     * 
     * @return The {@code Coordonnees} corresponding to the coordinate of the shape.
     * 
     * @see Coordonnees
     * @see #setPosition(Coordonnees)
     * 
     * @since 0.3.2.3
     */
    public Coordonnees getPosition() {
        return this.position;
    }

    /**
     * Mutator of the {@code point} of the rectangle enclosing the shape.
     * 
     * @param p_point A {@code double} corresponding to the new coordinates of the
     *                shape.
     * 
     * @see Coordonnees
     * @see #getPosition()
     * 
     * @since 0.3.2.3
     */
    public void setPosition(Coordonnees p_point) {
        this.position = p_point;
    }

    /**
     * Accessor of the abcissa of the top left corner of the rectangle that encloses
     * the shape.
     * 
     * @return A {@code double} corresponding to the abcissa of the top left corner
     * 
     * @see Coordonnees
     * @see #getCadreMinX()
     * 
     * @since 0.3.2.3
     */
    public double getCadreMaxX() {
        return Math.max(this.getPosition().getAbscisse(), this.getPosition().getAbscisse() + this.getLargeur());
    }

    /**
     * Accessor of the abcissa of the lower right corner of the rectangle that
     * encloses the shape.
     * 
     * @return A {@code double} corresponding to the abcissa of the lower right
     *         corner
     * 
     * @see Coordonnees
     * @see #getCadreMaxX()
     * 
     * @since 0.3.2.3
     */
    public double getCadreMinX() {
        return Math.min(this.getPosition().getAbscisse(), this.getPosition().getAbscisse() + this.getLargeur());
    }

    /**
     * Accessor of the abcissa of the top left corner of the rectangle that encloses
     * the shape.
     * 
     * @return A {@code double} corresponding to the ordinate of the top left corner
     * 
     * @see Coordonnees
     * @see #getCadreMinY()
     * 
     * @since 0.3.2.3
     */
    public double getCadreMaxY() {
        return Math.max(this.getPosition().getOrdonnee(), this.getPosition().getOrdonnee() + this.getHauteur());
    }

    /**
     * Accessor of the abcissa of the lower right corner of the rectangle that
     * encloses the shape.
     * 
     * @return A {@code double} corresponding to the ordinate of the lower right
     *         corner
     * 
     * @see Coordonnees
     * @see #getCadreMaxY()
     * 
     * @since 0.3.2.3
     */
    public double getCadreMinY() {
        return Math.min(this.getPosition().getOrdonnee(), this.getPosition().getOrdonnee() + this.getHauteur());
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Calculates the perimeter of the shape.
     * 
     * @return A {@code double} corresponding to the perimeter of the shape.
     * 
     * @see #aire()
     * 
     * @since 0.3.2.3
     */
    public abstract double perimetre();

    /**
     * Calculates the surface of the form.
     * 
     * @return A {@code double} corresponding to the surface of the shape.
     * 
     * @see #perimetre()
     * 
     * @since 0.3.2.3
     */
    public abstract double aire();

    /**
     * Function to know if a point is inside the shape.
     *
     * @param p_point A {@code Coordonnees} corresponding to the point of which we
     *                want to know to know if it is in the shape.
     * 
     * @return {@code true} if the point is in the form, {@code false} otherwise.
     * 
     * @since 0.3.2.8
     */
    public abstract boolean contient(Coordonnees p_point);

    /**
     * Mutator of the 2 coordinates of the point from a new abscissa and a new
     * ordinate.
     * 
     * @param p_x A {@code Coordonnees} corresponding to the new abscissa of the
     *            point.
     * @param p   A {@code Coordonnees} corresponding to the new ordinate of the
     *            point.
     * 
     * @see #deplacerDe(Coordonnees)
     * 
     * @since 0.3.2.3
     */
    public void deplacerVers(double p_x, double p_y) {
        position.deplacerVers(p_x, p_y);
    }

    /**
     * Mutators of the 2 coordinates of the point from a displacement vector. A
     * shift of the point is performed.
     * 
     * @param p_x A {@code Coordonnees} corresponding to the new abscissa of the
     *            point.
     * @param p   A {@code Coordonnees} corresponding to the new ordinate of the
     *            point.
     * 
     * @see #deplacerDe(Coordonnees)
     * 
     * @since 0.3.2.3
     */
    public void deplacerDe(double p_x, double p_y) {
        position.deplacerDe(p_x, p_y);
    }

    /**
     * Function returning a description of the point in the form:
     * <p>
     * {@code Class, [pos : Coordonnees, largeur : double, HAUTEUR : double]"}.
     * 
     * @return A {@code String}, corresponding to the description of the
     *         {@code Forme}.
     *         </p>
     * @since 0.3.2.3
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ", [pos : " + this.position + ", largeur : " + this.largeur
                + ", HAUTEUR : " + this.hauteur + "]";
    }

    /**
     * Function to compare whether two {@code Formes} are identical, to within
     * {@value #EPSILON}.
     * 
     * @param other The instance with which the form is compared.
     * 
     * @return {@code true} if two {@code Forms} are identical, {@code false}
     *         otherwise.
     * 
     * @since 0.3.3.6
     */
    @Override
    public boolean equals(final Object other) {
        if (other == this)
            return true;
        if (!(other instanceof Forme)) {
            return false;
        }
        final Forme forme = (Forme) other;
        return Math.abs(this.getLargeur() - forme.getLargeur()) <= Forme.EPSILON
                && Math.abs(this.getHauteur() - forme.getHauteur()) <= Forme.EPSILON
                && this.getPosition().equals(forme.getPosition());
    }

    /**
     * Function to obtain the hashCode of a {@code Forme}.
     * 
     * @return An {@code int} corresponding to the hashCode of the {@code Forme}.
     * 
     * @since 0.3.4.4
     */
    @Override
    public int hashCode() {
        return this.getPosition().hashCode() + Double.hashCode(this.getLargeur()) + Double.hashCode(this.getHauteur());
    }
}
