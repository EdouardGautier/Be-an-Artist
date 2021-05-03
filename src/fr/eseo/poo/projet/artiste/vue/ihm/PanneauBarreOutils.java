package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirLongueurBrancheEtoile;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirNombreBrancheEtoile;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

//TODO : Revoir la tabulation 
/**
 * Class {@code PanneauBarreOutils} to represent the side toolbar.
 * <p>
 * Possible actions are:
 * <ul>
 * <li>Delete</li>
 * <li>Select</li>
 * <li>Select the color</li>
 * <li>Drawing shapes</li>
 * <li>Fill a shape</li>
 * </ul>
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.5
 * 
 * @version 1.3.1
 */
public class PanneauBarreOutils extends JPanel {
        /**
         * Assigns representing the {@code PanneauDessin} where the buttons will be.
         * 
         * @since 0.3.4.5
         */
        private PanneauDessin panneauDessin;

        /**
         * Number of branches to draw for the star
         * 
         * @since 0.3.7.3
         */
        private int nbBranches;

        /**
         * Length of branches to draw for the star
         * 
         * @since 0.3.7.3
         */
        private double longueurBranche;

        /**
         * Default name of the spinner for the number of branches
         * 
         * @since 0.3.7.3
         */
        public static final String BRANCHE_SPINNER_NOM = "Spinner branche";

        /**
         * Default spinner name for branch length
         * 
         * @since 0.3.7.3
         */
        public static final String LONGUEUR_SPINNER_NOM = "Spinner longueur";

        /*************************************************************************/
        /****************************** Constructs *******************************/
        /*************************************************************************/

        /**
         * Constructor of a new {@code PanneauBarreOutils}.
         * <p>
         * The action area of the buttons is the one given in parameter.
         * 
         * @param p_panneauDessin the {@code PanneauDessin} on which the buttons will
         *                        have an action.
         * 
         * @see PanneauDessin
         * 
         * @since 0.3.4.5
         * 
         * @version 0.3.7.3
         */
        public PanneauBarreOutils(final PanneauDessin p_panneauDessin) {
                this.panneauDessin = p_panneauDessin;
                this.initComponents();
                this.nbBranches = Etoile.NOMBRE_BRANCHES_PAR_DEFAUT;
                this.longueurBranche = Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT;
                super.setLayout(new GridLayout(2, 2));
        }

        /*************************************************************************/
        /*********************** Accessors and Mutators **************************/
        /*************************************************************************/

        /**
         * Accessor of the number of branches of a {@code Etoile}
         * 
         * @return A {@code int} the number of branches
         */
        public int getNbBranches() {
                return this.nbBranches;
        }

        /**
         * Mutator f the number of branches of a {@code Etoile}
         * 
         * @param p_nbBranches {@code int} the number of branches
         */
        public void setNbBranches(int p_nbBranches) {
                this.nbBranches = p_nbBranches;
        }

        /**
         * Accessor of the lenght of branche of a {@code Etoile}
         * 
         * @return A {@code double} the lenght of branches
         */
        public double getLongueurBranche() {
                return this.longueurBranche;
        }

        /**
         * Mutator f the lenght of branches of a {@code Etoile}
         * 
         * @param p_longueurBranche {@code double} the lenght of branches
         */
        public void setLongueurBranches(double p_longueurBranche) {
                this.longueurBranche = p_longueurBranche;
        }

        /*************************************************************************/
        /******************************* Functions *******************************/
        /*************************************************************************/

        /**
         * Initializes and adds the various buttons present in the
         * {@code PanneauBarreOutils}.
         *
         * @since 0.3.4.5
         * 
         * @version 1.3.1
         */
        public void initComponents() {
                final JToolBar toolBar = new JToolBar();
                toolBar.setLayout(new GridLayout(10, 1));
                toolBar.setName("toolBar");
                this.add(toolBar);

                // Creation of the delete button
                final JButton effacer = new JButton(new ActionEffacer(this.panneauDessin));
                effacer.setName(ActionEffacer.NOM_ACTION);

                // Creation of the toggle select button
                final JToggleButton selectionner = new JToggleButton(new ActionSelectionner(this.panneauDessin));
                selectionner.setName(ActionSelectionner.NOM_ACTION);

                // Creation of the selection button for the color.
                final JButton couleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
                couleur.setName(ActionChoisirCouleur.NOM_ACTION);

                // Creation of the toggle line button
                final JToggleButton ligne = new JToggleButton(
                                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
                ligne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);

                // Creation of the circle toggle button
                final JToggleButton cercle = new JToggleButton(
                                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
                cercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);

                // Creation of the toggle ellipse button
                final JToggleButton ellipse = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this,
                                ActionChoisirForme.NOM_ACTION_ELLIPSE));
                ellipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);

                // Creation of the toggle etoile button
                final JToggleButton etoile = new JToggleButton(
                                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ETOILE));
                etoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);

                // Creation of the toggle rectangle button
                final JToggleButton rectangle = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this,
                                ActionChoisirForme.NOM_ACTION_RECTANGLE));
                etoile.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);

                // Creation of the toggle square button
                final JToggleButton carre = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this,
                                ActionChoisirForme.NOM_ACTION_CARRE));
                etoile.setName(ActionChoisirForme.NOM_ACTION_CARRE);

                // Creation of the checkBox for the choice of the filling of the shapes
                final JCheckBox checkBox = new JCheckBox(new ActionChoisirRemplissage(this.panneauDessin));
                checkBox.setName(ActionChoisirRemplissage.NOM_ACTION);
                checkBox.setSelected(false);

                // Adding the buttons
                toolBar.add(effacer);
                toolBar.add(selectionner);
                toolBar.add(couleur);
                toolBar.add(ligne);
                toolBar.add(cercle);
                toolBar.add(ellipse);
                toolBar.add(rectangle);
                toolBar.add(carre);
                toolBar.add(etoile);
                toolBar.add(checkBox);

                // Creation of the tool button group.
                final ButtonGroup groupe = new ButtonGroup();
                groupe.add(effacer);
                groupe.add(selectionner);
                groupe.add(couleur);
                groupe.add(ligne);
                groupe.add(cercle);
                groupe.add(etoile);
                groupe.add(rectangle);
                groupe.add(carre);
                groupe.add(ellipse);

                // Creation of the star container
                final JPanel conteneurEtoile = new JPanel();
                conteneurEtoile.setLayout(new GridLayout(4, 1));
                conteneurEtoile.setName("CONTENEUR_ETOILE_NOM");
                this.add(conteneurEtoile, "CONTENEUR_ETOILE_NOM");

                // Creation of the label and the branch number spinner
                final JSpinner nombreBranchesEtoile = new JSpinner(
                                new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1));
                final JLabel labelNombre = new JLabel(ActionChoisirNombreBrancheEtoile.NOM_ACTION);
                nombreBranchesEtoile.setName(this.BRANCHE_SPINNER_NOM);
                labelNombre.setName(ActionChoisirNombreBrancheEtoile.NOM_ACTION);
                nombreBranchesEtoile.addChangeListener(new ActionChoisirNombreBrancheEtoile(this));

                // Creation of the label and branch length spinner
                final JSpinner longueurBrancheEtoile = new JSpinner(
                                new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0, 1, 0.01));
                final JLabel labelLongueur = new JLabel(ActionChoisirLongueurBrancheEtoile.NOM_ACTION);
                longueurBrancheEtoile.setName(this.LONGUEUR_SPINNER_NOM);
                labelLongueur.setName(ActionChoisirLongueurBrancheEtoile.NOM_ACTION);
                longueurBrancheEtoile.addChangeListener(new ActionChoisirLongueurBrancheEtoile(this));

                // Adding components
                conteneurEtoile.add(labelNombre);
                conteneurEtoile.add(nombreBranchesEtoile);
                conteneurEtoile.add(labelLongueur);
                conteneurEtoile.add(longueurBrancheEtoile);
        }
}