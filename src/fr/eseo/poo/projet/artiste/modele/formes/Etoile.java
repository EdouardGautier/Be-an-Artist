package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

/**
 * Class {@code Etoile} representing a star.
 * <p>
 * A star is defined by :
 * <ul>
 * <li>How many branches it has.</li>
 * <li>The angle between its branches</li>
 * <li>The length of its branches</li>
 * <li>A <i>position</i> corresponding to the upper left corner of the rectangle
 * enclosing it.</li>
 * <li>A <i>hauteur</i> and <i>longueur</i> corresponding to those of the square
 * the enclosing square.</li>
 * </ul>
 * <p>
 * The <i>hauteur</i> and <i>longueur</i> may not be less than or equal to 0.
 * <p>
 * By default:
 * <ul>
 * <li>The <i>hauteur</i> and <i>longueur</i> are initialized to
 * {@value Forme#LARGEUR_PAR_DEFAUT}.</li>
 * <li>The <i>position</i> is initialized to
 * ({@value Coordonnees#ABSCISSE_PAR_DEFAUT} ,
 * {@value Coordonnees#ORDONNEE_PAR_DEFAUT}).</li>
 * </ul>
 * 
 * @see Forme
 * @see Coordonnees
 * @see Remplissable
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.1
 */
public class Etoile extends Forme implements Remplissable {
    /**
     * This is the default number of branches for a star, it is {@value}
     */
    public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;

    /**
     * This is the default angle of the first branch of the star (ne radian).
     * <p>
     * By default the value is {@value} rad which is {@code 242°}.
     */
    public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = Math.PI / 2;

    /**
     * This is the percentage the length of the hollow between the branches and the
     * radius of the circle enclosing the star by default.
     * <p>
     * By default the percentage is {@value}.
     */
    public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 1;

    /**
     * Number of branches of the star
     */
    private int nombreBranches;

    /**
     * Corresponds to the angle between the horizontal and the first branch.
     * <p>
     * This angle is in {@code radius}
     */
    private double anglePremiereBranche;

    /**
     * Corresponds to the ratio between the radius of the circle enclosing the star
     * and the hollow between the branches.
     */
    private double longueurBranche;

    /**
     * List of vertices of the star polynomial.
     */
    private List<Coordonnees> coordonnees = new ArrayList<Coordonnees>();

    /**
     * List of vertices of the polynomial of the star.
     */
    private List<Coordonnees> coordonneesPolygone = new ArrayList<Coordonnees>();

    /**
     * Attribute allowing to save the filling state of the {@code Ellipse}.
     */
    private boolean estRempli;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Constructeur par d'une nouvelle {@code Etoile}.
     * <p>
     * L'ensemble des attributs de l'étoiles sont définit avec les paramètre donnés.
     * <p>
     * <ul>
     * <li>{@code taille} doit être supérieiur à <i>0</i>.</li>
     * <li>{@code nombreBranches} doit être compris entre <i>3</i> et
     * <i>15</i>.</li>
     * <li>{@code anglePremiereBranche} doit être compris entre <i>-π</i> et
     * <i>π</i>.</li>
     * <li>{@code longueurBranche} doit être compris entre <i>0</i> et
     * <i>1</i>.</li>
     * </ul>
     * 
     * @param p_coordonnees          A {@code Coordonnees} corresponding to the
     *                               position of the top of the first branch of the
     *                               star
     * @param p_taille               A {@code double} corresponding to the diameter
     *                               of the circle enclosing the star
     * @param p_nombreBranches       A {@code int} corresponding to the number of
     *                               branches of the star
     * @param p_anglePremiereBranche A {@code double} corresponding to the angle in
     *                               radiating angle</i> formed by the first branch
     * @param p_longueurBranche      A {@code double} corresponding to the ratio of
     *                               the length of the hollow between the branches
     *                               and the radius of the circle enclosing the
     *                               star.
     * 
     * @throws IllegalArgumentException if the given dimensions do not meet all the
     *                                  conditions.
     * 
     * @see #Etoile(double)
     * @see #Etoile(Coordonnees)
     * @see #Etoile(Coordonnees, double)
     * @see #Etoile()
     * 
     * @since 0.3.7.1
     */
    public Etoile(Coordonnees p_coordonnees, double p_taille, int p_nombreBranches, double p_anglePremiereBranche,
            double p_longueurBranche) {
        super(p_coordonnees);
        this.estRempli = false;
        this.setLongueurBranche(p_longueurBranche);
        this.setHauteur(p_taille);
        this.setAnglePremiereBranche(p_anglePremiereBranche);
        this.setNombreBranches(p_nombreBranches);
    }

    /**
     * Builder of a new {@code Etoile}.
     * 
     * @param p_coordonnees A {@code Coordonnees} corresponding to the position of
     *                      the top of the first branch of the star.
     * @param p_taille      A {@code double} corresponding to the diameter of the
     *                      circle enclosing the star.
     * 
     * @throws IllegalArgumentException if the size is less than or equal to 0.
     * 
     * @see #NOMBRE_BRANCHES_PAR_DEFAUT
     * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
     * @see #LONGUEUR_BRANCHE_PAR_DEFAUT
     * @see #Etoile(double)
     * @see #Etoile(Coordonnees)
     * @see #Etoile(Coordonnees, double, int, double, double)
     * @see #Etoile()
     * 
     * @since 0.3.7.1
     */
    public Etoile(Coordonnees p_coordonnees, double p_taille) {
        this(p_coordonnees, p_taille, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT);
    }

    /**
     * Builder of a new {@code Etoile}.
     * 
     * @param p_coordonnees A {@code Coordonnees} corresponding to the position of
     *                      the top of the first branch of the star.
     * 
     * @see #NOMBRE_BRANCHES_PAR_DEFAUT
     * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
     * @see #LONGUEUR_BRANCHE_PAR_DEFAUT
     * @see #Etoile(double)
     * @see #Etoile(Coordonnees, double)
     * @see #Etoile(Coordonnees, double, int, double, double)
     * @see #Etoile()
     * 
     * @since 0.3.7.1
     */
    public Etoile(Coordonnees p_coordonnees) {
        this(p_coordonnees, Forme.LARGEUR_PAR_DEFAUT);
    }

    /**
     * Builder of a new {@code Etoile}.
     * 
     * @param p_taille A {@code double} corresponding to the diameter of the circle
     *                 enclosing the star.
     * 
     * @throws IllegalArgumentException Si la taille est inférieurs ou égales à
     *                                  <i>0<i/>.
     * 
     * @see #NOMBRE_BRANCHES_PAR_DEFAUT
     * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
     * @see #Etoile(Coordonnees)
     * @see #Etoile(Coordonnees, double)
     * @see #Etoile(Coordonnees, double, int, double, double)
     * @see #Etoile()
     * 
     * @since 0.3.7.1
     */
    public Etoile(double p_taille) {
        this(new Coordonnees(), p_taille);
    }

    /**
     * Default constructor of a new {@code Etoile}.
     * <p>
     * All the attributes of the class are then initialized to the values by default
     * values.
     * 
     * @see #NOMBRE_BRANCHES_PAR_DEFAUT
     * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
     * @see #LONGUEUR_BRANCHE_PAR_DEFAUT
     * @see #Etoile(Coordonnees)
     * @see #Etoile(Coordonnees, double)
     * @see #Etoile(Coordonnees, double, int, double, double)
     * @see #Etoile(double)
     * 
     * @since 0.3.7.1
     */
    public Etoile() {
        this(Forme.LARGEUR_PAR_DEFAUT);
    }

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * {@inheritDoc}
     * <p>
     * 
     * @param p_largeur In the case of the start, the height of the rectangle is
     *                  also modified so that its two dimensions remain equal.
     * 
     * @throws IllegalArgumentException If the width is less than or equal to 0.
     * 
     * @see #setHauteur(double)
     * @see Forme#getLargeur()
     * 
     * @since 0.3.7.1
     */
    @Override
    public void setLargeur(double p_largeur) {
        if (p_largeur <= 0) {
            throw new IllegalArgumentException("La largeur de " + getClass().getSimpleName() + " doit être positive");
        } else {
            super.setLargeur(p_largeur);
            super.setHauteur(p_largeur);
            this.calculSommet();
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * 
     * @param p_hauteur In the case of the start, the height of the rectangle is
     *                  also modified so that its two dimensions remain equal.
     * 
     * @throws IllegalArgumentException If the width is less than or equal to 0.
     * 
     * @see #setLargeur(double)
     * @see Forme#getHauteur()
     * 
     * @since 0.3.7.1
     */
    @Override
    public void setHauteur(double p_hauteur) {
        if (p_hauteur <= 0) {
            throw new IllegalArgumentException("La hauteur de " + getClass().getSimpleName() + " doit être positive");
        } else {
            this.setLargeur(p_hauteur);
        }
    }

    /**
     * Accessor to know the number of branches of the star
     * 
     * @return The {@code int} corresponding to number of branches.
     */
    public int getNombreBranches() {
        return this.nombreBranches;
    }

    /**
     * Mutator of the number of branches of a star.
     * 
     * @param p_nombreBranches A {@code int} corresponding to the new number of
     *                         branches of the star.
     * 
     * @throws IllegalArgumentException If the number of branches is greater than 15
     *                                  or less than 3.
     * 
     * @since 0.3.7.1
     */
    public void setNombreBranches(int p_nombreBranches) {
        if (p_nombreBranches >= 3 && p_nombreBranches <= 15) {
            this.nombreBranches = p_nombreBranches;
            this.coordonnees = new ArrayList<Coordonnees>(Arrays.asList(new Coordonnees[this.nombreBranches]));
            this.coordonneesPolygone = new ArrayList<Coordonnees>(Arrays.asList(new Coordonnees[this.nombreBranches]));
            this.calculSommet();
        } else {
            throw new IllegalArgumentException("Le nombre de branche doit être compris entre 3 et 15");
        }
    }

    /**
     * Accessor to the angle formed between the horizontal and the first limb of the
     * the star.
     * <p>
     * The value returned is in radiant.
     * 
     * @return A {@code double} corresponding to the angle formed between the
     *         horizontal and the first branch of the star.
     * 
     * @since 0.3.7.1
     */
    public double getAnglePremiereBranche() {
        return this.anglePremiereBranche;
    }

    /**
     * Mutator of the angle formed between the horizontal and the first branch of
     * the the star.
     * <p>
     * The value given is in radiant.
     * 
     * @param p_anglePremiereBranche A {@code double} corresponding to the new angle
     *                               formed between the horizontal and the first
     *                               branch of the star.
     * 
     * @throws IllegalArgumentException If the angle is less than <i>-π</i> or
     *                                  greater than <i>π</i>.
     * 
     * @see #getAnglePremiereBranche()
     * 
     * @since 0.3.7.1
     */
    public void setAnglePremiereBranche(final double p_anglePremiereBranche) {
        if (p_anglePremiereBranche >= -Math.PI && p_anglePremiereBranche <= Math.PI) {
            this.anglePremiereBranche = p_anglePremiereBranche;
            this.calculSommet();
        } else {
            throw new IllegalArgumentException("L'angle de la première branche doit être compris entre -π et π");
        }
    }

    /**
     * Accessors for the length of the star's branches.
     * 
     * @return A {@double code} between <i>0</i> and <i>1</i> corresponding to the
     *         ratio of the length of the star's branches to the radius of the
     *         circle enclosing the star.
     * 
     * @see #setLongueurBranche(double)
     * 
     * @since 0.3.7.1
     */
    public double getLongueurBranche() {
        return this.longueurBranche;
    }

    /**
     * Mutator between <i>0</i> and <i>1</i> corresponding to the ratio of the
     * length of the star's branches to the radius of the circle enclosing the star.
     * 
     * @param p_longueur A {@double code} corresponding to the new report.
     * 
     * @throws IllegalArgumentException if the length is less than <i>0</i> or
     *                                  greater than <i>1</i>.
     * 
     * @see #getLongueurBranche()
     * 
     * @since 0.3.7.1
     */
    public void setLongueurBranche(final double p_longueur) {
        if (p_longueur >= 0 && p_longueur <= 1) {
            this.longueurBranche = p_longueur;
            this.calculPolynome();
        } else {
            throw new IllegalArgumentException("Le rapport des longueurs des branches doit être compris entre 0 et 1.");
        }
    }

    /**
     * Accessor to the list of vertices of the star.
     * 
     * @return A {@code List<Coordonnees} corresponding to the vertices of the star.
     * 
     * @since 0.3.7.1
     */
    public List<Coordonnees> getCoordonnees() {
        return this.coordonnees;
    }

    /**
     * Accessor to the list of vertices of the star polynomial.
     * 
     * @return A {@code List<Coordinates} corresponding to the vertices of the
     *         polynomial of the star.
     * 
     * @since 0.3.7.1
     */
    public List<Coordonnees> getCoordonneesPolygone() {
        return this.coordonneesPolygone;
    }

    /**
     * {@inheritDoc} The position of the vertices must be recalculated.
     * 
     * @param p_position A {@code double} corresponding to the new coordinates of
     *                   the shape.
     * 
     * @see #deplacerDe(double, double)
     * @see #deplacerVers(double, double)
     * 
     * @since 0.3.7.1
     */
    @Override
    public void setPosition(final Coordonnees p_position) {
        super.setPosition(p_position);
        this.calculSommet();
    }

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.7.1
     */
    @Override
    public boolean estRempli() {
        return this.estRempli;
    }

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.7.1
     */
    @Override
    public void setRempli(final boolean p_rempli) {
        this.estRempli = p_rempli;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Function to calculate the position of the vertices of the branches of the
     * star.
     * <p>
     * <ul>
     * <li>{@code x' = cos(α) * x - sin(α) * y}</li>
     * <li>{@code y' = sin(α) * x + cos(α) * y}</li>
     * </ul>
     * 
     * @see #calculPolynome()
     * @see #getCoordonnees()
     * 
     * @since 0.3.7.1
     */
    private void calculSommet() {
        this.getCoordonnees().clear();
        for (int i = 0; i < this.nombreBranches; i++) {
            final double alpha = this.getAnglePremiereBranche() - (2 * Math.PI / nombreBranches) * i;
            final double x2 = (super.getCadreMaxX() + super.getCadreMinX()) / 2
                    + Math.cos(alpha) * super.getHauteur() / 2;
            final double y2 = (super.getCadreMaxY() + super.getCadreMinY()) / 2
                    - Math.sin(alpha) * super.getHauteur() / 2;
            this.getCoordonnees().add(new Coordonnees(x2, y2));
        }
        this.calculPolynome();
    }

    /**
     * Function to calculate the position of the vertices of the component
     * polynomial the heart of the star.
     * 
     * @see #calculSommet()
     * @see #getCoordonneesPolygone()
     * 
     * @since 0.3.7.1
     */
    private void calculPolynome() {
        this.getCoordonneesPolygone().clear();
        for (int i = 0; i < this.nombreBranches; i++) {
            final double alpha = this.getAnglePremiereBranche() - (Math.PI / this.getNombreBranches()) * (2 * i - 1);
            final double x2 = (super.getCadreMaxX() + super.getCadreMinX()) / 2
                    + Math.cos(alpha) * super.getHauteur() * (1 - this.getLongueurBranche()) / 2;
            final double y2 = (super.getCadreMaxY() + super.getCadreMinY()) / 2
                    - Math.sin(alpha) * super.getHauteur() * (1 - this.getLongueurBranche()) / 2;
            this.getCoordonneesPolygone().add(new Coordonnees(x2, y2));
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.7.1
     */
    @Override
    public double perimetre() {
        return 2 * this.getNombreBranches()
                * this.getCoordonnees().get(0).distanceVers(this.getCoordonneesPolygone().get(0));
    }

    /**
     * {@inheritDoc}
     * <p>
     * The calculation of the area of a regular polynomial is done with the formula
     * {@code aire = a*p / 2} where:
     * <ul>
     * <li><i>a</i> is the apothene of the polynomial</li>
     * <li><i>p</i> is the perimeter of the polynomial</li>
     * </ul>
     * <p>
     * The area of the star is the sum of the area of the polynomial and the product
     * of the area of the triangle, making a branch, by the number of branches.
     * 
     * @since 0.3.7.1
     */
    @Override
    public double aire() {
        final double poly = this.getCoordonneesPolygone().get(0).distanceVers(this.getCoordonneesPolygone().get(1));

        final double apotheme = Math
                .sqrt(Math.pow((1 - this.getLongueurBranche()) * super.getHauteur() / 2, 2) - Math.pow(poly / 2, 2));
        final double airePoly = apotheme * poly * 0.5 * this.getNombreBranches();
        final double hauteur = super.getHauteur() * 0.5 - apotheme;
        final double aireBranche = hauteur * poly * 0.5;

        return airePoly + this.getNombreBranches() * aireBranche;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The method used here is that of ray-casting. 
     * 
     * @param point The{@code Coordonnees} which we want to know if it is in the
     *              star.
     * 
     * @return {@code true} if the point is in the star {@code false} otherwise
     * 
     * 
     * @since 0.3.7.1
     */
    @Override
    public boolean contient(final Coordonnees point) {
        // If the point is one of the vertices
        if (this.getCoordonnees().contains(point) || this.getCoordonneesPolygone().contains(point)) {
            return true;
        }
        // If <dedans> is true, then the ray intersects the star an odd number of times,
        // so the point is inside
        boolean contient = false;

        for (int i = 0; i < this.nombreBranches; i++) {
            final Coordonnees[] tab_coordonneesTriangle = new Coordonnees[3];
            tab_coordonneesTriangle[1] = this.getCoordonnees().get(i);
            tab_coordonneesTriangle[0] = this.getCoordonneesPolygone().get(i);
            if (i + 1 > this.getNombreBranches() - 1) {
                tab_coordonneesTriangle[2] = this.getCoordonneesPolygone().get(0);
            } else {
                tab_coordonneesTriangle[2] = this.getCoordonneesPolygone().get(i + 1);
            }
            final Coordonnees sommetBranche = tab_coordonneesTriangle[1];
            for (int j = 0; j < 3; j += 2) {
                final Coordonnees sommetPolygone = tab_coordonneesTriangle[j];
                // The test point must be in the ordinate range of the segment.
                if ((sommetBranche.getOrdonnee() > point.getOrdonnee()) != (sommetPolygone.getOrdonnee() > point
                        .getOrdonnee())) {
                    // Equation of the line in the form y = ax + b.
                    final double a = (sommetPolygone.getOrdonnee() - sommetBranche.getOrdonnee())
                            / (sommetPolygone.getAbscisse() - sommetBranche.getAbscisse());
                    final double b = sommetPolygone.getOrdonnee() - a * sommetPolygone.getAbscisse();

                    final double c = -(b - point.getOrdonnee()) / a;
                    // We test the points on the right.
                    if (c >= point.getAbscisse() - Forme.EPSILON) {
                        if (new Coordonnees(c, point.getOrdonnee()).equals(point)) {
                            return true;
                        }
                        contient = !contient;
                    }
                }
            }
        }
        return contient;
    }

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.7.1
     */
    @Override
    public String descriptionRemplissage() {
        if (this.estRempli) {
            return "-Rempli";
        } else {
            return "";
        }
    }

    /**
     * Function returning a description of the start in the form :
     * <p>
     * {@code [Etoile<-Rempli>] pos : (abscissa , ordinate) dim width x hauteur 
     * périmètre : <perimetre> aire : <aire> couleur = R<color code red>,
     * G<green color code>,B<blue color code>
     * 
     * @return A {@code String}, ccorresponding to the description of the
     * {@code Etoile}.
     * 
     * @since 0.3.7.1
     */
    @Override
    public String toString() {
        final DecimalFormat formater = new DecimalFormat("0.0#");
        return "[" + this.getClass().getSimpleName() + this.descriptionRemplissage() + "] : pos "
                + this.getPosition().toString() + " dim " + formater.format(this.getLargeur()) + " x "
                + formater.format(this.getHauteur()) + " périmètre : " + formater.format(this.perimetre()) + " aire : "
                + formater.format(this.aire()) + this.descriptionCouleur();
    }
}
