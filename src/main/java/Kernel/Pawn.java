package Kernel;

import Kernel.Cases.Case;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pawn extends Group {
    public Pawn() throws FileNotFoundException {
        super();
        ImageView img = new ImageView(new Image(new FileInputStream(Pawn.class.getResource("pawn.png").getFile())));
        img.setFitWidth(25.0f);
        img.setFitHeight(25.0f);
        getChildren().add(img);
    }
}
