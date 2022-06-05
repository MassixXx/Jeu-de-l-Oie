package Kernel.Cases;

import Kernel.NotTheRightCaseException;
import Kernel.Plateau;
import Kernel.Couleur;

import java.net.URL;

public abstract class Case {
    protected Case(int num,Couleur couleur,String iconPath,Plateau plateau){
        this.num = num;
        this.couleur = couleur;
        this.iconPath = iconPath;
        this.plateau = plateau;
    };

    private final Couleur couleur;
    protected  Plateau plateau;
    private int num;
    private final String iconPath;


    public  void action() throws NotTheRightCaseException{
        if (num != plateau.getTargetPos()) throw new NotTheRightCaseException("Case incorrecte");
    };

    public int getNum() {
        return num;
    }

    public String getIconPath() {
        return iconPath.toString();
    }

    public Couleur getCouleur() {
        return couleur;
    }
    public void setNum(int n){this.num = n;}
}
