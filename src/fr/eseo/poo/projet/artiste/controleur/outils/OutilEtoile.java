package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

/**
 * Class {@code OutilEtoile} allowing to create a representation of a
 * {@code Etoile}.
 * 
 * @see Etoile
 * @see VueEtoile
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.7.3
 */
public class OutilEtoile extends OutilForme {

	/**
	 * {@code PanneauBarreOutilswhere} we get the information about the star to be
	 * drawn
	 */
	private PanneauBarreOutils panneauBarreOutils;

	/**
	 * Builder of a new {@code OutilEtoile}
	 * 
	 * @param p_paPanneauBarreOutils {@code PanneauBarreOutils} where we get the
	 *                               information about the star to be drawn
	 * 
	 * @see PanneauBarreOutils
	 */
	public OutilEtoile(PanneauBarreOutils p_paPanneauBarreOutils) {
		this.panneauBarreOutils = p_paPanneauBarreOutils;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.3
	 */
	@Override
	protected VueForme creerVueForme() {

		final Etoile etoile = new Etoile(super.getDebut());
		etoile.setCouleur(super.getPanneauDessin().getCouleurCourante());
		etoile.setRempli(super.getPanneauDessin().getModeRemplissage());

		if (!super.getDebut().equals(super.getFin())) {
			etoile.setLargeur(super.getDebut().distanceVers(super.getFin()) * 2);

			etoile.setPosition(new Coordonnees(super.getFin().getAbscisse() - etoile.getLargeur() / 2,
					super.getFin().getOrdonnee() - etoile.getHauteur() / 2));

			etoile.setAnglePremiereBranche(-super.getFin().angleVers(super.getDebut()));
			etoile.setLongueurBranche(panneauBarreOutils.getLongueurBranche());
			etoile.setNombreBranches(panneauBarreOutils.getNbBranches());
		}
		return new VueEtoile(etoile);
	}

}