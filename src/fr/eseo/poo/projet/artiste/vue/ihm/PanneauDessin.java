package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
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
 * @version 0.3.4.1
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
     * drawing, default value: {@code (255, 228, 245)}.
     * 
     * @see Color
     * 
     * @since 0.3.3.2
     */
    public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(233, 234, 234);

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

    /*************************************************************************/
    /****************************** Constructs *******************************/
    /*************************************************************************/

    /**
     * Construct a new {@code DesignPanel} from a width, a height, and a background
     * color.
     * 
     * @param p_largeur   A {@double code} corresponding to the width of the drawing
     *                    area.
     * @param p_hauteur   A {@code double} corresponding to the height of the
     *                    drawing area.
     * @param p_fondColor A {@code Color} corresponding to the background color of
     *                    the drawing area.
     * 
     * @see #PanneauDessin()
     * 
     * @since 0.3.3.2
     */
    public PanneauDessin(int p_largeur, int p_hauteur, Color p_fondColor) {
        super.setBackground(p_fondColor);
        super.setPreferredSize(new Dimension(p_largeur, p_hauteur));
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
     * @param p_outil The new {@code Outil} that you want to associate as a tool.
     * 
     * @see #getOutilCourant()
     * 
     * @since 0.3.4.1
     */
    private void setOutilCourant(final Outil p_outil) {
        this.outilCourant = p_outil;
    }

    /*************************************************************************/
    /******************************* Functions *******************************/
    /*************************************************************************/

    /**
     * Mutator of the {@code VueForme}.
     * <p>
     * Allows you to add the representation of the shape passed as a parameter.
     * 
     * @param p_vueForme The {@code vueForme} corresponding to the representation of
     *                   the shape that you want to display.
     * 
     * @since 0.3.3.5
     */
    public void ajouterVueForme(final VueForme p_vueForme) {
        this.vueFormes.add(p_vueForme);
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
     * @see associerOutil(Outil)
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
     * @param p_outil {@code Outil} that we want to associate.
     * 
     * @see dissocierOutil()
     * 
     * @since 0.3.4.1
     */
    public void associerOutil(final Outil p_outil) {
        if (p_outil != null) {
            this.dissocierOutil();
            this.setOutilCourant(p_outil);
            // We listen to this new tool.
            addMouseListener(this.getOutilCourant());
            addMouseMotionListener(this.getOutilCourant());

            this.getOutilCourant().setPanneauDessin(this);
        }
    }
}
