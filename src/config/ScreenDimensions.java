package config;
/**
* Cette classe permet de stocker la taille initiale choisie par l'utilisateur afin qu'elle reste accessible partout dans le projet.
* */
public class ScreenDimensions {

    private final int hauteur;
    private final int largeur;

    public ScreenDimensions(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }
}
