package Kernel.Cases;

import Kernel.Couleur;
import Kernel.Plateau;

public class CaseDepart extends Case {
    public CaseDepart(int num, Plateau plateau){
        super(num, Couleur.Yellow,"start.png",plateau);
    }

    @Override
    public void action() {

    }
}
