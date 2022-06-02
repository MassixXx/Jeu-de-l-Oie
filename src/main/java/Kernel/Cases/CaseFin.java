package Kernel.Cases;

import Kernel.Plateau;
import Kernel.Couleur;

public class CaseFin extends Case {

    public CaseFin(int num, Plateau plateau){
        super(num, Couleur.Black,"path/icons/crown.svg",plateau);
    }
    @Override
    public void action() {

    }
}
