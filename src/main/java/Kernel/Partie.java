package Kernel;

import Graphics.Infos;

import java.io.Serializable;

public class Partie implements Serializable {
    private Plateau plateau; //Une partie contient un plateau
    private int score;
    private transient  User user;
    private transient  De de;
    private  transient Jeu jeu;
    private Notify listener;
    private Infos infos;

    //+Tableau de questions


    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public Partie(Plateau plateau, User user) {
        this.plateau = plateau;
        score = 1000;
         de = new De(this);
    }

    public Partie(User user) {
        this.plateau = new Plateau(this);
        score = 1000;
        de = new De(this);
    }

    public Plateau getPlateau(){return plateau;}

    public void setDe(De de) {
        this.de = de;
    }

    public De getDice(){return de;}

    public void lancerDes() {
        de.throwDice();
    }

    public int getSommeDes() {

        return (de.getSum());
    }

    public void addScore(int s){
        score += s;
        infos.addScore(s);
    }

    public void subScore(int s){
        score -= s;
        infos.addScore(-s);
        if (score < 0){
            listener.onFinal();
        }
    }

    public void subScore(){
        score -= 10;
        infos.addScore(-10);
    }

    public void end() {

    }

    public void save() {

    }

    public void suspend() {
    }

    public void setListener(Notify node){
        listener = node;
    }

    public void setInfos(Infos inf){infos = inf;}

    public void notifyListener(int i){
        if (i==1){
            listener.onQuizQues();
        }
        else if (i==2){
            listener.onImgQues();
        }
        else if (i == 3){
            listener.onFinal();
        }
    }

    public int getScore() {
        return score;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
