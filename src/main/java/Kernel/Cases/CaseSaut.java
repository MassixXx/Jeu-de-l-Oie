package Kernel.Cases;

import Kernel.NotTheRightCaseException;
import Kernel.Plateau;
import Kernel.Couleur;

public class CaseSaut extends Case {

    public CaseSaut(int num, Plateau plateau){
        super(num, Couleur.Orange,"jump.png",plateau);
    }
    @Override
    public void action() throws NotTheRightCaseException {
        super.action();
        plateau.sauter(getNum());
    }
}
