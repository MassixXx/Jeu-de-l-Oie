package Kernel.Cases;

import Kernel.NotTheRightCaseException;
import Kernel.Plateau;
import Kernel.Couleur;

public class CaseFin extends Case {

    public CaseFin(int num, Plateau plateau){
        super(num, Couleur.Black,"crown.png",plateau);
    }
    @Override
    public void action() throws NotTheRightCaseException {
        super.action();
        plateau.getPartie().notifyListener(3);
        plateau.getPartie().end();
    }
}
