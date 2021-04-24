package fr.eseo.poo.projet.artiste.modele;

/**
 * Inteface allowing to fill a {@code Forme}.
 * 
 * @see Forme
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.6.1
 */
public interface Remplissable {

    /**
     * Filling accessor, allows to know if the {@code Forme} is filled or not.
     * 
     * @return {@code true} if the form is filled, {@code false} if not.
     */
    public boolean estRempli();

    /**
     * Mutator of the filling indication of the {@code Forme}
     * 
     * @param p_estRempli a {@code boolean}
     *                    <ul>
     *                    <li>{@code true} if we want to fill the
     *                    {@code Forme}.</li>
     *                    <li>{@code false} if we don't want to fill the
     *                    {@code Forme}.</li>
     *                    </ul>
     */
    public void setRempli(boolean p_estRempli);

    /**
     * Function that describes the filling of the {@code Forme} .
     * 
     * @return {@code String} indicating whether the {@code Forme} is filled or not.
     */
    public String descriptionRemplissage();
}