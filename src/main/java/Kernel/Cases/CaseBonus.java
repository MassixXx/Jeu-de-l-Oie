package Kernel.Cases;

import Kernel.Couleur;
import Kernel.Plateau;

public class CaseBonus extends Case {
    public CaseBonus(int num, Plateau plateau){
        super(num,Couleur.Green,"plus2.png",plateau);
    }
    @Override
    public void action() {

    }
}
