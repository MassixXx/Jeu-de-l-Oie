package Kernel.Cases;

import Kernel.NotTheRightCaseException;
import Kernel.Plateau;
import Kernel.Couleur;

public class CaseParcours extends Case {

    public CaseParcours(int num, Plateau plateau) {
        super(num, Couleur.White,"none.png",plateau);

    }
    @Override
    public void action() throws NotTheRightCaseException {
        super.action();
    //Case normale : aucune action à faire
    }
}
