package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Carre;
import fr.eseo.poo.projet.artiste.vue.formes.VueCarre;
import java.awt.event.MouseEvent;

/**
 * Class {@code OutilCarre} allowing to create a representation of a
 * {@code Carre}.
 * 
 * @see Carre
 * @see VueCarre
 * 
 * @author EdouardGautier
 * 
 * @since 1.3.2
 */
public class OutilCarre extends OutilForme {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected VueCarre creerVueForme() {
		final Carre carre = new Carre(super.getDebut()); // Default size if double clicked

		carre.setCouleur(this.getPanneauDessin().getCouleurCourante());
		carre.setRempli(this.getPanneauDessin().getModeRemplissage());

		if (!super.getDebut().equals(super.getFin())) {
			// The maximum between the width and height of the movement made with the mouse
			carre.setLargeur(Math.max(Math.abs(super.getFin().getAbscisse() - super.getDebut().getAbscisse()),
					Math.abs(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee())));
			/*
			 * If the width or height is negative, then the position of the point is changed
			 * to draw the circle without creating errors.
			 */
			if (super.getDebut().getAbscisse() > super.getFin().getAbscisse()) {
				// We shift the point to the left
				super.getDebut().deplacerDe(-carre.getHauteur(), 0);
			}
			if (super.getDebut().getOrdonnee() > super.getFin().getOrdonnee()) {
				// We shift the point upwards
				super.getDebut().deplacerDe(0, -carre.getHauteur());
			}
		}
		carre.setPosition(super.getDebut());
		return new VueCarre(carre);
	}

	/**
     * {@inheritDoc}
     * 
     * @param event The {@code MouseEvent} associated with the click.
     * 
     * @since 1.3.2
     */
    @Override
    public void mouseClicked(final MouseEvent event) {
        super.mouseClicked(event);
    }
}