package Kernel.Cases.C_Question;

import Kernel.Cases.Case;
import Kernel.Couleur;
import Kernel.Plateau;

import Kernel.QuestionGen;


public abstract class C_Question extends Case {

    C_Question(int num,Couleur couleur,Plateau plateau){super(num,couleur,"interrogation.png",plateau);}
    private static QuestionGen question_gen;

    abstract protected void generate_question();

    abstract protected void showPopWindow();
}
