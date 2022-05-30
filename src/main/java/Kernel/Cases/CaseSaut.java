package Kernel.Cases;

import Kernel.Plateau;
import Kernel.Couleur;

public class CaseSaut extends Case {

    CaseSaut(int num, Plateau plateau){
        super(num, Couleur.Orange,"path/icons/jump.svg",plateau);
    }
    @Override
    public void action() {

    }
}
