package Kernel.Cases;

import Kernel.Couleur;
import Kernel.Plateau;

public class CaseMalus extends Case {

    public CaseMalus(int num, Plateau plateau) {
        super(num, Couleur.Red,"minus2.png",plateau);
    }
    @Override
    public void action() {

    }
}
