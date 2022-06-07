package Graphics;

import Kernel.Partie;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PartieG extends BorderPane {
    private Partie partie;
    public PartieG(Partie partie){
        super();
        this.partie = partie;

        setCenter(new PlateauGrid(partie.getPlateau()));

        HBox hb = new HBox();
        hb.getChildren().add(new Dice(partie.getDice()));
        hb.setAlignment(Pos.CENTER_LEFT);
        setBottom(hb);
    }
}
