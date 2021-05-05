package fr.eseo.poo.projet.artiste.modele;

import java.awt.Color;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;

/**
 * The {@code interface Coloriable} used to change and retrieve the color of a
 * {@code Forme}.
 * 
 * @see Forme
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.5.111
 */
public interface Coloriable {

	/**
	 * Accessor of the color of the shape.
	 * 
	 * @return A {@code Color} corresponding to the color of the shape.
	 * 
	 * @since 0.3.5.1
	 */
	public abstract Color getCouleur();

	/**
	 * Mutator of the color of the shape.
	 * 
	 * @param couleur {@code Color} corresponding to the new color of the shape
	 * 
	 * @since 0.3.5.1
	 */
	public abstract void setCouleur(Color couleur);

	/**
	 * Gives the description of the color of the shape
	 * <p>
	 * {@code  couleur = R<color code red>,G<green color code>,B<code couleur bleu>}
	 * <p>
	 * In case the {@code Locale} of the computer is French, then the {@code G} will
	 * be replaced by {@code V}.
	 * 
	 * @return {@code String}, description of the color of the shape
	 * 
	 * @since 0.3.5.1
	 */
	public abstract String descriptionCouleur();
}