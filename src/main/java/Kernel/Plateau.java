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
    private int currentPosition,targetPos;
    private Partie partie; //Il y aura une redondance dans le fichier
    //Ici, partie est un attribut secondaire

    public Plateau(Case[] cases, int currentPosition) {
        this.cases = cases;
        this.currentPosition = currentPosition;

    }

    public Plateau(Partie prt) {
        this.partie = prt;
        currentPosition = targetPos = 0;
        this.cases = new Case[100];
        cases[0] = new CaseDepart(0,this);
        ArrayList<Case> casesInternes = new ArrayList<Case>(100);
        for (int i=0;i<98;i++){
            if (i<25) {
                if (i % 5 == 0) casesInternes.add(new CaseBonus(i, this));
                else if (i % 5 == 1) casesInternes.add(new CaseMalus(i, this));
                else if (i % 5 == 2) casesInternes.add(new CaseSaut(i, this));
                else if (i % 5 == 3) casesInternes.add(new CaseDefinition(i, this));
                else casesInternes.add(new CaseImage(i, this));
            }else casesInternes.add(new CaseParcours(i,this));
        }
        Collections.shuffle(casesInternes);
        for (int i = 0; i < 98; i++){
            cases[i + 1] = casesInternes.get(i);
            cases[i+1].setNum(i+1);
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
        targetPos += nombreCases;
        if (targetPos > 99){
            targetPos = 99 - targetPos%99;
        }
    }



    public void reculer(int nombreCases) {
        targetPos -= nombreCases;
        if (targetPos < 0) targetPos = 0;
    }
    public Partie getPartie(){return partie;}

    public void sauter(int n) {
        targetPos = getNextJump(n + 1);
    }

    public void goToTarget(){
        currentPosition = targetPos;
    }

    public void setCurrentPosition(int i){
        currentPosition = i;
    }
    public void setTargetPos(int i){currentPosition = i;}
    private int getNextJump(int curr){
        for (int i = curr;i<99;i++){
            if (cases[i] instanceof CaseSaut) return i;
        }
        return getNextJump(0);
    }

    public int getTargetPos(){return targetPos;}
    public int getCurrentPosition(){return currentPosition;}


}

