package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;

/**
 * Class {@code OutilEllipse} allowing to create a representation of a
 * {@code Ellipse}.
 * 
 * @see Ellipse
 * @see VueEllipse
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.7
 * 
 * @version 0.3.4.10
 */
public class OutilEllipse extends OutilForme {

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.4.7
     * 
     * @version 0.3.4.10
     */
    @Override
    protected VueEllipse creerVueForme() {
        final Ellipse ellipse = new Ellipse(super.getDebut()); // Default size if double clicked

        if (!super.getDebut().equals(super.getFin())) {
            double largeur = super.getFin().getAbscisse() - super.getDebut().getAbscisse();
            double hauteur = super.getFin().getOrdonnee() - super.getDebut().getOrdonnee();

            /*
             * If the width or height is negative, then the position of the point is changed
             * to draw the circle without creating errors.
             */
            if (largeur < 0) {
                super.getDebut().deplacerVers(super.getFin().getAbscisse(), super.getDebut().getOrdonnee());
                super.getFin().deplacerVers(super.getDebut().getAbscisse() + Math.abs(largeur),
                        super.getFin().getOrdonnee());
            } else if (largeur == 0) {
                largeur = Ellipse.LARGEUR_PAR_DEFAUT;
            }
            if (hauteur < 0) {
                super.getDebut().deplacerVers(super.getDebut().getAbscisse(), super.getFin().getOrdonnee());
                super.getFin().deplacerVers(super.getFin().getAbscisse(),
                        super.getDebut().getOrdonnee() + Math.abs(hauteur));
            } else if (hauteur == 0) {
                hauteur = Ellipse.HAUTEUR_PAR_DEFAUT;
            }

            ellipse.setPosition(super.getDebut());
            ellipse.setLargeur(super.getFin().getAbscisse() - super.getDebut().getAbscisse());
            ellipse.setHauteur(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee());
        }
        return new VueEllipse(ellipse);
    }
}