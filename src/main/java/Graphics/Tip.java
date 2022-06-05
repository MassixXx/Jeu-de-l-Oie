package Graphics;

import javafx.scene.Group;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Tip extends Group {
    public Tip() throws FileNotFoundException {
        super();
        ImageView img = new ImageView(new Image(new FileInputStream(Graphics.Tip.class.getResource("tip.gif").getFile())));
        img.setFitWidth(30.0f);
        img.setFitHeight(30.0f);
        getChildren().add(img);
    }
}
