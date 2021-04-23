package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;

import java.awt.BorderLayout;

/**
 * Base test class of the {@linkplain PanneauBarreOutils}.
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.11
 */
public class PanneauBarreOutilsTest {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanneauBarreOutilsTest();
            }
        });
    }

    public PanneauBarreOutilsTest() {
        this.testConstructeurParDefaut();
    }

    /**
     * Test of {@linkplain PanneauBarreOutils#PanneauBarreOutils()} .
     * <p>
     * We would create a main window with the title {@code Etre un Artiste}, in
     * which we add {@code PanneauBarreOutils}.
     * <p>
     * Closing the window will stop the application.
     */
    private void testConstructeurParDefaut() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneauDessin = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
        PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneauDessin);

        frame.getContentPane().add(panneauDessin);
        frame.setTitle("Etre un Artiste");
        frame.setSize(panneauDessin.getPreferredSize());
        frame.setLocation(250, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panneauOutils, BorderLayout.EAST);

        OutilLigne outilLigne = new OutilLigne();
        OutilEllipse outilEllipse = new OutilEllipse();
        OutilCercle outilCercle = new OutilCercle();
        new ActionEffacer(panneauDessin);
        new ActionSelectionner(panneauDessin);

        panneauDessin.associerOutil(outilLigne);
        panneauDessin.associerOutil(outilEllipse);
        panneauDessin.associerOutil(outilCercle);
    }
}
