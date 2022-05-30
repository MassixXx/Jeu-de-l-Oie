package Kernel.Cases;

import Kernel.Plateau;
import Kernel.Couleur;

public abstract class Case {
    private Couleur couleur;
    private static Plateau plateau;
    private int num;

    public abstract void action();

    public int getNum() {
        return num;
    }
}
