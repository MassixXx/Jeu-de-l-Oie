package Kernel.Cases;

import Kernel.Couleur;
import Kernel.Plateau;

public class CaseMalus extends Case {

    CaseMalus(int num, Plateau plateau) {
        super(num, Couleur.Red,plateau);
    }
    @Override
    public void action() {

    }
}
