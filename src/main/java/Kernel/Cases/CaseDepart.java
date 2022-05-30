package Kernel.Cases;

import Kernel.Couleur;
import Kernel.Plateau;

public class CaseDepart extends Case {
    CaseDepart(int num, Plateau plateau){
        super(num, Couleur.Yellow,plateau);
    }
    @Override
    public void action() {

    }
}
