package Graphics.Cases;

import Kernel.Cases.Case;
import Kernel.Couleur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;

import java.util.Map;

public class CaseButton extends StackPane{
    public CaseButton(Case casee){
        super();
        this.casee = casee;
        Rectangle box = new Rectangle();
        box.setHeight(5.0f);
        box.setWidth(5.0f);
        box.setFill(colorConverter(casee.getCouleur()));
        ImageView img = new ImageView(new Image(casee.getIconPath()));

        super.getChildren().addAll(box,img);
    };

    private Color colorConverter(Couleur color){
        Map<Couleur, Color> colorMap = Map.of(
                Couleur.Black,Color.BLACK,
                Couleur.Blue,Color.BLUE,
                Couleur.Green,Color.GREEN,
                Couleur.Orange,Color.PINK,
                Couleur.Yellow, Color.YELLOW,
                Couleur.Red,Color.RED,
                Couleur.White,Color.WHITE
        );
        return colorMap.get(color);
    }

    private Case casee;
}
