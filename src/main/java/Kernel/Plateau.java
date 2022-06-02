package Kernel;

import Kernel.Cases.*;
import Kernel.Cases.C_Question.CaseDefinition;
import Kernel.Cases.C_Question.CaseImage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Plateau implements Serializable {
    private Case[] cases;
    private int currentPosition;
    private transient Partie partie; //Il y aura une redondance dans le fichier
    //Ici, partie est un attribut secondaire

    public Plateau(Case[] cases, int currentPosition) {
        this.cases = cases;
        this.currentPosition = currentPosition;

    }

    public Plateau() {
        this.cases = new Case[100];
        cases[0] = new CaseDepart(0,this);
        ArrayList<Case> casesInternes = new ArrayList<Case>(98);
        for (int i=0;i<98;i++){
            if (i<5) casesInternes.set(i, new CaseBonus(i,this));
            else if (i < 10) casesInternes.set(i, new CaseMalus(i,this));
            else if (i < 15) casesInternes.set(i, new CaseSaut(i,this));
            else if (i<20) casesInternes.set(i, new CaseDefinition(i,this));
            else if (i<25) casesInternes.set(i, new CaseImage(i,this));
            else casesInternes.set(i,new CaseParcours(i,this));
        }
        Collections.shuffle(casesInternes);
        Collections.shuffle(Arrays.asList(cases));
        for (int i = 0; i < 98; i++){
            cases[i + 1] = casesInternes.get(i);
        }
        cases[99] = new CaseFin(99,this);
    }

    public Case getCaseAt(int i) throws IndexOutOfBoundsException{
        return cases[i];
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

