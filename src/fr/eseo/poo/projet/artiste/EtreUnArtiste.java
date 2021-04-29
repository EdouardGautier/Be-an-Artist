package fr.eseo.poo.projet.artiste;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Main class to launch the application {@code Etre un Artiste}
 * 
 * @since 0.3.8
 * 
 * @version 1
 */
public class EtreUnArtiste {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EtreUnArtiste();
            }
        });
    }

    public EtreUnArtiste() {
        final JFrame frame = new JFrame();
        final PanneauDessin panneauDessin = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
        PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneauDessin);

        frame.getContentPane().add(panneauDessin);
        frame.setTitle("Etre un Artiste");
        frame.setSize(panneauDessin.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panneauOutils, BorderLayout.EAST);
    }
}
