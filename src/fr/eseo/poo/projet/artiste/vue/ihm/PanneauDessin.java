package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * The class {@code PanneauDessin} allowing to display the representations of
 * the figures add to its list of figures.
 * 
 * @see JPanel
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.3.2
 * 
 * @version 0.3.6.2
 */
public class PanneauDessin extends JPanel {

    /**
     * The default {@code double} type value of the drawing area width.
     * 
     * @since 0.3.3.2
     */
    public static final int LARGEUR_PAR_DEFAUT = 400;

    /**
     * The default {@code double} type value of the drawing area length.
     * 
     * @since 0.3.3.2
     */
    public static final int HAUTEUR_PAR_DEFAUT = 240;

    /**
     * The default value of type {@code Color} of the background color of the
     * drawing, default value: {@code (255, 255, 255)}.
     * 
     * @see Color
     * 
     * @since 0.3.3.2
     */
    public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(255, 255, 255);

    /**
     * {@code List} of {@code formes} display in the panel.
     * 
     * @since 0.3.3.5
     */
    private final List<VueForme> vueFormes = new ArrayList<VueForme>();

    /**
     * {@code Outil} associated as the current tool.
     * 
     * @since 0.3.4.1
     */
    private Outil outilCourant;

    /**
     * {@code Color} to store the color that will be used.
     * 
     * @since 0.3.5.2
     */
    private Color couleurCourante = Forme.COULEUR_PAR_DEFAUT;

    /**
     * The {@code boolean} to save whether to fill the forms.
     * 
     * @since 0.3.6.2
     */
    private boolean estRempli = false;

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Construct a new {@code DesignPanel} from a width, a height, and a background
     * color.
     * 
     * @param largeur   A {@double code} corresponding to the width of the drawing
     *                  area.
     * @param hauteur   A {@code double} corresponding to the height of the drawing
     *                  area.
     * @param fondColor A {@code Color} corresponding to the background color of the
     *                  drawing area.
     * 
     * @see #PanneauDessin()
     * 
     * @since 0.3.3.2
     * 
     * @version 0.3.5.2
     */
    public PanneauDessin(int largeur, int hauteur, Color fondColor) {
        super.setBackground(fondColor);
        super.setPreferredSize(new Dimension(largeur, hauteur));
    }

    /**
     * Constructor of a new {@code PanneauDessin} by default. Instances will be
     * initialized to default values.
     * 
     * @see #PanneauDessin(int, int, Color)
     * 
     * @since 0.3.3.2
     */
    public PanneauDessin() {
        this(PanneauDessin.LARGEUR_PAR_DEFAUT, PanneauDessin.HAUTEUR_PAR_DEFAUT, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
    }

    /*************************************************************************/
    /*********************** Accessors and Mutators **************************/
    /*************************************************************************/

    /**
     * Accessor of {@viewForms code}.
     * 
     * @return A {@code List<Forme>} of the representation of the displayed shapes.
     * 
     * @since 0.3.3.5
     */
    public List<VueForme> getVueFormes() {
        return this.vueFormes;
    }

    /**
     * Accessor of the tool.
     * 
     * @return {@code Outil} which is currently the tool.
     * 
     * @see #setOutilCourant(Outil)
     * 
     * @since 0.3.4.1
     */
    public Outil getOutilCourant() {
        return this.outilCourant;
    }

    /**
     * Mutator of {@code outil}.
     * 
     * @param outil The new {@code Outil} that you want to associate as a tool.
     * 
     * @see #getOutilCourant()
     * 
     * @since 0.3.4.1
     */
    private void setOutilCourant(final Outil outil) {
        this.outilCourant = outil;
    }

    /**
     * Accessor of the current {@code Color} used to draw the shapes.
     * 
     * @return {@code Color} used to draw the shapes.
     * 
     * @see #setCouleurCourante(Color)
     * 
     * @since 0.3.5.2
     */
    public Color getCouleurCourante() {
        return this.couleurCourante;
    }

    /**
     * Common {@code Color} mutator used to draw shapes.
     * 
     * @param couleurCourante {@code Color} to be used to draw the
     * 
     * @see #getCouleurCourante()
     * 
     * @since 0.3.5.2
     */
    public void setCouleurCourante(final Color couleurCourante) {
        this.couleurCourante = couleurCourante;
    }

    /**
     * Accessor allowing to know if the forms are filled or not.
     * 
     * @return {@code true} if the user wants to fill the forms, {@code false} if
     *         not.
     * 
     * @see #setModeRemplissage(boolean)
     * 
     * @since 0.3.6.2
     */
    public boolean getModeRemplissage() {
        return this.estRempli;
    }

    /**
     * Mutator of the filling or not the forms.
     * 
     * @param rempli {@code boolean} indicating whether or not you want to fill in
     *               the shapes you draw
     * 
     * @see #getModeRemplissage()
     * 
     * @since 0.3.6.2
     */
    public void setModeRemplissage(final boolean rempli) {
        this.estRempli = rempli;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Mutator of the {@code VueForme}.
     * <p>
     * Allows you to add the representation of the shape passed as a parameter.
     * 
     * @param vueForme The {@code vueForme} corresponding to the representation of
     *                 the shape that you want to display.
     * 
     * @since 0.3.3.5
     */
    public void ajouterVueForme(final VueForme vueForme) {
        this.vueFormes.add(vueForme);
    }

    /**
     * Function to display the shapes in the shape list in the representative graph.
     * 
     * @param g2d The {@code Graphics} where the display is desired.
     * 
     * @since 0.3.3.5
     */
    @Override
    protected void paintComponent(final Graphics g2d) {
        super.paintComponent(g2d);
        final Graphics2D g2D = (Graphics2D) g2d.create();
        // We display all forms
        for (final VueForme vueForme : this.getVueFormes()) {
            vueForme.affiche(g2D);
        }
        g2D.dispose();
    }

    /**
     * Method that deletes {@code Outil} already associated.
     * 
     * @see #associerOutil(Outil)
     * 
     * @since 0.3.4.1
     */
    private void dissocierOutil() {
        if (this.getOutilCourant() != null) {
            // We remove the current
            removeMouseListener(this.getOutilCourant());
            removeMouseMotionListener(this.getOutilCourant());
            // We replace with nothing
            this.getOutilCourant().setPanneauDessin(null);
            this.setOutilCourant(null);
        }
    }

    /**
     * Method that associates {@code Outil} given in parameter.
     * <p>
     * Only one tool can be associated at a time. Associating a new {@code Outil}
     * deletes the old one.
     * 
     * @param outil {@code Outil} that we want to associate.
     * 
     * @see #dissocierOutil()
     * 
     * @since 0.3.4.1
     */
    public void associerOutil(final Outil outil) {
        if (outil != null) {
            this.dissocierOutil();
            this.setOutilCourant(outil);
            // We listen to this new tool.
            addMouseListener(this.getOutilCourant());
            addMouseMotionListener(this.getOutilCourant());

            this.getOutilCourant().setPanneauDessin(this);
        }
    }
}
