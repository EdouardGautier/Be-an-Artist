package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Class {@code Ellipse} representing an ellipse.
 * <p>
 * An ellipse is characterized by:
 * <ul>
 * <li>a <i>position</i> corresponding to the upper left corner of the rectangle
 * l'neglobant.</li>
 * <li>a <i>hauteur</i> corresponding to that of the rectangle surrounding
 * it.</li>
 * <li>a <i>largeur</i> corresponding to that of the rectangle surrounding
 * it.</li>
 * </ul>
 * <p>
 * <p>
 * The <i>hauteur</i> and <i>largeur</i> may not be less than or equal to 0.
 * <p>
 * Par défaut:
 * <ul>
 * <li>The <i>largeur</i> is initialized to
 * {@value Forme#LARGEUR_PAR_DEFAUT}.</li>
 * <li>The <i>hauteur</i> is initialized to
 * {@value Forme#HAUTEUR_PAR_DEFAUT}.</li>
 * <li>The <i>position</i> is initialized to
 * ({@value Coordonnees#ABSCISSE_PAR_DEFAUT} ,
 * {@value Coordonnees#ORDONNEE_PAR_DEFAUT}).</li>
 * </ul>
 * <p>
 * It is possible to:
 * <ul>
 * <li>know the area of the ellipse.</li>
 * <li>know the perimeter of the ellipse.</li>
 * </ul>
 * 
 * @see Forme
 * @see Coordonnees
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.2.6
 * 
 * @version 0.3.2.8
 */
public class Ellipse extends Forme {

	/*************************************************************************/
	/****************************** Constructs *******************************/
	/*************************************************************************/
	/**
	 * Constructor of the class {@linkplain Ellipse} from a position, a height and
	 * width.
	 * <p>
	 * The height and width must be greater than 0.
	 * 
	 * @param p_position The {@code Coordonnees} corresponding to the position of
	 *                   the of the rectangle enclosing the ellipse.
	 * @param p_largeur  A {@code double} corresponding to the width of the
	 *                   rectangle encompassing the ellipse.
	 * @param p_hauteur  A {@code double} corresponding to the height of the
	 *                   rectangle encompassing the ellipse.
	 * 
	 * @throws IllegalArgumentException If the width or height is less than or equal
	 *                                  to 0.
	 * 
	 * @see Forme#Forme(Coordonnees, double, double)
	 * @see #Ellipse()
	 * @see #Ellipse(Coordonnees)
	 * @see #Ellipse(double, double)
	 * 
	 * @since 0.3.2.6
	 */
	public Ellipse(Coordonnees p_position, double p_largeur, double p_hauteur) {
		if (p_largeur <= 0 || p_hauteur <= 0) {
			throw new IllegalArgumentException(
					"La largeur et la hauteur de " + getClass().getSimpleName() + " doit être positive");
		} else {
			this.largeur = p_largeur;
			this.hauteur = p_hauteur;
			super.setPosition(p_position);
		}
	}

	/**
	 * Construct a new {@code Ellipse} from a width and a height, the height, the
	 * position being initialized from the default values.
	 * <p>
	 * The height and width must be greater than 0.
	 * 
	 * @param p_largeur A {@doublecode} corresponding to the width of the rectangle
	 *                  encompassing the ellipse.
	 * @param p_hauteur A {@code double} corresponding to the height of the
	 *                  rectangle encompassing the ellipse.
	 * 
	 * @throws IllegalArgumentException If the width or height is less than or equal
	 *                                  to 0.
	 * 
	 * @see #Ellipse()
	 * @see #Ellipse(Coordonnees)
	 * @see #Ellipse(Coordonnees, double, double)
	 * 
	 * @since 0.3.2.6
	 */
	public Ellipse(double p_largeur, double p_hauteur) {
		if (p_largeur <= 0 || p_hauteur <= 0) {
			throw new IllegalArgumentException(
					"La largeur et la hauteur de " + getClass().getSimpleName() + " doit être positive");
		} else {
			this.largeur = p_largeur;
			this.hauteur = p_hauteur;
			super.setPosition(new Coordonnees());
		}
	}

	/**
	 * Constructor of a new {@code Ellipse} from a point, the other attribute being
	 * initialized from the default values.
	 * 
	 * @param p_position The {@code Coordinates} corresponding to the position of
	 *                   the of the rectangle enclosing the ellipse.
	 * 
	 * @see Forme#Forme(Coordonnees)
	 * @see #Ellipse()
	 * @see #Ellipse(double, double)
	 * @see #Ellipse(Coordonnees, double, double)
	 * 
	 * @since 0.3.2.6
	 */
	public Ellipse(Coordonnees p_position) {
		super(p_position);
	}

	/**
	 * Constructor of a new {@code Ellipse}, it is the constructor by default,
	 * initializing the attributes of the class to default values.
	 * 
	 * @see Forme#Forme()
	 * @see #Ellipse(Coordonnees)
	 * @see #Ellipse(double, double)
	 * @see #Ellipse(Coordonnees, double, double)
	 * 
	 * @since 0.3.2.6
	 */
	public Ellipse() {
		super();
	}

	/*************************************************************************/
	/*********************** Accessors and Mutators **************************/
	/*************************************************************************/

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * @param p_largeur width must be greater than 0.
	 * 
	 * @throws IllegalArgumentException Si la largeur est inférieur ou égale à 0.
	 * 
	 * @see #setHauteur(double)
	 * @see Forme#getLargeur()
	 * 
	 * @since 0.3.2.6
	 */
	@Override
	public void setLargeur(final double p_largeur) {
		if (p_largeur > 0) {
			super.setLargeur(p_largeur);
		} else {
			throw new IllegalArgumentException("La largeur de " + getClass().getSimpleName() + " doit être positive");
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * @param p_hauteur heigt must be greater than 0.
	 * 
	 * @throws IllegalArgumentException Si la largeur est inférieur ou égale à 0.
	 * 
	 * @see #setLargeur(double)
	 * @see Forme#getHauteur()
	 * 
	 * @since 0.3.2.6
	 */
	@Override
	public void setHauteur(final double p_hauteur) {
		if (p_hauteur > 0) {
			super.setHauteur(p_hauteur);
		} else {
			throw new IllegalArgumentException("La hauteur de " + getClass().getSimpleName() + " doit être positive");
		}
	}

	/*************************************************************************/
	/******************************* Functions *******************************/
	/*************************************************************************/

	/**
	 * {@inheritDoc}
	 * <p>
	 * Calul is done according to the formula of Srinivasa Ramanujan:
	 * <p>
	 * {@code π(a + b)(1 + 3h / (10+ sqrt(4-3h)))}.
	 * <p>
	 * Où:
	 * <ul>
	 * <li><i>a</i> is the small radius of the ellipse</li>
	 * <li><i>b</i> is the large radius of the ellipse</li>
	 * <li><i>h</i> is equal to {@code(a-b)² / (a+b)²}</li>
	 * </ul>
	 * <p>
	 * 
	 * @see #aire()
	 * 
	 * @since 0.3.2.6
	 */
	@Override
	public double perimetre() {
		double a = Math.min(this.getHauteur() / 2, this.getLargeur() / 2);
		double b = Math.max(this.getHauteur() / 2, this.getLargeur() / 2);
		double h = Math.pow((a - b) / (a + b), 2);
		return Math.PI * (a + b) * (1 + (3 * h / (10 + Math.sqrt(4 - 3 * h))));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The calculation is based on the formula : {@code π x a x b}.
	 * <p>
	 * Où:
	 * <ul>
	 * <li><i>a</i> is the small radius of the ellipse</li>
	 * <li><i>b</i> is the large radius of the ellipse</li>
	 * <ul>
	 * <p>
	 * 
	 * @see #perimetre()
	 * 
	 * @since 0.3.2.6
	 */
	@Override
	public double aire() {
		return Math.PI * (this.getHauteur() / 2) * (this.getLargeur() / 2);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * In the case of an ellipse, we consider that the shape contains the point if
	 * the point is inside or on the contour of the shape.
	 * <p>
	 * 
	 * If the ellipse is defined by the coordinates of the two points A and B of the
	 * rectangle enclosing the ellipse, knowing that:
	 * <ul>
	 * <li><i>A</i> is the radius of the ellipse parallel to the height.</li>
	 * <li><i>B</i> is the radius of the ellipse parallel to the height.</li>
	 * <li><i>(X, Y)<i> is the center of the ellipse.</li>
	 * </ul>
	 * <p>
	 * the point (x, y) must verify :
	 * <p>
	 * {@code ( (x - X)/A )² + ( (x - X)/B )² <= 1}
	 * <p>
	 * If:
	 * <ul>
	 * <li>the result is less than 1, then the point is in the ellipse.</li>
	 * <li>the result is equal to 1, then the point is on the contour of the
	 * ellipse.</li>
	 * <li>the result is greater than 1, then the point is outside the the
	 * ellipse.</li></ul>
	 * 
	 * @param p_point the point to evaluate
	 * 
	 * @since 0.3.2.8
	 */
	@Override
	public boolean contient(final Coordonnees p_point) {
		final double A = super.getHauteur() / 2;
		final double B = super.getLargeur() / 2;
		final double X = super.getPosition().getAbscisse() + B;
		final double Y = super.getPosition().getOrdonnee() + A;

		return Math.pow(((p_point.getAbscisse() - X)) / B, 2) + Math.pow(((p_point.getOrdonnee() - Y)) / A, 2) <= 1;
	}

	/**
	 * Function returning a description of the ellipse in the form :
	 * <p>
	 * {@code [Ellipse] pos : (abscissa , ordinate) dim width x hauteur 
	 * périmètre : <perimetre> aire : <aire>
	 * 
	 * @return A {@code String}, ccorresponding to the description of the
	 * {@code Ellipse}.
	 * 
	 * @see Coordonnees#toString()
	 * 
	 * @since 0.3.2.6
	 */
	@Override
	public String toString() {
		final DecimalFormat formater = new DecimalFormat("0.0#");
		return "[" + this.getClass().getSimpleName() + "] : pos " + this.getPosition().toString() + " dim "
				+ formater.format(this.getLargeur()) + " x " + formater.format(this.getHauteur()) + " périmètre : "
				+ formater.format(this.perimetre()) + " aire : " + formater.format(this.aire());
	}
}
