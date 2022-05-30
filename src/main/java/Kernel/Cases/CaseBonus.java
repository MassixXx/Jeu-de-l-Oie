package Kernel.Cases;

import Kernel.Couleur;
import Kernel.Plateau;

public class CaseBonus extends Case {
    CaseBonus(int num,Plateau plateau){
        super(num,Couleur.Green,"path/icons/plus2.svg",plateau);
    }
    @Override
    public void action() {

    }
}
