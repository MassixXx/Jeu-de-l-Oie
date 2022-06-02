package Kernel.Cases;

import Kernel.Couleur;
import Kernel.Plateau;

public class CaseDepart extends Case {
    public CaseDepart(int num, Plateau plateau){
        super(num, Couleur.Yellow,"path/icons/start.svg",plateau);
    }

    @Override
    public void action() {

    }
}
