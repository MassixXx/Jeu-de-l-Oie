package Kernel.Cases.C_Question;

import Kernel.Cases.C_Question.C_Question;
import Kernel.NotTheRightCaseException;
import Kernel.Plateau;
import Kernel.Couleur;

public class CaseDefinition extends C_Question {

    public CaseDefinition(int num, Plateau plateau){
        super(num, Couleur.Blue,plateau);
    }
    private String question;
    private String reponse;

    @Override
    protected void generate_question() {

    }

    @Override
    protected void showPopWindow() {

    }

    @Override
    public void action() throws NotTheRightCaseException {
        super.action();
        plateau.getPartie().notifyListener(1);
    }
}
