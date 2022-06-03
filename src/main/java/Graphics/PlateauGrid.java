package Graphics;

import Graphics.Cases.CaseButton;
import Kernel.Plateau;
import javafx.scene.layout.GridPane;
import java.io.*;
import java.util.Scanner;

public class PlateauGrid extends GridPane {
    public PlateauGrid(Plateau plateau)  {

        File fichPos = new File(PlateauGrid.class.getResource("pos.txt").getFile());

        try {
            Scanner reader = new Scanner(fichPos);
            cases = new CaseButton[100];
            for (int i = 0;i<100;i++){
                cases[i] = new CaseButton(plateau.getCaseAt(i));
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

    private CaseButton[] cases;
}
