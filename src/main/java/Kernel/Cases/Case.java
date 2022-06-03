package Kernel.Cases;

import Kernel.Plateau;
import Kernel.Couleur;

import java.net.URL;

public abstract class Case {
    protected Case(int num,Couleur couleur,String iconPath,Plateau plateau){
        this.num = num;
        this.couleur = couleur;
        this.iconPath = iconPath;
    };

    private final Couleur couleur;
    private static Plateau plateau;
    private final int num;
    private final String iconPath;

    public static Plateau getPlateau() {
        return plateau;
    }

    public static void setPlateau(Plateau plateau) {
        Case.plateau = plateau;
    }


    public abstract void action();

    public int getNum() {
        return num;
    }

    public String getIconPath() {
        return iconPath.toString();
    }

    public Couleur getCouleur() {
        return couleur;
    }
}
