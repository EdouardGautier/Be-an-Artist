package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.formes.VueRectangle;

/**
 * Class {@code OutilRectangle} allowing to create a representation of a
 * {@code Rectangle}.
 * 
 * @see Rectangle
 * @see VueRectangle
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.1
 */
public class OutilRectangle extends OutilForme {

    /**
     * {@inheritDoc}
     */
    @Override
    protected VueRectangle creerVueForme() {
        final Rectangle rectangle = new Rectangle(super.getDebut()); // Default size if double clicked

        rectangle.setCouleur(this.getPanneauDessin().getCouleurCourante());
        rectangle.setRempli(this.getPanneauDessin().getModeRemplissage());

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
                largeur = Forme.LARGEUR_PAR_DEFAUT;
            }
            if (hauteur < 0) {
                super.getDebut().deplacerVers(super.getDebut().getAbscisse(), super.getFin().getOrdonnee());
                super.getFin().deplacerVers(super.getFin().getAbscisse(),
                        super.getDebut().getOrdonnee() + Math.abs(hauteur));
            } else if (hauteur == 0) {
                hauteur = Forme.HAUTEUR_PAR_DEFAUT;
            }

            rectangle.setPosition(super.getDebut());
            rectangle.setLargeur(super.getFin().getAbscisse() - super.getDebut().getAbscisse());
            rectangle.setHauteur(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee());
        }
        return new VueRectangle(rectangle);
    }
}