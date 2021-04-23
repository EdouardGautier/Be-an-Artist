package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;

/**
 * The {@code Coordonnees} class is used to save the position of a point in a
 * cartesian plane. The Cartesian plane is defined as follows:
 * <ul>
 * <li>The x-axis is oriented to the right</li>
 * <li>The ordinate axis is oriented downward</li>
 * </ul>
 * <p>
 * A point is defined by its <B>abscissa</B>, and its <B>ordinate</B>.
 * <p>
 * By default the point takes the value {@value #ABSCISSE_PAR_DEFAUT} in
 * <B>abscissa</B> and {@value #ORDONNEE_PAR_DEFAUT} in <B>ordinate</B>.
 * <p>
 * It is possible to calculate the angle and distance between two points.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2
 */
public class Coordonnees {

	/**
	 * The default {@code double} type value for the abscissa.
	 * <p>
	 * Of value {@value #ABSCISSE_PAR_DEFAUT}.
	 * 
	 * @since 0.3.2.1
	 */
	public static final double ABSCISSE_PAR_DEFAUT = 0;

	/**
	 * The default {@code double} type value for the ordinate.
	 * <p>
	 * Of value {@value #ORDONNEE_PAR_DEFAUT}.
	 * 
	 * @since 0.3.2.1
	 */
	public static final double ORDONNEE_PAR_DEFAUT = 0;

	/**
	 * Attribute representing the abscissa of the point.
	 * <p>
	 * This abscissa is modifiable.
	 * <p>
	 * Initialized by default to {@value #ABSCISSE_PAR_DEFAUT}.
	 * 
	 * @see #getAbscisse()
	 * @see #setAbscisse(double)
	 * @see #y
	 * 
	 * @since 0.3.2.1
	 */
	private double x;

	/**
	 * Attribute representing the abscissa of the point.
	 * <p>
	 * This abscissa is modifiable.
	 * <p>
	 * Initialized by default to {@value #ORDONNEE_PAR_DEFAUT}.
	 * 
	 * @see #getOrdonnee()
	 * @see #setOrdonnee(double)
	 * @see #x
	 * 
	 * 
	 */
	private double y;

	/***
	 * Value of type {@code double}, for comparison between two points.
	 * <p>
	 * The precision of the comparison is {@value #EPSILON}.
	 * 
	 * @since 0.3.2.1
	 */
	public static final double EPSILON = 0.01;

	/*************************************************************************/
	/****************************** Constructs *******************************/
	/*************************************************************************/

	/**
	 * Construct a new {@code Coordonnees} from an abscissa and an ordinate passed
	 * as parameters.
	 * 
	 * @param p_x A {@code double} corresponding to the abscissa of the point.
	 * @param p_y A {@code double} corresponding to the ordinate of the point.
	 * 
	 * @see #Coordonnees()
	 * 
	 * @since 0.3.2.1
	 */
	public Coordonnees(double p_x, double p_y) {
		this.x = p_x;
		this.y = p_y;
	}

	/**
	 * Constructor of a new {@code Coordonnees}, this is the default constructor
	 * constructor, initializing the attributes of the class to the default values.
	 * 
	 * @see #Coordonnees(double, double)
	 *
	 * @since 0.3.2.1
	 */
	public Coordonnees() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
	}

	/*************************************************************************/
	/*********************** Accessors and Mutators **************************/
	/*************************************************************************/

	/**
	 * Accessor of the {@code abscissa} of the rectangle enclosing the point.
	 * 
	 * @return The {@code double} corresponding to the abscissa of the point.
	 * 
	 * @see #setAbscisse(double)
	 * 
	 * @since 0.3.2.1
	 */
	public double getAbscisse() {
		return this.x;
	}

	/**
	 * Mutator of the {@code X} of the rectangle enclosing the point.
	 * 
	 * @param p_x A {@code double} corresponding to the new abscissa of the point.
	 * 
	 * @see #getAbscisse(double)
	 * 
	 * @since 0.3.2.1
	 */
	public void setAbscisse(double p_x) {
		this.x = p_x;
	}

	/**
	 * Accessor of the {@code ordinate} of the rectangle enclosing the point.
	 * 
	 * @return The {@code double} corresponding to the ordinate of the point.
	 * 
	 * @see #setOrdonnee(double)
	 * 
	 * @since 0.3.2.1
	 */
	public double getOrdonnee() {
		return this.y;
	}

	/**
	 * Mutator of the {@code Y} of the rectangle enclosing the point.
	 * 
	 * @param p_y A {@code double} corresponding to the new ordinate of the point.
	 * 
	 * @see #getOrdonnee()
	 * 
	 * @since 0.3.2.1
	 */
	public void setOrdonnee(double p_y) {
		this.y = p_y;
	}

	/*************************************************************************/
	/******************************* Functions *******************************/
	/*************************************************************************/

	/**
	 * Mutator of the 2 coordinates of the point from a new abscissa and a new
	 * ordinate.
	 * 
	 * @param p_x A {@code double} corresponding to the new abscissa of the point.
	 * @param p_y A {@code double} corresponding to the new ordinate of the point.
	 * 
	 * @see #deplacerDe(double, double)
	 * 
	 * @since 0.3.2.1
	 */
	public void deplacerVers(double p_x, double p_y) {
		this.x = p_x;
		this.y = p_y;
	}

	/**
	 * Mutators of the 2 coordinates of the point from a displacement vector. A
	 * shift of the point is performed.
	 * 
	 * @param p_x A {@code double} corresponding to the new abscissa of the point.
	 * @param p_y A {@code double} corresponding to the new ordinate of the point.
	 * 
	 * @see #deplacerDe(double, double)
	 * 
	 * @since 0.3.2.1
	 */
	public void deplacerDe(double p_x, double p_y) {
		this.x += p_x;
		this.y += p_y;
	}

	/**
	 * Method to know the distance between two points.
	 * 
	 * @param p_point A {@code Coordinates} corresponding to the other point with
	 *                which we want to know the distance.
	 * 
	 * @return A {@code double} corresponding to the distance between the two
	 *         points.
	 * 
	 * @see #angleVers(Coordonnees)
	 * 
	 * @since 0.3.2.1
	 * 
	 */
	public double distanceVers(Coordonnees p_point) {
		return Math.sqrt(Math.pow(p_point.x - this.x, 2) + Math.pow(p_point.y - this.y, 2));
	}

	/**
	 * Method to know the angle <i>teta</i> form between two points.
	 * <p>
	 * The value returned is in <i>radian</i>.
	 * </p>
	 * 
	 * @param p_coord A {@code Coordonnees} corresponding to the other point with
	 *                which we want to know the angle.
	 * 
	 * @return A {@code double} corresponding to the angle between the two points
	 *         (in <i>radian</i>).
	 * 
	 * @see #distanceVers(Coordonnees)
	 * 
	 * @since 0.3.2.1
	 */
	public double angleVers(Coordonnees p_coord) {
		return Math.atan2(p_coord.getOrdonnee() - this.getOrdonnee(), p_coord.getAbscisse() - this.getAbscisse());
	}

	/**
	 * Function returning a description of the point in the form:
	 * <p>
	 * {@code (x, y)}.
	 * 
	 * @return A {@code String}, corresponding to the description of the
	 *         {@code Coordonnees}.
	 * 
	 * 
	 * @since 0.3.2.1
	 */
	@Override
	public String toString() {
		final DecimalFormat formater = new DecimalFormat("0.0#");

		return "(" + formater.format(this.getAbscisse()) + " , " + formater.format(this.getOrdonnee()) + ")";
	}

	/**
	 * Function to compare if two {@code Coordinates} are identical at
	 * {@value #EPSILON} loans.
	 * <p>
	 * <li>if the two points have the same {@code abscissa} and the same
	 * {@code ordinate}.</li>
	 * 
	 * @param p_other The instance with which the point is compared
	 * 
	 * @return {@code true} if two points are equal, {@code false} otherwise.
	 * 
	 * @since 0.3.3.4
	 */
	@Override
	public boolean equals(final Object p_other) {
		final Coordonnees point = (Coordonnees) p_other;
		return Math.abs(this.getAbscisse() - point.getAbscisse()) <= Coordonnees.EPSILON
				&& Math.abs(this.getOrdonnee() - point.getOrdonnee()) <= Coordonnees.EPSILON;
	}

	/**
	 * Function to obtain the hashCode of a {@code Coordonnees}.
	 * 
	 * @return An {@code int} corresponding to the hashCode of the
	 *         {@code Coordonnees}.
	 * 
	 * @since 0.3.2.4
	 */
	@Override
	public int hashCode() {
		return Double.hashCode(this.getAbscisse()) + Double.hashCode(this.getOrdonnee());
	}
}
