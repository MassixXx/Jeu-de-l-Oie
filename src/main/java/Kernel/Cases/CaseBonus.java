package Kernel.Cases;

import Kernel.Couleur;
import Kernel.Plateau;

public class CaseBonus extends Case {
    CaseBonus(int num,Plateau plateau){
        super(1,Couleur.Green,plateau);
    }
    @Override
    public void action() {

    }
}
