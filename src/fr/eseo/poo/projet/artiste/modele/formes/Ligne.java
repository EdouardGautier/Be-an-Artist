package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * class {@code Ligne} allowing a representation of a line.
 * <p>
 * A line is characterized part:
 * <ul>
 * <li>A <i>position</i> corresponding to one of its ends.</li>
 * <li>A <i>hauteur</i> corresponding to that of the rectangle encompassing
 * it.</li>
 * <li>A <i>largeur</i> corresponding to that of the rectangle enclosing
 * it.</li>
 * </ul>
 * <p>
 * By default:
 * <ul>
 * <li>The <i>largeur</i> is initialized to
 * {@value Forme#LARGEUR_PAR_DEFAUT}.</li>
 * <li>The <i>hauteur</i> is initialized to
 * {@value Forme#HAUTEUR_PAR_DEFAUT}.</li>
 * <li>The <i>position</i> is initialized to
 * ({@value Coordinates#ABSCISSE_PAR_DEFAUT} ,
 * {@value Coordinate#ORDINATE_DEFAULT}).</li>
 * </ul>
 * <p>
 * For information refer to the class {@linkplain Forme} and the class
 * {@linkplain Coordonnees} class.
 * <p>
 * It is possible to:
 * <ul>
 * <li>know the length of the line.</li>
 * </ul>
 * <p>
 * 
 * @see Coordonnees
 * @see Forme
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.4
 * 
 * @version 0.3.5.1
 */
public class Ligne extends Forme {

    /***
     * Value of type {@code double}, for comparison between two points.
     * <p>
     * The precision of the comparison is {@value #EPSILON}.
     * 
     * @since 0.3.2.8
     */
    public final static double EPSILON = 0.01;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Construct a new {@code Ligne} from a position, a height and a width. height
     * and width.
     * 
     * @param position A {@code Coordinates} corresponding to the upper corner of
     *                 the rectangle enclosing the line.
     * @param largeur  A {@code double} corresponding to the width of the rectangle
     *                 rectangle enclosing the line.
     * @param hauteur  The {@code double} corresponding to the height of the
     *                 rectangle encompassing the line.
     * 
     * @see Forme#Forme(Coordonnees, double, double)
     * @see #Ligne()
     * @see #Ligne(Coordonnees)
     * @see #Ligne(double, double)
     * 
     * @since 0.3.2.4
     */
    public Ligne(Coordonnees position, double largeur, double hauteur) {
        super(position, largeur, hauteur);
    }

    /**
     * Construct a new {@code Ligne} from a width and a height, the position being
     * height, the position being initialized from the default values.
     * 
     * @param largeur The {@code double} corresponding to the width of the rectangle
     *                rectangle enclosing the line.
     * @param hauteur The {@code double} corresponding to the height of the
     *                rectangle encompassing the line.
     * 
     * @see Forme#Forme(double, double)
     * @see #Ligne()
     * @see #Ligne(Coordonnees)
     * @see #Ligne(Coordonnees, double, double)
     * 
     * @since 0.3.2.4
     */
    public Ligne(double largeur, double hauteur) {
        super(largeur, hauteur);
    }

    /**
     * Construct a new {@code Ligne} from a point, the other attributes being
     * attributes being initialized from the default values.
     * 
     * @param position A {@code Coordonnees} corresponding to the top left corner of
     *                 the of the rectangle enclosing the line.
     * 
     * @see Forme#Forme(Coordonnees)
     * @see #Ligne()
     * @see #Ligne(double, double)
     * @see #Ligne(Coordonnees, double, double)
     * 
     * @since 0.3.2.4
     */
    public Ligne(Coordonnees position) {
        super(position);
    }

    /**
     * Default constructor of the class {@linkplain Ligne}, initiates the attributes
     * of the class from the default values.
     * 
     * @see Forme#Forme()
     * @see #Ligne(Coordonnees)
     * @see #Ligne(double, double)
     * @see #Ligne(Coordonnees, double, double)
     * 
     * @since 0.3.2.4
     */
    public Ligne() {
        super();
    }

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * Accessor of the first end of the line, which corresponds to the
     * {@code position} of the line.
     * 
     * @return The {@code Coordonnees} corresponding to the first end of the line.
     * 
     * @see Forme#getPosition()
     * @see #getC2()
     * @see #setC1()
     * 
     * @since 0.3.2.4
     */
    public Coordonnees getC1() {
        return this.getPosition();
    }

    /**
     * Mutator of the first end of the line, resulting in a change of the line's
     * dimensions.
     * 
     * @param position A {@code Coordonnees} corresponding to the new first
     *                 extremity of the line.
     * 
     * @see #getC1()
     * @see #setC2(Coordonnees)
     * @see Forme#setHauteur(double)
     * @see Forme#setLargeur(double)
     * 
     * @since 0.3.2.4
     */
    public void setC1(Coordonnees position) {
        this.setLargeur(this.getC2().getAbscisse() - position.getAbscisse());
        this.setHauteur(this.getC2().getOrdonnee() - position.getOrdonnee());
        this.setPosition(position);
    }

    /**
     * Accessor of the second end of the line.
     * 
     * @return The {@code Coordonnees} corresponding to the second end of the line.
     * 
     * @see #getC1()
     * @see #setC2(Coordonnees)
     * 
     * @since 0.3.2.4
     */
    public Coordonnees getC2() {
        return new Coordonnees(this.getC1().getAbscisse() + this.getLargeur(),
                this.getC1().getOrdonnee() + this.getHauteur());
    }

    /**
     * Mutateur de la deuxieme extremite de la ligne, entrainant une modification
     * des dimensions de la ligne.
     * 
     * @param coordonnees Une {@code Coordonnees} correspondant à la nouvelle
     *                    deuxième extremitté de la ligne.
     * 
     * @see #getC2()
     * @see #setC1(Coordonnees)
     * @see Forme#setHauteur(double)
     * @see Forme#setLargeur(double)
     * 
     * @since 0.3.2.4
     */
    public void setC2(Coordonnees coordonnees) {
        this.setLargeur(coordonnees.getAbscisse() - this.getC1().getAbscisse());
        this.setHauteur(coordonnees.getOrdonnee() - this.getC1().getOrdonnee());
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * {@inheritDoc}
     * <p>
     * In the case of a line, this is its length, or the distance between its two
     * extremities.
     * 
     * @see Coordonnees#distanceVers(Coordonnees)
     * 
     * @since 0.3.2.4
     */
    @Override
    public double perimetre() {
        return this.getC1().distanceVers(this.getC2());
    }

    /**
     * {@inheritDoc}
     * <p>
     * As it is a line, the area is equal to 0,0.
     * 
     * @since 0.3.2.4
     */
    @Override
    public double aire() {
        return 0.0;
    }

    /**
     * {@inheritDoc}
     * <p>
     * A point is considered to be on the line if it is located at a distance less
     * than {@value Ligne#EPSILON}.
     * 
     * The sum of the distance between points C1 and C2 must be equal to the length
     * of the line. To the nearest EPSILON.
     * 
     * @since 0.3.2.8
     */
    @Override
    public boolean contient(final Coordonnees point) {
        return (point.distanceVers(this.getC1()) + point.distanceVers(this.getC2()))
                - (this.perimetre()) <= Ligne.EPSILON;
    }

    /**
     * Function returning a description of the line in the form :
     * <p>
     * {@code [Ligne] c1 : (<abscissa>) , <ordinate>) c2 : (<abscissa>) , 
     * <ordinate>) longueur : <length> angle : <angle>° couleur = R<color code red>,
     * G<green color code>,B<blue color code>}.
     * 
     * @return A {@code String}, corresponding to the description of the
     *         {@code Line}.
     * 
     * @since 0.3.5.1
     */
    @Override
    public String toString() {
        final DecimalFormat formater = new DecimalFormat("0.0#");
        double angle = Math.toDegrees(this.getC1().angleVers(this.getC2()));
        angle = angle < 0 ? angle + 360 : angle;
        return '[' + getClass().getSimpleName() + "] c1 : " + this.getC1().toString() + " c2 : "
                + this.getC2().toString() + " longueur : " + formater.format(this.perimetre()) + " angle : "
                + formater.format(angle) + "°" + this.descriptionCouleur();
    }

    /**
     * {@inheritDoc}
     * 
     * @see Forme#equals(Object)
     * 
     * @since 0.3.4.4
     */
    @Override
    public boolean equals(final Object other) {
        if (other == this)
            return true;
        if (!(other instanceof Ligne)) {
            return false;
        }
        final Ligne ligne = (Ligne) other;
        return super.equals(ligne);
    }

    /**
     * Function to obtain the hashCode of {@code Ligne}.
     * 
     * @return An {@code int} corresponding to the hashCode of the {@code Ligne}.
     * 
     * @see Forme#hashCode()
     * 
     * @since 0.3.4.4
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
