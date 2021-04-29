package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

/**
 * Class {@linkplain VueEtoile} allowing the display of a start, from the class
 * {@linkplain Etoile}.
 * 
 * @see Etoile
 * @see VueForme
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.2
 */
public class VueEtoile extends VueForme {
    /**
     * Constructor of a new {@code VueEtoile}. The instance of the class is
     * initialized with the shape given in parameter.
     * 
     * @param p_etoile {@code Etoile} that you wish to display.
     * 
     * @since 0.3.7.2
     */
    public VueEtoile(final Etoile p_etoile) {
        super(p_etoile);
    }

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.7.2
     */
    @Override
    public void affiche(final Graphics2D g2d) {
        final Etoile etoile = (Etoile) super.getForme();
        final Color colorOld = g2d.getColor();
        final int[] tab_x = new int[2 * etoile.getNombreBranches()];
        final int[] tab_y = new int[2 * etoile.getNombreBranches()];
        g2d.setColor(etoile.getCouleur());        
        // We calculate the position of the points
        for (int i = 0; i < 2 * etoile.getNombreBranches(); i += 2) {
            tab_x[i] = (int) Math.round(etoile.getCoordonneesPolygone().get(i / 2).getAbscisse());
            tab_y[i] = (int) Math.round(etoile.getCoordonneesPolygone().get(i / 2).getOrdonnee());
            tab_x[i + 1] = (int) Math.round(etoile.getCoordonnees().get(i / 2).getAbscisse());
            tab_y[i + 1] = (int) Math.round(etoile.getCoordonnees().get(i / 2).getOrdonnee());
        }
        if (etoile.estRempli()) {
            g2d.fillPolygon(tab_x, tab_y, etoile.getNombreBranches() * 2);
        }
        g2d.drawPolygon(tab_x, tab_y, etoile.getNombreBranches() * 2);
        g2d.setColor(colorOld);
    }
}