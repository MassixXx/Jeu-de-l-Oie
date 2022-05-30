package Kernel;

import java.io.Serializable;

public class Partie implements Serializable {
    private Plateau plateau; //Une partie contient un plateau
    private int score;
    private User user;
    private transient De de1 = new De();
    private transient De de2 = new De();
    private transient Jeu jeu;

    //+Tableau de questions
    public Partie(Plateau plateau, User user) {
        this.plateau = plateau;

    }

    public void lancerDes() {
        de1.throwDie();
        de2.throwDie();
    }

    public int getSommeDes() {

        return (de1.getValue() + de2.getValue());
    }

    public void end() {
    }

    public void save() {

    }

    public void suspend() {
    }


}
