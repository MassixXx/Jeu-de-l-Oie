package Kernel.Cases;

import Kernel.Plateau;
import Kernel.Couleur;

public abstract class Case {
    protected Case(int num,Couleur couleur,String iconPath,Plateau plateau){
        this.num = num;
        this.couleur = couleur;
        this.plateau = plateau;
        this.iconPath = iconPath;
    };

    private Couleur couleur;
    private static Plateau plateau;
    private int num;
    private String iconPath;

    public abstract void action();

    public int getNum() {
        return num;
    }
}
