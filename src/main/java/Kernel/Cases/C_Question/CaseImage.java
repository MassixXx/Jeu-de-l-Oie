package Kernel.Cases.C_Question;


import Kernel.Cases.C_Question.C_Question;
import Kernel.Plateau;
import Kernel.Couleur;

public class CaseImage extends C_Question {

    public CaseImage(int num, Plateau plateau){
        super(num, Couleur.Pink,plateau)
        ;
    }
    private String nom;
    private String[] imgPaths;

    @Override
    public void action() {
        plateau.getPartie().notifyListener(2);
    }

    @Override
    protected void generate_question() {

    }

    @Override
    protected void showPopWindow() {

    }
}
