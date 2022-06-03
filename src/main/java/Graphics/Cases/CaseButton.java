package Graphics.Cases;

import Kernel.Cases.Case;
import Kernel.Cases.CaseParcours;
import Kernel.Couleur;
import Kernel.Pawn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class CaseButton extends StackPane{
    public CaseButton(Case casee) throws FileNotFoundException {
        super();
        current = false;
        double size = 30.0f;
        this.casee = casee;
        Rectangle box = new Rectangle();
        box.setHeight(size);
        box.setWidth(size);
        box.setStroke(Color.BLACK);
        box.setFill(colorConverter(casee.getCouleur()));
        ImageView img = new ImageView(new Image(new FileInputStream(Case.class.getResource(casee.getIconPath()).getFile())));
        img.setFitHeight(size);
        img.setFitWidth(size);

        super.getChildren().addAll(box,img);

        if (casee instanceof CaseParcours){
            super.getChildren().add(new Text(String.valueOf(casee.getNum()+1)));
        }
    };


    private Color colorConverter(Couleur color){
        Map<Couleur, Color> colorMap = Map.of(
                Couleur.Black,Color.BLACK,
                Couleur.Blue,Color.BLUE,
                Couleur.Green,Color.GREEN,
                Couleur.Orange,Color.ORANGE,
                Couleur.Pink,Color.PINK,
                Couleur.Yellow, Color.YELLOW,
                Couleur.Red,Color.RED,
                Couleur.White,Color.WHITE
        );
        return colorMap.get(color);
    }

    public void setCurrent(boolean val) throws FileNotFoundException {
        current = val;
        if (current){
            getChildren().add(new Pawn());
        }
        else {
            getChildren().remove(2);
        }
    }

    private Case casee;
    private boolean current;
}
