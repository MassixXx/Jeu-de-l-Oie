package Graphics;

import Graphics.Cases.CaseButton;
import Kernel.Plateau;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

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
                this.add(cases[i],col,row);
                setMaxSize(500.0f,500.0f);
                cases[i].setAlignment(Pos.CENTER);

                GridPane.setConstraints(cases[i],col,row,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS,Priority.ALWAYS);
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



    public void setPawn(){
        for (int i=0;i<99;i++){
            cases[i].setCurrent(false);
        }
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
