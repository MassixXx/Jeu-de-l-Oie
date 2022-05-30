package Kernel;

import java.io.*;

public class User implements Serializable {
    private static final long serialversionUID =
            129348938L;
    //Attributs
    private String nom;
    private int meilleurScore;

    //Méthodes
    public User(String nom) {
        this.nom = nom;
        this.meilleurScore = 0;
    }

    public User() {
    }

    public void setMeilleurScore(int meilleurScore) {
        this.meilleurScore = meilleurScore;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMeilleurScore() {
        return meilleurScore;
    }

    public String getNom() {
        return nom;
    }

    public void afficher() {
        System.out.println(this.nom);
        System.out.println(this.meilleurScore);
    }


}
