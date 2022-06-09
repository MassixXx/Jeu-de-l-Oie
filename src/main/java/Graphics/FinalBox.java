package Graphics;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FinalBox extends StackPane {

    public FinalBox(int score){
        Rectangle box = new Rectangle();
        box.setFill(Color.WHITE);
        double w = 500.0f,h = 300.0f;
        box.setHeight(h);
        box.setWidth(w);
        box.setEffect(new DropShadow(60,Color.BLACK));

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50.);

        if (score > 0){
            Text fText = new Text("Vous avez gagné !!");
            fText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            Text vsText = new Text("Votre score");
            vsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            fText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            Text sText = new Text(String.valueOf(score));
            sText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            vBox.getChildren().addAll(fText,vsText,sText);
        } else {
            Text fText = new Text("Dommage vous avez perdu !");
            fText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            vBox.getChildren().add(fText);
        }

        getChildren().addAll(box,vBox);
    }

}
