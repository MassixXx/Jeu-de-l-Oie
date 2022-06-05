package Graphics;

import Graphics.Cases.CaseButton;
import Kernel.Plateau;
import javafx.scene.layout.GridPane;
import java.io.*;
import java.util.Scanner;

public class PlateauGrid extends GridPane {
    public PlateauGrid(Plateau plateau)  {
        this.plateau = plateau;
        enabled = true;
        File fichPos = new File(PlateauGrid.class.getResource("pos.txt").getFile());

        try {
            Scanner reader = new Scanner(fichPos);
            cases = new CaseButton[100];
            for (int i = 0;i<100;i++){
                cases[i] = new CaseButton(plateau.getCaseAt(i),this);
                int row = reader.nextInt();
                int col = reader.nextInt();
                this.add(cases[i],row,col);
            }
            cases[0].setCurrent(true);
        }
        catch (FileNotFoundException e){
            System.out.println("Fichier pos.txt introuvable");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Erreur d'index sur le tableau cases");
        }
    }

    public void movePawn(int origin,int dest){
        for (int i = origin,lastPos =origin;;){
            cases[lastPos].setCurrent(false);
            cases[i].setCurrent(false);
            lastPos = i;
            if (i == dest) break;
            if (origin < dest){
                i++;
            } else {
                i--;
            }
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void movePawn(){
        movePawn(plateau.getCurrentPosition(),plateau.getTargetPos());
    }

    public void setPawn(){
        cases[plateau.getCurrentPosition()].setCurrent(false);
        cases[plateau.getTargetPos()].setCurrent(true);
        plateau.goToTarget();
    }

    public void setEnabled(boolean val){enabled = val;}
    public boolean getEnabled(){return enabled;}
    public void showTip(){
        cases[plateau.getTargetPos()].showTip();
    }

    private CaseButton[] cases;
    private Plateau plateau;
    private boolean enabled;
}
