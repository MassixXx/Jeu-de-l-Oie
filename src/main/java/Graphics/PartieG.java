package Graphics;

import Kernel.Cases.Case;
import Kernel.Partie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PartieG extends StackPane {
    private Partie partie;
    private PlateauGrid plateauG;
    private Dice de;

    public PartieG(Partie partie){
        super();
        BorderPane bdp = new BorderPane();
        try {
         ImageView bg = new ImageView(new Image(new FileInputStream(PartieG.class.getResource("bg.jpg").getFile())));
            bg.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
            bg.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());

        this.partie = partie;
        this.plateauG = new PlateauGrid(partie.getPlateau(),this);
        this.de = new Dice(partie.getDice(),this);
        bdp.setCenter(plateauG);

        HBox hb = new HBox();
        hb.getChildren().add(de);
        hb.setAlignment(Pos.CENTER_LEFT);
        double margin = 10.0f;
        HBox.setMargin(de,new Insets(0,0,margin,margin));
        bdp.setBottom(hb);

        this.getChildren().addAll(bg,bdp);

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            System.out.println("Fichier bg.jpg introuvable");
        }
    }

    public void setEnabledPlateau(boolean val){
        plateauG.setEnabled(val);
    }

    public void setEnabledDice(boolean val){
        de.setEnabled(val);
    }
}
