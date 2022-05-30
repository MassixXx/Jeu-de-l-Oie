package Kernel;

import Kernel.Cases.Case;

public class Jeu {
    //Attributes
    private User[] users;
    private Partie partie;
    private String[] fichParties;

    // + liste de scores
    // +fichier de sauvegarde des scores
    //Methods
    public Jeu() {
    }

    public Jeu(User[] users, Partie partie) {
        this.users = users;
        this.partie = partie;
    }

    public void identification(User user) {
        //Identifies the user
    }

    public void lancerPartie() {
        //Lauches a new game part
        Plateau plateau = new Plateau(new Case[100], 1);
        //this.partie = new Partie();
    }

    public void chargerPartie() {
        //Loads an old game part
    }

    public void quitter() {
        //Quits the game
    }

    public void consulterClassement() {
    }

    public void meilleurScoreBattu() {
    }

    public void addUser() {
    }

    public void sauvegarderPartie() {
    }

}

