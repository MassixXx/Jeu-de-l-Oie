package Kernel;

import Kernel.Cases.Case;

import java.io.Serializable;

public class Plateau implements Serializable {
    private Case[] cases;
    private int currentPosition;
    private transient Partie partie; //Il y aura une redondance dans le fichier
    //Ici, partie est un attribut secondaire

    public Plateau(Case[] cases, int currentPosition) {
        this.cases = cases;
        this.currentPosition = currentPosition;

    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public void avancer(int nombreCases) {
    }

    public void reculer(int nombreCases) {
    }

    public void sauter(int nombreCases) {
    }
}

