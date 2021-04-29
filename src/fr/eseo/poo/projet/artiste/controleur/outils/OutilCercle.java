package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import java.awt.event.MouseEvent;

/**
 * Class {@code OutilCercle} allowing to create a representation of a
 * {@code Cercle}.
 * 
 * @see Cercle
 * @see VueCercle
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.7
 * 
 * @version 0.3.6.3
 */
public class OutilCercle extends OutilForme {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected VueCercle creerVueForme() {
		final Cercle cercle = new Cercle(super.getDebut()); // Default size if double clicked

		cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		cercle.setRempli(this.getPanneauDessin().getModeRemplissage());

		if (!super.getDebut().equals(super.getFin())) {
			// The maximum between the width and height of the movement made with the mouse
			cercle.setLargeur(Math.max(Math.abs(super.getFin().getAbscisse() - super.getDebut().getAbscisse()),
					Math.abs(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee())));
			/*
			 * If the width or height is negative, then the position of the point is changed
			 * to draw the circle without creating errors.
			 */
			if (super.getDebut().getAbscisse() > super.getFin().getAbscisse()) {
				// We shift the point to the left
				super.getDebut().deplacerDe(-cercle.getHauteur(), 0);
			}
			if (super.getDebut().getOrdonnee() > super.getFin().getOrdonnee()) {
				// We shift the point upwards
				super.getDebut().deplacerDe(0, -cercle.getHauteur());
			}
		}
		cercle.setPosition(super.getDebut());
		return new VueCercle(cercle);
	}

	/**
     * {@inheritDoc}
     * 
     * @param event The {@code MouseEvent} associated with the click.
     * 
     * @since 0.3.4.7
     */
    @Override
    public void mouseClicked(final MouseEvent event) {
        super.mouseClicked(event);
    }
}