package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import java.awt.GridLayout;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;

//TODO : Revoir la tabulation 
/**
 * Class {@code PanneauBarreOutils} to represent the side toolbar.
 * <p>
 * Possible actions are:
 * <ul>
 * <li>Delete</li>
 * </ul>
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.5
 */
public class PanneauBarreOutils extends JPanel {
        /**
         * Assigns representing the {@code PanneauDessin} where the buttons will be.
         * 
         * @since 0.3.4.5
         */
        private PanneauDessin panneauDessin;

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
         */
        public PanneauBarreOutils(final PanneauDessin p_panneauDessin) {
                this.panneauDessin = p_panneauDessin;
                this.initComponents();
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
         * @version 0.3.4.10
         */
        public void initComponents() {
                final JPanel conteneurBouton = new JPanel();
                conteneurBouton.setLayout(new GridLayout(5, 1));
                conteneurBouton.setName("CONTENEUR BOUTONS");
                this.add(conteneurBouton);

                // Creation of the delete button
                final JButton effacer = new JButton(new ActionEffacer(this.panneauDessin));
                effacer.setName(ActionEffacer.NOM_ACTION);

                // Creation of the toggle select button
                final JToggleButton selectionner = new JToggleButton(new ActionSelectionner(this.panneauDessin));
                selectionner.setName(ActionSelectionner.NOM_ACTION);

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

                // Adding the buttons
                conteneurBouton.add(effacer);
                conteneurBouton.add(selectionner);
                conteneurBouton.add(ligne);
                conteneurBouton.add(cercle);
                conteneurBouton.add(ellipse);

                // Creation of the tool button group.
                final ButtonGroup groupe = new ButtonGroup();
                groupe.add(selectionner);
                groupe.add(ligne);
                groupe.add(cercle);
                groupe.add(ellipse);
        }
}