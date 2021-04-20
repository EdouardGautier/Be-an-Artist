package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

/**
 * Class {@code OutilLigne} allowing to create a representation of a
 * {@code Ligne}.
 * 
 * @see Ligne
 * @see VueLigne
 * 
 * @author EdouardGautier
 * 
 * @since 0.3.4.3
 */
public class OutilLigne extends OutilForme {

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.4.3
     * 
     * @version 0.4.4.2
     */
    @Override
    protected VueForme creerVueForme() {
        final Ligne ligne = new Ligne(super.getDebut());
        if (!super.getDebut().equals(super.getFin())) {
            ligne.setC2(super.getFin());
        }
        return new VueLigne(ligne);
    }
}